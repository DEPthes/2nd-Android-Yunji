package com.example.indepthstudy_week5_retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.indepthstudy_week5_retrofit.R
import com.example.indepthstudy_week5_retrofit.databinding.ActivityMainBinding
import com.example.indepthstudy_week5_retrofit.repository.ProductRepositoryImpl
import com.example.indepthstudy_week5_retrofit.viewmodel.MainViewModel
import com.example.indepthstudy_week5_retrofit.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: ViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val productRepository = ProductRepositoryImpl()
        viewModelFactory = ViewModelFactory(productRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java )

        binding.btnButton.setOnClickListener {
            if(binding.etInput.text.toString() != ""){
                viewModel.getPost(Integer.parseInt(binding.etInput.text.toString()))
            }else{
                Toast.makeText(this, "숫자를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.image.observe(this, Observer {
            Glide.with(this).load(it).fitCenter().into(binding.ivImage)
        })
        viewModel.title.observe(this, Observer{
            binding.tvTitle.text = it.toString()
        })
        viewModel.description.observe(this, Observer {
            binding.tvContent.text = it.toString()
        })
    }
}