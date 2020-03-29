package co.icanteach.app.coronatracker.core.inject

import co.icanteach.app.coronatracker.data.remote.NetworkModule
import co.icanteach.app.coronatracker.presentation.dashboard.inject.DashboardComponent
import co.icanteach.app.coronatracker.presentation.dashboard.inject.DashboardModule
import co.icanteach.app.coronatracker.presentation.news.inject.NewsComponent
import co.icanteach.app.coronatracker.presentation.news.inject.NewsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        NewsModule::class,
        DashboardModule::class]
)
interface ApplicationComponent {
    fun newsComponent(): NewsComponent.Factory

    fun dashboardComponent(): DashboardComponent.Factory
}