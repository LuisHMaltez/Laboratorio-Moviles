package com.example.laboratorio6.iu.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio6.MovieReviewerApplication
import com.example.laboratorio6.data.model.MovieModel
import com.example.laboratorio6.repositories.MovieRepository

class MovieViewModel (private val repository: MovieRepository) : ViewModel() {
    fun getMovies ()= repository.getMovies()

    fun addMovies (movie: MovieModel) = repository.addMovies(movie)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app =
                    this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}