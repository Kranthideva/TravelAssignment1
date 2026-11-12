
package com.kranthi.Travelassignmentv2.Composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.kranthi.Travelassignmentv2.Destination
import com.kranthi.Travelassignmentv2.JourneyColor


@Composable
fun DestinationCard(
    destination: Destination,
    rating: Int,
    showSlider: Boolean,
    onRatingChange: (Int) -> Unit = {}
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = JourneyColor.VeryLightGreen
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            DestinationInfo(destination = destination)

            Spacer(modifier = Modifier.height(12.dp))

            if (showSlider) {

                Text(
                    text = "Your Rating: $rating / 5",
                    color = JourneyColor.DarkGreen
                )

                Slider(
                    value = rating.toFloat(),
                    onValueChange = {
                        onRatingChange(it.toInt())
                    },
                    valueRange = 0f..5f,
                    steps = 4,
                    colors = SliderDefaults.colors(
                        activeTrackColor = JourneyColor.Green
                    )
                )

            } else {

                Text(
                    text = "Rating: " +
                            "★".repeat(rating) +
                            "☆".repeat(5 - rating),
                    color = JourneyColor.Gold
                )
            }
        }
    }
}
