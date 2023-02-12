package com.example.androidhomework.di

import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.domain.items.ItemsInteractor
import com.example.androidhomework.presentation.view.adapter.view.MainPresenter
import com.example.androidhomework.presentation.view.adapter.view.auth.login.LoginPresenter
import com.example.androidhomework.presentation.view.adapter.view.home.details.DetailsPresenter
import com.example.androidhomework.presentation.view.adapter.view.home.favorites.FavoritePresenter
import com.example.androidhomework.presentation.view.adapter.view.home.home.HomePresenter
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsPresenter
import com.example.androidhomework.presentation.view.adapter.view.home.onBoarding.OnBoardingPresenter
import dagger.Module
import dagger.Provides

@Module
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

    @Provides
    fun provideFavoritePresenter(itemsInteractor: ItemsInteractor): FavoritePresenter {
        return FavoritePresenter(itemsInteractor)
    }

    @Provides
    fun provideHomePresenter(itemsInteractor: ItemsInteractor): HomePresenter {
        return HomePresenter(itemsInteractor)
    }

    @Provides
    fun provideOnBoardingPresenter(authInteractor: AuthInteractor): OnBoardingPresenter {
        return OnBoardingPresenter(authInteractor)
    }

    @Provides
    fun provideMainPresenter(authInteractor: AuthInteractor): MainPresenter {
        return MainPresenter(authInteractor)
    }

}