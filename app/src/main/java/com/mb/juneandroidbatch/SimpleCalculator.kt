package com.mb.juneandroidbatch

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SimpleCalculator : AppCompatActivity() {
    var num1: EditText? = null
    var num2 : EditText? = null
    var result: TextView? = null

    var addbtn: Button? = null
    var subbtn: Button? = null
    var multibtn: Button? = null
    var divbtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_simple_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
        events()
    }

    fun init() {
        num1 = findViewById(R.id.num1_et)
        num2 = findViewById(R.id.num2_et)
        result = findViewById(R.id.result_tv)

        addbtn = findViewById(R.id.add_btn)
        subbtn = findViewById(R.id.subtract_btn)
        multibtn = findViewById(R.id.multiply_btn)
        divbtn = findViewById(R.id.divide_btn)

    }

    fun events() {
        addbtn?.setOnClickListener {
            // exception handling
            try {
                val number1 = num1?.text.toString().toIntOrNull()
                val number2 = num2?.text.toString().toIntOrNull()
                if (number1 != null && number2 != null) {
                    add(number1, number2).also {
                        result?.text = "result = " + it.toString()
                    }
                } else {
                    result?.text = "Please enter valid numbers"
                }
            } catch (e: Exception) {
                result?.text = "Please enter valid numbers"
            }
        }

        subbtn?.setOnClickListener {
            try {
                val number1 = num1?.text.toString().toIntOrNull()
                val number2 = num2?.text.toString().toIntOrNull()
                if (number1 != null && number2 != null) {
                    subract(number1, number2).also {
                        result?.text = "result = " + it.toString()
                    }
                } else {
                    result?.text = "Please enter valid numbers"
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Error in subtraction: ${e.message}")
            }
        }


        multibtn?.setOnClickListener {
            try {
                val number1 = num1?.text.toString().toIntOrNull()
                val number2 = num2?.text.toString().toIntOrNull()
                if (number1 != null && number2 != null) {
                    mutlipy(number1, number2).also {
                        result?.text = "result = " + it.toString()
                    }
                } else {
                    result?.text = "Please enter valid numbers"
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Error in multiplication: ${e.message}")
            }
        }

        divbtn?.setOnClickListener {
            try {
                val number1 = num1?.text.toString().toIntOrNull()
                val number2 = num2?.text.toString().toIntOrNull()
                if (number1 != null && number2 != null) {
                    if (number2 == 0) {
                        result?.text = "Cannot divide by zero"
                    } else {
                        divide(number1, number2).also {
                            result?.text = "result = " + it.toString()
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Error in division: ${e.message}")
            }
        }
    }

    fun add(number1: Int, number2: Int): Int {
        return number1 + number2

    }

    fun subract(number1: Int, number2: Int): Int {
        return number1 - number2
    }

    fun mutlipy(number1: Int, number2: Int): Int {
        return number1 * number2
    }

    fun divide(number1: Int, number2: Int): Int {
        return number1 / number2
    }
}