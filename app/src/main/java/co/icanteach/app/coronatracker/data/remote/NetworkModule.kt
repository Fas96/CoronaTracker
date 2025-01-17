package co.icanteach.app.coronatracker.data.remote

import co.icanteach.app.coronatracker.BuildConfig
import co.icanteach.app.coronatracker.data.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @Provides
    @Reusable
    internal fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(TokenInterceptor())
        return builder.build()
    }

    @Provides
    @Reusable
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Reusable
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Reusable
    fun provideRestInterface(retrofit: Retrofit): CoronaTrackerRestInterface {
        return retrofit.create(CoronaTrackerRestInterface::class.java)
    }
}