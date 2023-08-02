package com.geektech.month5_hw2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.month5_hw2.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) : ViewModel(), java.io.Serializable {

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getPercentage(firstName, secondName)
    }

    fun getData() = repository.getAllData()
}