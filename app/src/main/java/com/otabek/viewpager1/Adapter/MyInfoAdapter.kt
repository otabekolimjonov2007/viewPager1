package com.otabek.viewpager1.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.otabek.viewpager1.MyInfo
import com.otabek.viewpager1.databinding.ItemPagerBinding


class MyInfoAdapter(private val list: ArrayList<MyInfo>) : RecyclerView.Adapter<MyInfoAdapter.Vh>() {
    inner class Vh(private val binding: ItemPagerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(myInfo: MyInfo) {
            binding.tvTitle.text = myInfo.title
            binding.tvText.text = myInfo.text
            binding.itemImage.setImageResource(myInfo.imeg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        val binding = ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Vh(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}