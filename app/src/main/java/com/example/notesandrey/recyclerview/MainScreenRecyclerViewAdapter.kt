package com.example.notesandrey.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesandrey.R


class MainScreenRecyclerViewAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var items: List<FragmentItem> = listOf()

    fun setItems(items: List<FragmentItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = R.layout.recycler_item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)

        return MainViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}