package co.icanteach.app.coronatracker.core.inject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * reference : https://github.com/googlesamples/android-architecture-components
 */
@Singleton
class ViewModelFactory @Inject constructor(private val viewModelMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var viewModel = viewModelMap[modelClass]

        if (viewModel == null) {
            for (entry in viewModelMap) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    viewModel = entry.value
                    break
                }
            }
        }
        requireNotNull(viewModel) { "Unknown model class $modelClass" }
        return viewModel.get() as T
    }
}