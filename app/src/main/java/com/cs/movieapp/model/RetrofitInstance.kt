package com.cs.movieapp.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    const val API_KEY = "4813d2a45541f505da221eb5c8bb1020"

    val api : NetworkDataSource by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkDataSource::class.java)
    }
}