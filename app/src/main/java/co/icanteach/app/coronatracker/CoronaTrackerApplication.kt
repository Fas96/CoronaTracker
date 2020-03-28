package co.icanteach.app.coronatracker

import android.app.Application
import co.icanteach.app.coronatracker.core.inject.ApplicationComponent
import co.icanteach.app.coronatracker.core.inject.DaggerApplicationComponent

class CoronaTrackerApplication : Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}