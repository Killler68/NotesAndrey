package com.example.notesandrey.soundsplin.viewmodel

import android.media.MediaPlayer
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesandrey.R


private const val SOUND_COMPLETION = "end"

class SoundSplinViewModel : ViewModel() {

    private val _sound1: MutableLiveData<Boolean> = MutableLiveData()
    val sound1: MutableLiveData<Boolean> get() = _sound1

    private val _sound2: MutableLiveData<Boolean> = MutableLiveData()
    val sound2: LiveData<Boolean> get() = _sound2

    lateinit var mediaPlayer: MediaPlayer

     fun soundClickStart(a: Boolean) {
        mediaPlayer.start()
        mediaPlayer.seekTo(0)
        _sound1.postValue(false)
       _sound2.postValue(  true)
    }
     fun soundCompletionListener() {
        binding.soundStop.isEnabled = false
        binding.soundStart.isEnabled = true
        _sound1.postValue(Toast.makeText(activity, SOUND_COMPLETION, Toast.LENGTH_SHORT).show().toString())
    }

     fun soundClickStop(a: Boolean) {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.reset()
            mediaPlayer.release()

            binding.soundStop.isEnabled = false
            binding.soundStart.isEnabled = true
        }
    }
}