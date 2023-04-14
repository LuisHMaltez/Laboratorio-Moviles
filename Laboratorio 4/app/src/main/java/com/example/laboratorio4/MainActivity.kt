package com.example.laboratorio4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.dependencia.R
import com.google.android.material.textfield.TextInputEditText

private lateinit var nameinput: TextInputEditText
private lateinit var mailinput: TextInputEditText
private lateinit var numberinput: TextInputEditText
private lateinit var savebtn: Button

private val keyName = "NAME";
private val keyMail = "MAIL";
private val keyNumber = "NUMBER";

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        listeners()


    }
    private fun bind(){
        nameinput = findViewById(R.id.name_input);
        mailinput = findViewById(R.id.mail_input);
        numberinput = findViewById(R.id.number_input);
        savebtn = findViewById(R.id.save_btn);
    }

    private fun listeners(){
        savebtn.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java);
            intent.putExtra(keyName, nameinput.text.toString());
            intent.putExtra(keyMail, mailinput.text.toString());
            intent.putExtra(keyNumber, numberinput.text.toString());

            startActivity(intent);
        }
    }
}