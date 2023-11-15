package com.example.indepthstudy_week02

import androidx.lifecycle.ViewModel

class UserViewModel(first:String, last:String):ViewModel() {
//    var firstName:String =""
//    var lastName:String=""
//
//    init {
//        firstName = first
//        lastName = last
//    }
    var firstName = first
    var lastName = last

    fun setName(first:String, last:String){
        firstName = first
        lastName = last
    }

//    fun getFirstName():String{
//        return firstName
//    }
//
//    fun getLastName():String{
//        return lastName
//    }
}