package com.geektech.month5_hw2.di

import android.content.Context
import androidx.room.Room
import com.geektech.month5_hw2.data.AppDatabase
import com.geektech.month5_hw2.data.LoveDao
import com.geektech.month5_hw2.data.Pref
import com.geektech.month5_hw2.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "love_table")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun providePref(@ApplicationContext context: Context): Pref = Pref(context)

    @Provides
    fun provideLoveDao(@ApplicationContext context: Context): LoveDao {
        return provideAppDatabase(context).loveDao()
    }

}