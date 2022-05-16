package com.example.notesandrey.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.notesandrey.R
import com.example.notesandrey.common.fragment.navigateToFragment
import com.example.notesandrey.mainscreen.adapters.MainScreenRecyclerViewAdapter
import com.example.notesandrey.mainscreen.models.FragmentItem
import com.example.notesandrey.mainscreen.viewmodel.MainViewModel
import com.example.notesandrey.mainscreen.viewmodel.MainViewModelFactory


class MainScreenFragment() : Fragment() {

    private val recyclerViewAdapter = MainScreenRecyclerViewAdapter()
    private val viewModel: MainViewModel by viewModels { MainViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = recyclerViewAdapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.item.observe(viewLifecycleOwner) {
            val items = it.map {
                FragmentItem(
                    it.fragment,
                    it.name,
                    ::onClick
                )
            }
            recyclerViewAdapter.setItems(items)
        }
        viewModel.mainScreenFragmentItem()
    }

    private fun onClick(fragment: Fragment) {
        navigateToFragment(fragment)
    }
}