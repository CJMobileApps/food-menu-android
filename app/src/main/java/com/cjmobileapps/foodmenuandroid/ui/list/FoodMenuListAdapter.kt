package com.cjmobileapps.foodmenuandroid.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.cjmobileapps.foodmenuandroid.data.model.Meal
import com.cjmobileapps.foodmenuandroid.databinding.ItemMealBinding
import com.squareup.picasso.Picasso

class FoodMenuListAdapter(var meals: List<Meal> = emptyList()) :
    RecyclerView.Adapter<FoodMenuListAdapter.FoodMenuListHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodMenuListHolder {
        val itemBinding =
            ItemMealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodMenuListHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FoodMenuListHolder, position: Int) {
        holder.bind(meals[position])
    }

    override fun getItemCount() = meals.size

    inner class FoodMenuListHolder(private val itemBinding: ItemMealBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(meal: Meal) {
            itemBinding.mealTitle.text = meal.title

            Picasso.get()
                .load(meal.image.fullUrl)
                .into(itemBinding.mealImage)

            itemBinding.root.setOnClickListener { view ->
                val action = FoodMenuListFragmentDirections.actionFoodMenuListToFoodMenuDetail(meal)
                view.findNavController().navigate(action)
            }
        }
    }
}
