package com.example.firstjetpackcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstjetpackcomposeproject.ui.theme.FirstJetPackComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstJetPackComposeProjectTheme {
//                Greeting("Android")
//                var count by remember {
//                    mutableStateOf(0)
//                }
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Text(
//                        text = count.toString(),
//                        fontSize = 30.sp
//                    )
//                    Button(onClick = {
//                        count++
//                    }) {
//                        Text(text = "click me!")
//                    }
//                }
                var name by remember{
                    mutableStateOf("")
                }
                var names by remember{
                    mutableStateOf(listOf<String>())
                }

                Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                        ){
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = name ,
                            onValueChange = {text->
                                name = text
                            },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            if( name.isNotBlank() ){
                                names = names + name
                                name = ""
                            }
                        }) {
                            Text(
                                text = "Add"
                            )
                        }
                    }

                    LazyColumn{
                        items(names){currentName->
                            Text(
                                text = currentName,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )

                            Divider()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    LazyColumn( modifier = Modifier.fillMaxSize()){
        items(20){
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstJetPackComposeProjectTheme {
        Greeting("Android")
    }
}