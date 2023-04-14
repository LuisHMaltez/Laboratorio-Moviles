package com.example.laboratorio4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.dependencia.R


private val keyName = "NAME"
private val keyMail = "MAIL"
private val keyNumber = "NUMBER"

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val showTextName = findViewById<TextView>(R.id.name_show_confirm)
        val showTextMail = findViewById<TextView>(R.id.mail_show_confirm)
        val showTextNumber = findViewById<TextView>(R.id.number_show_confirm)
        val btnShare = findViewById<Button>(R.id.share_btn)

        //logical
        val name = intent.getStringExtra(keyName).toString()
        val mail = intent.getStringExtra(keyMail).toString()
        val number = intent.getStringExtra(keyNumber).toString()

        showTextName.text = name
        showTextMail.text = mail
        showTextNumber.text = number

        btnShare.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Name: $name\nEmail: $mail\nCellphone: $number")

            startActivity(Intent.createChooser(shareIntent, "Share to:"))
        }

    }

}