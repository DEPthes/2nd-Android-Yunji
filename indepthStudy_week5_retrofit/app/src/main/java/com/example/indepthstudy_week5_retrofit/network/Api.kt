package com.example.indepthstudy_week5_retrofit.network

import com.example.indepthstudy_week5_retrofit.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("products/{number}")
    suspend fun getPost(
        @Path("number") number: Int
    ): Response<ProductResponse>
}