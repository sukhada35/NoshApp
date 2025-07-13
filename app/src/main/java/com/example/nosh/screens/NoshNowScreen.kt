package com.example.nosh.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.nosh.R
import com.example.nosh.viewmodel.PantryViewModel

@Composable
fun NoshNowScreen(viewModel: PantryViewModel = viewModel()) {
    var selectedMealType by remember { mutableStateOf("Snack") }
    var portionSize by remember { mutableStateOf(2) }
    var timeToCook by remember { mutableStateOf(15f) }
    var selectedDifficulty by remember { mutableStateOf("Beginner") }

    val mealTypes = listOf("Snack", "Drinks", "Appetizer", "Full Meal")
    val difficulties = listOf("Beginner", "Novice", "Intermediate", "Professional")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("Nosh Now", style = MaterialTheme.typography.titleLarge)
                    Text("Cook up something tasty!", color = Color.Gray)
                }
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = "Filter",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(30.dp)
                            .border(1.dp, Color.LightGray, shape = CircleShape)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
// ignore this is for future
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(mealTypes) { meal ->
                    Box(
                        modifier = Modifier
                            .background(
                                if (meal == selectedMealType) Color(0xFFCCFF00) else Color.LightGray,
                                RoundedCornerShape(10.dp)
                            )
                            .padding(12.dp)
                            .clickable { selectedMealType = meal }
                    ) {
                        Text(meal)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text("Portion Size", style = MaterialTheme.typography.titleMedium)
            Text("Select the number of people to cook for")
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.minus),
                        contentDescription = "Decrease",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { if (portionSize > 1) portionSize-- }
                    )
                    Text(portionSize.toString(), style = MaterialTheme.typography.bodyLarge)
                    Icon(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = "Increase",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { portionSize++ }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text("Time to Cook", style = MaterialTheme.typography.titleMedium)
            Text("Select the amount of preparation time")
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                Column {
                    Slider(
                        value = timeToCook,
                        onValueChange = { timeToCook = it },
                        valueRange = 5f..30f,
                        steps = 5
                    )
                    Text("${timeToCook.toInt()} mins")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text("Difficulty", style = MaterialTheme.typography.titleMedium)
            Text("How hard it is to prepare the dish")
            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(difficulties) { level ->
                    Box(
                        modifier = Modifier
                            .background(
                                if (level == selectedDifficulty) Color(0xFFCCFF00) else Color.LightGray,
                                RoundedCornerShape(10.dp)
                            )
                            .clickable { selectedDifficulty = level }
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                    ) {
                        Text(level, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }


            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCCFF00))
            ) {
                Text("Save", style = MaterialTheme.typography.titleMedium, color = Color.Black)
            }
        }
    }
}

