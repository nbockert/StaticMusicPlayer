package com.example.staticmusicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.ArrowBack



import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource




//var isPlaying = true;
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerScreen()
        }
    }
}

@Composable
fun MusicPlayerScreen() {
    var isPlaying by remember { mutableStateOf(false) }
    val pauseicon: ImageVector = ImageVector.vectorResource(id = R.drawable.baseline_pause_24)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.albumcover),
                contentDescription = "Album Cover",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(text="Love from the Other Side",fontSize=24.sp,fontWeight= FontWeight.Bold)
        Text(text = "L'Impératrice", fontSize = 18.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            MakeButton(icon = Icons.AutoMirrored.Filled.ArrowBack, description = "Previous"){}
            MakeButton(
                icon = if (isPlaying) pauseicon else Icons.Filled.PlayArrow, // Switch icon dynamically
                description = if (isPlaying) "Pause" else "Play"
            ){
                isPlaying = !isPlaying
            }
            MakeButton(icon = Icons.AutoMirrored.Filled.ArrowForward, description = "Next"){}
        }
    }
}

@Composable
fun MakeButton(icon: ImageVector, description: String,onClick: () -> Unit) {
    if(description==="Play" || description === "Pause"){
        Button(
            onClick = onClick,
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
        ) {
            Icon(imageVector = icon, contentDescription = description, tint = Color.White)
        }

    }else{
        Button(
            onClick = {},
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
        ) {
            Icon(imageVector = icon, contentDescription = description, tint = Color.White)
        }

    }



}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MusicPlayerScreen()
}