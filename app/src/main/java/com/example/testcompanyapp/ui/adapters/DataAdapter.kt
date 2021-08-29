package com.example.testcompanyapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testcompanyapp.data.Data
import com.example.testcompanyapp.databinding.ItemBinding

class DataAdapter(
    private val clickListener: (Data) -> Unit
) : ListAdapter<Data, DataAdapter.MyViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val bindingView = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item: Data = currentList[position]

        holder.bind(item, clickListener)
    }

    class MyViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data, clickListener: (Data) -> Unit) {
            binding.itemName.text = item.title

            binding.root.setOnClickListener {
                clickListener(item)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

    }
}