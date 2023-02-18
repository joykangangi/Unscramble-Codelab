package com.example.unscramble.ui.screens.components

//extension Function for neat work

fun String.shuffleString(): String{
   val aCharArray: CharArray = this.toCharArray()
    aCharArray.shuffle()
    while (aCharArray.equals(this)) {
        aCharArray.shuffle()
    }

    return aCharArray.toString()
}