package com.mb.juneandroidbatch

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mb.juneandroidbatch.databinding.ActivityTicTacToeBinding

class TicTacToe : AppCompatActivity() {

    var flag = 0;
    var count = 0
    private lateinit var binding: ActivityTicTacToeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTicTacToeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



    }


    fun check(view: View) {

        val btncurrent = view as Button

        if(btncurrent.text == "") {
            count++ // 2


            if (flag == 0) {
                btncurrent.text = "X"
                flag = 1;
            } else {
                btncurrent.text = "O"
                flag = 0;
            }

            val btn1 = binding.btn1.text.toString()
            val btn2 = binding.btn2.text.toString()
            val btn3 = binding.btn3.text.toString()
            val btn4 = binding.btn4.text.toString()
            val btn5 = binding.btn5.text.toString()
            val btn6 = binding.btn6.text.toString()
            val btn7 = binding.btn7.text.toString()
            val btn8 = binding.btn8.text.toString()
            val btn9 = binding.btn9.text.toString()


            if (btn1 == btn2 && btn2 == btn3 && btn3 != "") {
                Toast.makeText(this, "Winner is $btn1", Toast.LENGTH_SHORT).show()
                newGame()
            } else if (btn4 == btn5 && btn5 == btn6 && btn6 != "") {
                Toast.makeText(this, "Winner is $btn4", Toast.LENGTH_SHORT).show()
                newGame()
            } else if (btn7 == btn8 && btn8 == btn9 && btn9 != "") {
                Toast.makeText(this, "Winner is $btn7", Toast.LENGTH_SHORT).show()
                newGame()
            } else if (btn1 == btn4 && btn4 == btn7 && btn7 != "") {
                Toast.makeText(this, "Winner is $btn1", Toast.LENGTH_SHORT).show()
                newGame()
            } else if (btn2 == btn5 && btn5 == btn8 && btn8 != "") {
                Toast.makeText(this, "Winner is $btn2", Toast.LENGTH_SHORT).show()
                newGame()
            } else if (btn3 == btn6 && btn6 == btn9 && btn9 != "") {
                Toast.makeText(this, "Winner is $btn3", Toast.LENGTH_SHORT).show()
                newGame()
            } else if (btn1 == btn5 && btn5 == btn9 && btn9 != "") {
                Toast.makeText(this, "Winner is $btn1", Toast.LENGTH_SHORT).show()
                newGame()
            } else if (btn3 == btn5 && btn5 == btn7 && btn7 != "") {
                Toast.makeText(this, "Winner is $btn3", Toast.LENGTH_SHORT).show()
                newGame()
            }
            else if(count == 9) {
                Toast.makeText(this, "Match is Draw", Toast.LENGTH_SHORT).show()
                newGame()
            }

        }
    }


    fun newGame(){
        binding.btn1.text = ""
        binding.btn2.text = ""
        binding.btn3.text = ""
        binding.btn4.text = ""
        binding.btn5.text = ""
        binding.btn5.text = ""
        binding.btn6.text = ""
        binding.btn7.text = ""
        binding.btn8.text = ""
        binding.btn9.text = ""
        flag = 0;
        count = 0;
    }

}
