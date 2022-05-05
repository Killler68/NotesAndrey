package com.example.notesandrey

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notesandrey.extensions.navigateToFragmentActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToFragmentActivity(MainScreenFragment())
    }
}
