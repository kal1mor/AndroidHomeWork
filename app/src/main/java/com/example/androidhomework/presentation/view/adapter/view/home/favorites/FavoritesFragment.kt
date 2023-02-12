package com.example.androidhomework.presentation.view.adapter.view.home.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidhomework.databinding.FragmentFavoritesBinding
import com.example.androidhomework.di.FavoritesModel
import com.example.androidhomework.presentation.view.adapter.view.home.favorites.adapter.FavoriteAdapter
import com.example.androidhomework.presentation.view.adapter.view.home.favorites.adapter.FavoriteListener
import com.example.androidhomework.utils.App
import javax.inject.Inject


class FavoritesFragment : Fragment(), FavoriteView, FavoriteListener {

    @Inject
    lateinit var favoritesPresenter: FavoritePresenter

    private lateinit var favAdapter: FavoriteAdapter

    private var _viewBinding: FragmentFavoritesBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentFavoritesBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)
        favoritesPresenter.setView(this)

        favAdapter = FavoriteAdapter(this)

        viewBinding.rcView.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.rcView.adapter = favAdapter

        favoritesPresenter.getFavorites()
    }

    override fun favReceived(list: List<FavoritesModel>) {
        favAdapter.submitList(list)
    }

    override fun onDeleteClicked(id: Int) {
        favoritesPresenter.onDeleteClicked(id)
    }
}