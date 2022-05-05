package com.example.notesandrey

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var buttonItem: Button = itemView.findViewById(R.id.button_item)
    fun bind(item: FragmentItem) {
        buttonItem.setOnClickListener {
            item.onClick(item.fragment)
        }
        buttonItem.text = item.name
    }
}
