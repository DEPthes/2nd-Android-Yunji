package com.example.androidbasicstudy_week4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidbasicstudy_week4.databinding.ActivitySecondBinding
//import com.example.androidbasicstudy_week4.databinding.AddnewfolderBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.creatFolderButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("text", binding.editText.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cancelButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}