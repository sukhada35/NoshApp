package com.example.nosh.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RecipeViewModel : ViewModel() {
    val selectedCategory = mutableStateOf("Snacks")

    fun selectCategory(category: String) {
        selectedCategory.value = category
    }
}
