package com.example.unscramble.ui

import androidx.lifecycle.ViewModel
import com.example.unscramble.data.Words
import com.example.unscramble.ui.screens.components.shuffleString

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<GameUiState> = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private lateinit var currentWord: String

    var totalscore = 0

    init {
        resetGame()
    }

    private fun getWord(): String {
        val words = Words.allWords
        currentWord = words.random()
        _uiState.value = _uiState.value.copy(currentScrambleWord = currentWord )
        words.minus(currentWord)
        return currentWord.shuffleString()
    }

    private fun resetGame() {
        _uiState.value = _uiState.value.copy(currentScrambleWord = "")
        getWord()
    }

    private fun calculateScore(): Int {
        val wordSize = Words.allWords.size
        val currentScore = _uiState.value.currentScore
        return (currentScore / wordSize) * 100
    }
}