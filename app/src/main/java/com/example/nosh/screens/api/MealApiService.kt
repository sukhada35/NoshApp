package com.example.nosh.screens.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiService {

    @GET("filter.php")
    suspend fun getMealsByCategory(
        @Query("c") category: String
    ): Response<MealResponse>

    @GET("filter.php?c=Dessert") //tells retrofit to fetch that
    suspend fun getDesserts(): Response<MealResponse>
}
