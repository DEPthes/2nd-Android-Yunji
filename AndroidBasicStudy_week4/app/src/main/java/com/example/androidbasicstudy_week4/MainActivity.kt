package com.example.androidbasicstudy_week4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidbasicstudy_week4.databinding.ActivityMainBinding
import com.example.androidbasicstudy_week4.databinding.ActivitySecondBinding
import kotlin.contracts.contract

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == Activity.RESULT_OK){
                binding.folderTitle.text = result.data?.getStringExtra("text")
            }
        }

        binding.addNewFolder.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            launcher.launch(intent)
        }

    }

}