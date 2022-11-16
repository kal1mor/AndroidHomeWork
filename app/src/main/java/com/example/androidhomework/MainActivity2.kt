package com.example.androidhomework

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val firstTextView = findViewById<TextView>(R.id.textView1)
        val first = intent.getStringExtra(KEY)
        firstTextView.text=first

        val secondTextView = findViewById<TextView>(R.id.textView2)
        val second = intent.getStringExtra(KEY2)
        secondTextView.text=second

        val title = intent.getStringExtra(KEY3)
        supportActionBar?.title =title
    }


    companion object{

        private const val KEY = "1"
        private const val KEY2 ="2"
        private const val KEY3 ="3"

        fun startTitle(context: Context, string: String){
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY3, string)
            context.startActivity(intent)
        }

        fun startMainActivity2(context: Context, string: String, string2: String){

            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY, string)
            intent.putExtra(KEY2,string2)
            context.startActivity(intent)
        }
    }
}