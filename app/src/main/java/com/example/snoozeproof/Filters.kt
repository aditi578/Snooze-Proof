package com.example.snoozeproof

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterSection() {
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

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = true,
                onClick = { },
                label = { Text("All", color = Color.White) },
                shape = CircleShape,
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFFFFB7C5),
                    containerColor = Color.Transparent,
                    selectedLabelColor = Color.White
                ),
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = true,
                    borderColor = Color(0xFFFFD1DC),
                    selectedBorderColor = Color(0xFFFFB7C5),
                    borderWidth = 1.dp
                )
            )

            FilterChip(
                selected = false,
                onClick = { },
                label = { Text("Work", color = Color(0xFF4A4A4A)) },
                shape = CircleShape,
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFFFFB7C5),
                    containerColor = Color(0xFFFFF1F3)
                ),
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = false,
                    borderColor = Color(0xFFFFD1DC),
                    borderWidth = 1.dp
                )
            )

            FilterChip(
                selected = true,
                onClick = { },
                label = { Text("Work", color = Color(0xFF4A4A4A)) },
                shape = CircleShape,
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFFFFB7C5),
                    containerColor = Color(0xFFFFF1F3)
                ),
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = false,
                    borderColor = Color(0xFFFFD1DC),
                    borderWidth = 1.dp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FiltersPreview() {
    FilterSection()
}