package co.icanteach.app.coronatracker.presentation.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import co.icanteach.app.coronatracker.R
import co.icanteach.app.coronatracker.databinding.ItemDashboardCountryBinding
import co.icanteach.app.coronatracker.databinding.ItemDashboardEarthTotalBinding
import co.icanteach.app.coronatracker.databinding.ItemDashboardMotherlandBinding
import co.icanteach.app.coronatracker.domain.dashboard.model.DashboardItem
import co.icanteach.app.coronatracker.domain.news.model.News
import co.icanteach.app.coronatracker.presentation.news.NewsItemViewState
import javax.inject.Inject

private const val ITEM_TYPE_MOTHERLAND = 1
private const val ITEM_TYPE_EARTH_TOTAL = 2
private const val ITEM_TYPE_COUNTRY = 2

class DashboardAdapter @Inject constructor() :
        RecyclerView.Adapter<DashboardAdapter.BaseViewHolder<out ViewDataBinding>>() {

    private var dashboardItems: MutableList<DashboardItem> = mutableListOf()

    override fun onBindViewHolder(holder: BaseViewHolder<out ViewDataBinding>, position: Int) {
        when (holder) {
            is DashboardMotherlandViewHolder -> holder.bind(getDashboardItem(position) as DashboardItem.Motherland)
            is DashboardEarthTotalViewHolder -> holder.bind(getDashboardItem(position))
            is DashboardCountryViewHolder -> holder.bind(getDashboardItem(position))
        }
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): BaseViewHolder<out ViewDataBinding> {

        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding

        return when (viewType) {
            ITEM_TYPE_MOTHERLAND -> {
                binding = DataBindingUtil.inflate(
                        inflater,
                        R.layout.item_dashboard_motherland,
                        parent,
                        false
                )
                DashboardMotherlandViewHolder(binding as ItemDashboardMotherlandBinding)
            }

            ITEM_TYPE_EARTH_TOTAL -> {
                binding = DataBindingUtil.inflate(
                        inflater,
                        R.layout.item_dashboard_earth_total,
                        parent,
                        false
                )
                DashboardEarthTotalViewHolder(binding as ItemDashboardEarthTotalBinding)
            }
            else -> {
                binding = DataBindingUtil.inflate(
                        inflater,
                        R.layout.item_dashboard_country,
                        parent,
                        false
                )
                DashboardCountryViewHolder(binding as ItemDashboardCountryBinding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getDashboardItem(position)) {
            is DashboardItem.Motherland -> ITEM_TYPE_MOTHERLAND
            is DashboardItem.EarthTotal -> ITEM_TYPE_EARTH_TOTAL
            is DashboardItem.CountrySpecial -> ITEM_TYPE_COUNTRY
        }
    }

    override fun getItemCount(): Int = dashboardItems.size

    private fun getDashboardItem(position: Int) = dashboardItems[position]

    fun setDashboardItems(dashboardItemList: List<DashboardItem>) {
        val beforeSize = dashboardItems.size
        dashboardItems.addAll(dashboardItemList)
        notifyItemRangeInserted(beforeSize, dashboardItemList.size)
    }

    inner class DashboardMotherlandViewHolder(override val binding: ItemDashboardMotherlandBinding) :
            DashboardAdapter.BaseViewHolder<ItemDashboardMotherlandBinding>(binding) {

        fun bind(item: DashboardItem.Motherland) {
            with(binding) {
                viewState = DashboardMotherlandItemViewState(item)
                executePendingBindings()
            }
        }
    }

    inner class DashboardEarthTotalViewHolder(override val binding: ItemDashboardEarthTotalBinding) :
            DashboardAdapter.BaseViewHolder<ItemDashboardEarthTotalBinding>(binding) {

        fun bind(item: DashboardItem) {
        }
    }

    inner class DashboardCountryViewHolder(override val binding: ItemDashboardCountryBinding) :
            DashboardAdapter.BaseViewHolder<ItemDashboardCountryBinding>(binding) {

        fun bind(item: DashboardItem) {
        }
    }

    abstract class BaseViewHolder<T : ViewDataBinding>(open val binding: T) :
            RecyclerView.ViewHolder(binding.root)

}