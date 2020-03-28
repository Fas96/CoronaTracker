package co.icanteach.app.coronatracker.data

import co.icanteach.app.coronatracker.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class TokenInterceptor @Inject constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()
        val builder = originRequest.newBuilder()
        builder.addHeader("authorization", "apikey ${BuildConfig.CONSUMER_KEY}")
        return chain.proceed(builder.build())
    }
}