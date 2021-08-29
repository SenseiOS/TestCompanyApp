package com.example.testcompanyapp.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testcompanyapp.data.Data
import com.example.testcompanyapp.repository.ItemsRepository

class CategoriesViewModel(
    private val itemId: String
) : ViewModel() {
    val items: MutableLiveData<Data> = MutableLiveData()

    init {
        getItems()
    }

    fun getItems() {

        items.postValue(ItemsRepository.items.find { it.id == itemId })
    }
}