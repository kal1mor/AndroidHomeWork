package com.example.androidhomework.presentation.view.adapter.view.home.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentHomeBinding
import com.example.androidhomework.databinding.FragmentItemsBinding
import com.example.androidhomework.domain.model.HomeModel
import com.example.androidhomework.domain.model.ItemsModel
import com.example.androidhomework.presentation.view.adapter.view.home.home.adapter.HomeAdapter
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsPresenter
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsView
import com.example.androidhomework.presentation.view.adapter.view.home.items.adapter.ItemsAdapter
import com.example.androidhomework.presentation.view.adapter.view.home.items.adapter.ItemsListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeView {

    @Inject
    lateinit var homePresenter: HomePresenter

    private lateinit var homeAdapter: HomeAdapter

    private var _viewBinding: FragmentHomeBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentHomeBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.setView(this)

        homeAdapter = HomeAdapter()

        viewBinding.rcView.adapter = homeAdapter
        viewBinding.rcView.layoutManager = LinearLayoutManager(context)

        homePresenter.getData()

    }

    override fun dataReceived(list: List<HomeModel>) {
        homeAdapter.submitList(list)
    }
}