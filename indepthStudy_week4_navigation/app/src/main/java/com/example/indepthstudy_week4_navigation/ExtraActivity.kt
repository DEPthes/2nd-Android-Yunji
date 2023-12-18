package com.example.indepthstudy_week4_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.indepthstudy_week4_navigation.databinding.ActivityExtraBinding

class ExtraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExtraBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtraBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}