package com.example.androidhomework.data

import com.example.androidhomework.R
import com.example.androidhomework.domain.ItemsRepository
import com.example.androidhomework.model.ItemsModel

class ItemsRepositoryImpl:ItemsRepository {
    override fun getData(): List<ItemsModel> {
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
            )
        )
        return listItems
    }


}