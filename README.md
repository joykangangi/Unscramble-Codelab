# Unscramble-Codelab
- This is a replica of this [codelab](https://developer.android.com/codelabs/basic-android-kotlin-compose-viewmodel-and-state)
- I wanted to improve my coding logic through this exercise as I understand the role of viewmodel in state management. 
- The idea is the same as the codelab's but I majorly used my logic and tweaked the screen presentation.

### What I got to Learn
- [Recomposition](https://developer.android.com/jetpack/compose/mental-model#recomposition) in `Jetpack Compose`. Since Jetpack Compose is declarative I got to learn that for any update you have to call it from a `composable`
E.g. If you want to display text being typed you have to call the respective function within that composable so as to recompose. Calling it in the `init` block if the viewmodel is not enough
to cause recomposition.(This is what I had done). 
- Also the meaning of `val` and `var` change in compose since they have a `state object` attached to them. It is a special variable in compose.( I have always suspected their functionality in compose and after tweaking around, my doubts were cleared 😅) 
```
private val num: MutableState<Int> = mutableStateOf(1)
private var num2: MutableState<Int> = mutableStateOf(2) 
private val num3 by remember { mutableStateOf(3) } // Unreassignable Int
private var num4 by remember { mutableStateOf(4) } //Reassignable Int
```
- With this said, 
```
num.state = 7 
````
#### Explanation
Correct, since it is a mutable state object. The object containing the value never changes (val) but the content of that object (mutable state) can change.

```
num2.state = 6
```
#### Explanation
Correct, but if this is all you want to do with the variable, use `val` plus the ide will suggest an improvement. Otherwise, you can change the object `num2` to another object/variable.

``` 
num2 = myNum
```

- More will be shared very soon.


### Test the app here [Appetize Link](https://appetize.io/app/by32i52lgpnee3x3dspc252rda?device=pixel4&osVersion=11.0&scale=75)
