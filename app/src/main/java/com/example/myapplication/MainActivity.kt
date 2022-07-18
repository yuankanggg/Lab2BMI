package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Linking UI to program
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)


        buttonCalculate.setOnClickListener{
            if(editTextHeight.text.toString().isEmpty()){
                editTextHeight.setError(getString(R.string.error_value_required))
                return@setOnClickListener //exit function
            }
                val height = editTextHeight.toString().toFloat()

            val weight = editTextWeight.toString().toFloatOrNull()
            if(weight == null){
                editTextWeight.setError(getString(R.string.error_value_required))
                return@setOnClickListener //exit function
            }

            val bmi = weight /(height/100).pow(2)
            if(bmi <= 18.5){
                textViewBMI.text = String.format("$%s : %s (%.2f)",getString(R.string.bmi),getString(R.string.underweight),bmi)
                imageViewBMI.setImageResource(R.drawable.under)
            }

            if(bmi in 18.5..24.9){
                textViewBMI.text = String.format("$%s : %s (%.2f)",getString(R.string.bmi),getString(R.string.normal),bmi)
                imageViewBMI.setImageResource(R.drawable.normal)
            }

            if(bmi in 24.9..29.9){
                textViewBMI.text = String.format("$%s : %s (%.2f)",getString(R.string.bmi),getString(R.string.overweight),bmi)
                imageViewBMI.setImageResource(R.drawable.over)
            }
        }
        buttonReset.setOnClickListener{

        }
    }
}