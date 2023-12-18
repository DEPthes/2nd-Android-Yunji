package com.example.indepthstudy_week03_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.indepthstudy_week03_livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mutableLiveData: MutableLiveData<Int> = MutableLiveData(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btn.setOnClickListener{
            mutableLiveData.value = mutableLiveData.value!!.plus(1)
        }

        mutableLiveData.observe(this) {
            binding.tv.text = mutableLiveData.value.toString()
        }

    }
}