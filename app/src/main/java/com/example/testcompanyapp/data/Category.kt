package com.example.testcompanyapp.data

data class Category(
    val date: String,
    val id: String,
    val subcategories: List<Subcategory>,
    val title: String
)