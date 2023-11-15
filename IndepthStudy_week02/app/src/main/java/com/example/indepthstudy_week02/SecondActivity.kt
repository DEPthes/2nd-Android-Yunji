package com.example.indepthstudy_week02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.indepthstudy_week02.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
//    private lateinit var viewModel: UserViewModel
//    private lateinit var viewModelFactory: UserViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        changeFragment(FirstFragment())

        binding.btnFirst.setOnClickListener {
            changeFragment(FirstFragment())
        }
        binding.btnSecond.setOnClickListener {
            changeFragment(SecondFragment(binding.frame))
        }
    }

    private fun changeFragment(frag: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame, frag).commit()
    }
}