package com.nextlua.nextluacase.repository

import com.nextlua.nextluacase.api.MovieApiService
import com.nextlua.nextluacase.models.MovieIndex
import kotlinx.coroutines.Dispatchers
import com.nextlua.nextluacase.resources.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MovieIndexRepository @Inject constructor(
    private val movieApiService: MovieApiService
) {

    fun getMovieList(
        apiKey: String?,
        language: String?,
        page: Int?,
    ): Flow<Resource<MovieIndex>> {
        return flow {
            emit(Resource.loading(null))
            val movieResponse = movieApiService.getIndexMovies(
                apiKey = apiKey,
                language = language,
                page = page
            )
            emit(Resource.success(movieResponse))
        }.catch {
            emit(Resource.error(it.localizedMessage, null))
        }.flowOn(Dispatchers.IO)
    }

}