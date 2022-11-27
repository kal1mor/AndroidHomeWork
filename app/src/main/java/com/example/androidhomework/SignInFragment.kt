package com.example.androidhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout


class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnSignIn = view.findViewById<Button>(R.id.btnSignIn)
        val btnRegistration = view.findViewById<Button>(R.id.btnRegistration)
        val titl1 = view.findViewById<TextInputLayout>(R.id.titl1)
        val titl2 = view.findViewById<TextInputLayout>(R.id.titl2)
        val tet1 = view.findViewById<EditText>(R.id.tet1)
        val tet2 = view.findViewById<EditText>(R.id.tet2)

        btnRegistration.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .add(R.id.app_container, RegistrationFragment())
                .addToBackStack("Sign in")
                .commit()
        }

        btnSignIn.setOnClickListener {
            if (tet1.text.toString().isEmpty() && tet2.text.toString().isEmpty()) {
                titl1.setErrorIconDrawable(R.drawable.ic_error)
                tet1.error = getString(R.string.email_cant_be_empty)
                titl2.setErrorIconDrawable(R.drawable.ic_error)
                titl2.isPasswordVisibilityToggleEnabled = false
                tet2.error = getString(R.string.password_cant_be_empty)
            } else if (tet1.text.toString().isEmpty()) {

                titl1.setErrorIconDrawable(R.drawable.ic_error)
                tet1.error = getString(R.string.email_cant_be_empty)
                titl2.isPasswordVisibilityToggleEnabled = true

            } else if (tet2.text.toString().isEmpty()) {

                titl2.setErrorIconDrawable(R.drawable.ic_error)
                titl2.isPasswordVisibilityToggleEnabled = false
                tet2.error = getString(R.string.password_cant_be_empty)
            } else {
                titl2.isPasswordVisibilityToggleEnabled = true
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.app_container, MainFragment())
                    .commit()

            }
        }
    }
}