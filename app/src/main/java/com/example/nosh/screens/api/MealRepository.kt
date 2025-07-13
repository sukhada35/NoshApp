package com.example.nosh.screens.api

import retrofit2.Response

class MealRepository {
    suspend fun getDesserts(): Response<MealResponse> {
        return RetrofitInstance.api.getDesserts()
    }
}
