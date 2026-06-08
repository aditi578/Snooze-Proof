package com.example.snoozeproof

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun FilterSection() {
    val filtersList = listOf("All", "Work", "Exercise", "Fun")
    var selectedFilter by remember { mutableStateOf("All") }

    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Filters",
            color = Color(0xFF4A4A4A),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(count = filtersList.size) { index ->
                val isSelected = selectedFilter == filtersList[index]

                FilterChip(
                    selected = isSelected,
                    onClick = { selectedFilter = filtersList[index] },
                    label = {
                        Text(
                            text = filtersList[index],
                            color = if (isSelected) Color.White else Color(0xFF4A4A4A),
                            fontSize = 14.sp,
                            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                        )
                    },
                    shape = CircleShape,
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color(0xFFFFB7C5),
                        selectedLabelColor = Color.White,
                        containerColor = Color(0xFFFFF0F2),
                        labelColor = Color(0xFF4A4A4A)
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = isSelected,
                        borderColor = Color(0xFFFFD1DC),
                        selectedBorderColor = Color(0xFFFFB7C5),
                        borderWidth = 1.dp
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FiltersPreview() {
    FilterSection()
}