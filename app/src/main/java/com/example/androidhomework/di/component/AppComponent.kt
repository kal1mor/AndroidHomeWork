package com.example.androidhomework.di.component

import com.example.androidhomework.di.*
import com.example.androidhomework.di.factory.ScreenScope
import com.example.androidhomework.presentation.view.adapter.view.MainActivity
import com.example.androidhomework.presentation.view.adapter.view.auth.login.LogInFragment
import com.example.androidhomework.presentation.view.adapter.view.home.details.DetailsFragment
import com.example.androidhomework.presentation.view.adapter.view.home.favorites.FavoritesFragment
import com.example.androidhomework.presentation.view.adapter.view.home.home.HomeFragment
import com.example.androidhomework.presentation.view.adapter.view.home.items.ItemsFragment
import com.example.androidhomework.presentation.view.adapter.view.home.onBoarding.OnBoardingFragment
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        DatabaseModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)

@ScreenScope
interface AppComponent {
    fun inject(loginFragment: LogInFragment)
    fun inject(detalesFragment: DetailsFragment)
    fun inject(favoriteFragment: FavoritesFragment)
    fun inject(itemsFragment: ItemsFragment)
    fun inject(onBoardingFragment: OnBoardingFragment)
    fun inject(homeFragment: HomeFragment)
    fun inject(mainActivity: MainActivity)
}