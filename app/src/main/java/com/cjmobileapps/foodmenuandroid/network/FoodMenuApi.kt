package com.cjmobileapps.foodmenuandroid.network

import com.cjmobileapps.foodmenuandroid.data.model.Menu
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface FoodMenuApi {

    @GET("mapp/tovala_demo_menu.json")
    fun getMenuAsync(): Deferred<Response<Menu>>
}
