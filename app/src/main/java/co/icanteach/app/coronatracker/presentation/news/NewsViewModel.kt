package co.icanteach.app.coronatracker.presentation.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.icanteach.app.coronatracker.core.Resource
import co.icanteach.app.coronatracker.domain.news.FetchNewsUseCase
import co.icanteach.app.coronatracker.domain.news.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val fetchNewsUseCase: FetchNewsUseCase
) : ViewModel() {

    private val news = MutableLiveData<List<News>>()

    fun getNewsResult(): LiveData<List<News>> = news

    fun fetchCoronaNews() {
        viewModelScope
            .launch(Dispatchers.IO) {
                fetchNewsUseCase.fetchCoronaNews().collect { resource ->
                    when (resource) {
                        is Resource.Success -> updatePageForResult(resource.data)
                        is Resource.Error -> updatePageForError()
                        is Resource.Loading -> updatePageForLoading()
                    }
                }
            }
    }

    private fun updatePageForResult(data: List<News>) {
        news.postValue(data)
    }

    private fun updatePageForError() {

    }

    private fun updatePageForLoading() {

    }
}