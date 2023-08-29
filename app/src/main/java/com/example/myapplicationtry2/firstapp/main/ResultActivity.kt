package com.example.myapplicationtry2.firstapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplicationtry2.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvResult.text = "Hello $name"
    }
}