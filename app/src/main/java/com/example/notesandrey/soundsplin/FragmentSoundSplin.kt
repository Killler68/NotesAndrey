package com.example.notesandrey.soundsplin

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notesandrey.R
import com.example.notesandrey.databinding.FragmentSoundSplinBinding
import com.example.notesandrey.soundsplin.viewmodel.SoundSplinViewModel
import com.example.notesandrey.soundsplin.viewmodel.SoundSplinViewModelFactory


class FragmentSoundSplin : Fragment() {

    private var _binding: FragmentSoundSplinBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SoundSplinViewModel by viewModels { SoundSplinViewModelFactory() }

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
        with(viewModel) {
            sound1.observe(viewLifecycleOwner) {
                binding.soundStart.text = it.toString()
            }
            sound2.observe(viewLifecycleOwner) {
                binding.soundStop.text = it
            }
        }
        soundSplin()
    }

    private fun soundSplin() {
        viewModel.mediaPlayer = MediaPlayer.create(activity, R.raw.splin)

        binding.soundStart.setOnClickListener {
            viewModel.soundClickStart(binding.soundStart.isEnabled)

            viewModel.mediaPlayer.setOnCompletionListener {
                viewModel.soundCompletionListener()
            }
        }
        binding.soundStop.setOnClickListener {
            viewModel.soundClickStop(binding.soundStop.isEnabled)
        }
    }
}

