package com.cjmobileapps.foodmenuandroid.data

import com.cjmobileapps.foodmenuandroid.data.model.Image
import com.cjmobileapps.foodmenuandroid.data.model.Meal
import com.cjmobileapps.foodmenuandroid.data.model.Menu
import java.text.SimpleDateFormat
import java.util.*

object FakeData {

    val menu = Menu(
        menuId = 1,
        meals = meals()
    )

    fun meals() = listOf(
        Meal(
            id = 2943,
            title = "Garlic Tamari Panko-Crusted Chicken",
            subtitle = "with Cauliflower Fried Rice",
            story = "Chef Chrissy is partial to Japanese and Korean fried chicken and the incredible sauces that flavor them. This week, she’s serving a rich and outstandingly crispy chicken breast that gets a glorious umami boost from garlic tamari sauce. Enjoy it with cauliflower fried rice to round out your plate and some extra soy sauce (obviously). ",
            ingredients = "chicken breast, cauliflower, peas, carrots, red bell peppers, scallions, neutral marinade, mayonnaise, soy sauce, panko bread crumbs, mirin, tamari, light brown sugar, cornstarch, garlic, olive oil, garlic powder, onion powder, ground ginger",
            image = Image(
                hash = null,
                mealid = 2943,
                uploaded = formatDate("2021-09-22T18:53:02.6291Z"),
                filename = "Garlic-Tamari-Panko-Crusted-Chicken_CELL_TILE.jpg",
                url = "//cdn.tovala.com/mealmedia/86e28481cf9bff9d05445e820c088d0251961e8b9e735c448c5cac6de09fff68-Garlic-Tamari-Panko-Crusted-Chicken_CELL_TILE.jpg"
            )
        ),
        Meal(
            id = 2933,
            title = "Bánh-Mì-Inspired Pork Meatballs",
            subtitle = "with Arugula Salad, Pickled Carrots & Cilantro Lime Dressing",
            ingredients = "ground pork, carrots, arugula, eggs, mayonnaise, hoisin, rice wine vinegar, yellow on ingredients :ions, sriracha, panko bread crumbs, sambal, tamari, cilantro, granulated sugar, pure sesame oil, mint, chinese five spice powder, black pepper, garlic powder, onion powder, kosher salt, crushed red pepper flakes",
            image = Image(
                hash = "039078c5d860b1d5fe7bea5d1935684f50f82782185eb80be1db618f10baee33",
                mealid = 2933,
                url = "//cdn.tovala.com/mealmedia/039078c5d860b1d5fe7bea5d1935684f50f82782185eb80be1db618f10baee33-Banh-Mi-Inspired-Meatballs_CELL_TILE.jpg",
                uploaded = null,
                filename = null
            ),
            story = null
        ),
        Meal(
            id = 2940,
            title = "Chicken Parmesan",
            subtitle = "with Cheesy Stuffed Shells in Marinara",
            ingredients = "chicken breast, stuffed shells (ricotta cheese, semolina flour enriched, mozzarella cheese, parmesan cheese, eggs, romano cheese, salt, modified food starch, xanthan gum, guar gum, locust bean gum, black pepper, parsley), marinara sauce (vine-ripened fresh tomatoes, extra virgin olive oil, sunflower oil, salt, onions, sugar, black pepper, basil, oregano, parsley, naturally derived citric acid), italian cheese blend (low-moisture mozzarella cheese, low-moisture part-skim mozzarella cheese, provolone cheese, parmesan cheese, romano cheese), garlic, neutral marinade, white balsamic vinegar, parsley, grape-seed oil, capers, kosher salt, crushed red pepper flakes",
            image = Image(
                hash = "3b7578a929329a47309f47ea7641260f43cb75af6ece166e4e70f275589306e6",
                mealid = 2940,
                url= "//cdn.tovala.com/mealmedia/3b7578a929329a47309f47ea7641260f43cb75af6ece166e4e70f275589306e6-Chicken-Parmesan_CELL_TILE.jpg",
                filename = null,
                uploaded = null
            ),
            story = null
        )
    )

    private fun formatDate(dateText: String): Date {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
        return formatter.parse(dateText)
    }
}
