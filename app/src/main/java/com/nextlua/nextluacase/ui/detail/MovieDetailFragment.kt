package com.nextlua.nextluacase.ui.detail

import android.util.Log
import com.nextlua.nextluacase.MainActivity
import com.nextlua.nextluacase.R
import com.nextlua.nextluacase.base.BaseDialogFragment
import com.nextlua.nextluacase.constants.Keys
import com.nextlua.nextluacase.databinding.FragmentMovieDetailBinding
import com.nextlua.nextluacase.models.Result

class MovieDetailFragment : BaseDialogFragment<FragmentMovieDetailBinding>(R.layout.fragment_movie_detail) {

    override fun FragmentMovieDetailBinding.initialize() {
        val movieData = arguments?.get(Keys.movieNameKey) as Result
        binding.movie = movieData
        Log.e("Deneme", movieData.toString())
        Log.e("MovieIndex ", movieData.backdropPath.toString())
    }
}
