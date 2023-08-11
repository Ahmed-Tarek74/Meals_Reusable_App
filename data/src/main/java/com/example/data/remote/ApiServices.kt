package com.example.data.remote

import com.example.domain.models.MealResponse
import retrofit2.http.GET

interface ApiServices {
    @GET("categories.php")
    suspend fun getMeals(): MealResponse
}
