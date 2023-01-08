package com.example.androidhomework.presentation.view.adapter.view.home.items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentItemsBinding
import com.example.androidhomework.presentation.view.adapter.adapter.ItemsAdapter
import com.example.androidhomework.presentation.view.adapter.listener.ItemsListener
import com.example.androidhomework.presentation.view.adapter.view.home.details.DetailsFragment
import com.example.androidhomework.utils.NavigationFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener {



    private lateinit var itemsAdapter: ItemsAdapter
    private val viewMOdel: ItemsViewModel by viewModels()

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!



//    private val viewModel: ItemsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rcView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        viewMOdel.getData()
        viewMOdel.items.observe(viewLifecycleOwner){ listItems ->
            itemsAdapter.submitList(listItems)
        }

        viewMOdel.message.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }

        viewMOdel.bundle.observe(viewLifecycleOwner){ navBundle ->
            if (navBundle != null){
                val detailsFragment = DetailsFragment()
                val bundle = Bundle()
                bundle.putString(KEY_NAME, navBundle.name)
                bundle.putString(KEY_DATE, navBundle.date)
                bundle.putInt(KEY_IMAGE_VIEW, navBundle.image)
                detailsFragment.arguments = bundle

                NavigationFragment.fmReplace(parentFragmentManager, detailsFragment, true)
                viewMOdel.userNavigated()
            }
        }
    }

    override fun onClick() {
        viewMOdel.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewMOdel.elementClicked(name, date, imageView)
    }

    companion object{
        const val KEY_NAME = "name"
        const val KEY_DATE = "date"
        const val KEY_IMAGE_VIEW = "imageView"
    }
}
