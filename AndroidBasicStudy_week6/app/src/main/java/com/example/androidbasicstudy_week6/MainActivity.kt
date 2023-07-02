package com.example.androidbasicstudy_week6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidbasicstudy_week6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var launcher: ActivityResultLauncher<Intent>

    //val memos = mutableListOf<Memo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeViews()

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){}

        binding.addButton.setOnClickListener{
            val intent = Intent(this, editMemoActivity::class.java)
            launcher.launch(intent)
        }
    }

    private fun initializeViews(){
        binding.memoList.layoutManager = LinearLayoutManager(this)
        binding.memoList.adapter = MemoAdapter(MemoList)
    }
}