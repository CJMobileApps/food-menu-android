package com.cjmobileapps.foodmenuandroid.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cjmobileapps.foodmenuandroid.data.FakeData
import com.cjmobileapps.foodmenuandroid.data.FoodMenuService
import com.cjmobileapps.foodmenuandroid.ui.list.FoodMenuListViewModel
import com.cjmobileapps.foodmenuandroid.testutil.BaseTest
import com.cjmobileapps.foodmenuandroid.testutil.TestCoroutineDispatchers
import com.cjmobileapps.foodmenuandroid.testutil.TestCoroutineRule
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.CompletableDeferred
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import retrofit2.Response

class FoodMenuListViewModelTest : BaseTest() {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    lateinit var foodMenuListViewModel: FoodMenuListViewModel

    @Mock
    lateinit var foodMenuService: FoodMenuService

    private val mockMenu = FakeData.menu

    private fun setupViewModel() {
        foodMenuListViewModel = FoodMenuListViewModel(
            foodMenuService = foodMenuService,
            coroutineDispatchers = TestCoroutineDispatchers
        )
    }

    @Test
    fun `get meals successfully`() {

        // given when
        val responseBuilder = Response.success(mockMenu)

        Mockito.`when`(foodMenuService.getMenuAsync()).thenReturn(CompletableDeferred(responseBuilder))

        setupViewModel()

        // verify
        assertEquals(
            mockMenu.meals,
            foodMenuListViewModel.mealsLiveData.value
        )
        assertEquals(
            false,
            foodMenuListViewModel.mealsAreLoading.value
        )
        assertEquals(
            null,
            foodMenuListViewModel.showDefaultErrorMessageLiveData.value
        )
    }

    @Test
    fun `get meals throws exception`() {

        // given when
        Mockito.`when`(foodMenuService.getMenuAsync()).thenThrow(RuntimeException("Random Error occurred"))

        setupViewModel()

        // verify
        assertEquals(
            null,
            foodMenuListViewModel.mealsLiveData.value
        )
        assertEquals(
            false,
            foodMenuListViewModel.mealsAreLoading.value
        )
        assertEquals(
            false,
            foodMenuListViewModel.showDefaultErrorMessageLiveData.value
        )
    }
}
