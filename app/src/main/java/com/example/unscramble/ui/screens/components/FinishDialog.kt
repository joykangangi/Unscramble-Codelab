package com.example.unscramble.ui.screens.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.AlertDialog
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unscramble.R

@Composable
fun FinishDialog(onPlayAgain: () -> Unit, percScore: Int) {
    val activity = (LocalContext.current as Activity)

    AlertDialog(
        onDismissRequest = {
            activity.finish()
        },
        title = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (percScore >= 50) {
                        stringResource(id = R.string.congrats)
                    } else {
                        stringResource(id = R.string.trial)
                    },
                    fontSize = 25.sp
                )
                Image(imageVector = Icons.Default.ThumbUp, contentDescription = "thumb up")
            }
        },
        text = {
            Text(text = stringResource(id = R.string.fin_score, percScore), fontSize = 30.sp)
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