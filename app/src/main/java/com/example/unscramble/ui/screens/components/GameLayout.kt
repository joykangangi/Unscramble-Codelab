package com.example.unscramble.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unscramble.R


@OptIn(ExperimentalTextApi::class)
@Composable
fun GameLayout(
    currentWord: String,
    userAnswer: String,
    onAnswerChange: (String) -> Unit,
    onKeyBoardDone:() -> Unit
) {

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = currentWord, fontSize = 45.sp, style = TextStyle(
                brush = Brush.linearGradient(colors = Constants.GradientColours)
            )
            )

            Text(text = stringResource(id = R.string.instructions), fontSize = 17.sp)

            OutlinedTextField(
                value = userAnswer,
                onValueChange = onAnswerChange,
                placeholder = { Text(text = stringResource(id = R.string.enter_et)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    onKeyBoardDone()
                }),
                modifier = Modifier.padding(bottom = 15.dp)
            )
        }
    }
}
/*
@Composable
fun ScrambledWord(word: String, color: Color) {
    val letterColorMap = mutableMapOf<Char, Color>()

    val annotatedString = AnnotatedString.Builder().apply {
        for ((index, char) in word.withIndex()) {
            val color = if (index)
        }
    }

}*/
