
package com.kranthi.Travelassignmentv2
import com.kranthi.Travelassignmentv2.ui.theme.Travelassignmentv2Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.kranthi.Travelassignmentv2.screens.HomeScreen
import com.kranthi.Travelassignmentv2.screens.DestinationHomeScreen

val sampleDestinations = listOf(
    Destination(1, "Toronto", "Canada", "CN Tower"),
    Destination(2, "Kingston", "Jamaica", "Bob Marley Museum"),
    Destination(3, "Paris", "France", "Eiffel Tower"),
    Destination(4, "Tokyo", "Japan", "Shibuya Crossing"),
    Destination(5, "Cape Town", "South Africa", "Table Mountain")
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Travelassignmentv2Theme {

                val navController = rememberNavController()

                // State Management: Map stores destination IDs and ratings
                var ratings by remember {
                    mutableStateOf(
                        sampleDestinations.associate {
                            it.id to 0
                        }
                    )
                }

                // Set stores IDs of destinations rated 4 or 5
                val favoriteIds: Set<Int> = ratings.filter {
                    it.value >= 4
                }.keys

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {

                    composable("home") {
                        HomeScreen(
                            destinationList = sampleDestinations,
                            ratings = ratings,

                            // State Hoisting: callback updates parent state
                            onRatingChange = { destinationId, newRating ->
                                ratings = ratings +
                                        (destinationId to newRating)
                            },

                            moveToFavClicked = {
                                navController.navigate("favorites")
                            }
                        )
                    }

                    composable("favorites") {

                        val favoriteDestinations =
                            sampleDestinations.filter {
                                it.id in favoriteIds
                            }

                        DestinationHomeScreen(
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
