package com.ocruzmartz.laboratorio06

import android.app.Application
import com.ocruzmartz.laboratorio06.data.movies
import com.ocruzmartz.laboratorio06.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}