package com.example.unscramble.ui

import androidx.lifecycle.ViewModel
import com.example.unscramble.data.Words
import com.example.unscramble.ui.screens.shuffleString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<GameUiState> = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private lateinit var currentWord: String
    private lateinit var correctAns: String

    private var score = _uiState.value.currentScore
    val wordSize = Words.allWords.size
    val percScore = (score / wordSize) * 100
    private val usedWords = mutableSetOf<String>()


    init {
        getWord()
        hasError()
        wordCount()
    }

    private fun getWord(): String {
        val words = Words.allWords
        currentWord = words.random()
        correctAns = currentWord
        _uiState.value = _uiState.value.copy(currentScrambleWord = currentWord.shuffleString())
        usedWords.add(currentWord)
        words.minus(currentWord)
        return currentWord.shuffleString()
    }

    private fun resetWord() {
        _uiState.value = _uiState.value.copy(currentScrambleWord = "", answer = "")
        getWord()
    }

    fun resetGame() {
        usedWords.removeAll(usedWords)
        resetWord()
    }


    //onNext Click
    fun checkAns() {
        if (_uiState.value.answer == correctAns) {
            _uiState.value = _uiState.value.copy(currentScore = _uiState.value.currentScore + 10)
        } else {
            _uiState.value = _uiState.value.copy(currentScore = _uiState.value.currentScore - 10)
        }
        resetWord()
        hasError()
        wordCount()
    }

    //onSkip Click
    fun onSkipClick() {
        //score = score -15
        _uiState.value = _uiState.value.copy(currentScore = _uiState.value.currentScore - 15)
        resetWord()
        hasError()
        wordCount()
    }

    private fun wordCount() {
        _uiState.value = _uiState.value.copy(wordCount = usedWords.size)
    }


    //short text
    private fun hasError() {
        val wordSize = _uiState.value.currentScrambleWord.length
        val answerSize = _uiState.value.answer.length

        if (answerSize != wordSize) {
            _uiState.value = _uiState.value.copy(isEnabled = false)
        } else {
            _uiState.value = _uiState.value.copy(isEnabled = true)
        }
        //Log.i("VModel","Answer Length ${answerSize}, Word Length $wordSize, isEnabled: ${_uiState.value.isEnabled} " )
    }

    fun updateAns(input: String) {
        _uiState.value = _uiState.value.copy(answer = input)
        hasError()
    }
}