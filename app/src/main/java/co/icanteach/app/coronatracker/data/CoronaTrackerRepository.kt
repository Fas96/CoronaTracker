package co.icanteach.app.coronatracker.data

import co.icanteach.app.coronatracker.core.Resource
import co.icanteach.app.coronatracker.data.remote.model.CountriesDataResponse
import co.icanteach.app.coronatracker.data.remote.model.NewsResponse
import co.icanteach.app.coronatracker.data.remote.model.TotalDataResponse
import co.icanteach.app.coronatracker.data.remote.source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoronaTrackerRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun fetchCountriesData(): Flow<Resource<CountriesDataResponse>> {
        return flow {
            emit(Resource.Loading())
            try {
                val countriesDataResponse = remoteDataSource.fetchCountriesData()
                emit(Resource.Success(countriesDataResponse))
            } catch (exception: Exception) {
                emit(Resource.Error(exception))
            }
        }
    }

    suspend fun fetchTotalData(): Flow<Resource<TotalDataResponse>> {
        return flow {
            emit(Resource.Loading())
            try {
                val totalDataResponse = remoteDataSource.fetchTotalData()
                emit(Resource.Success(totalDataResponse))
            } catch (exception: Exception) {
                emit(Resource.Error(exception))
            }
        }
    }

    suspend fun fetchCoronaNews(): Flow<Resource<NewsResponse>> {
        return flow {
            emit(Resource.Loading())
            try {
                val coronaNewsResponse = remoteDataSource.fetchCoronaNews()
                emit(Resource.Success(coronaNewsResponse))
            } catch (exception: Exception) {
                emit(Resource.Error(exception))
            }
        }
    }
}