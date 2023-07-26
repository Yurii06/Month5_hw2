package com.geektech.month5_hw2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.month5_hw2.model.LoveModel

class LoveViewModel : ViewModel(), java.io.Serializable {
    var repository = Repository()

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getPercentage(firstName, secondName)
    }
}