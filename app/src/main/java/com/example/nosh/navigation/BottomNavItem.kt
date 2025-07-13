package com.example.nosh.navigation

import androidx.annotation.DrawableRes
import com.example.nosh.R

sealed class BottomNavItem(val route: String, @DrawableRes val iconRes: Int, val label: String) {
    object Home : BottomNavItem("home", R.drawable.home, "Home")
    object MealPlanner : BottomNavItem("mealplanner", R.drawable.mealplanner, "Planner")
    object NoshNow : BottomNavItem("noshnow", R.drawable.nosh, "Nosh Now")
    object Pantry : BottomNavItem("pantry", R.drawable.pantry, "Pantry")
    object Profile : BottomNavItem("profile", R.drawable.profile, "Profile")
}

