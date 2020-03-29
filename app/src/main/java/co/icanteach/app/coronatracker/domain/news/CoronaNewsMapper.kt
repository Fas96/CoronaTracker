package co.icanteach.app.coronatracker.domain.news

import co.icanteach.app.coronatracker.core.Mapper
import co.icanteach.app.coronatracker.data.remote.model.NewsItemResponse
import co.icanteach.app.coronatracker.domain.news.model.News
import javax.inject.Inject

class CoronaNewsMapper @Inject constructor() : Mapper<List<NewsItemResponse>, List<News>> {
    override fun mapFromResponse(response: List<NewsItemResponse>): List<News> {
        return response.map { itemResponse ->
            News(
                sourceName = itemResponse.source,
                imageUrl = itemResponse.image,
                title = itemResponse.name,
                description = itemResponse.description,
                sourceUrl = itemResponse.url
            )
        }
    }
}