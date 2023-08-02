package com.geektech.month5_hw2.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geektech.month5_hw2.model.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_table")
    fun getAll() : List<LoveModel>
}