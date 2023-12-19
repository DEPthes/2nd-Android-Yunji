package com.example.indepthstudy_week5_retrofit.model

data class ProductResponse(
    val id:Int,
    val title:String,
    val description: String,
    val images: List<String>
)
