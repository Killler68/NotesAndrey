package com.example.notesandrey.mainscreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesandrey.mainscreen.models.MainItemFragments
import com.example.notesandrey.mainscreen.repository.MainRepository

class MainViewModel(private val mainRepositoryImpl: MainRepository) : ViewModel() {

    private var _item: MutableLiveData<List<MainItemFragments>> = MutableLiveData()
    val item: LiveData<List<MainItemFragments>> get() = _item
    
    fun mainScreenFragmentItem() {
        val fragmentItems = mainRepositoryImpl.fragmentsItem()
        _item.postValue(fragmentItems)
    }
}