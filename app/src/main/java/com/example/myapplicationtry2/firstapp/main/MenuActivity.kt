package com.example.myapplicationtry2.firstapp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplicationtry2.R
import com.example.myapplicationtry2.firstapp.main.imccalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaluted = findViewById<Button>(R.id.btnSaluted)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnSaluted.setOnClickListener{navigateToSaluted()}
        btnIMCApp.setOnClickListener{navigateToImcApp()}

    }
    private fun navigateToSaluted(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToImcApp(){
        val intent = Intent(this,ImcCalculatorActivity::class.java)
        startActivity(intent)
    }
}