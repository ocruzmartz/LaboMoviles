package com.ocruzmartz.laboratorio08.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ocruzmartz.laboratorio08.MovieReviewerApplication
import com.ocruzmartz.laboratorio08.R
import com.ocruzmartz.laboratorio08.data.model.MovieModel
import com.ocruzmartz.laboratorio08.databinding.FragmentBillboardBinding
import com.ocruzmartz.laboratorio08.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.ocruzmartz.laboratorio08.ui.movie.viewmodel.MovieViewModel

class BillboardFragment : Fragment() {
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var adapter: MovieRecyclerViewAdapter
    private lateinit var binding: FragmentBillboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener {
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.recyclerView.adapter = adapter
        displayMovie()
    }

    private fun showSelectedItem(movie: MovieModel) {
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }

    private fun displayMovie() {
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }
}