@file:Suppress("UNUSED_EXPRESSION")

package com.example.nosh.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nosh.R
import androidx.navigation.NavController


@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        GreetingCard()

        Spacer(modifier = Modifier.height(16.dp))

        ChefNosh()

        Spacer(modifier = Modifier.height(16.dp))

        QuickBites(navController)

        Spacer(modifier = Modifier.height(24.dp))

        Feature(navController)

        Spacer(modifier = Modifier.height(24.dp))

        UpcomingMeals()

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun ChefNosh() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = "Cook Now",
                modifier = Modifier
                    .size(100.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Column(

            ) {
                Text("Chef Nosh", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    "Not sure what to cook?",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
                Text(
                    "Ask your personal chef!",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(3.dp))
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCCFF00)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Ask Chef ", color = Color.Black)
                    Icon(Icons.Default.ArrowForward, contentDescription = "Arrow Forward", tint = Color.Black)
                }
            }
        }
    }
}

@Composable
fun GreetingCard() {
    //var showSearch by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profilepic),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Good Morning! User",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "How's it going today?",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Search",
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun Feature(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { navController.navigate("recipe") },
            modifier = Modifier
                .weight(1f)
                .height(60.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCCFF00))
        ) {
            Image(
                painter = painterResource(id = R.drawable.recipe),
                contentDescription = "Custom Icon",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(text = "Recipes", color = Color.Black)
        }
        Spacer(modifier = Modifier.padding(6.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .weight(1f)
                .height(60.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCCFF00))
        ) {
            Image(
                painter = painterResource(id = R.drawable.aichef),
                contentDescription = "Custom Icon 2",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(text = "Random", color = Color.Black)
        }
    }
}

@Composable
fun QuickBites(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Quick Bites",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Whip up something delicious",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(horizontal = 12.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            QuickBiteButton(
                color = Color(0xFFFFD966),
                imageRes = R.drawable.snack,
                label = "Snacks",
                onClick = { navController.navigate("dessert") }
            )
            QuickBiteButton(
                color = Color(0xFF4FC3F7),
                imageRes = R.drawable.drinks,
                label = "Drinks",
                onClick = { navController.navigate("drinks") }
            )
            QuickBiteButton(
                color = Color(0xFF7A72FF),
                imageRes = R.drawable.appetizer,
                label = "Appetizer",
                onClick = { navController.navigate("appetizer") }
            )
            QuickBiteButton(
                color = Color(0xFF66BB6A),
                imageRes = R.drawable.fullmeal,
                label = "Full Meal",
                onClick = { navController.navigate("fullmeal") }
            )
        }
    }
}

@Composable
fun QuickBiteButton(
    color: Color,
    imageRes: Int,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.width(72.dp) // Ensures even width for each item
    ) {
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = color),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.size(60.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = label,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = label,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1
        )
    }
}

@Composable
fun UpcomingMeals() {
    Column {
        Text(text = "Upcoming Meals", style = MaterialTheme.typography.titleLarge)
        Text(
            text = "Here are upcoming meals / No upcoming schedule one",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                MealCard("Pancakes")
            }
            item {
                MealCard("Cookie")
            }
        }
    }
}

@Composable
fun MealCard(name: String) {
    Box(
        modifier = Modifier
            .width(320.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profilepic),
                contentDescription = "Meal Image",
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(text = name, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Breakfast\n330 Kcal\nMaterials: available\nCook at 3:30",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Spacer(
                    modifier = Modifier
                        .height(6.dp)
                        .width(3.dp)
                )
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCCFF00)),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Text(text = "Cook", color = Color.Black)
                }
            }
        }
    }
}