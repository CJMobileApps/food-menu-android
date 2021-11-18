package com.cjmobileapps.foodmenuandroid.testutil

import kotlinx.coroutines.Dispatchers

object CoroutineDispatchersImpl : CoroutineDispatchers {
    override val io = Dispatchers.IO

    //val computation = Schedulers.computation().asCoroutineDispatcher() //TODO make a computation dispatcher
    override val main = Dispatchers.Main
}
