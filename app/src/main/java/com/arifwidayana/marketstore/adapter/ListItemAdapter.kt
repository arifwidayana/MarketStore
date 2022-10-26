package com.arifwidayana.marketstore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arifwidayana.marketstore.data.ListStoreResponse
import com.arifwidayana.marketstore.databinding.ItemContentBinding
import com.bumptech.glide.Glide

class ListItemAdapter(private val onClick: (ListStoreResponse) -> Unit):
    ListAdapter<ListStoreResponse, ListItemAdapter.ProductHolder>(
        Differ()
    ) {
    class ProductHolder(
        private val binding: ItemContentBinding,
        private val onClick: (ListStoreResponse) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {
        fun result(listStoreResponse: ListStoreResponse) {
            binding.apply {
                with(listStoreResponse) {
                    tvTitle.text = name
                    tvDesc.text = desc
                    Glide.with(root)
                        .load(image)
                        .into(ivImage)
                    root.setOnClickListener {
                        onClick.invoke(listStoreResponse)
                    }
                }
            }
        }
    }

    class Differ : DiffUtil.ItemCallback<ListStoreResponse>() {
        override fun areItemsTheSame(
            oldItem: ListStoreResponse,
            newItem: ListStoreResponse
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: ListStoreResponse,
            newItem: ListStoreResponse
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val binding = ItemContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.result(getItem(position))
    }
}