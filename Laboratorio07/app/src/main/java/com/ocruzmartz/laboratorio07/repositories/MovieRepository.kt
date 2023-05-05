package com.ocruzmartz.laboratorio07.repositories

import com.ocruzmartz.laboratorio07.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies
    fun addMovies(movie: MovieModel) = movies.add(movie)
}