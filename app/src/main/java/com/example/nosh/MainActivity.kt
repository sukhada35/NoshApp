package com.example.nosh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.example.nosh.ui.theme.NoshTheme
import androidx.compose.material3.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nosh.navigation.BottomNavItem
import com.example.nosh.navigation.BottomNavigationBar
import com.example.nosh.screens.profilescreens.EditProfileScreen
import com.example.nosh.screens.HomeScreen
import com.example.nosh.screens.MealPlannerScreen
import com.example.nosh.screens.NoshNowScreen
import com.example.nosh.screens.OnboardingScreen
import com.example.nosh.screens.PantryScreen
import com.example.nosh.screens.profilescreens.ProfileScreen
import com.example.nosh.screens.RecipeScreen
import com.example.nosh.screens.profilescreens.AccessibilitySettings
import com.example.nosh.screens.profilescreens.Allergens
import com.example.nosh.screens.profilescreens.Appetizer
import com.example.nosh.screens.profilescreens.CustomerService
import com.example.nosh.screens.profilescreens.DietType
import com.example.nosh.screens.profilescreens.Drinks
import com.example.nosh.screens.profilescreens.FullMeal
import com.example.nosh.screens.profilescreens.PushNotification
import com.example.nosh.screens.quickbitescreens.SnacksScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoshTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController)
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "onboarding",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("onboarding") { OnboardingScreen(navController) }
                        composable(BottomNavItem.Home.route) { HomeScreen(navController) }
                        composable("recipe") { RecipeScreen(navController, viewModel()) }
                        composable(BottomNavItem.MealPlanner.route) { MealPlannerScreen() }
                        composable(BottomNavItem.NoshNow.route) { NoshNowScreen() }
                        composable(BottomNavItem.Pantry.route) { PantryScreen() }
                        composable(BottomNavItem.Profile.route) { ProfileScreen(navController) }
                        composable(route = "edit_profile") { EditProfileScreen(navController) }
                        composable("edit_details") { EditProfileScreen(navController) }
                        composable("accessibility") { AccessibilitySettings(navController) }
                        composable("diet_type") { DietType(navController) }
                        composable("allergens") { Allergens(navController) }
                        composable("notifications") { PushNotification(navController) }
                        composable("customer_service") { CustomerService(navController) }
                        composable("dessert") { SnacksScreen(viewModel(),navController) }
                        composable("drinks") { Drinks(navController) }
                        composable("appetizer") { Appetizer(navController) }
                        composable("fullmeal") { FullMeal(navController) }
                    }
                }
            }
        }

    }
}













