package co.icanteach.app.coronatracker.domain.news

import co.icanteach.app.coronatracker.core.Resource
import co.icanteach.app.coronatracker.data.CoronaTrackerRepository
import co.icanteach.app.coronatracker.domain.news.model.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchNewsUseCase @Inject constructor(
    private val repository: CoronaTrackerRepository,
    private val mapper: CoronaNewsMapper
) {

    suspend fun fetchCoronaNews(): Flow<Resource<List<News>>> {
        return repository
            .fetchCoronaNews()
            .map { resource ->
                resource.map {
                    mapper.mapFromResponse(it.result)
                }
            }
    }
}