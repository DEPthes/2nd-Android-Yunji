package com.example.week5_fragmentstudy

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.week5_fragmentstudy.databinding.ActivityEditidcardBinding
import com.example.week5_fragmentstudy.databinding.ActivityMainBinding

class EditidcardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditidcardBinding
    //lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditidcardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val beforeName = intent.getStringExtra("beforeName")
        if(beforeName != null){
            binding.newUserName.hint = beforeName
        }

        binding.confirmButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            if(binding.newUserName.text.toString()!=""){
                intent.putExtra("afterName", binding.newUserName.text.toString())
            }
            else{
                intent.putExtra("afterName", beforeName)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}