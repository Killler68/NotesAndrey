package com.example.notesandrey.common.fragment

import androidx.fragment.app.Fragment
import com.example.notesandrey.R

fun Fragment.navigateToFragment(fragment: Fragment) {
    this.parentFragmentManager.beginTransaction()
        .replace(R.id.background_main, fragment, fragment.javaClass.simpleName)
        .addToBackStack(fragment.javaClass.simpleName)
        .commit()
}