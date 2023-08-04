package com.example.gopikalab02android

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MViewModel(application: Application) : AndroidViewModel(application) {

    private val movieDao: MovieDao

    init {
        val database = MovieDatabase.getDatabase(application)
        movieDao = database.movieDao()
    }

    val movies: LiveData<List<MovieEntity>> = movieDao.getAllMovies()

    fun addMovie(title: String, genre: String) {
        val newMovie = MovieEntity(title = title, genre = genre)
        viewModelScope.launch {
            movieDao.insert(newMovie)
        }
    }
}
