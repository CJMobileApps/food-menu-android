package com.cjmobileapps.foodmenuandroid.hilt.module

import com.cjmobileapps.foodmenuandroid.util.RxDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoroutineModule {

    @Singleton
    @Provides
    fun rxDispatcher(): RxDispatchers {
        return RxDispatchers
    }
}
