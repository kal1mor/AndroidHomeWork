package com.example.androidhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tel1 = findViewById<TextInputLayout>(R.id.til1)
        val tel2 = findViewById<TextInputLayout>(R.id.til2)
        val tet_text1 = findViewById<EditText>(R.id.tet_text1)
        val tet_text2 = findViewById<EditText>(R.id.tet_text2)
        val textView = findViewById<TextView>(R.id.tv1)
        val btnLog = findViewById<Button>(R.id.btnLog)



        btnLog.setOnClickListener{

            if(tet_text1.text.toString().isEmpty()){
                tel1.setErrorIconDrawable(R.drawable.ic_error)
                tet_text1.error = getString(R.string.email_cant_be_empty)
            }
            if (tet_text2.text.toString().isEmpty()){
                tel2.setErrorIconDrawable(R.drawable.ic_error)
                tel2.isPasswordVisibilityToggleEnabled = false
                tet_text2.error = getString(R.string.password_cant_be_empty)
            }else{
                textView.text = "${tet_text1.text.toString()} ${tet_text2.text.toString()}"
                tel2.isPasswordVisibilityToggleEnabled = true

                val dialog = AlertDialog.Builder(this)
                    .setTitle(getString(R.string.information))
                    .setMessage("${tet_text1.text.toString()} ${tet_text2.text.toString()}")
                    .setCancelable(true)
                    .setPositiveButton(getString(R.string.ok)){ dialog, _ ->
                        dialog.cancel()
                    }
                    .setNegativeButton(getString(R.string.cancel)){ dialog, _ ->
                        dialog.cancel()
                    }
                dialog.show()
            }
        }



    }
}