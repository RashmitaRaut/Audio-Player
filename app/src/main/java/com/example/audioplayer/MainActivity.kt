package com.example.audioplayer

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.lang.Exception

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                MainContent()
            }
        }
    }

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Audio Player") }) },
        content = { MyContent() }
    )
}

@Composable
fun MyContent(){
    val ctx = LocalContext.current

    val mediaPlayer = MediaPlayer()

    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
           IconButton(onClick = {
               val audioUrl = "https://bit.ly/MridangaAudio"

               mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

               try {
                   mediaPlayer.setDataSource(audioUrl)

                   mediaPlayer.prepare()

                   mediaPlayer.start()
               }catch (e: Exception){
                   e.printStackTrace()
               }

               Toast.makeText(ctx, "Strted", Toast.LENGTH_SHORT ).show()
           }) {
               Icon(painter = painterResource(id = R.drawable.play_button),
                   contentDescription = "Play Button",
                   modifier = Modifier.size(100.dp)
               )
           }

/*******************************************************************************************/
            IconButton(onClick = {
                if (mediaPlayer.isPlaying){
                    mediaPlayer.stop()
                    mediaPlayer.reset()
                    mediaPlayer.release()

                    Toast.makeText(ctx, "Paused", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(ctx, "Not played", Toast.LENGTH_SHORT)
                }

            }) {
                Icon(painter = painterResource(id = R.drawable.pause_button),
                    contentDescription = "Pause Button",
                    modifier = Modifier.size(100.dp)
                )
            }
        }

    }
}
            
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MainContent()
}



