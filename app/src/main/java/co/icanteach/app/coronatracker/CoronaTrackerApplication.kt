package co.icanteach.app.coronatracker

import android.app.Application
import co.icanteach.app.coronatracker.inject.ApplicationComponent
import co.icanteach.app.coronatracker.inject.DaggerApplicationComponent

class CoronaTrackerApplication : Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}