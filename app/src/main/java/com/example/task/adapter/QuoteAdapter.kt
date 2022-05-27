package com.example.task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task.databinding.ItemDetailsRecyclerviewBinding
import com.example.task.models.QuoteResult

class QuoteAdapter : ListAdapter<QuoteResult, QuoteAdapter.ViewHolder>(QuoteListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: ItemDetailsRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: QuoteResult) {
            binding.quote = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemDetailsRecyclerviewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class QuoteListDiffCallback : DiffUtil.ItemCallback<QuoteResult>() {

    override fun areItemsTheSame(oldItem: QuoteResult, newItem: QuoteResult): Boolean {
        return oldItem.author == newItem.author
    }

    override fun areContentsTheSame(oldItem: QuoteResult, newItem: QuoteResult): Boolean {
        return oldItem.author == newItem.author
    }
}