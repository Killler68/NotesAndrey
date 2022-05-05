package com.example.notesandrey.common.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.notesandrey.R


fun AppCompatActivity.navigateToFragmentActivity(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.background_main, fragment)
        .commit()
}
