package com.example.unscramble.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.unscramble.R
import com.example.unscramble.ui.GameViewModel
import com.example.unscramble.ui.screens.components.GameLayout
import com.example.unscramble.ui.screens.components.GameStatus

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    viewModel: GameViewModel
) {

    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            //.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        GameStatus(count = state.wordCount, currentScore = state.currentScore, totalWords = viewModel.wordSize)
        GameLayout(
            currentWord = state.currentScrambleWord,
            userAnswer = state.answer,
            onAnswerChange = {
                viewModel.updateAns(it)
            }
        )

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = {
                    viewModel.onSkipClick()
                },
                modifier = modifier.weight(1f)
            ) {
                Text(text = stringResource(id = R.string.skipBtn))
            }
            Button(
                onClick = {
                    viewModel.checkAns()
                },
                modifier = modifier.weight(1f),
                enabled = state.isEnabled
            ) {
                Text(text = stringResource(id = R.string.nextBtn))
            }
        }
    }
}