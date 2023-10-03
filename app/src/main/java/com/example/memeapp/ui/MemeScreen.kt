package com.example.memeapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp

@Composable
fun MemeScreen(title: String, image: ImageBitmap, onClickNext: () -> Unit, onFavourite: () -> Unit) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Meme App",
            modifier = Modifier
                .fillMaxSize()
            )
        Text(title)
        Image(
            bitmap = image, "meme",
             modifier = Modifier
                .fillMaxWidth()
                .width(500.dp)

              //  .align(Alignment.CenterHorizontally)*/
        )
    }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(40.dp),
            verticalAlignment =Alignment.Bottom,
            horizontalArrangement =Arrangement.spacedBy(50.dp)
            

        ){
            Button(onClick = onClickNext,
                modifier = Modifier
                   // .background(Color.White)
            ) { Text("Next Meme") }
            Button(onClick = onFavourite,
                modifier = Modifier
                   ) { Text("Favourite") }
        }

}

