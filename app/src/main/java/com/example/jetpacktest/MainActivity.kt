package com.example.jetpacktest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpacktest.ui.theme.JetpackTestTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingApp()
        }
    }
}

@Composable
fun GreetingApp() {
    var name by remember {mutableStateOf("")}
    var message by remember { mutableStateOf("Votre message apparaîtra ici.")}
    MaterialTheme{
        Surface(
            // Votre interface utilisateur sera ici
            modifier = Modifier.fillMaxSize(),
            color= MaterialTheme.colorScheme.background
        ){
            Column (
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ){
                TextField(
                    value = name,
                    onValueChange={name=it},
                    label ={Text("Entrez votre nom")},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {message= if (name.isNotBlank()){
                    "Bonjour, $name ! Bienvenue dans l'application."
                }else{
                    "Veuillez entrer votre nom."
                }
                }) {
                    Text("Valider")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text=message,
                    fontSize = 18.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingAppPreview() {
    GreetingApp()
}