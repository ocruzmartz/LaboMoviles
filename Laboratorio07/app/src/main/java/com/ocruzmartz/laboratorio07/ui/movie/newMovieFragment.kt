package com.ocruzmartz.laboratorio07.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.activityViewModels
//import com.google.android.material.textfield.TextInputEditText
//import com.ocruzmartz.laboratorio07.R
//import com.ocruzmartz.laboratorio07.data.model.MovieModel
import com.ocruzmartz.laboratorio07.databinding.FragmentNewMovieBinding

class newMovieFragment : Fragment() {
    private val viewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

//    private lateinit var name: TextInputEditText
//    private lateinit var category: TextInputEditText
//    private lateinit var description: TextInputEditText
//    private lateinit var calification: TextInputEditText
//    private lateinit var action: Button

    private lateinit var binding: FragmentNewMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_new_movie, container, false)
        binding = FragmentNewMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        bind(view)
//        action.setOnClickListener {
//            createMovie()
//        }

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

//    private fun bind(view: View) {
//        name = view.findViewById(R.id.text_name_movieFragment)
//        category = view.findViewById(R.id.text_category_movieFragment)
//        description = view.findViewById(R.id.text_description_movieFragment)
//        calification = view.findViewById(R.id.text_calification_movieFragment)
//        action = view.findViewById(R.id.btn_submit_action)
//    }
//
//    private fun createMovie() {
//        val newMovie = MovieModel(
//            name.text.toString(),
//            category.text.toString(),
//            description.text.toString(),
//            calification.text.toString()
//        )
//
//        viewModel.addMovies(newMovie)
//        Log.d("APP TAG", viewModel.getMovies().toString())
//        findNavController().popBackStack()
//    }

//    private fun observeStatus(){
//        viewModel.status.observe(viewLifecycleOwner) { status ->
//            when{
//                status.equals(MovieViewModel.MOVIE_CREATED) -> {
//                    Log.d("APP_TAG", status)
//                    Log.d("APP_TAG", viewModel.getMovies().toString())
//                    viewModel.clearData()
//                    viewModel.clearStatus()
//                    findNavController().popBackStack()
//                }
//                status.equals(MovieViewModel.WRONG_DATA) -> {
//                    Log.d("APP_TAG", status)
//                    viewModel.clearStatus()
//                    //findNavController().popBackStack()
//                }
//            }
//        }
//    }

    private fun observeStatus() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d("APP_TAG", status)
                    viewModel.clearStatus()
                }

                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("APP_TAG", status)
                    Log.d("APP_TAG", viewModel.getMovies().toString())
                    viewModel.clearData()

                    viewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
}