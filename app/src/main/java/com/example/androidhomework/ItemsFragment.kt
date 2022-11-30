package com.example.androidhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.adapter.ItemsAdapter
import com.example.androidhomework.listener.ItemsListener
import com.example.androidhomework.model.ItemsModel

class ItemsFragment : Fragment(), ItemsListener{

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
            ItemsModel (R.drawable.m4a1,
                "AK-47",
                "28.11.2022"),
            ItemsModel (R.drawable.aug,
                "AUG",
                "27.11.2022"),
            ItemsModel (R.drawable.awp,
                "AWP",
                "26.11.2022"),
            ItemsModel (R.drawable.p2000,
                "Deagle",
                "25.11.2022"),
            ItemsModel (R.drawable.m4a1,
                "Famas",
                "24.11.2022"),
            ItemsModel (R.drawable.aug,
                "FiveSeven",
                "23.11.2022"),
            ItemsModel (R.drawable.awp,
                "Glock",
                "22.11.2022"),
            ItemsModel (R.drawable.p2000,
                "M4A1",
                "21.11.2022"),
            ItemsModel (R.drawable.m4a1,
                "M4A4",
                "20.11.2022"),
            ItemsModel (R.drawable.aug,
                "P2000",
                "19.11.2022"),
            ItemsModel (R.drawable.awp,
                ".P250",
                "18.11.2022"),
            ItemsModel (R.drawable.p2000,
                "Sg553",
                "17.11.2022"),
            ItemsModel (R.drawable.m4a1,
                "Tec-9",
                "16.11.2022"),
            ItemsModel (R.drawable.aug,
                "Usp",
                "15.11.2022"),
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
            .addToBackStack("Details")
            .commit()
    }
}