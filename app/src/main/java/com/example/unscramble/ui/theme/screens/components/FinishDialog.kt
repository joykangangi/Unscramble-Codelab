package com.example.unscramble.ui.theme.screens.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.AlertDialog
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.unscramble.R

@Composable
fun FinishDialog(onPlayAgain:()-> Unit) {
    val openDialog = remember { mutableStateOf(false) }
    val percScore = 78
    //Todo VM - getTitle()

    val activity = (LocalContext.current as Activity)

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                activity.finish()
            },
            title = {
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    Text(text = "")
                    Image(imageVector = Icons.Default.Check, contentDescription = null)
                }
            },
            text = {
                Text(text = stringResource(id = R.string.fin_score, percScore))
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { activity.finish() }
                ) {
                    Text(text = stringResource(id = R.string.exit))
                }
            },
            confirmButton = {
                OutlinedButton(
                    onClick = onPlayAgain
                ) {
                    Text(text = stringResource(id = R.string.tryAgain))
                }
            }
        )
    }
}