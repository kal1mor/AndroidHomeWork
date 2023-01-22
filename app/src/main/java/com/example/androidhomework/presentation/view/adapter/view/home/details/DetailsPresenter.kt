package com.example.androidhomework.presentation.view.adapter.view.home.details

import android.util.Log
import com.example.androidhomework.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsPresenter
@Inject
constructor(private val authInteractor: AuthInteractor) {

    private lateinit var detailsView: DetailsView

    fun setView(detailsFragment: DetailsFragment) {
        detailsView = detailsFragment
    }

    fun getDetails(name: String?, userName: String?, email: String?) {
        detailsView.displayDetails(
            when (name.isNullOrEmpty()) {
                true -> "NO DATA"
                false -> name
            },
            when (userName.isNullOrEmpty()) {
                true -> "NO DATA"
                false -> userName
            },
            when (email.isNullOrEmpty()) {
                true -> "NO DATA"
                false -> email
            }
        )
    }

    fun logoutUser() {
        CoroutineScope(Dispatchers.Main).launch {
            val job = launch {
                try {
                    authInteractor.logoutUser()
                    detailsView.userLoggedOut()
                } catch (e: Exception) {
                    Log.w("exception", "user not logout")
                }
            }
            job.join()
            job.cancel()
        }

    }
}
