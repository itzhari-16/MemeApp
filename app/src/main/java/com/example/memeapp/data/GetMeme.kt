package com.example.memeapp.data

import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.concurrent.Executors


class GetMeme(val link: String) {

    private fun setMemeData(onGetImage: (ImageBitmap, String) -> Unit)  {
        Log.d("R", "1")
        val url = URL(link)
        val connection = url.openConnection()
        connection.connect()
        Log.d("R", "2")
        val stream = connection.getInputStream()
        val reader = BufferedReader(InputStreamReader(stream))
        var buffer = ""
        var line: String? = ""
        while (line != null) {
            line = reader.readLine()
            if (line.isNullOrBlank()) break
            buffer += line
        }
        val obj = JSONObject(buffer)
        val memeData = MemeData(
            obj.getString("title"),
            //"ABC",
            obj.getString("url")
            //"https://i.redd.it/dhsrdpypnarb1.jpg"
        )
        Log.d("Response: ", memeData.toString())
        val imageConnection = URL(memeData.memePath).openConnection()
        imageConnection.connect()
        val stream2 = imageConnection.getInputStream()
        val image = BitmapFactory.decodeStream(stream2).asImageBitmap()
        onGetImage(image, memeData.title)
    }

    fun getMeme(onGet: (ImageBitmap, String) -> Unit) {
        Log.d("MSG", "sent")
        Executors.newSingleThreadExecutor().submit {
            try {
                setMemeData(onGet)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}