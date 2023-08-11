package com.example.domain.usecases

import com.example.domain.models.MealResponse
import com.example.domain.repo.MealsRepo

class GetMeals (private val repo:MealsRepo) {
    suspend fun getMeals ():MealResponse{
        return repo.getMealsFromRemote()
    }
}