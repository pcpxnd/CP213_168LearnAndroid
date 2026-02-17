package com.example.a168lablearnandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.a168lablearnandroid.utils.PokemonEntry

// สีโทน Pokedex
val PokedexRed = Color(0xFFC60808)
val DarkRed = Color(0xFF8E0606)
val LightGrayBackground = Color(0xFFE0E0E0)

class ListActivity3 : ComponentActivity() {
    // ใช้ viewModels() delegate เพื่อให้ Android จัดการ Lifecycle ของ ViewModel ให้
    private val viewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // เรียกดึงข้อมูลเมื่อ Activity ถูกสร้าง
        viewModel.fetchPokemon()

        setContent {
            ListScreen(viewModel)
        }
    }
}

@Composable
fun ListScreen(viewModel: PokemonViewModel) {
    // เชื่อมต่อ State จาก ViewModel
    val pokemonList by viewModel.pokemonList.collectAsState()
    var searchText by remember { mutableStateOf("") }

    // กรองข้อมูลจาก List ที่ได้มาจาก API
    val filteredPokemon = pokemonList.filter {
        it.pokemon_species.name.contains(searchText, ignoreCase = true) ||
                it.entry_number.toString().contains(searchText)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PokedexRed)
            .statusBarsPadding()
    ) {
        HeaderWithSearch(
            searchText = searchText,
            onSearchChange = { searchText = it }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(LightGrayBackground)
                .padding(12.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(filteredPokemon) { entry ->
                    PokemonRow(entry)
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        thickness = 1.dp,
                        color = Color.LightGray
                    )
                }

                if (filteredPokemon.isEmpty() && pokemonList.isNotEmpty()) {
                    item {
                        Box(modifier = Modifier.fillParentMaxSize(), contentAlignment = Alignment.Center) {
                            Text("No Pokemon found", color = Color.Gray)
                        }
                    }
                }

                // กรณีที่ List ยังว่างเปล่า (กำลังโหลด)
                if (pokemonList.isEmpty()) {
                    item {
                        Box(modifier = Modifier.fillParentMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator(color = PokedexRed)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PokemonRow(entry: PokemonEntry) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "#${entry.entry_number}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier.width(60.dp)
        )

        Text(
            text = entry.pokemon_species.name.replaceFirstChar { it.uppercase() },
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )

        // ใช้ entry_number ในการดึงรูปภาพจาก Server
        AsyncImage(
            model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${entry.entry_number}.png",
            contentDescription = entry.pokemon_species.name,
            modifier = Modifier.size(60.dp),
            contentScale = ContentScale.Fit
        )
    }
}

// --- ส่วน HeaderWithSearch และ SmallLight คงเดิมตามที่คุณเขียนไว้ ---
@Composable
fun HeaderWithSearch(searchText: String, onSearchChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(65.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(4.dp)
                .clip(CircleShape)
                .background(Color(0xFF3F51B5)),
            contentAlignment = Alignment.Center
        ) {
            Box(modifier = Modifier.size(20.dp).clip(CircleShape).background(Color(0x80FFFFFF)))
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                SmallLight(Color.Red)
                SmallLight(Color.Yellow)
                SmallLight(Color.Green)
            }

            TextField(
                value = searchText,
                onValueChange = onSearchChange,
                placeholder = { Text("Search name or ID", color = Color(0xFFC58A8A), fontSize = 14.sp) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(25.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = DarkRed,
                    unfocusedContainerColor = DarkRed,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true
            )
        }
    }
}

@Composable
fun SmallLight(color: Color) {
    Box(
        modifier = Modifier
            .size(12.dp)
            .clip(CircleShape)
            .background(color)
            .background(Color(0x33FFFFFF))
    )
}