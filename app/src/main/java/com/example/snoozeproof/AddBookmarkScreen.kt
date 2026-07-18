package com.example.snoozeproof

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import kotlin.math.roundToInt

@Composable
fun AddBookmarkScreen(onSaveClick: (String, String, String, String, String) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFFFF9F9)
    ) {
        AddBookmarkScreenContent(onSaveClick)
    }
}

@Composable
fun AddBookmarkScreenContent(onSaveClick: (String, String, String, String, String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        var urlInput by remember { mutableStateOf("") }
        var titleInput by remember { mutableStateOf("") }
        var locationInput by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        var selectedPlatform by remember { mutableStateOf("Select Platform") }
        val platforms = listOf("Youtube", "Instagram", "Chrome", "Medium", "Twitter", "GitHub", "Other")

        var sliderPosition by remember { mutableFloatStateOf(0f) }
        val timeLabels = listOf("5 mins", "10 mins", "30 mins", "45 mins", "60+ mins")
        val focusManager = LocalFocusManager.current

        Text(
            text = "Add Bookmark",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = Color(0xFF9C27B0),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = "URL (Link)",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF4A4A4A),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = urlInput,
            onValueChange = { newValue -> urlInput = newValue },
            placeholder = {
                Text(
                    text = "Paste your bookmark URL here...",
                    color = Color.Gray.copy(alpha = 0.6f)
                )
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF8079BE),
                unfocusedBorderColor = Color(0xFFFFD1DC)
            )
        )

        Text(
            text = "Title",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF4A4A4A),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = titleInput,
            onValueChange = { newValue -> titleInput = newValue },
            placeholder = {
                Text(
                    text = "Add title for your Bookmark",
                    color = Color.Gray.copy(alpha = 0.6f)
                )
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF8079BE),
                unfocusedBorderColor = Color(0xFFFFD1DC)
            )
        )

        Text(
            text = "Choose Platform",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF4A4A4A),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Surface(
                onClick = { expanded = true },
                shape = RoundedCornerShape(12.dp),
                color = Color(0xFFFFF0F2),
                border = BorderStroke(1.dp, Color(0xFFFFD1DC)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = selectedPlatform, color = Color(0xFF4A4A4A))
                    Text(text = "▼", color = Color(0xFF8079BE))
                }
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                platforms.forEach { platformName ->
                    DropdownMenuItem(
                        text = { Text(text = platformName) },
                        onClick = {
                            selectedPlatform = platformName
                            expanded = false
                        }
                    )
                }
            }
        }

        Text(
            text = "Time Commitment",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF4A4A4A),
            modifier = Modifier.padding(top = 8.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            val currentIndex = sliderPosition.roundToInt()
            Text(
                text = timeLabels[currentIndex],
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9C27B0)
            )

            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 0f..4f,
                steps = 3,
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFF8079BE),
                    activeTrackColor = Color(0xFF8079BE),
                    inactiveTrackColor = Color(0xFFFFD1DC)
                )
            )
        }

        Text(
            text = "Trigger Location",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF4A4A4A),
            modifier = Modifier.padding(top = 8.dp)
        )

        OutlinedTextField(
            value = locationInput,
            onValueChange = { newValue -> locationInput = newValue },
            placeholder = {
                Text(
                    text = "e.g., Home, Office, Gym...",
                    color = Color.Gray.copy(alpha = 0.6f)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location Icon",
                    tint = Color(0xFF8079BE)
                )
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF8079BE),
                unfocusedBorderColor = Color(0xFFFFD1DC)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                focusManager.clearFocus()
                val cleanUrl = urlInput.trim()

                val finalUrl = if (cleanUrl.startsWith("https://") || cleanUrl.startsWith("http://")) {
                    cleanUrl
                } else {
                    "https://$cleanUrl"
                }
                val currentIndex = sliderPosition.roundToInt()
                val chosenTime = timeLabels[currentIndex]
                onSaveClick(
                    finalUrl,
                    titleInput,
                    selectedPlatform,
                    chosenTime,
                    locationInput
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF9C27B0),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Add to Vault",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview
fun AddBookmarkScreenPreview() {
    AddBookmarkScreen(onSaveClick = { _, _, _, _, _ -> })
}