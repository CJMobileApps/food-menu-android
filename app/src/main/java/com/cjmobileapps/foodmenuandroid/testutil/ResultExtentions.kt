package com.cjmobileapps.foodmenuandroid.testutil

import retrofit2.Response

inline fun <T : Any> Response<T>.onSuccess(action: (T) -> Unit): Response<T> {
    val body = this.body()
    if (this.isSuccessful && body != null) action(body)
    return this
}

inline fun <T : Any> Response<T>.onError(action: (Boolean) -> Unit): Response<T> {
    val errorBody = this.errorBody()
    if (!this.isSuccessful && errorBody != null) {
        action(true)
    }
    return this
}

//TODO if the backend gave a better error message
//data class ErrorResponse(
//    val code: Int,
//    val message: String
//)

