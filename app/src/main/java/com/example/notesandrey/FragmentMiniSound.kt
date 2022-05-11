package com.example.notesandrey

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.notesandrey.databinding.FragmentMiniSoundBinding

private const val SOUND_COMPLETION = "end"


class FragmentMiniSound : Fragment() {

    private var _binding: FragmentMiniSoundBinding? = null
    private val binding get() = _binding!!
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMiniSoundBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        soundPlayer()
    }

    private fun soundPlayer() {
        binding.btnSoundStart.setOnClickListener {
            soundMediaStart()

            mediaPlayer.setOnCompletionListener {
                completionSound()
            }
        }
        binding.btnSoundStop.setOnClickListener {
            soundMediaStop()
        }
    }

    private fun soundMediaStart() {
        mediaPlayer = MediaPlayer.create(activity, R.raw.sudno)
        mediaPlayer.start()
        binding.btnSoundStart.isEnabled = false
        binding.btnSoundStop.isEnabled = true
    }

    private fun completionSound() {
        binding.btnSoundStop.isEnabled = false
        binding.btnSoundStart.isEnabled = true
        Toast.makeText(activity, SOUND_COMPLETION, Toast.LENGTH_SHORT).show()
    }

    private fun soundMediaStop() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.reset()
            mediaPlayer.release()

            binding.btnSoundStop.isEnabled = false
            binding.btnSoundStart.isEnabled = true
        }
    }
}