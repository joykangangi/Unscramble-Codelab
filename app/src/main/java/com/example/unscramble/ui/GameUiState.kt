package com.example.unscramble.ui

data class GameUiState(
    val currentScrambleWord: String = "",
    val wordCount: Int = 0,
    val currentScore: Int = 0,
    val answer: String = "",
    val isEnabled: Boolean = false,
    val isGameOver: Boolean = false
    //val letterColor: Color = Color.DarkGray
)