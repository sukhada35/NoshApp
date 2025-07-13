package com.example.nosh.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nosh.R
import com.example.nosh.viewmodel.MealPlannerViewModel

@Composable
fun MealPlannerScreen(viewModel: MealPlannerViewModel = viewModel()) {
    val selectedDay by viewModel.selectedDay
    val meals = viewModel.getMealsForDay(selectedDay)
    var addText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Meal Planner", style = MaterialTheme.typography.titleLarge)
        Text("Plan your meal for the week!", color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))
        DaySelector(viewModel)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Add your meals", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))

        meals.forEach { meal ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(meal)
                Icon(
                    painter = painterResource(id = R.drawable.trash),
                    contentDescription = "Delete",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            viewModel.removeMeal(selectedDay, meal)
                        }
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }


        Spacer(modifier = Modifier.weight(1f))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(16.dp))
                .border(1.dp, Color.LightGray)
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            TextField(
                value = addText,
                onValueChange = { addText = it },
                placeholder = { Text("Add an item") },
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.add),
                contentDescription = "Add",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        if (addText.isNotBlank()) {
                            viewModel.addMeal(selectedDay, addText.trim())
                            addText = ""
                        }
                    }
            )
        }
    }
}

@Composable
fun DaySelector(viewModel: MealPlannerViewModel) {
    val selectedDay by viewModel.selectedDay
    val days = listOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        days.forEach { day ->
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        if (selectedDay == day) Color(0xFFCCFF00) else Color.LightGray,
                        shape = CircleShape
                    )
                    .clickable { viewModel.selectDay(day) },
                contentAlignment = Alignment.Center
            ) {
                Text(day, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

