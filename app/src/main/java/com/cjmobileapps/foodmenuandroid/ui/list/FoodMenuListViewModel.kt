package com.cjmobileapps.foodmenuandroid.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cjmobileapps.foodmenuandroid.data.FoodMenuService
import com.cjmobileapps.foodmenuandroid.data.model.Meal
import com.cjmobileapps.foodmenuandroid.testutil.CoroutineDispatchers
import com.cjmobileapps.foodmenuandroid.testutil.onError
import com.cjmobileapps.foodmenuandroid.testutil.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FoodMenuListViewModel @Inject constructor(
    private val foodMenuService: FoodMenuService,
    private val coroutineDispatchers: CoroutineDispatchers
) : ViewModel() {
    private val compositeJob = Job()
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Timber.tag(tag).e("coroutineExceptionHandler() error occurred: ${throwable.message}")
        showDefaultErrorMessageLiveData.value = true
        showDefaultErrorMessageLiveData.value = false
        mealsAreLoadingMutableLiveData.value = false
    }

    private val mealsMutableLiveData = MutableLiveData<List<Meal>>()
    val mealsLiveData = mealsMutableLiveData

    private val mealsAreLoadingMutableLiveData = MutableLiveData(false)
    val mealsAreLoading = mealsAreLoadingMutableLiveData

    private val showDefaultErrorMessageMutableLiveData = MutableLiveData<Boolean>()
    val showDefaultErrorMessageLiveData = showDefaultErrorMessageMutableLiveData

    private val tag = FoodMenuListViewModel::class.java.simpleName

    override fun onCleared() {
        super.onCleared()
        compositeJob.cancel()
    }

    init {
        getMenu()
    }

    private fun getMenu() {
        mealsAreLoadingMutableLiveData.value = true
        GlobalScope.launch(compositeJob + coroutineDispatchers.io + exceptionHandler) {
            val menuAsync = foodMenuService.getMenuAsync()
            menuAsync
                .await()
                .onSuccess { menu ->
                    withContext(coroutineDispatchers.main) {
                        mealsMutableLiveData.value = menu.meals
                        mealsAreLoadingMutableLiveData.value = false
                    }
                }
                .onError {
                    withContext(coroutineDispatchers.main) {
                        Timber.tag(tag).e("getMenu() error occurred")
                        showDefaultErrorMessageLiveData.value = true
                        showDefaultErrorMessageLiveData.value = false
                        mealsAreLoadingMutableLiveData.value = false
                    }
                }
        }
    }
}
