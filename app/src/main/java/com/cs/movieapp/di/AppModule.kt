package com.cs.movieapp.di

import android.content.Context
import com.cs.movieapp.model.NetworkDataSource
import com.cs.movieapp.model.RetrofitInstance
//import com.cs.movieapp.model.movie.MovieDao
//import com.cs.movieapp.model.movie.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideNetworkDataSource(): NetworkDataSource {
        return RetrofitInstance.api
    }

//    @Singleton
//    @Provides
//    fun provideTodoDao(@ApplicationContext context: Context): MovieDao {
//        return MovieDatabase.getDatabase(context).movieDao()
//    }

//    @Singleton
//    @Provides
//    fun provideUserDao(@ApplicationContext context: Context): UserDao {
//        return UserDatabase.getDatabase(context).userDao()
//    }
}