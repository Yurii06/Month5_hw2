package com.geektech.month5_hw2.model

import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("fname")
    var firsName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
):java.io.Serializable