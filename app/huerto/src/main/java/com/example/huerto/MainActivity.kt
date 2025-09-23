package com.example.huerto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.huerto.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var cont : Int =0
    var mejora: Int=0
    val imagenes=listOf(
        R.drawable.cajonera_con_sustrato,
        R.drawable.descarga,
        R.drawable.descarga__1_,
        R.drawable.descarga__2_,
        R.drawable.descarga__3_,
        R.drawable.descarga__4_
    )
    val felinos=listOf(
        R.drawable.descarga__5_,
        R.drawable.descarga__7_,
        R.drawable.descarga__9_,
        R.drawable.descarga__8_,
        R.drawable.descarga__6_,
        R.drawable.descarga__10_
    )
    var imagen by remember { mutableIntStateOf(0) }
    var felino by remember { mutableIntStateOf(0) }
    var punto by remember {  mutableIntStateOf(0)}
    var mejorar by remember {  mutableIntStateOf(mejora)}
    Surface(color = Color.White) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (mejorar==0)
            Image(
                painter = painterResource(id = imagenes[imagen]),
                contentDescription = "gatete",
                modifier = Modifier.size(300.dp),
                contentScale = ContentScale.Crop
            )
            if (mejorar==1)
            Image(
                painter = painterResource(id = felinos[felino]),
                contentDescription = "gatete",
                modifier = Modifier.size(300.dp),
                contentScale = ContentScale.Crop
            )
            Button(onClick = {
                if (mejorar==0)
                imagen = (imagen+1)% imagenes.size
                if (mejorar==1)
                    felino = (felino+1)% felinos.size
                cont++
                if (cont == 6) {
                    punto += 10
                    cont = 0
                }
            }) {
                if (cont < 5) {
                    Text("crecer")
                } else {
                    Text("Vender")
                }



            }
            Text(text=" puntuación = $punto")
            Button(onClick = {
            if (punto>=100 && mejorar==0){
            punto-=100
                mejora=1
}
            }){
           Text("mejorar: 100 puntos")            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}