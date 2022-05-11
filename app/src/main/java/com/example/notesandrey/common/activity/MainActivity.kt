package com.example.notesandrey.common.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notesandrey.R
import com.example.notesandrey.mainscreen.MainScreenFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToFragmentActivity(MainScreenFragment())
    }
}
