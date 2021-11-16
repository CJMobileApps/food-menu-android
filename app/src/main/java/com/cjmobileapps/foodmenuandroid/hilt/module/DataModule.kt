package com.cjmobileapps.foodmenuandroid.hilt.module

import com.cjmobileapps.foodmenuandroid.data.FoodMenuService
import com.cjmobileapps.foodmenuandroid.network.FoodMenuApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Singleton
    @Provides
    fun foodMenuService(
        foodMenuApi: FoodMenuApi
    ) : FoodMenuService {
        return FoodMenuService(foodMenuApi)
    }
}
