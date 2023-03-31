    package com.example.laboratorio3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var addfivecent: ImageView
    private lateinit var addtencents: ImageView
    private lateinit var addquarter: ImageView
    private lateinit var addonedollar: ImageView
    private lateinit var counttext: TextView
    private var counter = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        counttext.text = String.format("$%.2f", counter)
        addListener()
    }

    private fun bind() {
        addfivecent = findViewById(R.id.five_cents_img)
        addtencents = findViewById(R.id.ten_cents_img)
        addquarter = findViewById(R.id.quarter_img)
        addonedollar = findViewById(R.id.one_dollar_img)
        counttext = findViewById(R.id.count_text_view)
    }

    @SuppressLint("SetTextI18n")
    private fun addListener() {
        addfivecent.setOnClickListener {
            counter += 0.05
            counttext.text = "$ %.2f".format(counter)

        }

        addtencents.setOnClickListener {
            counter += 0.10
            counttext.text = "$ %.2f".format(counter)

        }

        addquarter.setOnClickListener {
            counter += 0.25
            counttext.text = "$ %.2f".format(counter)

        }

        addonedollar.setOnClickListener {
            counter += 1
            counttext.text = "$ %.2f".format(counter)

        }
    }
}