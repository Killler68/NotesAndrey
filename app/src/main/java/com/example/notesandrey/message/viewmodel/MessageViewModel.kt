package com.example.notesandrey.message.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MessageViewModel : ViewModel(){

    private var _text: MutableLiveData<String> = MutableLiveData()
    private val text: LiveData<String> get() = _text


}