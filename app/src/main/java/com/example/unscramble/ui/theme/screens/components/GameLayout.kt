package com.example.unscramble.ui.theme.screens.components

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
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unscramble.R
import com.example.unscramble.data.Words
import com.example.unscramble.ui.theme.screens.components.Constants.GradientColours

@OptIn(ExperimentalTextApi::class)
@Composable
fun GameLayout() {
   //Todo VM var etText

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
            Text(
                text = getNextWord(), style = TextStyle(
                    brush = Brush.linearGradient(colors = GradientColours)
                ), fontSize = 45.sp
            )
            //Spacer(modifier = Modifier.height(4.dp))
            Text(text = stringResource(id = R.string.instructions), fontSize = 17.sp)
           // Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = stringResource(id = R.string.enter_et)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                }),
                isError = false //Todo VM
            )
        }
    }
}

//Todo VM?
fun getNextWord(): String {
    var wordIndex = 0
    val words = Words.allWords
    return words.elementAt(++wordIndex).toCharArray().shuffle().toString()
}