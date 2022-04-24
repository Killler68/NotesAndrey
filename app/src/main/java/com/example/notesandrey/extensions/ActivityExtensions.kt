package com.example.notesandrey.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.notesandrey.R

fun AppCompatActivity.navigateToFragment(fragment: Fragment) {
    this.supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_relative_layout_activity, fragment, fragment.javaClass.simpleName)
        .addToBackStack(fragment.javaClass.simpleName)
        .commit()
}