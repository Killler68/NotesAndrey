package com.example.notesandrey

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.notesandrey.extensions.navigateToFragment


class MainActivity : AppCompatActivity() {
    private val buttonBeer: Button by lazy {
        findViewById(R.id.find_beer_button)
    }
    private val buttonMessage: Button by lazy {
        findViewById(R.id.send_button)
    }
    private val stopWatch: Button by lazy {
        findViewById(R.id.stop_watch)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonBeer.setOnClickListener {
            navigateToFragment(FindBeerFragment())
        }
        buttonMessage.setOnClickListener {
            navigateToFragment(CreateMessage())
        }
        stopWatch.setOnClickListener {
            navigateToFragment(StopWatchFragment())
        }
    }
}
