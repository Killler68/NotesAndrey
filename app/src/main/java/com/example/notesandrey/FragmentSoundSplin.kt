package com.example.notesandrey

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.notesandrey.databinding.FragmentSoundSplinBinding

private const val SOUND_COMPLETION = "end"

class FragmentSoundSplin : Fragment() {

    private var _binding: FragmentSoundSplinBinding? = null
    private val binding get() = _binding!!
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSoundSplinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        soundSplin()
    }

    private fun soundSplin() {
        binding.soundStart.setOnClickListener {
            soundClickStart()

            mediaPlayer.setOnCompletionListener {
                soundCompletionListener()
            }
        }
        binding.soundStop.setOnClickListener {
            soundClickStop()
        }
    }

    private fun soundClickStart() {
        mediaPlayer = MediaPlayer.create(activity, R.raw.splin)
        mediaPlayer.start()
        mediaPlayer.seekTo(0)
        binding.soundStart.isEnabled = false
        binding.soundStop.isEnabled = true
    }

    private fun soundCompletionListener() {
        binding.soundStop.isEnabled = false
        binding.soundStart.isEnabled = true
        Toast.makeText(activity, SOUND_COMPLETION, Toast.LENGTH_SHORT).show()
    }

    private fun soundClickStop() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.reset()
            mediaPlayer.release()

            binding.soundStop.isEnabled = false
            binding.soundStart.isEnabled = true
        }
    }
}

