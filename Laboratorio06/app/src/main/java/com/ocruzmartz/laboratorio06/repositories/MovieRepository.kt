package com.ocruzmartz.laboratorio06.repositories

import com.ocruzmartz.laboratorio06.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies
    fun addMovies(movie: MovieModel) = movies.add(movie)
}