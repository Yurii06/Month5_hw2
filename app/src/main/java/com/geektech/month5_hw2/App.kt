package com.geektech.month5_hw2

import android.app.Application
import androidx.room.Room
import com.geektech.month5_hw2.data.AppDatabase
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love-file")
                .allowMainThreadQueries().build()
    }
}