package org.example.home.data.mappers

import org.example.coreNetwork.model.TrendingMovieDto
import org.example.home.domain.model.TrendingMovies


const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
fun TrendingMovieDto.toDomain(): TrendingMovies {
    return TrendingMovies(
        page = this.page,
        results = this.results.map { it.toDomain() },
        total_pages = this.total_pages,
        total_results = this.total_results
    )
}

fun TrendingMovieDto.Result.toDomain(): TrendingMovies.Result {
    return TrendingMovies.Result(
        adult = this.adult,
        backdrop_path = this.backdrop_path,
        genre_ids = this.genre_ids,
        id = this.id,
        original_language = this.original_language,
        original_title = this.original_title,
        overview = this.overview,
        popularity = this.popularity,
        poster_path = IMAGE_BASE_URL + this.poster_path,
        release_date = this.release_date,
        title = this.title,
        video = this.video,
        vote_average = this.vote_average,
        vote_count = this.vote_count
    )
}