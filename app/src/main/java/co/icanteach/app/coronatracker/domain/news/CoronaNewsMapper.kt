package co.icanteach.app.coronatracker.domain.news

import co.icanteach.app.coronatracker.core.Mapper
import co.icanteach.app.coronatracker.data.remote.model.NewsItemResponse
import co.icanteach.app.coronatracker.domain.news.model.News

class CoronaNewsMapper : Mapper<List<NewsItemResponse>, List<News>> {
    override fun mapFromResponse(response: List<NewsItemResponse>): List<News> {
        return response.map {
            News()
        }
    }
}