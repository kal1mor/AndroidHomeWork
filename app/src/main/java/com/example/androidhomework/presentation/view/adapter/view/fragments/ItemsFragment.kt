package com.example.androidhomework.presentation.view.adapter.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentItemsBinding
import com.example.androidhomework.model.ItemsModel
import com.example.androidhomework.presentation.view.adapter.ItemsAdapter
import com.example.androidhomework.presentation.view.adapter.listener.ItemsListener
import com.example.androidhomework.presentation.view.adapter.view.ItemsPresenter
import com.example.androidhomework.presentation.view.adapter.view.ItemsView
import com.example.androidhomework.utils.NavigationFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    @Inject
    lateinit var itemsPresenter: ItemsPresenter

    private lateinit var itemsAdapter: ItemsAdapter

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!



//    private val viewModel: ItemsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter.setView(this)
        itemsAdapter = ItemsAdapter(this)

        viewBinding.rcView.adapter = itemsAdapter
        viewBinding.rcView.layoutManager = LinearLayoutManager(context)
        itemsPresenter.getData()

    }

    override fun onClick() {
        itemsPresenter.imageViewCLicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        itemsPresenter.elementSelected(name, date, imageView)
    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewCLicked(msg: Int) {
        Toast.makeText(context, getString(R.string.image_view_clicked), Toast.LENGTH_SHORT).show()
    }

    override fun goToDetails(name: String, date: String, imageView: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString(KEY_NAME, name)
        bundle.putString(KEY_DATE, date)
        bundle.putInt(KEY_IMAGE_VIEW, imageView)
        detailsFragment.arguments = bundle

        //ADD method we will not use
        //We will use replace
        //replace always have addToBackstack to go back, or if we don't have addToBackstack we will not back
        NavigationFragment.fmReplace(parentFragmentManager, detailsFragment, true)
    }

    companion object{
        const val KEY_NAME = "name"
        const val KEY_DATE = "date"
        const val KEY_IMAGE_VIEW = "imageView"
    }
}
