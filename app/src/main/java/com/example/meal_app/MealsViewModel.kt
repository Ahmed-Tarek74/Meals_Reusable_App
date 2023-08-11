package com.example.meal_app

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.MealResponse
import com.example.domain.usecases.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase: GetMeals
): ViewModel() {

    private val _mealsList: MutableStateFlow<MealResponse?> = MutableStateFlow(null)
    val mealsList: StateFlow<MealResponse?> = _mealsList

    fun getMeals(){
        viewModelScope.launch{
            try {
                _mealsList.value = getMealsUseCase.getMeals()
            } catch (e: Exception){
                Log.e("catching meals error", e.message.toString())
            }
        }
    }

}