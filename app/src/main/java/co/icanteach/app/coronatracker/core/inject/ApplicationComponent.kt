package co.icanteach.app.coronatracker.core.inject

import co.icanteach.app.coronatracker.data.remote.NetworkModule
import co.icanteach.app.coronatracker.presentation.news.inject.NewsComponent
import co.icanteach.app.coronatracker.presentation.news.inject.NewsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        NewsModule::class]
)
interface ApplicationComponent {
    fun newsComponent(): NewsComponent.Factory
}