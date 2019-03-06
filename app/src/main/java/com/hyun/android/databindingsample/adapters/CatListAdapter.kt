package com.hyun.android.databindingsample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hyun.android.databindingsample.databinding.RvItemCatListBinding
import com.hyun.android.databindingsample.model.Cat

class CatListAdapter : ListAdapter<Cat, CatListAdapter.ViewHolder>(CatListDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatListAdapter.ViewHolder {
        return ViewHolder(RvItemCatListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CatListAdapter.ViewHolder, position: Int) {
        var cat = getItem(position)
        holder.bind(cat)

    }

    class ViewHolder(val binding: RvItemCatListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mCat: Cat) {
            binding.apply {
                cat = mCat
                executePendingBindings()
            }
        }
    }
}

private class CatListDiffCallback : DiffUtil.ItemCallback<Cat>() {
    override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
        return true
    }

}
