package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class Content (
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("dateTime")
    var dateTime: String,
    @SerializedName("tags")
    var tags: List<String>,
    @SerializedName("content")
    var content: List<DetailContent>,
    @SerializedName("ingress")
    var ingress: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("created")
    var created: Int,
    @SerializedName("changed")
    var changed: Int,
)