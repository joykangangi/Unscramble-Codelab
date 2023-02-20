package com.example.unscramble.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.unscramble.R
import com.example.unscramble.ui.screens.components.GameLayout
import com.example.unscramble.ui.screens.components.GameStatus

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    wordCount: Int,
    currentScore: Int,
    currentWord: String,
    userAns: String,
    onAnsChange: (String)-> Unit,
    checkAns: ()->Unit,
    skipAns: () -> Unit,
    isEnabled: Boolean,
    corrAns: String
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            //.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        GameStatus(count = wordCount, currentScore = currentScore)
        GameLayout(
            currentWord = currentWord,
            userAnswer = userAns,
            onAnswerChange = onAnsChange,
            onKeyBoardDone = checkAns
        )

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = {
                    showToast(context, message = corrAns)
                    skipAns()
                },
                modifier = modifier.weight(1f)
            ) {
                Text(text = stringResource(id = R.string.skipBtn))
            }
            Button(
                onClick = {
                    showToast(context, message = corrAns)
                    checkAns()
                    },
                modifier = modifier.weight(1f),
                enabled = isEnabled
            ) {
                Text(text = stringResource(id = R.string.nextBtn))
            }
        }
        Spacer(modifier = modifier.height(10.dp))
    }
}

private fun showToast(context: Context, message: String) {
    Toast.makeText(context,"CORRECT ANSWER: $message", Toast.LENGTH_LONG ).show()

}