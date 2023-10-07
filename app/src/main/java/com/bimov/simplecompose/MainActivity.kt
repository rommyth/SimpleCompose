package com.bimov.simplecompose
import androidx.compose.ui.unit.sp

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.bimov.simplecompose.ui.theme.SimpleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleComposeTheme {
                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                }
                DefaultPreview()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Hello $name!",
            fontSize = 24.sp
        )
        Text(text = "Klik untuk memunculkan Toast")
    }
}

@Composable
fun CustomDialog(onDismissRequest: () -> Unit ,text: String){
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(text = "$text",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                )
        }
    }
}

@Composable
fun CustomButton (text: String, onClick: () -> Unit) {
    Button(onClick = { onClick() }, modifier = Modifier
        .padding(top = 12.dp)
        .width(200.dp)) {
        Text(text = "Klik")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val openDialog = remember { mutableStateOf(false) }
    SimpleComposeTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Greeting("Semua")
            CustomButton("Klik", onClick = { openDialog.value = true })
            when {
                openDialog.value -> {
                    CustomDialog(onDismissRequest = { openDialog.value = false }, text = "Hallo, It`s Bimo")
                }
            }
        }

    }
}