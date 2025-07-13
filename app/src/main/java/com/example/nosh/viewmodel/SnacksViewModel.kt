package com.example.nosh.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nosh.screens.api.Meal
import com.example.nosh.screens.api.MealRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class MealUiState {
    object Loading : MealUiState()
    data class Success(val meals: List<Meal>) : MealUiState()
    data class Error(val message: String) : MealUiState()
}

class SnacksViewModel(private val repository: MealRepository = MealRepository()) : ViewModel() {

    private val _uiState = MutableStateFlow<MealUiState>(MealUiState.Loading)
    val uiState: StateFlow<MealUiState> = _uiState

    fun fetchDesserts() {
        viewModelScope.launch {
            try {
                _uiState.value = MealUiState.Loading
                val response = repository.getDesserts()
                if (response.isSuccessful) {
                    val meals = response.body()?.meals ?: emptyList()
                    _uiState.value = MealUiState.Success(meals)
                } else {
                    _uiState.value = MealUiState.Error("Failed: ${response.code()}")
                }
            } catch (e: Exception) {
                _uiState.value = MealUiState.Error("Error: ${e.localizedMessage ?: "Unknown"}")
            }
        }
    }
}
