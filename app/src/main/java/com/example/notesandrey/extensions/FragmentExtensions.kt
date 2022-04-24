package com.example.notesandrey.extensions

import androidx.fragment.app.Fragment
import com.example.notesandrey.R

fun Fragment.navigateToFragment(fragment: Fragment) {
    this.parentFragmentManager.beginTransaction()
        .replace(R.id.fragment_relative_layout_activity, fragment, fragment.javaClass.simpleName)
        .addToBackStack(fragment.javaClass.simpleName)
        .commit()
}