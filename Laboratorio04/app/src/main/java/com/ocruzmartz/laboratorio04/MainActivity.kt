package com.ocruzmartz.laboratorio04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var telEditText: EditText
    private lateinit var actionNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.id_name_text_main)
        emailEditText = findViewById(R.id.id_email_text_main)
        telEditText = findViewById(R.id.id_phone_text_main)
        actionNext = findViewById(R.id.action_save)

        actionNext.setOnClickListener {
            val intent = Intent(this, ShareActivity::class.java)
            intent.putExtra("name", nameEditText.text.toString())
            intent.putExtra("email", emailEditText.text.toString())
            intent.putExtra("tel", telEditText.text.toString())
            startActivity(intent)
        }
    }
}