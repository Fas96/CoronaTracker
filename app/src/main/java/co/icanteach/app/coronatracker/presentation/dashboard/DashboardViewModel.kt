package co.icanteach.app.coronatracker.presentation.dashboard

import androidx.lifecycle.ViewModel
import co.icanteach.app.coronatracker.domain.dashboard.FetchDashboardUseCase
import javax.inject.Inject

class DashboardViewModel @Inject constructor(
    val fetchDashboardUseCase: FetchDashboardUseCase
) : ViewModel() {
    fun fetchDashboard() {

    }
}