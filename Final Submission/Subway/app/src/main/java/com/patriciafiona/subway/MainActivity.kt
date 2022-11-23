package com.patriciafiona.subway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.patriciafiona.subway.ui.theme.SubwayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SubwayTheme {
                SubwayApp()
            }
        }
    }
}