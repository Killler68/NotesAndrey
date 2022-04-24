package com.example.notesandrey.extensions

import androidx.fragment.app.Fragment
import com.example.notesandrey.R

fun Fragment.navigateToFragmentWithOutBackStack(fragment: Fragment) {
    this.parentFragmentManager.beginTransaction()
        .replace(R.id.fragment_create_message, fragment)
        .commit()
}