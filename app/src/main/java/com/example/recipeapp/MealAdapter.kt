package com.example.recipeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeapp.databinding.RecipeLayoutBinding

class MealAdapter : RecyclerView.Adapter<MealAdapter.ViewHolder>() {

    private var listOfMeals = ArrayList<Meal>()
    private lateinit var setOnMealClickListener : SetOnMealClickListener
    fun setOnMealClickListener(setOnMealClickListener: SetOnMealClickListener){
        this.setOnMealClickListener = setOnMealClickListener
    }
    fun setMealData(listOfMeals : List<Meal>) {
        this.listOfMeals = listOfMeals as ArrayList<Meal>
        notifyDataSetChanged()
    }
    class ViewHolder(val binding: RecipeLayoutBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecipeLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        Glide.with(holder.itemView).load(listOfMeals[position].strMealThumb).into(holder.binding.recipeImage)
        holder.binding.recipeName.text= listOfMeals[position].strMeal
    }

    override fun getItemCount(): Int {
        return listOfMeals.size
    }
    interface SetOnMealClickListener {
        fun setOnClickListener(mealsByCategoryName: MealsByCategoryName)
    }

}
