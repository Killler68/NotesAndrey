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
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sound_splin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSoundSplinBinding.bind(view)
        soundSplin()
    }

    private fun soundSplin() {
        binding.apply {
            soundStart.setOnClickListener {
                mediaPlayer = MediaPlayer.create(activity, R.raw.splin)
                mediaPlayer.start()
                it.isEnabled = false
                soundStop.isEnabled = true

                mediaPlayer.setOnCompletionListener {
                    soundStop.isEnabled = false
                    soundStart.isEnabled = true
                    Toast.makeText(activity, SOUND_COMPLETION, Toast.LENGTH_SHORT).show()
                }
            }
            soundStop.setOnClickListener {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.stop()
                    mediaPlayer.reset()
                    mediaPlayer.release()

                    it.isEnabled = false
                    soundStart.isEnabled = true
                }
            }
        }
    }
}

