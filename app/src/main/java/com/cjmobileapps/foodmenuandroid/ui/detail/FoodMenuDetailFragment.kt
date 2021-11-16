package com.cjmobileapps.foodmenuandroid.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.cjmobileapps.foodmenuandroid.databinding.FragmentFoodMenuDetailBinding
import com.squareup.picasso.Picasso

class FoodMenuDetailFragment : Fragment() {

    private val args: FoodMenuDetailFragmentArgs by navArgs()

    private var binding: FragmentFoodMenuDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodMenuDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val meal = args.meal
        binding?.mealDetailTitle?.text = meal.title
        binding?.mealDetailIngredients?.text = meal.ingredients

        Picasso.get()
            .load(meal.image.fullUrl)
            .into(binding?.mealDetailImage)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
