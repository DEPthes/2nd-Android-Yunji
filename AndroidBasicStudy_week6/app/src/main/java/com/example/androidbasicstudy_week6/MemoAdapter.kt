package com.example.androidbasicstudy_week6

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbasicstudy_week6.databinding.ItemMemoBinding

class MemoAdapter(private val memoList:MemoList) :
    RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val binding = ItemMemoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MemoViewHolder(binding).also { holder ->
            //수정하기
            binding.memoItem.setOnClickListener(){
                val intent = Intent(parent.context, editMemoActivity::class.java)
                intent.putExtra("editIndex",holder.adapterPosition+1)
                parent.context.startActivity(intent)
            }
            //삭제하기
            binding.removeButton.setOnClickListener(){
                MemoList.memos.removeAt(holder.adapterPosition)
                notifyDataSetChanged()
            }
        }
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(memoList.memos[position])
    }

    override fun getItemCount(): Int = memoList.memos.size

    class MemoViewHolder(private val binding: ItemMemoBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(memo:Memo){
            binding.memoItem.text = memo.title
        }
    }
}