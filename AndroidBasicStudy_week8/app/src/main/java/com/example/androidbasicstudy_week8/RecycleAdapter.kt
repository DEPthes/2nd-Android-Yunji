package com.example.androidbasicstudy_week8

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidbasicstudy_week8.databinding.ItemCardBinding

class RecycleAdapter(private val productList: List<UserData>): RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val binding = ItemCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecycleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount() = productList.count()

    class RecycleViewHolder(private val binding: ItemCardBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(userData: UserData){
                binding.title.text = userData.title
                binding.price.text = "$"+userData.price.toString()
                Glide.with(binding.root).load(userData.images[0]).into(binding.itemImg)

                binding.cardItem.setOnClickListener{
                    val intent = Intent(binding.root.context, MainActivity2::class.java)
                    intent.putExtra("title",userData.title)
                    intent.putExtra("description",userData.description)
                    intent.putExtra("price",userData.price)
                    intent.putExtra("imgSize",userData.images.size)
                    val bundle = Bundle()
                    bundle.putStringArrayList("images",ArrayList(userData.images))
                    intent.putExtras(bundle)
                    binding.root.context.startActivity(intent)
                }
            }
        }
}