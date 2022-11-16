package com.example.androidhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.androidhomework.MainActivity2.Companion.startMainActivity2
import com.example.androidhomework.MainActivity2.Companion.startTitle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.item_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.textView -> startMainActivity2(this,getString(R.string.first_activity),getString(R.string.sec_activity))
            R.id.close_app -> finishAffinity()
            R.id.clicked_second_item -> startTitle(this,getString(R.string.kalimor_production))
            R.id.go_to_activity2 -> startActivity(Intent(this, MainActivity2::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}