package com.example.androidbasicstudy_week6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.androidbasicstudy_week6.databinding.ActivityEditMemoBinding

class editMemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditMemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //item을 클릭하여 왔을땐 수정 기능 제공
        val isEdit = intent.getIntExtra("editIndex",0)
        if(isEdit!=0){
            binding.title.text = Editable.Factory.getInstance().newEditable(MemoList.memos[isEdit-1].title)
            binding.content.text = Editable.Factory.getInstance().newEditable(MemoList.memos[isEdit-1].content)
            binding.saveButton.text = "수정하기"
        }

        binding.saveButton.setOnClickListener{
            if(isEdit!=0){
                //수정하는 경우
                MemoList.memos[isEdit-1] = Memo(binding.title.text.toString(),binding.content.text.toString())
            }
            else{
                //새로 생성
                MemoList.memos.add(
                    Memo(binding.title.text.toString(),binding.content.text.toString())
                )
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}