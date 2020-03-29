package co.icanteach.app.coronatracker.core


interface Mapper2<T, M, R> {
    fun mapFromResponse(response: T, response2: M): R
}