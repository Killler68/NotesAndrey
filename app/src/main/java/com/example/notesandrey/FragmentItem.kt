package com.example.notesandrey

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

data class FragmentItem(
    val fragment: Fragment,
    val name: String,
    val onClick: (Fragment) -> Unit
)