package com.patriciafiona.mycomposetesting.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import com.patriciafiona.mycomposetesting.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patriciafiona.mycomposetesting.ui.theme.MyComposeTestingTheme

@Composable
fun CalculatorApp(
    modifier: Modifier = Modifier
) {
    var lengthInput by remember { mutableStateOf("") }
    var widthInput by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    val length = lengthInput.toDoubleOrNull() ?: 0.0
    val width = widthInput.toDoubleOrNull() ?: 0.0

    Box(
        modifier = modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            TextField(
                value = lengthInput,
                onValueChange = { lengthInput = it },
                label = { Text(stringResource(R.string.enter_length)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            Spacer(modifier.height(8.dp))
            TextField(
                value = widthInput,
                onValueChange = { widthInput = it },
                label = { Text(stringResource(R.string.enter_width)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            Button(onClick = { result = (length * width).toString() }) {
                Text(stringResource(R.string.count))
            }
            Text(
                text = stringResource(R.string.result, result),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTestingTheme {
        CalculatorApp()
    }
}