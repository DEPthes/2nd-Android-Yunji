package com.example.androidbasicstudy_week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidbasicstudy_week8.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var productList= listOf<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder().baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val networkService = retrofit.create(IRetrofit::class.java)
        val userProductCall = networkService.getProduct()

        userProductCall.enqueue(object: Callback<Products>{
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                if(response.isSuccessful){
                    //성공
                    val products = response.body()
                    if (products != null) {
                        productList = products.products
                    }
                    initializeViews()
                    Log.d("TAG", "Success")
                }else{
                    //실패
                    Log.d("TAG", "Fail")
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                //통신 실패
                Log.d("TAG", "onFailure")
                call.cancel()
            }
        })
    }
    private fun initializeViews(){
        binding.recycler.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,false)
        binding.recycler.adapter = RecycleAdapter(productList)
    }
}