package com.example.r504tl197_3004_numeropeli_v1

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.r504tl197_3004_numeropeli_v1.ui.theme.R504TL1973004_numeropeli_v1Theme
import kotlin.random.Random

@Composable
fun NumberGuessScreenRoot(modifier: Modifier = Modifier) {
    val state = remember {
        mutableStateOf(NumberGuessState())
    }
    // alussa arvotaan numero, kun peli käynnistetään
    // numero on 1-100
    if (state.value.correctNumber == 0) {
        state.value = state.value.copy(correctNumber = Random.nextInt(1, 101))
    }

    NumberGuessScreen(state = state.value)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberGuessScreen(modifier: Modifier = Modifier, state: NumberGuessState) {

    Scaffold(topBar = {
        TopAppBar(title = {
            Text("Numeropeli")
        })
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                TextField(value = state.number, onValueChange = { newText ->
                    Log.d("juhanitestaa", newText)
                })

                Button(onClick = {}) {
                    Text("Arvaa")
                }

                Text(state.guessText)

                Button(onClick = {}) {
                    Text("Uusi peli")
                }

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun NumberGuessScreenPreview() {
    R504TL1973004_numeropeli_v1Theme {
        NumberGuessScreen(state = NumberGuessState())
    }
}