package com.example.androidhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.androidhomework.MainActivity2.Companion.startActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tetEmail = findViewById<EditText>(R.id.tetEmail)
        val tetPass = findViewById<EditText>(R.id.tetPass)
        val btnLogin = findViewById<Button>(R.id.btnLogIn)

        val videoCard = ComputerSetting
            .setVideoCard(true)
            .setNameOfVideoCard("Nvidia Gforce 2080TI")
            .setPowerOfVideoCard(2000)

        btnLogin.setOnClickListener {

            Log.w("Computer settings", "${videoCard.videoCard} ${videoCard.nameOfVideoCard} ${videoCard.powerOfVideoCard}")

            if(tetEmail.text.toString().isEmpty()&&tetPass.text.toString().isEmpty()){
                tetEmail.error = getString(R.string.email_cant_be_empty)
                tetPass.error = getString(R.string.password_cant_be_empty)

            } else if (tetEmail.text.toString().isEmpty()){


                tetEmail.error = getString(R.string.email_cant_be_empty)


            }else if(tetPass.text.toString().isEmpty()){
                tetPass.error = getString(R.string.password_cant_be_empty)
            }else {
                startActivity2(this)
            }
        }
    }
}