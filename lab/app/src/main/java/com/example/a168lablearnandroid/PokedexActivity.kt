package com.example.a168lablearnandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

val PokedexRed = Color(0xFFC60808)
val DarkRed = Color(0xFF8E0606)
val LightGrayBackground = Color(0xFFE0E0E0)

data class Pokemon(
    val name: String,
    val number: Int
)

class ListActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListScreen()
        }
    }
}

@Composable
fun ListScreen() {
    var searchText by remember { mutableStateOf("") }

    val filteredPokemon = allKantoPokemon.filter {
        it.name.contains(searchText, ignoreCase = true) ||
                it.number.toString().contains(searchText)
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
                items(filteredPokemon) { pokemon ->
                    PokemonRow(pokemon)
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        thickness = 1.dp,
                        color = Color.LightGray
                    )
                }

                if (filteredPokemon.isEmpty()) {
                    item {
                        Box(modifier = Modifier.fillParentMaxSize(), contentAlignment = Alignment.Center) {
                            Text("No Pokemon found", color = Color.Gray)
                        }
                    }
                }
            }
        }
    }
}

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
                placeholder = { Text("Search name or ID", color = Color(0xFF5A0404), fontSize = 14.sp) },
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
            .background(Color(0x33FFFFFF)) // เพิ่มเงาไฮไลท์นิดหน่อยให้ดูนูน
    )
}

@Composable
fun PokemonRow(pokemon: Pokemon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "#${pokemon.number}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier.width(50.dp)
        )

        Text(
            text = pokemon.name.lowercase(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )

        AsyncImage(
            model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/versions/generation-iii/firered-leafgreen/${pokemon.number}.png",
            contentDescription = pokemon.name,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.Fit
        )
    }
}

val allKantoPokemon = listOf(
    Pokemon("Bulbasaur", 1),
    Pokemon("Ivysaur", 2),
    Pokemon("Venusaur", 3),
    Pokemon("Charmander", 4),
    Pokemon("Charmeleon", 5),
    Pokemon("Charizard", 6),
    Pokemon("Squirtle", 7),
    Pokemon("Wartortle", 8),
    Pokemon("Blastoise", 9),
    Pokemon("Caterpie", 10),
    Pokemon("Metapod", 11),
    Pokemon("Butterfree", 12),
    Pokemon("Weedle", 13),
    Pokemon("Kakuna", 14),
    Pokemon("Beedrill", 15),
    Pokemon("Pidgey", 16),
    Pokemon("Pidgeotto", 17),
    Pokemon("Pidgeot", 18),
    Pokemon("Rattata", 19),
    Pokemon("Raticate", 20),
    Pokemon("Spearow", 21),
    Pokemon("Fearow", 22),
    Pokemon("Ekans", 23),
    Pokemon("Arbok", 24),
    Pokemon("Pikachu", 25),
    Pokemon("Raichu", 26),
    Pokemon("Sandshrew", 27),
    Pokemon("Sandslash", 28),
    Pokemon("Nidoran♀", 29),
    Pokemon("Nidorina", 30),
    Pokemon("Nidoqueen", 31),
    Pokemon("Nidoran♂", 32),
    Pokemon("Nidorino", 33),
    Pokemon("Nidoking", 34),
    Pokemon("Clefairy", 35),
)

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    ListScreen()
}
