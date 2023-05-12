package com.ocruzmartz.laboratorio08.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ocruzmartz.laboratorio08.R

import com.ocruzmartz.laboratorio08.databinding.ActivityMainBinding
import com.ocruzmartz.laboratorio08.databinding.FragmentMovieBinding
import com.ocruzmartz.laboratorio08.ui.movie.viewmodel.MovieViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
