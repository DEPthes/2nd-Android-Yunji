package com.example.androidbasicstudy_week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidbasicstudy_week8.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.title.text = intent.getStringExtra("title")
        binding.price.text = "$" + intent.getIntExtra("price", 0)
        binding.description.text = intent.getStringExtra("description")

        val receivedBundle = intent.extras
        val images = receivedBundle?.getStringArrayList("images")
        if (images != null) {
            binding.itemImg.adapter = PagerAdapter(images, this)
        }
    }
}