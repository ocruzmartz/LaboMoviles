package com.ocruzmartz.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var actionCalculate: Button
    private lateinit var bmiTextView: TextView
    private lateinit var resultTextView: TextView
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        setListener()
    }

    private fun bind() {
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        actionCalculate = findViewById(R.id.action_calculate)
        bmiTextView = findViewById(R.id.bmi_text_view)
        resultTextView = findViewById(R.id.result_text_view)
        infoTextView = findViewById(R.id.info_text_view)
    }

    private fun setListener() {
        actionCalculate.setOnClickListener {
            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()

            if (!validateInput(height, weight)) {
                clearTextView()
                return@setOnClickListener
            }

            val bmi = calculateBmi(height.toFloat(), weight.toFloat())
            val bmiTwoDigits = String.format("%.1f", bmi)

            clearFocus()
            displayResult(bmiTwoDigits.toFloat())
        }
    }

    private fun calculateBmi(height: Float, weight: Float): Float {
        return weight / ((height / 100) * (height / 100))
    }

    private fun displayResult(bmi: Float) {
        bmiTextView.text = bmi.toString()
        infoTextView.text = "(Normal range is 18.5 - 24.9)"
        var informationResult = ""
        var color = 0

        when {
            bmi < 18.50 -> {
                informationResult = "Underweight"
                color = R.color.under_weight
            }
            bmi in 18.50..24.99 -> {
                informationResult = "Healthy"
                color = R.color.normal_weight
            }
            bmi in 25.00..29.99 -> {
                informationResult = "Overweight"
                color = R.color.over_weight
            }
            bmi > 18.50 -> {
                informationResult = "Obese"
                color = R.color.obese
            }
        }

        resultTextView.text = informationResult
        resultTextView.setTextColor(ContextCompat.getColor(this, color))
    }

    private fun clearFocus() {
        weightEditText.clearFocus()
        heightEditText.clearFocus()
    }

    private fun clearTextView() {
        bmiTextView.text = ""
        resultTextView.text = ""
        infoTextView.text = ""
    }

    private fun validateInput(height: String?, weight: String?): Boolean {
        when {
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty!", Toast.LENGTH_SHORT).show()
                return false
            }
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty!", Toast.LENGTH_SHORT).show()
                false
            }
        }
        return true
    }
}