package com.ocruzmartz.laboratorio07.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ocruzmartz.laboratorio07.R
import com.ocruzmartz.laboratorio07.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}