package co.icanteach.app.coronatracker.domain

import co.icanteach.app.coronatracker.core.Mapper2
import co.icanteach.app.coronatracker.data.remote.model.CountriesDataResponse
import co.icanteach.app.coronatracker.data.remote.model.TotalDataResponse
import co.icanteach.app.coronatracker.domain.dashboard.model.DashboardItem
import javax.inject.Inject

class DashboardItemMapper @Inject constructor() :
    Mapper2<TotalDataResponse, CountriesDataResponse, List<DashboardItem>> {
    override fun mapFromResponse(
        response: TotalDataResponse,
        response2: CountriesDataResponse
    ): List<DashboardItem> {

        val dashboardItems = mutableListOf<DashboardItem>()

        dashboardItems.add(
            0, DashboardItem.Motherland(
                dailyInfoImage = "https://covid19.saglik.gov.tr/img/1.jpg",
                totalInfoImage = "https://covid19.saglik.gov.tr/img/2.jpg"
            )
        )
        return dashboardItems
    }
}