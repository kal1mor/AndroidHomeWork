package com.example.androidhomework.presentation.view.adapter.view.home.items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentItemsBinding
import com.example.androidhomework.domain.model.ItemsModel
import com.example.androidhomework.presentation.view.adapter.listener.ItemsListener
import com.example.androidhomework.presentation.view.adapter.view.home.details.DetailsFragment
import com.example.androidhomework.utils.NavHelper.navigate
import com.example.androidhomework.utils.NavHelper.navigateWithBundle
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



    override fun onElementSelected(name: String, username: String, email: String) {
        itemsPresenter.elementSelected(name, username, email)
    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun goToDetails(name: String, username: String, email: String) {
        val bundle = Bundle()
        bundle.putString(KEY_NAME, name)
        bundle.putString(KEY_USERNAME, username)
        bundle.putString(KEY_EMAIL, email)

        //ADD method we will not use
        //We will use replace
        //replace always have addToBackstack to go back, or if we don't have addToBackstack we will not back
        navigateWithBundle(R.id.action_itemsFragment_to_detailsFragment, bundle)
    }

    companion object {
        const val KEY_NAME = "name"
        const val KEY_USERNAME = "username"
        const val KEY_EMAIL = "email"
    }
}
