package com.example.androidhomework.di

import com.example.androidhomework.domain.auth.AuthInteractor
import com.example.androidhomework.domain.auth.AuthRepository
import com.example.androidhomework.domain.items.ItemsInteractor
import com.example.androidhomework.domain.items.ItemsRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepository): ItemsInteractor {
        return ItemsInteractor(itemsRepository)
    }

    @Provides
    fun provideAuthInteractor(authRepository: AuthRepository): AuthInteractor {
        return AuthInteractor(authRepository)
    }
}