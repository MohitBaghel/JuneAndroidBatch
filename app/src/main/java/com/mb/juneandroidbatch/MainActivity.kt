package com.mb.juneandroidbatch

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val simpleCalculator = findViewById<Button>(R.id.simple_calculator_btn)
        val bmiCalculator = findViewById<Button>(R.id.bmi_calculator_btn)
        val lifecycle = findViewById<Button>(R.id.lifecycle)


        simpleCalculator.setOnClickListener {
           Intent(this,SimpleCalculator::class.java).also {
               startActivity(it)
           }
        }

        lifecycle.setOnClickListener {
            Intent(this, Lifecycle::class.java).also {
                startActivity(it)
            }
        }


        bmiCalculator.setOnClickListener {
            Intent(this, BMICalculator:: class.java).also{
                startActivity(it)
            }
        }
    }
}

