package com.example.snoozeproof.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.snoozeproof.WorkCard
import com.example.snoozeproof.data.BookmarkDataClass

@Composable
fun ListOfBookMarks(bookmarks: List<BookmarkDataClass>) {
    LazyColumn {
        items(bookmarks) { singleBookmark ->
            WorkCard(bookmark = singleBookmark)
        }
    }
}

@Preview
@Composable
fun ListOfBookMarksPreview() {
    ListOfBookMarks(bookmarks = listOf())
}