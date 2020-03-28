package co.icanteach.app.coronatracker.presentation.news.inject

import androidx.lifecycle.ViewModel
import co.icanteach.app.coronatracker.core.inject.ViewModelKey
import co.icanteach.app.coronatracker.presentation.news.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(subcomponents = [NewsComponent::class])
abstract class NewsModule {

    @IntoMap
    @Binds
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindNewsViewModel(moviesViewModel: NewsViewModel): ViewModel
}