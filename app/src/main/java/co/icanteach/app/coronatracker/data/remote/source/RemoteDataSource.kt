package co.icanteach.app.coronatracker.data.remote.source

import co.icanteach.app.coronatracker.data.remote.CoronaTrackerRestInterface
import co.icanteach.app.coronatracker.data.remote.model.CountriesDataResponse
import co.icanteach.app.coronatracker.data.remote.model.TotalDataResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val restInterface: CoronaTrackerRestInterface) {

    suspend fun fetchCountriesData(): CountriesDataResponse {
        return restInterface.fetchCountriesData()
    }

    suspend fun fetchTotalData(): TotalDataResponse {
        return restInterface.fetchTotalData()
    }

    suspend fun fetchCoronaNews() {
        return restInterface.fetchCoronaNews()
    }
}