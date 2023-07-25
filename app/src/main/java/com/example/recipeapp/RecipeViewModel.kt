package com.example.recipeapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeViewModel: ViewModel() {
    private var recipeLiveDat = MutableLiveData<List<Meal>>()
    fun getMealByCountryName(){
        MealInstance.api.getRecipeByCountryName("Indian").enqueue(object : Callback<Recipe>{
            override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {
                response.body()?.let { mealsList ->
                    recipeLiveDat.postValue(mealsList.meals)
                }
            }

            override fun onFailure(call: Call<Recipe>, t: Throwable) {
                Log.i("TAG", t.message.toString())
            }

        })
    }

    fun observeListData(): LiveData<List<Meal>>{
        return recipeLiveDat

    }

}