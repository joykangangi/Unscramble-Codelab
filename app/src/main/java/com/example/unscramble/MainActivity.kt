package com.example.unscramble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unscramble.ui.GameViewModel
import com.example.unscramble.ui.screens.GameScreen
import com.example.unscramble.ui.screens.components.FinishDialog
import com.example.unscramble.ui.theme.UnScrambleTheme

class MainActivity : ComponentActivity() {

    private val viewModel: GameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnScrambleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun MyApp(viewModel: GameViewModel) {
    val state by viewModel.uiState.collectAsState()

    if (state.isGameOver) {
        FinishDialog(onPlayAgain = { viewModel.resetGame() }, percScore = state.currentScore)
    } else {
        GameScreen(
            wordCount = state.wordCount,
            currentScore = state.currentScore,
            currentWord = state.currentScrambleWord,
            userAns = state.answer,
            onAnsChange = { viewModel.updateAns(it) },
            checkAns = { viewModel.checkAns() },
            skipAns = { viewModel.onSkipClick() },
            isEnabled = state.isEnabled,
            corrAns = viewModel.correctAns
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UnScrambleTheme {

    }
}