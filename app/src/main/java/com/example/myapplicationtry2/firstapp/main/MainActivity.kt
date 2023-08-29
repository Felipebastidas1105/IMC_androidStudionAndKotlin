package com.example.myapplicationtry2.firstapp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatEditText
import com.example.myapplicationtry2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        val editTextName = findViewById<AppCompatEditText>(R.id.etName)


        btn.setOnClickListener{
            val name = editTextName.text.toString()
            if (name.isNotEmpty()){
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }

        }
    }
}