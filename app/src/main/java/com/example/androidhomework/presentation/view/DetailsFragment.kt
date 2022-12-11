package com.example.androidhomework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentDetailsBinding
import com.example.androidhomework.databinding.FragmentLogInBinding

class DetailsFragment : Fragment() {

    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val bundle = arguments

        bundle?.let { _ ->
            val name = ItemsFragment.Companion.KEY_NAME
            val date = ItemsFragment.Companion.KEY_DATE
            val image = ItemsFragment.Companion.KEY_IMAGE_VIEW.toInt()

            viewBinding.detailsName.text = name
            viewBinding.detailsDate.text = date
            viewBinding.detailsImage.setBackgroundResource(image)
        }
    }

}