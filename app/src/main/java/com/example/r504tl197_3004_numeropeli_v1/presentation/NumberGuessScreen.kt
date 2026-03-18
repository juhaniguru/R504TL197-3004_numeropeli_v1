package com.example.r504tl197_3004_numeropeli_v1.presentation

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.r504tl197_3004_numeropeli_v1.ui.theme.R504TL1973004_numeropeli_v1Theme


@Composable
fun NumberGuessScreenRoot(modifier: Modifier = Modifier) {


    val vm = viewModel<NumberGuessGameViewModel>()
    val state by vm.state.collectAsStateWithLifecycle()


    NumberGuessScreen(state = state, updateText = { newText ->

        vm.updateText(newText)
    }, onGuess = {
        vm.onGuess()
    }, onNewGame = {
        vm.newGame()
    })


}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberGuessScreen(
    modifier: Modifier = Modifier,
    state: NumberGuessState,
    updateText: (String) -> Unit,
    onGuess: () -> Unit,
    onNewGame: () -> Unit
) {

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

                    updateText(newText)
                })

                Button(onClick = {
                    onGuess()
                }) {
                    Text("Arvaa")
                }

                Text(state.guessText)

                Button(onClick = {
                    onNewGame()
                }) {
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
        NumberGuessScreen(state = NumberGuessState(), updateText = {}, onGuess = {}, onNewGame = {})
    }
}