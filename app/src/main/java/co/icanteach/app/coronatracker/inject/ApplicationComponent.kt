package co.icanteach.app.coronatracker.inject

import co.icanteach.app.coronatracker.data.remote.NetworkModule
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

}