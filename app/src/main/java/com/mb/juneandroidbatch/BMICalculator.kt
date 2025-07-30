package com.mb.juneandroidbatch

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BMICalculator : AppCompatActivity() {

    private  lateinit var weight_et : EditText
    private  lateinit var height_ft : EditText
    private  lateinit var height_in : EditText
    private  lateinit var bmi : Button
    private  lateinit var health : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmicalculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()
        bmi.setOnClickListener {
            calculateBMi()
        }
    }


    fun init() {
        weight_et = findViewById(R.id.weight_et)
        height_ft = findViewById(R.id.height_ft_et)
        height_in = findViewById(R.id.height_inch_et)
        bmi = findViewById(R.id.calculate_bmi_btn)
        health = findViewById(R.id.your_health_tv)
    }

     fun calculateBMi(){


         if(!weight_et.text.toString().equals("") && !height_ft.text.toString().equals("") && ! height_in.text.toString().equals("")){

             val weight = weight_et!!.text.toString().toDouble()
             val heightFt = height_ft!!.text.toString().toDouble()
             val heightIn = height_in!!.text.toString().toDouble()

             val totalInch = (heightFt * 12) + heightIn
             val totalcm = totalInch * 2.54
             val totalM = totalcm / 100

             val bmi = weight/ (totalM * totalM)

             if(bmi> 25){
                 Toast.makeText(this, "You are overweight", Toast.LENGTH_SHORT).show()
             }






         } else{
             Toast.makeText(this, "Please enter valid values", Toast.LENGTH_SHORT).show()
         }
     }
}