package co.icanteach.app.coronatracker.presentation.dashboard.inject

import co.icanteach.app.coronatracker.presentation.dashboard.DashboardFragment
import dagger.Subcomponent

@Subcomponent
interface DashboardComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DashboardComponent
    }

    fun inject(fragment: DashboardFragment)
}