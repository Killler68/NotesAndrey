package com.example.notesandrey

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var title: TextView = itemView.findViewById(R.id.title)

    fun bind(item: FragmentItem) {
        itemView.setOnClickListener {
            item.onClick(item.fragment)
        }
        title.text = item.name
    }
}
