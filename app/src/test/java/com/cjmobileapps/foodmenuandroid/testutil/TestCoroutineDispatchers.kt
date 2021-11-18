package com.cjmobileapps.foodmenuandroid.testutil

import kotlinx.coroutines.Dispatchers

object TestCoroutineDispatchers : CoroutineDispatchers {
    override val io = Dispatchers.Unconfined

    //val computation = Schedulers.computation().asCoroutineDispatcher() //TODO make a computation dispatcher
    override val main = Dispatchers.Unconfined
}
