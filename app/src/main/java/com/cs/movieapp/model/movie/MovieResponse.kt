package com.cs.movieapp.model.movie

import androidx.room.Entity
import androidx.room.PrimaryKey

data class MovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)