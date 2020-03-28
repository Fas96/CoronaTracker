package co.icanteach.app.coronatracker.core

interface Mapper<T, R> {
    fun mapFromResponse(response: T): R
}