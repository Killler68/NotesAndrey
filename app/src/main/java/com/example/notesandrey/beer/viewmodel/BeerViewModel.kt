package com.example.notesandrey.beer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


private const val COLOR_BEER_AMBER = "amber"
private const val COLOR_BEER_LIGHT = "light"
private const val COLOR_BEER_DARK = "dark"
private const val COLOR_BEER_BROWN = "brown"
private const val NAME_BEER_COLOR_JACK_AMBER = "Jack Amber"
private const val NAME_BEER_COLOR_RED_MOUSE = "Red Mouse"
private const val NAME_BEER_COLOR_ZHATECKY_GUS = "Жатецкий гусь"
private const val NAME_BEER_COLOR_WHITE_BEAR = "Белый Медведь"
private const val NAME_BEER_COLOR_387 = "387"
private const val NAME_BEER_COLOR_KOZEL = "Козел"
private const val NAME_BEER_COLOR_JOY = "Joy"
private const val NAME_BEER_COLOR_HOT_BOY = "Hot Boy"

class BeerViewModel() : ViewModel() {

    private val _brands: MutableLiveData<String> = MutableLiveData()
    val brands: LiveData<String> get() = _brands

    private fun beerExpertMain(color: String): List<String> {
        val list = when (color) {
            COLOR_BEER_AMBER -> listOf(NAME_BEER_COLOR_JACK_AMBER, NAME_BEER_COLOR_RED_MOUSE)
            COLOR_BEER_LIGHT -> listOf(NAME_BEER_COLOR_ZHATECKY_GUS, NAME_BEER_COLOR_WHITE_BEAR)
            COLOR_BEER_DARK -> listOf(NAME_BEER_COLOR_387, NAME_BEER_COLOR_KOZEL)
            COLOR_BEER_BROWN -> listOf(NAME_BEER_COLOR_JOY, NAME_BEER_COLOR_HOT_BOY)
            else -> emptyList()
        }
        return list
    }

    fun fiendBeerExpert(brandsMvvm: String) {
        var str = ""
        for (brand in beerExpertMain(brandsMvvm)) {
            str += brand + "\n"
        }
        _brands.postValue(str)
    }
}

