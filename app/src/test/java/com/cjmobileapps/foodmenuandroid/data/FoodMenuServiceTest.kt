package com.cjmobileapps.foodmenuandroid.data

import com.cjmobileapps.foodmenuandroid.BaseTest
import com.cjmobileapps.foodmenuandroid.network.FoodMenuApi
import kotlinx.coroutines.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import retrofit2.Response

class FoodMenuServiceTest : BaseTest() {

    @Mock
    lateinit var mockFoodMenuApi: FoodMenuApi

    private lateinit var service: FoodMenuService

    private val mockMenu = FakeData.menu


    @Before
    fun setup() {
        service = FoodMenuService(
            foodMenuApi = mockFoodMenuApi
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getMenu_whenGetMenuCalled() {

        // given
        val responseBuilder = Response.success(mockMenu)

        // when
        Mockito.`when`(mockFoodMenuApi.getMenuAsync())
            .thenReturn(CompletableDeferred(responseBuilder))

        // then
        val results = service.getMenuAsync()

        // verify
        Assert.assertEquals(
            responseBuilder,
            results.getCompleted()
        )
    }
}
