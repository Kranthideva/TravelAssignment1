package travelexplorerKranthiMichelleMary.com.Screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import travelexplorerKranthiMichelleMary.com.Composables.DestinationCard
import travelexplorerKranthiMichelleMary.com.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    destinationList: List<Destination>,
    favList: Set<Int>,
    favoriteClicked: (id: Int) -> Unit,
    movetoFavClicked: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Travel Explorer App") },
                actions = {
                    IconButton(onClick = { movetoFavClicked() }) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "navigate to favorites"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
        ) {
            items(destinationList) { destination ->
                DestinationCard(
                    destination = destination.copy(isFavorite = destination.id in favList),
                    favoriteClicked = favoriteClicked
                )
            }
        }
    }
}