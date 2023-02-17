package com.example.myapplication.models


import com.google.gson.annotations.SerializedName

data class DetailContent(
    @SerializedName("type")
    var type: String,
    @SerializedName("subject")
    var subject: String,
    @SerializedName("description")
    var description: String,
)