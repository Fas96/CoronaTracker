package co.icanteach.app.coronatracker.domain.dashboard

import co.icanteach.app.coronatracker.core.Resource
import co.icanteach.app.coronatracker.data.CoronaTrackerRepository
import co.icanteach.app.coronatracker.domain.DashboardItemMapper
import co.icanteach.app.coronatracker.domain.dashboard.model.DashboardItem
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class FetchDashboardUseCase @Inject constructor(
    private val repository: CoronaTrackerRepository,
    private val mapper: DashboardItemMapper
) {
    @ExperimentalCoroutinesApi
    suspend fun fetchDashboard(): Flow<List<DashboardItem>> {
        val totalDataFlow = repository.fetchTotalData()
        val countriesDataFlow = repository.fetchCountriesData()
        return totalDataFlow
            .combine(countriesDataFlow) { totalData, countriesData ->
                when {
                    totalData is Resource.Success && countriesData is Resource.Success -> {
                        mapper.mapFromResponse(totalData.data, countriesData.data)
                    }
                    // todo update for error and loading.
                    else -> emptyList()
                }
            }
    }
}