package com.ocruzmartz.laboratorio04
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.TextView
import com.ocruzmartz.laboratorio04.R
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShareActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var telTextView: TextView
    private lateinit var actionShareImplicit: Button

    private lateinit var nameText : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        nameTextView = findViewById(R.id.id_textName_share)
        emailTextView = findViewById(R.id.id_textEmail_share)
        telTextView = findViewById(R.id.id_textPhone_share)
        actionShareImplicit = findViewById(R.id.id_btn_share)

        var nameShared = intent.getStringExtra("name").toString()
        var emailShared = intent.getStringExtra("email").toString()
        var telShared = intent.getStringExtra("tel").toString()

        nameTextView.text = "Nombre: ${nameShared}"
        emailTextView.text = "Correo: ${emailShared}"
        telTextView.text = "Teléfono: ${telShared}"

        nameText = nameTextView.text.toString();

        actionShareImplicit.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "Name: $nameText")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}