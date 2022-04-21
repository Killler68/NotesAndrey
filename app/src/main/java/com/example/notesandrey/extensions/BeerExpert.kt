package com.example.notesandrey.extensions


fun beerExpert(color: String): ArrayList<String> {

    val list = ArrayList<String>()
    if (color == "amber") {
        list.add("Jack Amber")
        list.add("Red Mouse")
    } else {
        list.add("Joy")
        list.add("Hot boy")
    }
    return list
}
