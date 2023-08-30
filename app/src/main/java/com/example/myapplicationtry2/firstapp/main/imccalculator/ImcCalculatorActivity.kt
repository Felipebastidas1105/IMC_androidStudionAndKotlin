package com.example.myapplicationtry2.firstapp.main.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.myapplicationtry2.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import org.w3c.dom.Text
import java.text.DecimalFormat
import kotlin.math.log

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private var currentWeight:Int = 60
    private var currentAge:Int = 25
    private var currentHeight:Int = 120

    private lateinit var  viewMale:CardView
    private lateinit var  viewfemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnSubtract:FloatingActionButton
    private lateinit var btnPlus:FloatingActionButton
    private lateinit var tvWeight:TextView
    private lateinit var btnPlusAge:FloatingActionButton
    private lateinit var btnSubtractAge:FloatingActionButton
    private lateinit var tvAge:TextView
    private lateinit var btncalculate:Button

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }

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
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtract = findViewById(R.id.btnSubtractWeight)
        btnPlus = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        tvAge = findViewById(R.id.tvAge)
        btncalculate = findViewById(R.id.btncalculate)

    }
    private fun initListeners() {
        viewfemale.setOnClickListener{
            changeGender()
            setGenderColor()}
        viewMale.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value,_ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnPlus.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtract.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btncalculate.setOnClickListener {
            val result = calculateICM()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this,ResultImcActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateICM():Double {
        val df = DecimalFormat("#.##")
        var imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)

        return df.format(imc).toDouble()
    }

    private fun setWeight(){
        tvWeight.text = currentWeight.toString()
    }
    private fun setAge(){
        tvAge.text = currentAge.toString()
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
        setWeight()
        setAge()
    }
}