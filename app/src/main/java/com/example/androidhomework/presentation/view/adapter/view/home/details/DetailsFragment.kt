package com.example.androidhomework.presentation.view.adapter.view.home.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentDetailsBinding
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment.Companion.KEY_DATE
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment.Companion.KEY_IMAGE_VIEW
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment.Companion.KEY_NAME
import com.example.androidhomework.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels()

    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.detailsName)
        val detailsDate = view.findViewById<TextView>(R.id.detailsDate)
        val detailsImage = view.findViewById<ImageView>(R.id.detailsImage)

        val bundle = arguments

        bundle?.let { safeBundle ->
            val name = safeBundle.getString(KEY_NAME)
            val date = safeBundle.getString(KEY_DATE) //ItemsFragment.Companion - отображает от куда взята (из какого фрагмента) константа
            val image = safeBundle.getInt(KEY_IMAGE_VIEW)

            detailsName.text = name
            detailsDate.text = date
            detailsImage.setBackgroundResource(image)
        }

        viewBinding.btnLogout.setOnClickListener {
            viewModel.logoutUser()
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                replaceGraph(it!!)
            }
        }

    }
}