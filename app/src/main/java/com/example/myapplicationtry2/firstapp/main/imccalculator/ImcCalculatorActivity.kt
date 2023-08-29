package com.example.myapplicationtry2.firstapp.main.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.myapplicationtry2.R

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false

    private lateinit var  viewMale:CardView
    private lateinit var  viewfemale:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUi()
    }

    private fun initComponents(){
        viewfemale = findViewById(R.id.viewFemale)
        viewMale = findViewById(R.id.viewMale)
    }
    private fun initListeners() {
        viewfemale.setOnClickListener{
            changeGender()
            setGenderColor()}
        viewMale.setOnClickListener{
            changeGender()
            setGenderColor()}
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewfemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }
    private fun getBackgroundColor(isSelectedComponent:Boolean):Int{

        val colorReference = if (isSelectedComponent){
            R.color.background_component_selected
        }else
            R.color.background_component

       return ContextCompat.getColor(this,colorReference)

    }
    private fun initUi() {
        setGenderColor()
    }
}