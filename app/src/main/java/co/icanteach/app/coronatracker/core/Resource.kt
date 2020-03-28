package co.icanteach.app.coronatracker.core

sealed class Resource<T> {

    class Success<T>(val data: T) : Resource<T>()

    class Error<T>(val exception: Throwable) : Resource<T>()

    class Loading<T>() : Resource<T>()

    fun <R> map(transform: (T) -> R): Resource<R> = when (this) {
        is Success -> Success(
            transform(data)
        )
        is Error -> Error(
            exception
        )
        is Loading -> Loading()
    }
}