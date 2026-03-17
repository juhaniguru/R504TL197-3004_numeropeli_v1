package com.example.r504tl197_3004_numeropeli_v1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.r504tl197_3004_numeropeli_v1.presentation.NumberGuessScreenRoot
import com.example.r504tl197_3004_numeropeli_v1.ui.theme.R504TL1973004_numeropeli_v1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            R504TL1973004_numeropeli_v1Theme {
                NumberGuessScreenRoot()
            }
        }
    }
}

