package com.example.a168lablearnandroid

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a168lablearnandroid.ui.theme._168LabLearnAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray)
                .padding(32.dp))
            {
                // hp
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .background(color = Color.White))
                {
                    Text(
                        text = "hp",
                        modifier = Modifier
                            .align(alignment = Alignment.CenterStart)
                            .fillMaxWidth(fraction = 0.5f)
                            .background(color = Color.Red)
                            .padding(8.dp)
                    )
                }

                // image
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(450.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 16.dp)
                        .clickable {
                            startActivity(Intent(this@MainActivity,ListActivity3::class.java))
                        }
                )
                // status
                var pac by remember { mutableStateOf(120) }
                var sho by remember { mutableStateOf(117) }
                var pas by remember { mutableStateOf(106) }
                var dri by remember { mutableStateOf(116) }
                var def by remember { mutableStateOf(81) }
                var phy by remember { mutableStateOf(115) }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Column (horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_drop_up_24),
                            contentDescription = "Increase PAC",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    pac = pac + 1
                                }
                        )
                        Text(text = "PAC", fontSize = 30.sp)
                        Text(text = pac.toString(), fontSize = 30.sp)
                        Image(
                            painter = painterResource(id = R.drawable.outline_arrow_drop_down_24),
                            contentDescription = "Decrease PAC",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    pac = pac - 1
                                }
                        )
                    }
                    Column (horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_drop_up_24),
                            contentDescription = "Increase SHO",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    sho = sho + 1
                                }
                        )
                        Text(text = "SHO", fontSize = 30.sp)
                        Text(text = sho.toString(), fontSize = 30.sp)
                        Image(
                            painter = painterResource(id = R.drawable.outline_arrow_drop_down_24),
                            contentDescription = "Decrease SHO",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    sho = sho - 1
                                }
                        )
                    }
                    Column (horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_drop_up_24),
                            contentDescription = "Increase PAS",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    pas = pas + 1
                                }
                        )
                        Text(text = "PAS", fontSize = 30.sp)
                        Text(text = pas.toString(), fontSize = 30.sp)
                        Image(
                            painter = painterResource(id = R.drawable.outline_arrow_drop_down_24),
                            contentDescription = "Decrease SHO",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    sho = sho - 1
                                }
                        )
                    }
                }
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Column (horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_drop_up_24),
                            contentDescription = "Increase DRI",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    dri = dri + 1
                                }
                        )
                        Text(text = "DRI", fontSize = 30.sp)
                        Text(text = dri.toString(), fontSize = 30.sp)
                        Image(
                            painter = painterResource(id = R.drawable.outline_arrow_drop_down_24),
                            contentDescription = "Decrease DRI",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    dri = dri - 1
                                }
                        )
                    }
                    Column (horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_drop_up_24),
                            contentDescription = "Increase DEF",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    def = def + 1
                                }
                        )
                        Text(text = "DEF", fontSize = 30.sp)
                        Text(text = def.toString(), fontSize = 30.sp)
                        Image(
                            painter = painterResource(id = R.drawable.outline_arrow_drop_down_24),
                            contentDescription = "Decrease DEF",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    def = def - 1
                                }
                        )
                    }
                    Column (horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_arrow_drop_up_24),
                            contentDescription = "Increase PHY",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    phy = phy + 1
                                }
                        )
                        Text(text = "PHY", fontSize = 30.sp)
                        Text(text = phy.toString(), fontSize = 30.sp)
                        Image(
                            painter = painterResource(id = R.drawable.outline_arrow_drop_down_24),
                            contentDescription = "Decrease PHY",
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    phy = phy - 1
                                }
                        )
                    }
                }
            }
        }
    }
}


