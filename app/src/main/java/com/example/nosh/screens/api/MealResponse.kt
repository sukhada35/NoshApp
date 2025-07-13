package com.example.nosh.screens.api

import com.google.gson.annotations.SerializedName

data class MealResponse( // specific list of items
    val meals: List<Meal>
)

data class Meal(
    @SerializedName("strMeal") val str: String,
    @SerializedName("strMealThumb") val strMealThumb: String,
    @SerializedName("idMeal") val id: String
)

