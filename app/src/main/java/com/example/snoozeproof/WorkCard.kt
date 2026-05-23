package com.example.snoozeproof

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
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
fun WorkCard() {
    Surface(
        shape = RoundedCornerShape(24.dp),
        color = Color(0xFFFFD1DC),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Platform name",
                fontSize = 14.sp,
                color = Color(0xFF4A4A4A).copy(alpha = 0.7f),
                fontWeight = FontWeight.Medium
            )

            Text(
                text = "Bookmark name",
                fontSize = 20.sp,
                color = Color(0xFF4A4A4A),
                fontWeight = FontWeight.Bold
            )

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFFFFB7C5),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .wrapContentSize()
                    .align(Alignment.End)
            ) {
                Text(
                    text = "Time required",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorkCardPreview() {
    WorkCard()
}