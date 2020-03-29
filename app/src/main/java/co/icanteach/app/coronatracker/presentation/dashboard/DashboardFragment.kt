package co.icanteach.app.coronatracker.presentation.dashboard

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import co.icanteach.app.coronatracker.CoronaTrackerApplication
import co.icanteach.app.coronatracker.R
import co.icanteach.app.coronatracker.presentation.MainActivity
import co.icanteach.app.coronatracker.presentation.dashboard.inject.DashboardComponent
import co.icanteach.app.coronatracker.presentation.news.NewsAdapter
import co.icanteach.app.coronatracker.presentation.news.NewsViewModel
import javax.inject.Inject

class DashboardFragment : Fragment() {

    lateinit var dashboardComponent: DashboardComponent

    private val viewModel: DashboardViewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this, viewModelFactory).get(DashboardViewModel::class.java)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchDashboard()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dashboardComponent =
            ((activity as MainActivity).applicationContext as CoronaTrackerApplication)
                .appComponent.dashboardComponent().create()
        dashboardComponent.inject(this)
    }
}