package co.icanteach.app.coronatracker.presentation.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.icanteach.app.coronatracker.core.Resource
import co.icanteach.app.coronatracker.domain.dashboard.FetchDashboardUseCase
import co.icanteach.app.coronatracker.domain.dashboard.model.DashboardItem
import co.icanteach.app.coronatracker.domain.news.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class DashboardViewModel @Inject constructor(
    private val fetchDashboardUseCase: FetchDashboardUseCase
) : ViewModel() {

    private val dashboardItems = MutableLiveData<List<DashboardItem>>()

    fun getDashboardItems(): LiveData<List<DashboardItem>> = dashboardItems

    init {
        fetchDashboard()
    }

    private fun fetchDashboard() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchDashboardUseCase.fetchDashboard().collect {
                updatePageForResult(it)
            }
        }
    }

    private fun updatePageForResult(data: List<DashboardItem>) {
        dashboardItems.postValue(data)
    }

    private fun updatePageForError() {

    }

    private fun updatePageForLoading() {

    }
}