package com.cjmobileapps.foodmenuandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cjmobileapps.foodmenuandroid.databinding.ActivityFoodMenuBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodMenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityFoodMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFoodMenuBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
    }
}
