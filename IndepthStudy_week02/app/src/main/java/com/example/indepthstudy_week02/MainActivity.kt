package com.example.indepthstudy_week02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.indepthstudy_week02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var viewModel: UserViewModel?=null
    private lateinit var viewModelFactory: UserViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Log.d("TAG", "onCreate: viewmodel before")
        if(viewModel==null){
            Log.d("TAG", "onCreate: viewmodel null")
            initViewModel()
        }
        Log.d("TAG", "onCreate: viewmodel after")
        binding.btnPrint.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()

            viewModel?.setName(firstName,lastName)
            binding.user = viewModel
//            binding.user = User(firstName,lastName)
        }

        binding.btnGoSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViewModel(){
        viewModelFactory = UserViewModelFactory("","")
        viewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)
    }
}