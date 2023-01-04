package com.example.androidhomework.di

import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.domain.items.ItemsInteractor
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsPresenter
import com.example.androidhomework.presentation.view.adapter.view.auth.login.LoginPresenter
import com.example.androidhomework.presentation.view.adapter.view.home.details.DetailsPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun provideItemsPresenter(itemsInteractor: ItemsInteractor): ItemsPresenter {
        return ItemsPresenter(itemsInteractor)
    }

    @Provides
    fun provideLoginPresenter(authInteractor: AuthInteractor): LoginPresenter {
        return LoginPresenter(authInteractor)
    }

    @Provides
    fun provideDetailsPresenter(authInteractor: AuthInteractor): DetailsPresenter {
        return DetailsPresenter(authInteractor)
    }
}