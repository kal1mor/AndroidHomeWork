package com.example.androidhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageSwitcher
import android.widget.Toast
import androidx.constraintlayout.utils.widget.ImageFilterButton
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.adapter.ItemsAdapter
import com.example.androidhomework.listener.ItemsListener
import com.example.androidhomework.model.ItemsModel

class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter


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

        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.m4a1,
                "m4a1",
                "28.11.2022"
            ),
            ItemsModel(
                R.drawable.aug,
                "AUG",
                "27.11.2022"
            ),
            ItemsModel(
                R.drawable.awp,
                "AWP",
                "26.11.2022"
            ),
            ItemsModel(
                R.drawable.p2000,
                "p2000",
                "25.11.2022"
            ),
            ItemsModel(
                R.drawable.m4a1,
                "m4a1",
                "24.11.2022"
            ),
            ItemsModel(
                R.drawable.aug,
                "aug",
                "23.11.2022"
            ),
            ItemsModel(
                R.drawable.awp,
                "awp",
                "22.11.2022"
            ),
            ItemsModel(
                R.drawable.p2000,
                "p2000",
                "21.11.2022"
            ),
            ItemsModel(
                R.drawable.m4a1,
                "m4a1",
                "20.11.2022"
            ),
            ItemsModel(
                R.drawable.aug,
                "aug",
                "19.11.2022"
            ),
            ItemsModel(
                R.drawable.awp,
                "awp",
                "18.11.2022"
            ),
            ItemsModel(
                R.drawable.p2000,
                "p2000",
                "17.11.2022"
            ),
            ItemsModel(
                R.drawable.m4a1,
                "m4a1",
                "16.11.2022"
            ),
            ItemsModel(
                R.drawable.aug,
                "aug",
                "15.11.2022"
            ),
        )

        itemsAdapter.submitList(listItems)


    }

    override fun onClick() {
        Toast.makeText(context, "ImageView clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {

        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("date", date)
        bundle.putInt("imageVIew", imageView)
        detailsFragment.arguments = bundle

        //ADD method we will not use
        //We will use replace
        //replace always have addToBackstack to go back, or if we don't have addToBackstack we will not back
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack(getString(R.string.details))
            .commit()
    }

    override fun onStarClick() {
//        val star = view?.findViewById<ImageFilterView>(R.id.star)
//        star?.setImageResource(R.drawable.starred)
    }
}
