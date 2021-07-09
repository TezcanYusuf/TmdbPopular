package com.nextlua.nextluacase.ui.detail

import com.nextlua.nextluacase.R
import com.nextlua.nextluacase.base.BaseDialogFragment
import com.nextlua.nextluacase.constants.Keys
import com.nextlua.nextluacase.databinding.FragmentMovieDetailBinding
import com.nextlua.nextluacase.models.Result

class MovieDetailFragment :
    BaseDialogFragment<FragmentMovieDetailBinding>(
        R.layout.fragment_movie_detail
    ) {

    override fun FragmentMovieDetailBinding.initialize() {
        val movieData = arguments?.get(Keys.movieKey) as Result
        binding.movie = movieData
    }
}
