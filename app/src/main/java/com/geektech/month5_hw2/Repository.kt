package com.geektech.month5_hw2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.geektech.month5_hw2.model.LoveModel
import com.geektech.month5_hw2.remote.LoveApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api : LoveApi) {

    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        var liveData = MutableLiveData<LoveModel>()
        api.getPercentage(firstName, secondName)
            .enqueue(object : Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    liveData.postValue(response.body())
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    liveData.postValue(LoveModel(error = t.message))
                }

            })
        return liveData
    }
}