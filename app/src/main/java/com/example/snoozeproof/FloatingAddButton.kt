package com.example.snoozeproof

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FloatingAddButton(onButtonClick: () -> Unit){
    FloatingActionButton(
        onClick = {
            onButtonClick()
        },
        modifier = Modifier.wrapContentSize(),
        elevation = FloatingActionButtonDefaults.elevation()

    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Item",
        )
    }
}

@Preview
@Composable
fun FloatingAddButtonPreview(){
    FloatingAddButton({})
}