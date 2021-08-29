package com.example.testcompanyapp.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testcompanyapp.data.Data
import com.example.testcompanyapp.repository.ItemsRepository
import kotlinx.coroutines.launch

class DataViewModel() : ViewModel() {
    private val mutableItems: MutableLiveData<List<Data>> = MutableLiveData()
    val items: LiveData<List<Data>> = mutableItems

    init {
        getItems()
    }

    fun getItems() {
        viewModelScope.launch {
            if (ItemsRepository.items.isEmpty()) {
                ItemsRepository.getItem()
            }
            mutableItems.postValue(ItemsRepository.items)
        }
    }
}