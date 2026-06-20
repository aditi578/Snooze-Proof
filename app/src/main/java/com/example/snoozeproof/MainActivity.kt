package com.example.snoozeproof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snoozeproof.data.BookmarkDataClass
import com.example.snoozeproof.ui.theme.ListOfBookMarks
import com.example.snoozeproof.ui.theme.SnoozeProofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnoozeProofTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFF9F9)
                ) {
                    val navController = rememberNavController()
                    val masterBookmarkList = remember { mutableStateListOf<BookmarkDataClass>() }

                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            MainScreen(
                                bookmarks = masterBookmarkList,
                                onNavigateToAddScreen = {
                                    navController.navigate("add")
                                }
                            )
                        }
                        composable("add") {
                            AddBookmarkScreen(
                                onSaveClick = { url, title, platform, time, location ->
                                    masterBookmarkList.add(
                                        BookmarkDataClass(
                                            bookmarkName = title,
                                            platformName = platform,
                                            timeRequired = time,
                                            url = url,
                                            location = location
                                        )
                                    )
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    bookmarks: List<BookmarkDataClass>,
    onNavigateToAddScreen: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingAddButton(onButtonClick = onNavigateToAddScreen)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Header()
            FilterSection()
            ListOfBookMarks(bookmarks = bookmarks)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnoozeProofTheme {
        MainScreen(
            bookmarks = listOf(),
            onNavigateToAddScreen = {}
        )
    }
}