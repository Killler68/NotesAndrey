package com.example.notesandrey.mainscreen.repository

import com.example.notesandrey.FragmentSoundSplin
import com.example.notesandrey.banner.FragmentBanner
import com.example.notesandrey.beer.FragmentBeer
import com.example.notesandrey.calculator.CalculatorFragment
import com.example.notesandrey.counter.FragmentCounter
import com.example.notesandrey.mainscreen.models.MainItemFragments
import com.example.notesandrey.message.CreateMessage
import com.example.notesandrey.minigames.FragmentMiniGamesCreated
import com.example.notesandrey.stopwatch.FragmentStopWatch


private const val NAME_BUTTON_BEER = "НАЙДИ ПИВО"
private const val NAME_BUTTON_MESSAGE = "ОТПРАВИТЬ СООБЩЕНИЕ"
private const val NAME_BUTTON_TIME = "СЕКУНДОМЕР"
private const val NAME_BUTTON_CALCULATOR = "КАЛЬКУЛЯТОР"
private const val NAME_BUTTON_BANNER = "БАННЕР"
private const val NAME_BUTTON_MINI_GAMES = "МИНИ ИГРЫ"
private const val NAME_BUTTON_SOUND = "ПЕСНЯ СПЛИН"
private const val NAME_BUTTON_COUNTER = "СЧЕТЧИК"

class MainRepositoryImpl : MainRepository {

    override fun fragmentsItem(): List<MainItemFragments> =
        listOf(
            MainItemFragments(FragmentBeer(), NAME_BUTTON_BEER),
            MainItemFragments(CreateMessage(), NAME_BUTTON_MESSAGE),
            MainItemFragments(FragmentStopWatch(), NAME_BUTTON_TIME),
            MainItemFragments(CalculatorFragment(), NAME_BUTTON_CALCULATOR),
            MainItemFragments(FragmentBanner(), NAME_BUTTON_BANNER),
            MainItemFragments(FragmentMiniGamesCreated(), NAME_BUTTON_MINI_GAMES),
            MainItemFragments(FragmentSoundSplin(), NAME_BUTTON_SOUND),
            MainItemFragments(FragmentCounter(), NAME_BUTTON_COUNTER)

        )
}
