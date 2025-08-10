package com.mb.juneandroidbatch

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mb.juneandroidbatch.fragment.FragmentTest
import com.mb.juneandroidbatch.recycler.NameAdapter
import com.mb.juneandroidbatch.recycler.NameItem
import com.mb.juneandroidbatch.viewpager.ViewPagers

class MainActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var nameAdapter: NameAdapter
    private val namelist = listOf(
        NameItem("John Doe"),
        NameItem("Jane Smith"),
        NameItem("Alice Johnson"),
        NameItem("Akila"),
        NameItem("vsd"),
        NameItem("svd Doe"),
        NameItem("svd Smith"),
        NameItem("vsd Johnson"),
        NameItem("svd"),
        NameItem("vs"),
        NameItem("vsdf Doe"),
        NameItem("Janevsdv Smisvdth"),
        NameItem("svd Johnson"),
        NameItem("vsd"),
        NameItem("svd")
    )

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
        val tictac = findViewById<Button>(R.id.tictactoe_btn)
        val frag = findViewById<Button>(R.id.frag_btn)
        val viewPager = findViewById<Button>(R.id.viewpager_btn)

        frag.setOnClickListener {
            replace(fragment = FragmentTest())
        }

        recyclerView = findViewById(R.id.list_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        nameAdapter = NameAdapter(namelist)
        recyclerView.adapter = nameAdapter


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
            try {
                Intent(this, BMICalculator:: class.java).also{
                    startActivity(it)
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Error starting BMI Calculator", e)
            }

        }


        tictac.setOnClickListener {
            try {
                Intent(this, TicTacToe:: class.java).also {
                    startActivity(it)
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }


        viewPager.setOnClickListener {
            try {
                Intent(this, ViewPagers:: class.java).also {
                    startActivity(it)
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }


    private  fun replace(fragment : FragmentTest){
        val fragmentTransaction  = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_layout, fragment)
        fragmentTransaction.commit()

    }
}

