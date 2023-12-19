package com.example.indepthstudy_week5_retrofit.repository

import com.example.indepthstudy_week5_retrofit.model.ProductResponse
import com.example.indepthstudy_week5_retrofit.network.RetrofitInstance.api
import retrofit2.Response

class ProductRepositoryImpl:ProductRepository  {
    override suspend fun getPost(number: Int): Response<ProductResponse> {
        return api.getPost(number)
    }
}