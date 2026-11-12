
package com.kranthi.Travelassignmentv2.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.kranthi.Travelassignmentv2.Destination
import com.kranthi.Travelassignmentv2.Composables.DestinationCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinationHomeScreen(
    destinationList: List<Destination>,
    ratings: Map<Int, Int>,
    backButtonClicked: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Favourite Destinations",
                        color = Color.White
                    )
                },
                navigationIcon = {
                    TextButton(
                        onClick = backButtonClicked
                    ) {
                        Text(
                            text = "Back",
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2E7D32)
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            if (destinationList.isEmpty()) {

                Text(
                    text = "No favourite destinations yet. Rate a destination 4 or 5 stars!",
                    style = MaterialTheme.typography.bodyLarge
                )

            } else {

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(
                        items = destinationList,
                        key = { it.id }
                    ) { destination ->

                        DestinationCard(
                            destination = destination,
                            rating = ratings[destination.id] ?: 0,
                            showSlider = false
                        )
                    }
                }
            }
        }
    }
}
