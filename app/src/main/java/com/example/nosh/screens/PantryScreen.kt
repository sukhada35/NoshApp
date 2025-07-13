package com.example.nosh.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nosh.R
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nosh.viewmodel.PantryViewModel

@Composable
fun PantryScreen(viewModel: PantryViewModel = viewModel()) {
    val selectedCategory by viewModel.selectedCategory
    val items = viewModel.pantryItems.value[selectedCategory] ?: emptyList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Pantry", style = MaterialTheme.typography.titleLarge, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth().border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            listOf("Fruits", "Vegetables", "Additives", "Dairy").forEach { category ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(
                                if (selectedCategory == category) Color(0xFFCCFF00) else Color.LightGray,
                                shape = RoundedCornerShape(6.dp)
                            )
                            .padding(10.dp)
                            .clickable { viewModel.selectCategory(category) },
                        contentAlignment = Alignment.Center
                    ) {
                        val iconRes = when (category) {
                            "Fruits" -> R.drawable.snack
                            "Vegetables" -> R.drawable.appetizer
                            "Additives" -> R.drawable.salt
                            "Dairy" -> R.drawable.drinks
                            else -> R.drawable.snack
                        }

                        Image(
                            painter = painterResource(iconRes),
                            contentDescription = category,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Text(category, color = Color.Gray, style = MaterialTheme.typography.bodySmall)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        items.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(item.name, modifier = Modifier.weight(1f))
                Row {
                    Icon(
                        painterResource(id = R.drawable.minus),
                        contentDescription = "Decrease",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { viewModel.decrease(item.name) }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(item.quantity.toString())
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painterResource(id = R.drawable.add),
                        contentDescription = "Increase",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { viewModel.increase(item.name) }
                    )
                }
            }
        }
    }
}


