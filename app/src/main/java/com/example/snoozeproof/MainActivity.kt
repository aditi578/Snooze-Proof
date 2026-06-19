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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            MainScreen(onNavigateToAddScreen = {
                                navController.navigate("add")
                            })
                        }
                        composable("add") {
                            AddBookmarkScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(onNavigateToAddScreen: () -> Unit) {
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
            ListOfBookMarks()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnoozeProofTheme {
        MainScreen(onNavigateToAddScreen = {})
    }
}