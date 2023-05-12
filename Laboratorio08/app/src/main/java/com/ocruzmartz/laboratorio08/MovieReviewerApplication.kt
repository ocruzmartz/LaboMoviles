package com.ocruzmartz.laboratorio08

import android.app.Application
import com.ocruzmartz.laboratorio08.data.movies
import com.ocruzmartz.laboratorio08.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}