package com.luismaltez.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var calculateButton: Button
    private lateinit var heightText: EditText
    private lateinit var weightText: EditText
    private lateinit var totalText: TextView
    private lateinit var ratingText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        

        calculateButton.setOnClickListener {


        }

    }
    private fun bind(){
        calculateButton = findViewById(R.id.calculate_button)
        heightText = findViewById(R.id.height_edit_text)
        weightText = findViewById(R.id.weight_edit_text)
        totalText = findViewById(R.id.total_text_view)
        ratingText = findViewById(R.id.rating_text_view)

    }
}
