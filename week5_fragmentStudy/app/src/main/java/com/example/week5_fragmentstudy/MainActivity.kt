package com.example.week5_fragmentstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week5_fragmentstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var userName: String? = null
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
                R.id.search->{
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,SearchFragment()).commit()
                }
                R.id.ranking->{
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,RankingFragment()).commit()
                }
                R.id.mypage->{
                    supportFragmentManager.beginTransaction().replace(R.id.framelayout,MypageFragment()).commit()
                }
            }
            true
        }
    }
    fun setUserName(userName: String?) {
    this.userName = userName
    }

    fun getUserName(): String? {
        return userName
    }
}