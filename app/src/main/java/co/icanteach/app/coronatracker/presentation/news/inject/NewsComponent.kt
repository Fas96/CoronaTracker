package co.icanteach.app.coronatracker.presentation.news.inject

import co.icanteach.app.coronatracker.presentation.news.NewsFragment
import dagger.Subcomponent

@Subcomponent
interface NewsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NewsComponent
    }

    fun inject(fragment: NewsFragment)
}