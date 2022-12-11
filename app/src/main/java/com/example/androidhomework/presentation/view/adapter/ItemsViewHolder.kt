package com.example.androidhomework.presentation.view.adapter

import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.R
import com.example.androidhomework.databinding.ItemGunBinding
import com.example.androidhomework.presentation.view.adapter.listener.ItemsListener
import com.example.androidhomework.model.ItemsModel

class ItemsViewHolder(
    private val viewBinding: ItemGunBinding,
    private val itemsListener: ItemsListener
    ): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(itemsModel: ItemsModel){
        viewBinding.tvName.text = itemsModel.name
        viewBinding.ivImage.setBackgroundResource(itemsModel.image)
        viewBinding.tvDate.text = itemsModel.date

        viewBinding.ivImage.setOnClickListener{
            itemsListener.onClick()
        }

        itemView.setOnClickListener{
            itemsListener.onElementSelected(
                itemsModel.name,
                itemsModel.date,
                itemsModel.image
            )
        }
    }
}