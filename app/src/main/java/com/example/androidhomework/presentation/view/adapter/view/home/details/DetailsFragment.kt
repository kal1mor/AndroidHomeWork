package com.example.androidhomework.presentation.view.adapter.view.home.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentDetailsBinding
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment.Companion.KEY_EMAIL
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment.Companion.KEY_NAME
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment.Companion.KEY_USERNAME
import com.example.androidhomework.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(), DetailsView {

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

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

        detailsPresenter.setView(this)

        val bundle = arguments

        bundle?.let { _ ->
            detailsPresenter.getDetails(
                bundle.getString(KEY_NAME),
                bundle.getString(KEY_EMAIL),
                bundle.getString(KEY_USERNAME)
            )
        }

        viewBinding.btnLogout.setOnClickListener {
            detailsPresenter.logoutUser()
        }
    }

    override fun userLoggedOut() {
        replaceGraph(R.navigation.auth_graph)
    }

    override fun displayDetails(name: String, userName: String, email: String) {
        viewBinding.detailsName.text = name
        viewBinding.detailsUserName.text = userName
        viewBinding.detailsEmail.text = email


    }

}