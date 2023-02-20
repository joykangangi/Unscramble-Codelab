package com.example.unscramble.ui

import androidx.lifecycle.ViewModel
import com.example.unscramble.data.Words
import com.example.unscramble.ui.screens.components.Constants.MAX_NO_OF_WORDS
import com.example.unscramble.ui.screens.components.Constants.SCORE_INCREASE
import com.example.unscramble.ui.screens.components.Constants.SKIP_DECREASE
import com.example.unscramble.ui.screens.shuffleString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<GameUiState> = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private lateinit var currentWord: String
    lateinit var correctAns: String

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
        _uiState.value = _uiState.value.copy(
            currentScrambleWord = "",
            wordCount = 0,
            currentScore = 0,
            answer = "",
            isEnabled = false,
            isGameOver = false
        )
        getWord()
        hasError()
        wordCount()
    }

    private fun isGameOver() {
        if (usedWords.size == MAX_NO_OF_WORDS) {
            _uiState.value = _uiState.value.copy(isGameOver = true)
        } else {
            resetWord()
            hasError()
            wordCount()
        }
    }

    //onNext Click
    fun checkAns() {
        if (_uiState.value.answer == correctAns) {
            _uiState.value =
                _uiState.value.copy(currentScore = _uiState.value.currentScore.plus(SCORE_INCREASE))
        } else {
            _uiState.value = _uiState.value.copy(
                currentScore = _uiState.value.currentScore.minus(SCORE_INCREASE)
            )
        }
        isGameOver()
    }

    //onSkip Click
    fun onSkipClick() {
        _uiState.value =
            _uiState.value.copy(currentScore = _uiState.value.currentScore.minus(SKIP_DECREASE))
        isGameOver()
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

    /* private fun colorText () {
          val quesWord = _uiState.value.currentScrambleWord
          val answerWord = _uiState.value.answer
          for (letter in answerWord) {
              if (quesWord.contains(letter)) {
                  _uiState.value = _uiState.value.copy(letterColor = Purple700)
              }
              else {
                  _uiState.value = _uiState.value.copy(letterColor = Color.DarkGray)
              }
          }
      }*/




    fun updateAns(input: String) {
        _uiState.value = _uiState.value.copy(answer = input)
        hasError()
    }
}