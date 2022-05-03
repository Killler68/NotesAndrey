package com.example.notesandrey

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var title: Button = itemView.findViewById(R.id.title)
    fun bind(item: FragmentItem) {
        itemView.setOnClickListener {
            item.onClick(item.fragment)
        }
        title.text = item.name
    }
}
