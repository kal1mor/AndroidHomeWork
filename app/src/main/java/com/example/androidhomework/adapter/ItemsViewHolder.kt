package com.example.androidhomework.adapter

import android.view.View
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterButton
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.R
import com.example.androidhomework.listener.ItemsListener
import com.example.androidhomework.model.ItemsModel

class ItemsViewHolder(
    private val view: View,
    private val itemsListener: ItemsListener
): RecyclerView.ViewHolder(view) {

    fun bind(itemsModel: ItemsModel){
        val name = view.findViewById<TextView>(R.id.tv_name)
        val date = view.findViewById<TextView>(R.id.tv_date)
        val imageView = view.findViewById<ImageFilterView>(R.id.iv_image)
        val starView = view.findViewById<ImageFilterView>(R.id.star)

        name.text = itemsModel.name
        imageView.setBackgroundResource(itemsModel.image)
        date.text = itemsModel.date

        var changeStar = true

        starView.setOnClickListener{
            when(changeStar){
                true -> {starView.setImageResource(R.drawable.starred)
                    changeStar = false}
                false -> {starView.setImageResource(R.drawable.star)
                    changeStar = true}
            }
        }

        imageView.setOnClickListener{
            itemsListener.onClick()
        }

        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                itemsModel.name,
                itemsModel.date,
                itemsModel.image
            )
        }
    }
}