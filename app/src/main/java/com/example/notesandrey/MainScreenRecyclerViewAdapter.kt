package com.example.notesandrey

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class MainScreenRecyclerViewAdapter : RecyclerView.Adapter<ViewHolder>() {

    private var items: List<FragmentItem> = listOf()

    fun setItems(items: List<FragmentItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = R.layout.recycler_item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)

        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}