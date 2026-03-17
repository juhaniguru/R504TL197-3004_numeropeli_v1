package com.example.r504tl197_3004_numeropeli_v1

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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

@Composable
fun NumberGuessScreen(modifier: Modifier = Modifier, state: NumberGuessState) {


    
}