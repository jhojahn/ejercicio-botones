package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.benchmark.traceprocessor.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.rememberComposableLambdaN
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "IRENE",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val image= painterResource(R.drawable.domestic_cat_eabdsul_1024x779)
    var num by remember{
        mutableIntStateOf(1)
    }
    Surface (color = Color.White ){
        Image(painter=image,
            contentDescription = "gatete",
            contentScale= ContentScale.Crop,
           alpha=0.7F
        )
        Column() {
            Row(modifier = Modifier.padding(bottom = 1.dp)) {
                Text(
                    text = "1",

                    color = Color.Red
                )
                Text(
                    text = "2",
                    color = Color.Blue
                )
                Text(
                    text = "3",
                    color = Color.Red
                )
                Button(onClick = {num=(1..10).random()}) {
                    Text(text="boton")
                }
                Text(text = num.toString())
            }
            Row() {
                Text(
                    text = "4",

                    color = Color.Red
                )
                Text(
                    text = "5",
                    color = Color.Blue
                )
                Text(
                    text = "6",
                    color = Color.Red
                )
            }
        }



        }

}

fun Row(map: Any) {}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}