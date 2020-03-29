package co.icanteach.app.coronatracker.presentation.dashboard.inject

import androidx.lifecycle.ViewModel
import co.icanteach.app.coronatracker.core.inject.ViewModelKey
import co.icanteach.app.coronatracker.presentation.dashboard.DashboardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(subcomponents = [DashboardComponent::class])
abstract class DashboardModule {

    @IntoMap
    @Binds
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(moviesViewModel: DashboardViewModel): ViewModel
}