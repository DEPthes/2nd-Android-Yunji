package com.example.androidbasicstudy_week8

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IRetrofit {
    @GET("products")
    fun getProduct(): Call<Products>
}