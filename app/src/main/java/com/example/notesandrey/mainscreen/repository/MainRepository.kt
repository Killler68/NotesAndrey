package com.example.notesandrey.mainscreen.repository

import com.example.notesandrey.mainscreen.models.MainItemFragments

interface MainRepository {
    fun fragmentsItem(): List<MainItemFragments>
}