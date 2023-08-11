package com.example.data.repo

import com.example.data.remote.ApiServices
import com.example.domain.models.MealResponse
import com.example.domain.repo.MealsRepo

class MealsRepoImpl(private val apiServices:ApiServices): MealsRepo {
    override suspend fun getMealsFromRemote(): MealResponse {
        return apiServices.getMeals()
    }
}