package com.example.androidbasicstudy_week8

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("products")
    val products:List<UserData>,
    @SerializedName("total")
    val total:Int,
)

data class UserData(
    @SerializedName("id")
    val id:Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price:Int,
    @SerializedName("images")
    val images:List<String>,
)
