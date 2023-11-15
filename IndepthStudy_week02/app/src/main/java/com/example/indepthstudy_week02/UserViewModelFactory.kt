package com.example.indepthstudy_week02

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class UserViewModelFactory(private val first:String, private val last:String):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel(first, last) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}