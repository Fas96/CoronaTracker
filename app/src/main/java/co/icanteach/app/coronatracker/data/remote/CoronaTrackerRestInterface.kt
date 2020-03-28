package co.icanteach.app.coronatracker.data.remote

import co.icanteach.app.coronatracker.data.remote.model.CountriesDataResponse
import co.icanteach.app.coronatracker.data.remote.model.NewsResponse
import co.icanteach.app.coronatracker.data.remote.model.TotalDataResponse
import retrofit2.http.GET

interface CoronaTrackerRestInterface {

    @GET("/countriesData")
    suspend fun fetchCountriesData(): CountriesDataResponse

    @GET("/totalData")
    suspend fun fetchTotalData(): TotalDataResponse

    @GET("/coronaNews")
    suspend fun fetchCoronaNews(): NewsResponse
}