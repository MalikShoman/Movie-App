package com.cs.movieapp.model

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.cs.fts.model.ApplicationPreferences
import com.cs.movieapp.model.movie.Movie
import com.cs.movieapp.model.movie.MovieResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class Repository @Inject constructor(

    private val networkDataSource: NetworkDataSource,
//    private val movieDao: MovieDao,
    @ApplicationContext
    private val context: Context,
    private val applicationPreferences: ApplicationPreferences
) {

    private lateinit var movieList: List<Movie>


    suspend fun getMovies(): MovieResponse {

        return networkDataSource.getPopularMovies()

//        if (true){
//           movieList = networkDataSource.getPopularMovies()
//            println("MMM${movieList}")
////            storeInRoom(movieList)
//        }else{
////            movieList = getFromRoom()
//        }
//        return movieList
    }

    fun setUserName(userName: String) {
        applicationPreferences.setUserName(userName)
    }

    fun getUserName(): String? {
        return applicationPreferences.getUserName()
    }


//    private suspend fun storeInRoom(movies: List<MovieResponse>) {
////        movieDao.insertMovies(movies)
//        println("KKK" + movieDao.getAll())
//    }
//
//    private suspend fun getFromRoom(): List<Movie> {
//        println("KKK" + movieDao.getAll())
//        return movieDao.getAll()
//    }

    private fun checkConnection(context: Context): Boolean {

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
//        Toast.makeText(context,context.getString(R.string.no_internet),Toast.LENGTH_SHORT).show()
        return false

    }

}