package com.nextlua.nextluacase.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MovieIndex(
    @JsonProperty("page")
    val page: Int?,
    @JsonProperty("results")
    val results: List<Result>?,
    @JsonProperty("total_pages")
    val totalPages: Int?,
    @JsonProperty("total_results")
    val totalResults: Int?
)