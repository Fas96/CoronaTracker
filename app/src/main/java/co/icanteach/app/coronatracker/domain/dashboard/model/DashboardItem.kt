package co.icanteach.app.coronatracker.domain.dashboard.model

sealed class DashboardItem {
    class Motherland(
        dailyInfoImage: String,
        totalInfoImage: String
    ) : DashboardItem()

    class EarthTotal(
        val totalDeaths: String,
        val totalCases: String,
        val totalRecovered: String
    ) : DashboardItem()

    class CountrySpecial(
        val countryName: String,
        val totalCases: String,
        val newCases: String,
        val totalDeaths: String,
        val newDeaths: String,
        val totalRecovered: String,
        val activeCases: String
    ) : DashboardItem()
}