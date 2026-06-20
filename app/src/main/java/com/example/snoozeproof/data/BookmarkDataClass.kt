package com.example.snoozeproof.data

import android.location.Location
import androidx.compose.ui.text.LinkAnnotation

data class BookmarkDataClass(
    val bookmarkName: String,
    val platformName: String,
    val timeRequired: String,
    val url: String,
    val location: String
)