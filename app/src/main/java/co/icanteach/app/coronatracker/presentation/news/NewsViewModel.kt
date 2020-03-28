package co.icanteach.app.coronatracker.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.icanteach.app.coronatracker.domain.news.FetchNewsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val fetchNewsUseCase: FetchNewsUseCase
) : ViewModel() {
    fun fetchReleaseNotes() {
        viewModelScope
            .launch {
                val result = fetchNewsUseCase.fetchCoronaNews()
            }
    }
}