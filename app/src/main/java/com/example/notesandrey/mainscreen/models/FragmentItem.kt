package com.example.notesandrey.mainscreen.models

import androidx.fragment.app.Fragment

data class FragmentItem(
    val fragment: Fragment,
    val name: String,
    val onClick: (Fragment) -> Unit
)