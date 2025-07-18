package org.example.coreNetwork.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendingMovieDto(
    val page: Int,
    val results: List<Result>,
    @SerialName("total_pages") val total_pages: Int,
    @SerialName("total_results") val total_results: Int
) {
    @Serializable
    data class Result(
        val adult: Boolean,
        val backdrop_path: String,
        val genre_ids: List<Int>,
        val id: Int,
        val original_language: String,
        val original_title: String,
        val overview: String,
        val popularity: Double,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val video: Boolean,
        val vote_average: Double,
        val vote_count: Int
    )
}