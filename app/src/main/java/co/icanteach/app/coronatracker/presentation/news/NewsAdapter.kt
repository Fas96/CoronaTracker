package co.icanteach.app.coronatracker.presentation.news

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.icanteach.app.coronatracker.R
import co.icanteach.app.coronatracker.core.inflate
import co.icanteach.app.coronatracker.databinding.ItemNewsBinding
import co.icanteach.app.coronatracker.domain.news.model.News
import javax.inject.Inject

class NewsAdapter @Inject constructor() :
    RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>() {

    private var newsList: MutableList<News> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsItemViewHolder {
        val itemBinding = parent.inflate<ItemNewsBinding>(R.layout.item_news, false)
        return NewsItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(getNews(position))
    }

    private fun getNews(position: Int) = newsList[position]

    fun setNews(news: List<News>) {
        val beforeSize = newsList.size
        newsList.addAll(news)
        notifyItemRangeInserted(beforeSize, news.size)
    }

    inner class NewsItemViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(newsItem: News) {
            with(binding) {
                viewState = NewsItemViewState(newsItem)
                executePendingBindings()
            }
        }

    }
}