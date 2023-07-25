package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RecipeViewModel
    private lateinit var mealAdapter: MealAdapter

    companion object{
        const val MEAL_ID = "com.sangyan.easyfood.idMeal"
        const val MEAL_Name = "com.sangyan.easyfood.nameMeal"
        const val MEAL_THUMB = "com.sangyan.easyfood.thumbMeal"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this) [RecipeViewModel::class.java]
        viewModel.getMealByCountryName()
        viewModel.observeListData().observe(this, Observer { it ->
            mealAdapter.setMealData(it)
        })

        mealAdapter.setOnMealClickListener(object : MealAdapter.SetOnMealClickListener{
            override fun setOnClickListener(mealsByCategoryName: MealsByCategoryName) {
                val intent = Intent(applicationContext, MealActivity::class.java)
                intent.putExtra(MEAL_ID, mealsByCategoryName.idMeal)
                intent.putExtra(MEAL_Name, mealsByCategoryName.strMeal)
                intent.putExtra(MEAL_THUMB, mealsByCategoryName.strMealThumb)
                startActivity(intent)
            }

        })
    }

    private fun prepareRecyclerView() {
        mealAdapter = MealAdapter()
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext,2)
            adapter = mealAdapter
        }
    }
}