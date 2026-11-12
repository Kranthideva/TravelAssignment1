package travelexplorerKranthiMichelleMary.com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import travelexplorerKranthiMichelleMary.com.Screens.HomeScreen
import travelexplorerKranthiMichelleMary.com.Screens.SelectedDestinations
import travelexplorerKranthiMichelleMary.com.ui.theme.TravelExplorerTheme

val sampleDestinations = listOf(
    Destination(1, "Toronto", "Canada", "CN Tower"),
    Destination(2, "Kingston", "Jamaica", "Explorer Bob Marley Museum"),
    Destination(3, "Paris", "France", "See the Eiffel Tower"),
    Destination(4, "Tokyo", "Japan", "Visit Shibuya"),
    Destination(5, "Cape Town", "South Africa", "See Table Mountain")
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TravelExplorerTheme {
                val navController = rememberNavController()

                // State Management: Map stores destination IDs and ratings - Karanthi
                var ratings by remember {
                    mutableStateOf(
                        sampleDestinations.associate {
                            it.id to 0
                        }
                    )
                }
                val favoriteDestinations = sampleDestinations.filter {
                    (ratings[it.id] ?: 0) >= 4
                }

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        HomeScreen(
                            destinationList = sampleDestinations,
                            ratings = ratings,

                            // State Hoisting: callback updates parent state - Karanthi
                            onRatingChange = { destinationId, newRating ->
                                ratings = ratings + (destinationId to newRating)
                            },
                            moveToFavClicked = {
                                navController.navigate("favorites")
                            }
                        )
                    }

                    composable("favorites") {
                        SelectedDestinations(
                            destinationList = favoriteDestinations,
                            ratings = ratings,
                            backButtonClicked = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}
