package com.example.unscramble.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unscramble.R

@Composable
fun GameStatus(count: Int, currentScore: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text( text = stringResource(id = R.string.out_of,count), fontSize = 18.sp )
        Text( text = stringResource(id = R.string.score_count, currentScore), fontSize = 18.sp )

    }
}