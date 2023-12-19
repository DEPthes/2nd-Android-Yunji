package com.example.indepthstudy_week5_retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.indepthstudy_week5_retrofit.repository.ProductRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val productRepository: ProductRepository
):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(productRepository) as T
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }
}