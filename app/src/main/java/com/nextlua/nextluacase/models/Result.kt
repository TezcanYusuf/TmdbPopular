package com.nextlua.nextluacase.models

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
data class Result(
    @JsonProperty("adult")
    val adult: Boolean? = false,
    @JsonProperty("backdrop_path")
    val backdropPath: String? = "",
    @JsonProperty("genre_ids")
    val genreIds: List<Int>? = null,
    @JsonProperty("id")
    val id: Int? = 0,
    @JsonProperty("original_language")
    val originalLanguage: String? = "",
    @JsonProperty("original_title")
    val originalTitle: String? = null,
    @JsonProperty("overview")
    val overview: String? = null,
    @JsonProperty("popularity")
    val popularity: Double? = null,
    @JsonProperty("poster_path")
    val posterPath: String? = null,
    @JsonProperty("release_date")
    val releaseDate: String? = null,
    @JsonProperty("title")
    val title: String? = "",
    @JsonProperty("video")
    val video: Boolean? = false,
    @JsonProperty("vote_average")
    val voteAverage: Double? = 0.0,
    @JsonProperty("vote_count")
    val voteCount: Int? = 0
): Parcelable