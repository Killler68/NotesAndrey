package com.example.notesandrey

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.notesandrey.extensions.navigateToFragment


class MainActivity : AppCompatActivity() {
    private val button1: Button by lazy {
        findViewById(R.id.find_beer1)
    }
    private val button2: Button by lazy {
        findViewById(R.id.btn_fragment2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener {
            navigateToFragment(FindBeerFragment())
        }
        button2.setOnClickListener {
            navigateToFragment(SecondFragment())
        }

    }
}
