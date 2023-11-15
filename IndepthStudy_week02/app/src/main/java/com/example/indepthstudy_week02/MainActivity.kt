package com.example.indepthstudy_week02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.indepthstudy_week02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var viewModelFactory: UserViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModelFactory = UserViewModelFactory("","")
        viewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)

        binding.btnPrint.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()

            viewModel.setName(firstName,lastName)
            binding.user = viewModel
//            binding.user = User(firstName,lastName)
        }

        binding.btnGoSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}