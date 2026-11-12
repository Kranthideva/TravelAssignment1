package travelexplorerKranthiMichelleMary.com.Composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import travelexplorerKranthiMichelleMary.com.Destination

@Composable
fun DestinationCard(
    destination: Destination,
    favoriteClicked: ((id: Int) -> Unit)? = null,
    rating: Int? = null,
    showSlider: Boolean = false,
    onRatingChange: (Int) -> Unit = {}
) {
    val boundedRating = rating?.coerceIn(0, 5)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = destination.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                if (favoriteClicked != null) {
                    IconButton(onClick = { favoriteClicked(destination.id) }) {
                        Icon(
                            imageVector = if (destination.isFavorite) {
                                Icons.Filled.Star
                            } else {
                                Icons.Outlined.Star
                            },
                            contentDescription = "Toggle Favourite",
                            tint = if (destination.isFavorite) {
                                Color(0xFFFFB300)
                            } else {
                                MaterialTheme.colorScheme.onSurfaceVariant
                            }
                        )
                    }
                }
            }

            DestinationInfo(label = "Country", value = destination.country)
            DestinationInfo(label = "Highlight", value = destination.highlight)

            if (boundedRating != null) {
                if (showSlider) {
                    Text(
                        text = "Your Rating: $boundedRating / 5",
                        color = MaterialTheme.colorScheme.primary
                    )

                    Slider(
                        value = boundedRating.toFloat(),
                        onValueChange = { onRatingChange(it.toInt().coerceIn(0, 5)) },
                        valueRange = 0f..5f,
                        steps = 4,
                        colors = SliderDefaults.colors(
                            activeTrackColor = MaterialTheme.colorScheme.primary
                        )
                    )
                } else {
                    Text(
                        text = "Rating: " +
                                "\u2605".repeat(boundedRating) +
                                "\u2606".repeat(5 - boundedRating),
                        color = Color(0xFFFFB300)
                    )
                }
            }
        }
    }
}
