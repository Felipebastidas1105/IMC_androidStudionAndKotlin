package com.example.myapplicationtry2.firstapp.main.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplicationtry2.R
import com.example.myapplicationtry2.firstapp.main.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY
import org.w3c.dom.Text

class ResultImcActivity : AppCompatActivity() {
    private lateinit var tvResult:TextView
    private lateinit var tvImc:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnRecalculate:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressed()}
    }

    private fun initUI(result: Double) {
        tvImc.text = result.toString()
        when(result){
            in 0.00 .. 18.50 -> { //Bajo peso
                tvResult.text = getString(R.string.tittle_bajo_peso)
                tvResult.setTextColor(getColor(R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.51 .. 24.99 -> { // Peso Normal
                tvResult.text = getString(R.string.tittle_peso_normal)
                tvResult.setTextColor(getColor(R.color.peso_normal))
                tvDescription.text = getString(R.string.description_peso_normal)
            }
            in 25.00 .. 29.99 -> { //SobrePeso
                tvResult.text = getString(R.string.tittle_sobre_peso)
                tvResult.setTextColor(getColor(R.color.sobre_peso))
                tvDescription.text = getString(R.string.description_sobre_peso)
            }
            in 30.00 .. 99.00 -> { //Obesidad
                tvResult.text = getString(R.string.tittle_obesidad)
                tvResult.setTextColor(getColor(R.color.obesidad))
                tvDescription.text = getString(R.string.description_obesidad)
            }else ->{ //Error
                tvImc.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(getColor(R.color.obesidad))
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents(){
        tvImc = findViewById(R.id.tvImc)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

}