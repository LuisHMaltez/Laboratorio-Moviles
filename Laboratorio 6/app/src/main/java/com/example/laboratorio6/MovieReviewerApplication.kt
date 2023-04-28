package com.example.laboratorio6

import android.app.Application
import com.example.laboratorio6.repositories.MovieRepository
import com.example.laboratorio6.data.model.movies

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}