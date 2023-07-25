package com.example.recipeapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    @GET("filter.php?")
    fun getRecipeByCountryName(@Query("a") countryName:String): Call<Recipe>
}