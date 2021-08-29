package com.example.testcompanyapp.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testcompanyapp.data.Category
import com.example.testcompanyapp.repository.ItemsRepository

class SubcategoryViewModel(
    private val lastDataId: String,
    private val lastCategoryId: String
) : ViewModel() {
    val items: MutableLiveData<Category> = MutableLiveData()

    init {
        getItems()
    }

    fun getItems() {

        val getSubcategoriesItems =
            ItemsRepository.items.find { it.id == lastDataId }?.categories?.find { it.id == lastCategoryId }
        if (getSubcategoriesItems != null) {
            items.postValue(getSubcategoriesItems)
        }
    }
}