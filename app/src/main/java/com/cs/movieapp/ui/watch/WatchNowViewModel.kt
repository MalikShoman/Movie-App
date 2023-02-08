package com.cs.movieapp.ui.watch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs.movieapp.model.Repository
import com.cs.movieapp.model.movie.Movie
import com.cs.movieapp.model.movie.MovieResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class WatchNowViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var _movieData = MutableLiveData<List<Movie>>()
    val movieData : MutableLiveData<List<Movie>> get() = _movieData
    private lateinit var movieList:List<Movie>

    val errorMessage = SingleLiveEvent<String>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    init {
        getAllMovies()
    }

//    fun filterList(newText: String?) {
//
//        val filteredList: ArrayList<Movie> = ArrayList()
//
//        for (item in movieData.value.orEmpty()) {
//            if (newText != null && item.title.lowercase(Locale.getDefault())
//                    .contains(newText.lowercase(Locale.getDefault()))
//            ) {
//                filteredList.add(item)
//            }
//        }
//
//        if (newText.isNullOrBlank()){
//            _movieData.value = movieList
//        }
//        else {
//            _movieData.value = filteredList
//        }
//        if (filteredList.isEmpty()){
//            onError("no such element")
//        }
//    }

    private fun getAllMovies(){
        viewModelScope.launch(exceptionHandler) {
            movieList = repository.getMovies().results
            _movieData.postValue(movieList)
            loading.value = false
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        println("MSG$message")
        loading.value = false
    }
}