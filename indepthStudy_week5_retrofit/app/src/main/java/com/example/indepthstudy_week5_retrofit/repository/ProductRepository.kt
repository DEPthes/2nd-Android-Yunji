package com.example.indepthstudy_week5_retrofit.repository

import com.example.indepthstudy_week5_retrofit.model.ProductResponse
import retrofit2.Response

interface ProductRepository {
    suspend fun getPost(number:Int): Response<ProductResponse>
}