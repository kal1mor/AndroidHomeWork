package com.example.androidhomework.presentation.view.adapter.view.home.details

import com.example.androidhomework.domain.auth.AuthInteractor
import javax.inject.Inject

class DetailsPresenter
    @Inject
    constructor(private val authInteractor: AuthInteractor){

    private lateinit var detailsView: DetailsView

        fun setView(detailsFragment: DetailsFragment){
            detailsView = detailsFragment
        }

        fun getDetails(name: String?, date: String?, image: Int){
            detailsView.displayDetails(
                when(name.isNullOrEmpty()){
                    true -> "NO DATA"
                    false -> name},
                when(date.isNullOrEmpty()){
                    true -> "NO DATA"
                    false -> date},
                image)
        }

        fun logoutUser(){
            authInteractor.logoutUser()
            detailsView.userLoggedOut()
        }
}
