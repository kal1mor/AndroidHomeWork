package com.example.androidhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import com.google.android.material.textfield.TextInputLayout


class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegistrationOnFragmentRegistration = view.findViewById<Button>(R.id.btnRegistrationOnFragmentRegistration)
        val titlEmailRegistration = view.findViewById<TextInputLayout>(R.id.titlEmailRegistration)
        val titlPasswordRegistration = view.findViewById<TextInputLayout>(R.id.titlPasswordRegistration)
        val tetEmailRegistration = view.findViewById<EditText>(R.id.tetEmailRegistration)
        val tetPasswordRegistration = view.findViewById<EditText>(R.id.tetPasswordRegistration)

        btnRegistrationOnFragmentRegistration.setOnClickListener {

            if (tetEmailRegistration.text.toString().isEmpty()&&tetPasswordRegistration.text.toString().isEmpty()){
                titlEmailRegistration.setErrorIconDrawable(R.drawable.ic_error)
                tetEmailRegistration.error = getString(R.string.email_cant_be_empty)
                titlPasswordRegistration.setErrorIconDrawable(R.drawable.ic_error)
                titlPasswordRegistration.isPasswordVisibilityToggleEnabled = false
                tetPasswordRegistration.error = getString(R.string.password_cant_be_empty)
            }else if (tetEmailRegistration.text.toString().isEmpty()) {

                titlEmailRegistration.setErrorIconDrawable(R.drawable.ic_error)
                tetEmailRegistration.error = getString(R.string.email_cant_be_empty)
                titlPasswordRegistration.isPasswordVisibilityToggleEnabled = true

            } else if (tetPasswordRegistration.text.toString().isEmpty()) {

                titlPasswordRegistration.setErrorIconDrawable(R.drawable.ic_error)
                titlPasswordRegistration.isPasswordVisibilityToggleEnabled = false
                tetPasswordRegistration.error = getString(R.string.password_cant_be_empty)
            } else {
                titlPasswordRegistration.isPasswordVisibilityToggleEnabled = true
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.app_container, MainFragment())
                    .commit()
            }
        }
    }
}