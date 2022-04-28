package com.example.notesandrey.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.notesandrey.R
import com.example.notesandrey.RecyclerFragment


fun AppCompatActivity.navigateToFragmentActivity(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.linearLayout2, RecyclerFragment())
        .commit()
}
