package com.example.tfliteapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tfliteapp.ui.theme.TFliteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TFliteAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview()
{
    HomeScreen()
}

@Composable
fun HomeScreen(modifier: Modifier=Modifier)
{
    var text by remember { mutableStateOf("") }
    var res by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text("Enter your post here...") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            maxLines = 10,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Run tokenization + TFLite prediction
            Log.d("InputText", "User typed: $text")
        }) {
            res = "Clicked"
            Text("Predict")
        }
        Text("Response: ${res}")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TFliteAppTheme {
        Greeting("Android")
    }
}