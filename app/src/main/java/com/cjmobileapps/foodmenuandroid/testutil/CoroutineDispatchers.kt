package com.cjmobileapps.foodmenuandroid.testutil

import kotlin.coroutines.CoroutineContext

interface CoroutineDispatchers {
    val io: CoroutineContext

    //val computation = Schedulers.computation().asCoroutineDispatcher() //TODO make a computation dispatcher
    val main: CoroutineContext
}
