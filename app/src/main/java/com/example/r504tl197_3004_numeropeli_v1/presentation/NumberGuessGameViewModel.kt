package com.example.r504tl197_3004_numeropeli_v1.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.lang.Exception
import kotlin.random.Random

class NumberGuessGameViewModel : ViewModel() {



    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()

    init {
        newGame()

    }



    fun updateText(newText: String) {
        _state.update { currentState -> currentState.copy(number = newText) }
    }

    fun newGame() {
        _state.update { currentState ->
            currentState.copy(
                guessText = "",
                correct = false,
                number = "",
                timesGuessed = 0,
                correctNumber = Random.nextInt(1, 101)
            )
        }
    }

        fun onGuess() {
            try {
                val numberInt = state.value.number.toInt()
                if (numberInt == state.value.correctNumber) {
                    _state.update { currentState ->
                        currentState.copy(
                            correct = true,
                            guessText = "Arvasit oikein, siihen meni ${state.value.timesGuessed + 1} kertaa"
                        )
                    }
                } else {
                    var text = "Arvasit väärin"
                    if (numberInt > state.value.correctNumber) {
                        text += ", arvauksesi on liian suuri"
                    } else {
                        text += ", arvauksesi on liian pieni"
                    }

                    _state.update { currentState ->
                        currentState.copy(guessText = text, correct = false)
                    }

                }

                _state.update { currentState ->
                    currentState.copy(timesGuessed = state.value.timesGuessed + 1)
                }

            } catch (e: Exception) {

            }
        }
    }