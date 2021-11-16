package com.cjmobileapps.foodmenuandroid.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

data class Menu(
    val menuId: Int,
    val meals: List<Meal>
)

@Parcelize
data class Meal(
    val id: Int,
    val title: String,
    val subtitle: String,
    val story: String?,
    val ingredients: String,
    val image: Image
) : Parcelable

@Parcelize
data class Image(
    val hash: String?,
    val mealid: Int,
    val uploaded: Date?,
    private val url: String,
    private val filename: String?
) : Parcelable {
    val fullUrl
        get() = "https:${url}"
}
