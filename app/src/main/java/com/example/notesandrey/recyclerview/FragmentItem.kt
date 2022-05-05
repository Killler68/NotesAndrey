package com.example.notesandrey.recyclerview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

data class FragmentItem(
    val fragment: Fragment,
    val name: String,
    val onClick: (Fragment) -> Unit
)