package com.example.memeapp.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import com.example.memeapp.data.GetMeme

class MemeScreenViewModel : ViewModel() {
    val memeGetter = GetMeme("https://meme-api.com/gimme")

    val imageState = mutableStateOf(ImageBitmap(500, 500))
    val title = mutableStateOf("")

    init {
        onNext()
    }

    fun onNext() {
        memeGetter.getMeme { image, titleX ->
            imageState.value = image
            title.value = titleX
        }
    }

    fun onFavourite() {

    }
}