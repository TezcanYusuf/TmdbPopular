package com.nextlua.nextluacase.ui.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nextlua.nextluacase.enums.Status
import com.nextlua.nextluacase.models.MovieIndex
import com.nextlua.nextluacase.repository.MovieIndexRepository
import com.nextlua.nextluacase.resources.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MovieListViewModel
@ViewModelInject constructor(
    private val movieIndexRepository: MovieIndexRepository
) : ViewModel() {

    var page: Int = 0

    private val movies: MutableLiveData<Resource<MovieIndex>> = MutableLiveData()

    fun getMovies(
        apiKey: String?,
        language: String?,
        page: Int?,
    ): LiveData<Resource<MovieIndex>> {
        return run {
            viewModelScope.launch {
                movieIndexRepository.getMovieList(apiKey = apiKey, language = language, page = page)
                    .collect {
                        if (it.status == Status.SUCCESS) {
                            movies.postValue(it)
                        }
                    }
            }
            movies
        }
    }
}
