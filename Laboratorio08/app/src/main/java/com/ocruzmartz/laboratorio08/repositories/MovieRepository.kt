package com.ocruzmartz.laboratorio08.repositories

import com.ocruzmartz.laboratorio08.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies
    fun addMovies(movie: MovieModel) = movies.add(movie)
}