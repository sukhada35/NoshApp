package com.example.nosh.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class MealPlannerViewModel : ViewModel() {
    private val _selectedDay = mutableStateOf("MON")
    val selectedDay: State<String> = _selectedDay

    private val _meals = mutableStateOf(
        mutableMapOf(
            "MON" to mutableStateListOf<String>(),
            "TUE" to mutableStateListOf(),
            "WED" to mutableStateListOf(),
            "THU" to mutableStateListOf(),
            "FRI" to mutableStateListOf(),
            "SAT" to mutableStateListOf(),
            "SUN" to mutableStateListOf()
        )
    )

    fun selectDay(day: String) {
        _selectedDay.value = day
    }

    fun getMealsForDay(day: String): List<String> {
        return _meals.value[day]?.toList() ?: emptyList()
    }

    fun addMeal(day: String, meal: String) {
        _meals.value[day]?.add(meal)
    }

    fun removeMeal(day: String, meal: String) {
        _meals.value[day]?.remove(meal)
    }
}

