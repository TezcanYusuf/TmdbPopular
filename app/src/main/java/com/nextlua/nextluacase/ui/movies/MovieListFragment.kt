package com.nextlua.nextluacase.ui.movies

import android.os.Bundle
import android.util.Log
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nextlua.nextluacase.MainActivity
import com.nextlua.nextluacase.R
import com.nextlua.nextluacase.base.BaseFragment
import com.nextlua.nextluacase.constants.Keys
import com.nextlua.nextluacase.databinding.FragmentMovieListBinding
import com.nextlua.nextluacase.enums.Status
import com.nextlua.nextluacase.extensions.navigateSafe
import com.nextlua.nextluacase.listener.IListener
import com.nextlua.nextluacase.models.Result
import com.nextlua.nextluacase.ui.movies.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding>(R.layout.fragment_movie_list), IListener {

    private val movieViewModel: MovieListViewModel by navGraphViewModels(R.id.navigaton_tmdb) {
        defaultViewModelProviderFactory
    }

    private lateinit var moviesData: MutableList<Result>
    private lateinit var movieAdapter: MovieAdapter
    var totalPage = 0

    override fun FragmentMovieListBinding.initialize() {

        val pageNumber = MainActivity.sharedObject.pageNumber
        if (pageNumber == 0) {
            getMoviesList(1)
            MainActivity.sharedObject.pageNumber = 1
        } else {
            getMoviesList(MainActivity.sharedObject.pageNumber)
        }
        Log.e("MovieListFragment", "asdasd")

        nextPageListener()

    }

    private fun nextPageListener() {
        binding.gvMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1)) {
                    val currentPageNumber = MainActivity.sharedObject.pageNumber
                    if (totalPage != 0 && currentPageNumber + 1 < totalPage) {
                        getMoviesList( currentPageNumber + 1)
                        MainActivity.sharedObject.pageNumber = currentPageNumber + 1
                        Log.e("Nextt", "Pageeee" + totalPage.toString())
                    }
                } else {
                    Log.e("Başa dön", "bir önceki sayfaya")
                }
            }
        })
    }

    private fun getMoviesList(page: Int) {
        Log.e("PageNumber :", page.toString())

        movieViewModel.getMovies(
            apiKey = Keys.apiKey,
            language = Keys.languageKey,
            page = page
        ).observe(viewLifecycleOwner, {

            when (it.status) {
                Status.SUCCESS -> {
                    Log.e("Data", it.data.toString())
                    totalPage = it.data?.totalPages!!
                    val layoutManager = GridLayoutManager(requireContext(), 2)
                    binding.gvMovies.layoutManager = layoutManager
                    binding.gvMovies.adapter = it.data.results?.let { it1 -> MovieAdapter(it1, this) }
                    moviesData = it.data.results as MutableList<Result>
                }
                Status.LOADING -> {
                }
                Status.ERROR -> {
                    Log.e("Response", "ERROR" + it.message)
                }
            }
        })
    }


    override fun onClick(position: Int) {
        Log.e("Click", "clickkk" + position.toString())
        moviesData
        Log.e("Data::", moviesData[position].toString())
        val bundle = Bundle().apply {
            putParcelable(Keys.movieNameKey, moviesData[position])
        }
        navigateSafe(resId = R.id.action_movieListFragment_to_movieDetailFragment, bundle = bundle)
    }

    override fun onResume() {
        super.onResume()

    }

}