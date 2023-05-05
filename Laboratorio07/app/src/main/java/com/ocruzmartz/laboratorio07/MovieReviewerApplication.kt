package com.ocruzmartz.laboratorio07

import android.app.Application
import com.ocruzmartz.laboratorio07.data.movies
import com.ocruzmartz.laboratorio07.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}