package travelexplorerKranthiMichelleMary.com.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import travelexplorerKranthiMichelleMary.com.Composables.DestinationCard
import travelexplorerKranthiMichelleMary.com.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedDestinations(
    //favoriteDestinations: List<Destination>,
    destinations: List<Destination>,
    favoriteIds: Set<Int>,
    favoriteClicked: (id: Int) -> Unit,
    onBack: () -> Unit
) {
    val favoriteDestinations = destinations.filter { it.id in favoriteIds }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Favorite Destinations") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        if (favoriteDestinations.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No favorite destinations yet.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = favoriteDestinations,
                    key = { destination -> destination.id }
                ) { destination ->
                    DestinationCard(
                        destination = destination.copy(isFavorite = true),
                        favoriteClicked = favoriteClicked
                    )
                }
            }
        }
    }
}
