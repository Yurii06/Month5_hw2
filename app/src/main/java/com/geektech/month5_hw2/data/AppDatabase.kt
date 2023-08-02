package com.geektech.month5_hw2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.month5_hw2.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun loveDao() : LoveDao
}