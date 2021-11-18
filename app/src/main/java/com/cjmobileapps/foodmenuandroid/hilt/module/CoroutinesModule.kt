package com.cjmobileapps.foodmenuandroid.hilt.module

import com.cjmobileapps.foodmenuandroid.testutil.CoroutineDispatchers
import com.cjmobileapps.foodmenuandroid.testutil.CoroutineDispatchersImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoroutinesModule {

    @Singleton
    @Provides
    fun coroutinesDispatchers() : CoroutineDispatchers {
        return CoroutineDispatchersImpl
    }
}
