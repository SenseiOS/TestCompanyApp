package com.example.testcompanyapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testcompanyapp.data.Subcategory
import com.example.testcompanyapp.databinding.ItemBinding

class SubcategoryAdapter() :
    ListAdapter<Subcategory, SubcategoryAdapter.MyViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val bindingView = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item: Subcategory = currentList[position]

        holder.bind(item)
    }

    class MyViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Subcategory) {
            binding.itemName.text = item.title
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Subcategory>() {
        override fun areItemsTheSame(oldItem: Subcategory, newItem: Subcategory): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Subcategory, newItem: Subcategory): Boolean {
            return oldItem == newItem
        }

    }
}