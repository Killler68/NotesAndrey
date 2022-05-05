package com.example.notesandrey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesandrey.extensions.navigateToFragment

private const val NAME_BUTTON_BEER = "НАЙДИ ПИВО"
private const val NAME_BUTTON_MESSAGE = "ОТПРАВИТЬ СООБЩЕНИЕ"
private const val NAME_BUTTON_TIME = "СЕКУНДОМЕР"
private const val NAME_BUTTON_CALCULATOR = "КАЛЬКУЛЯТОР"
private const val NAME_BUTTON_BANNER = "БАННЕР"
private const val NAME_BUTTON_MINI_GAMES = "МИНИ ИГРЫ"

class MainScreenFragment : Fragment() {

    private val recyclerViewAdapter = MainScreenRecyclerViewAdapter()

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

        val items = getItems()
        recyclerViewAdapter.setItems(items)
    }

    private fun onClick(fragment: Fragment) {
        navigateToFragment(fragment)
    }

    private fun getItems(): List<FragmentItem> =
        listOf(
            FragmentItem(FindBeerFragment(), NAME_BUTTON_BEER, ::onClick),
            FragmentItem(CreateMessage(), NAME_BUTTON_MESSAGE, ::onClick),
            FragmentItem(StopWatchFragment(), NAME_BUTTON_TIME, ::onClick),
            FragmentItem(CalculatorFragment(), NAME_BUTTON_CALCULATOR, ::onClick),
            FragmentItem(FragmentBanner(), NAME_BUTTON_BANNER, ::onClick),
            FragmentItem(FragmentMiniGamesCreated(), NAME_BUTTON_MINI_GAMES, ::onClick)
        )

}