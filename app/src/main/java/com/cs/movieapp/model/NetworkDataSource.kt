package com.cs.movieapp.model

import com.cs.movieapp.model.movie.Movie
import com.cs.movieapp.model.movie.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkDataSource {

    @GET("movie/popular?api_key=4813d2a45541f505da221eb5c8bb1020")
    suspend fun getPopularMovies(): MovieResponse

}