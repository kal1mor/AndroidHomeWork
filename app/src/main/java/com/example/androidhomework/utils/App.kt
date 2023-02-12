package com.example.androidhomework.utils

import android.app.Application
//import android.util.Log
//import androidx.hilt.work.HiltWorkerFactory
//import androidx.work.Configuration
//import androidx.work.ExistingPeriodicWorkPolicy
//import androidx.work.PeriodicWorkRequestBuilder
//import androidx.work.WorkManager
//import com.example.androidhomework.data.worker.PeriodWorker
import com.example.androidhomework.di.AppModule
import com.example.androidhomework.di.component.AppComponent
//import dagger.hilt.android.HiltAndroidApp
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import java.util.concurrent.TimeUnit
//import javax.inject.Inject
import com.example.androidhomework.di.component.DaggerAppComponent



class App: Application(){//, Configuration.Provider{

//    @Inject
//    lateinit var workerFactory: HiltWorkerFactory

//    val applicationScope = CoroutineScope(Dispatchers.Default)
//
//    override fun getWorkManagerConfiguration(): Configuration {
//        return Configuration.Builder()
//            .setWorkerFactory(workerFactory)
//            .setMinimumLoggingLevel(Log.DEBUG)
//            .build()
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        applicationScope.launch {
//            createWorkManager()
//        }
//    }
//
//    private fun createWorkManager() {
//        val repeatingRequest = PeriodicWorkRequestBuilder<PeriodWorker>(15, TimeUnit.MINUTES).build()
//        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
//            PeriodWorker.WORKER_NAME,
//            ExistingPeriodicWorkPolicy.KEEP,
//            repeatingRequest
//        )
//    }


    lateinit var appComponent : AppComponent

    fun provideAppComponent():AppComponent{
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        return appComponent
    }
}