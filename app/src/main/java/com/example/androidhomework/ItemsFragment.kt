package com.example.androidhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.adapter.ItemsAdapter
import com.example.androidhomework.listener.ItemsListener


const val KEY_NAME = "name"
const val KEY_DATE = "date"
const val KEY_IMAGE = "image"
const val KEY_IMAGE_VIEW = "imageView"
const val KEY_IMAGE_VIEW_ClICKED = "ImageView clicked"

class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rcView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner){ listItems ->
            itemsAdapter.submitList(listItems)
        }

        viewModel.message.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        viewModel.bundle.observe(viewLifecycleOwner){ navBundle ->
            val detailsFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putString(KEY_NAME, navBundle.name)
            bundle.putString(KEY_DATE, navBundle.date)
            bundle.putInt(KEY_IMAGE, navBundle.image)
            detailsFragment.arguments = bundle

            //ADD method we will not use
            //We will use replace
            //replace always have addToBackstack to go back, or if we don't have addToBackstack we will not back
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, detailsFragment)
                .addToBackStack("Details")
                .commit()
        }

    }

    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
    }
}
