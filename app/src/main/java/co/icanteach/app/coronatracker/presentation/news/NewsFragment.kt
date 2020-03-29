package co.icanteach.app.coronatracker.presentation.news

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.icanteach.app.coronatracker.CoronaTrackerApplication
import co.icanteach.app.coronatracker.R
import co.icanteach.app.coronatracker.core.observeNonNull
import co.icanteach.app.coronatracker.presentation.MainActivity
import co.icanteach.app.coronatracker.presentation.news.inject.NewsComponent
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment : Fragment() {

    lateinit var newsComponent: NewsComponent

    private val viewModel: NewsViewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var newsAdapter: NewsAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        newsComponent = ((activity as MainActivity).applicationContext as CoronaTrackerApplication)
            .appComponent.newsComponent().create()
        newsComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.adapter = newsAdapter
        newsAdapter.onNewsItemClick = {
            openWebContent(it)
        }
        viewModel.getNewsResult().observeNonNull(viewLifecycleOwner) { news ->
            newsAdapter.setNews(news)
        }
    }


    private fun openWebContent(url: String) {
        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        builder.addDefaultShareMenuItem()
        builder.setShowTitle(true)
        builder.setStartAnimations(
            requireContext(),
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )
        builder.setExitAnimations(
            requireContext(),
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )

        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(requireContext(), Uri.parse(url))
    }
}