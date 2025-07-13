package com.example.nosh.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

data class PantryItem(
    val name: String,
    var quantity: Int = 0
)

class PantryViewModel : ViewModel() {
    private val _selectedCategory = mutableStateOf("Fruits")
    val selectedCategory: State<String> = _selectedCategory

    fun selectCategory(cat: String) {
        _selectedCategory.value = cat
    }

    private val _pantryItems = mutableStateOf(
        mapOf(
            "Fruits" to mutableListOf(
                PantryItem("Strawberry", 0),
                PantryItem("Banana", 0),
                PantryItem("Apple", 0),
                PantryItem("Kiwi", 0),
            ),
            "Vegetables" to mutableListOf(
                PantryItem("Tomato", 0),
                PantryItem("Spinach", 0),
                PantryItem("Potato", 0)
            ),
            "Additives" to mutableListOf(
                PantryItem("Salt", 0),
                PantryItem("Sugar", 0),
                PantryItem("Spices", 0)
            ),
            "Dairy" to mutableListOf(
                PantryItem("Milk", 0),
                PantryItem("Cheese", 0),
                PantryItem("Butter", 0)
            )
        )
    )
    val pantryItems: State<Map<String, List<PantryItem>>> = _pantryItems

    fun increase(name: String) {
        updateQty(name, 1)
    }

    fun decrease(name: String) {
        updateQty(name, -1)
    }

    private fun updateQty(name: String, delta: Int) {
        val cat = _selectedCategory.value
        val updated = _pantryItems.value[cat]?.map {
            if (it.name == name) it.copy(quantity = maxOf(0, it.quantity + delta)) else it
        } ?: listOf()

        _pantryItems.value = _pantryItems.value.toMutableMap().apply {
            this[cat] = updated.toMutableList()
        }
    }
}
