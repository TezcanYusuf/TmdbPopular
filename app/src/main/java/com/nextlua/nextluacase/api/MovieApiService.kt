package com.nextlua.nextluacase.api

import com.nextlua.nextluacase.models.MovieIndex
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    suspend fun getIndexMovies(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int?,
    ): MovieIndex
}
