package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.recipeapp.databinding.ActivityMainBinding
import com.example.recipeapp.databinding.ActivityMealBinding

class MealActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMealBinding
    private lateinit var mealId : String
    private lateinit var mealName : String
    private lateinit var mealThumb : String
//    private lateinit var mealMVVM : MealViewModel
    private lateinit var youtubeLink : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMealsFromCountryIntent()
        setInformationViews()
//        val meadDatabase = MealDatabase.getInstance(this)
//        val viewModelFactory = MealViewModelFactory(meadDatabase)
//        mealMVVM = ViewModelProvider(this,viewModelFactory)[MealViewModel::class.java]
//        mealMVVM.getMealDetails(mealId)
//        observeMealDetailsLiveData()
    }

    private var mealToSave : Meal?= null
    /*private fun observeMealDetailsLiveData() {
        mealMVVM.observeMealDetailsLiveData().observe(this,object : Observer<Meal> {
            override fun onChanged(value: Meal) {
                val meal = t
                mealToSave = meal
                binding.tvCategory.text = "Category : ${meal!!.strCategory}"
                binding.tvArea.text = "Area : ${meal.strArea}"
                binding.tvInstructionsSteps.text = meal.strInstructions
            }
        })
    }*/

    private fun setInformationViews() {
        Glide.with(applicationContext)
            .load(mealThumb)
            .into(binding.imgMealDetail)
        binding.collapsingToolBar.title = mealName
        binding.collapsingToolBar.setCollapsedTitleTextColor(resources.getColor(R.color.white))
        binding.collapsingToolBar.setExpandedTitleColor(resources.getColor(R.color.white))
    }

    private fun getMealsFromCountryIntent() {
        mealId = intent.getStringExtra(MainActivity.MEAL_ID)!!
        mealName = intent.getStringExtra(MainActivity.MEAL_Name)!!
        mealThumb = intent.getStringExtra(MainActivity.MEAL_THUMB)!!
    }

}
