package com.example.domain.repo

import com.example.domain.models.MealResponse

interface MealsRepo {
    suspend fun getMealsFromRemote():MealResponse
}