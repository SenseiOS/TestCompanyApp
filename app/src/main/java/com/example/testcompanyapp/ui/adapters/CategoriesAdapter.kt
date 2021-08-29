package com.example.testcompanyapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testcompanyapp.data.Category
import com.example.testcompanyapp.databinding.ItemBinding

class CategoriesAdapter(
    private val clickListener: (Category) -> Unit
) : ListAdapter<Category, CategoriesAdapter.MyViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val bindingView = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item: Category = currentList[position]

        holder.bind(item, clickListener)
    }

    class MyViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Category, clickListener: (Category) -> Unit) {
            binding.itemName.text = item.title

            binding.root.setOnClickListener {
                clickListener(item)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

    }
}