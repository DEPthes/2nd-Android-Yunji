package com.example.indepthstudy_week5_retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indepthstudy_week5_retrofit.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val productRepository: ProductRepository):ViewModel() {
    private var _image = MutableLiveData("")
    val image: LiveData<String>
        get() = _image

    private var _title = MutableLiveData("title")
    val title: LiveData<String>
        get() = _title

    private var _description = MutableLiveData("description")
    val description:LiveData<String>
        get() = _description

    fun getPost(number:Int) = viewModelScope.launch {
        val response = productRepository.getPost(number)
        if(response.isSuccessful){
            response.body()?.let{
                _image.postValue(it.images[0])
                _title.postValue(it.title)
                _description.postValue(it.description)
            }
        }else{
            when(response.code()){
                404 -> {
                    _image.postValue("")
                    _title.postValue("Error 404")
                    _description.postValue("데이터가 존재하지 않습니다.")
                }
            }
        }
    }
}