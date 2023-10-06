package com.example.myapplicationtry2.firstapp.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplicationtry2.R
import com.example.myapplicationtry2.firstapp.main.imccalculator.ImcCalculatorActivity
import com.example.myapplicationtry2.firstapp.main.settings.SettingsActivity
import com.example.myapplicationtry2.firstapp.main.todoapp.ToDoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaluted = findViewById<Button>(R.id.btnSaluted)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnToDoApp = findViewById<Button>(R.id.btnToDo)
        val btnSettings = findViewById<Button>(R.id.btnSettings)
        btnSaluted.setOnClickListener{navigateToSaluted()}
        btnIMCApp.setOnClickListener{navigateToImcApp()}
        btnToDoApp.setOnClickListener{navigateToDoApp()}
        btnSettings.setOnClickListener{navigateToSettings()}

    }

    private fun navigateToSettings() {
        val intent = Intent(this,SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToDoApp() {
        val intent = Intent(this, ToDoActivity::class.java)
        startActivity(intent)
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