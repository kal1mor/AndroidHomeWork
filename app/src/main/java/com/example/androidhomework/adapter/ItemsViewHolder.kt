package com.example.androidhomework.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.R
import com.example.androidhomework.listener.ItemsListener
import com.example.androidhomework.model.ItemsModel

class ItemsViewHolder(private val view: View,
                      private val itemsListener: ItemsListener
): RecyclerView.ViewHolder(view) {

    fun bind(itemsModel: ItemsModel){
        val name = view.findViewById<TextView>(R.id.tv_name)
        val date = view.findViewById<TextView>(R.id.tv_date)
        val imageView = view.findViewById<ImageView>(R.id.iv_image)
        val starView = view.findViewById<ImageView>(R.id.star)

        name.text = itemsModel.name
        date.text = itemsModel.date
        imageView.setBackgroundResource(itemsModel.image)

        starView.setOnClickListener(){
            starView.setBackgroundResource(R.drawable.starred)
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