package com.ocruzmartz.laboratorio03

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var  fiveCentImage : ImageView;
    private lateinit var tenCentImage : ImageView;
    private lateinit var quarterCentImage : ImageView;
    private lateinit var oneDollarImage : ImageView;
    private lateinit var cashText : TextView;
    private var num = 0.00;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fiveCentImage = findViewById(R.id.Five_Cent_Image)
        tenCentImage = findViewById(R.id.Ten_Cent_Image)
        quarterCentImage = findViewById(R.id.Quarter_Cent_Image)
        oneDollarImage = findViewById(R.id.One_Dollar_Image)
        cashText = findViewById(R.id.Cash_Text)

        fiveCentImage.setOnClickListener(){
            num += 0.05
            num = String.format("%.2f", num).toDouble()
            cashText.text = "$${num}"
        }

        tenCentImage.setOnClickListener(){
            num += 0.10
            num = String.format("%.2f", num).toDouble()
            cashText.text = "$${num}"
        }

        quarterCentImage.setOnClickListener(){
            num += 0.25
            num = String.format("%.2f", num).toDouble()
            cashText.text = "$${num}"
        }

        oneDollarImage.setOnClickListener(){
            num += 1.00
            num = String.format("%.2f", num).toDouble()
            cashText.text = "$${num}"
        }


    }






}