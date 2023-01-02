package com.example.androidhomework.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.androidhomework.R

object NavigationFragment {

    fun fmReplace(parentFragmentManager: FragmentManager, fragment: Fragment, addToBackStack: Boolean){
        if (addToBackStack) {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, fragment)
                .addToBackStack("")
                .commit()
        }else{
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, fragment)
                .commit()
        }
    }
}