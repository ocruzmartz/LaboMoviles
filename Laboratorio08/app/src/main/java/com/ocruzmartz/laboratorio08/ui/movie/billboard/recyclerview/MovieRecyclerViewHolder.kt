package com.ocruzmartz.laboratorio08.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.ocruzmartz.laboratorio08.data.model.MovieModel
import com.ocruzmartz.laboratorio08.databinding.MovieItemBinding

class MovieRecyclerViewHolder(private val binding: MovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.titleTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification

        binding.idCardViewMovie.setOnClickListener {
            clickListener(movie)
        }
    }
}
