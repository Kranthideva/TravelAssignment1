
package com.kranthi.Travelassignmentv2.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kranthi.Travelassignmentv2.Destination
import com.kranthi.Travelassignmentv2.Composables.DestinationCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    destinationList: List<Destination>,
    ratings: Map<Int, Int>,
    onRatingChange: (Int, Int) -> Unit,
    moveToFavClicked: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Travel Destinations",
                        color = Color.White
                    )
                },
                actions = {
                    TextButton(
                        onClick = moveToFavClicked
                    ) {
                        Text(
                            text = "Favorites",
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

            Text(
                text = "Choose Your Favourite Destinations",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Move the slider to rate each destination from 0 to 5.",
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

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
                        showSlider = true,
                        onRatingChange = { newRating ->
                            onRatingChange(
                                destination.id,
                                newRating
                            )
                        }
                    )
                }
            }
        }
    }
}
