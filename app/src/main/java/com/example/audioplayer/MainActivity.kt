package com.example.audioplayer

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.audioplayer.ui.theme.AudioPlayerTheme

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
    val mContext = LocalContext.current

    val mMediaPlayer = MediaPlayer.create(mContext, R.raw.audio)

    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
           IconButton(onClick = {mMediaPlayer.start()}) {
               Icon(painter = painterResource(id = R.drawable.play_button),
                   contentDescription = "Play Button",
                   modifier = Modifier.size(100.dp)
               )
           }

            IconButton(onClick = {mMediaPlayer.pause()}) {
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



