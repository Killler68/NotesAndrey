package com.example.notesandrey.banner

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notesandrey.R
import com.example.notesandrey.databinding.FragmentBannerBinding


class FragmentBanner : Fragment() {

    private var _binding: FragmentBannerBinding? = null
    private val binding get() = _binding!!
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBannerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        soundMeow()
    }

    private fun soundMeow() {
        binding.apply {
            banner.setOnClickListener {
                mediaPlayer = MediaPlayer.create(activity, R.raw.catmeow1)
                mediaPlayer.start()
            }
            poster.setOnClickListener {
                mediaPlayer = MediaPlayer.create(activity, R.raw.catmeow2)
                mediaPlayer.start()
            }
        }
    }
}
