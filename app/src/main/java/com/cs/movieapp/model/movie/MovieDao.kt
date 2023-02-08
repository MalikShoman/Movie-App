package com.cs.movieapp.model.movie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

//@Dao
//interface MovieDao {
//
////    @Query("SELECT * FROM movie")
////    suspend fun getAll(): List<Movie>
//
////    @Insert(onConflict = REPLACE)
////    suspend fun insertMovies(movies : List<MovieResponse>)
//
////    @Query("DELETE FROM todo")
////    suspend fun delAll()
//}