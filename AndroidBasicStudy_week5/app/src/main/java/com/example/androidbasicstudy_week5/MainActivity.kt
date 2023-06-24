package com.example.androidbasicstudy_week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.androidbasicstudy_week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.framelayout,HomeFragment()).commit()

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,HomeFragment()).commit()
                }
                R.id.profile->{
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,ProfileFragment()).commit()
                }
                R.id.setting->{
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,SettingFragment()).commit()
                }
            }
            true
        }
    }

}