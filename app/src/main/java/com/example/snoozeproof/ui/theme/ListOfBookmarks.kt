package com.example.snoozeproof.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.snoozeproof.WorkCard

@Composable
fun ListOfBookMarks() {
    LazyColumn() {
        items(count = 7) {
            WorkCard()
        }
    }
}

@Preview
@Composable
fun ListOfBookMarksPreview(){
    ListOfBookMarks()
}