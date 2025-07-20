package com.mb.juneandroidbatch

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Lifecycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lifecycle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        Toast.makeText(this, "Activity is Created", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Activity is starting", Toast.LENGTH_SHORT).show()
        // Code to execute when the activity is becoming visible to the user
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Activity is Resume", Toast.LENGTH_SHORT).show()
        // Code to execute when the activity will start interacting with the user
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Activity is Paused", Toast.LENGTH_SHORT).show()
        // Code to execute when the activity is partially obscured by another activity
    }


    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Activity is Stop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Activity is Destroyed", Toast.LENGTH_SHORT).show()
        // Code to execute when the activity is being destroyed
    }
}


