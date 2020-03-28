package co.icanteach.app.coronatracker.data.remote.model

class CountriesDataItemResponse constructor(
    val country: String,
    val totalCases: String,
    val newCases: String,
    val totalDeaths: String,
    val newDeaths: String,
    val totalRecovered: String,
    val activeCases: String
)
