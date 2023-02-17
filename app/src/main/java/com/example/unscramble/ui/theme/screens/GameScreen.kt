package com.example.unscramble.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.unscramble.R
import com.example.unscramble.ui.theme.screens.components.GameLayout
import com.example.unscramble.ui.theme.screens.components.GameStatus

@Composable
fun GameScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            //.fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        GameStatus()
        GameLayout()

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            OutlinedButton(onClick = {
                //Todo VM
            }) {
                Text(text = stringResource(id = R.string.skipBtn))
            }
            Button(onClick = {
                //Todo VM
            }) {
                Text(text = stringResource(id = R.string.nextBtn))
            }
        }
    }
}