package com.zomato.sushi.compose.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.zomato.sushi.compose.internal.SushiPreview
import com.zomato.sushi.compose.sample.screen.MainActivityContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainActivityContent()
        }
    }
}

@Composable
@SushiPreview
private fun MainActivityPreview() {
    MainActivityContent()
}