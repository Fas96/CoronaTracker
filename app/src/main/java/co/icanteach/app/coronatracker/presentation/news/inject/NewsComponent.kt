package co.icanteach.app.coronatracker.presentation.news.inject

import co.icanteach.app.coronatracker.presentation.news.NewsFragment
import dagger.Subcomponent

@Subcomponent
interface NewsComponent {

    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): NewsComponent
    }

    fun inject(fragment: NewsFragment)
}