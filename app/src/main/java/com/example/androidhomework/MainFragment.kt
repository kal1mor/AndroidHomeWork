package com.example.androidhomework

import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dialog = AlertDialog.Builder(requireActivity())
            .setTitle(getString(R.string.information))
            .setMessage(getString(R.string.you_have_successfully_logged_in))
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