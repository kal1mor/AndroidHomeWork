package com.example.androidhomework.presentation.view.adapter.view.home.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidhomework.databinding.FragmentHomeBinding
import com.example.androidhomework.domain.model.HomeModel
import com.example.androidhomework.presentation.view.adapter.view.home.home.adapter.HomeAdapter
import com.example.androidhomework.utils.App
import javax.inject.Inject


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

        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

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