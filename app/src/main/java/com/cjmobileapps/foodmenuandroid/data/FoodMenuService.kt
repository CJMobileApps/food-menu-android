package com.cjmobileapps.foodmenuandroid.data

import com.cjmobileapps.foodmenuandroid.network.FoodMenuApi

class FoodMenuService(private val foodMenuApi: FoodMenuApi) {

    fun getMenuAsync() = foodMenuApi.getMenuAsync()
}
