package com.example.myapplication.models


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("status")
    var status: String,
    @SerializedName("content")
    var content: List<Content>,
    @SerializedName("serverTime")
    var serverTime: Int,
)