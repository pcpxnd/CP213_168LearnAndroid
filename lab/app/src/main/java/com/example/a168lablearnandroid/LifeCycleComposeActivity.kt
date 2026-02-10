package com.example.a168lablearnandroid

import android.os.Bundle
import android.util.Log // ต้องมีตัวนี้เพื่อใช้ Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
// ต้องมี 2 ตัวนี้เพื่อให้ 'by' ไม่แดง
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a168lablearnandroid.ui.theme._168LabLearnAndroidTheme

class MainActivity2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _168LabLearnAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Phichitphong",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        Log.i("Lifecycle", "MainActivity : onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "MainActivity : onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "MainActivity : onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "MainActivity : onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "MainActivity : onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "MainActivity : onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "MainActivity : onRestart")
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    var inputText by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        Text(
            text = "Hello $name!"
        )
        TextField(
            value = inputText,
            onValueChange = {
                inputText = it
            },
            label = { Text("กรอกข้อความที่นี่") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    _168LabLearnAndroidTheme {
        Greeting2("Android")
    }
}