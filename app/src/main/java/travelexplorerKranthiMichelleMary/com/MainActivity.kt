package travelexplorerKranthiMichelleMary.com

import android.os.Bundle
import android.util.Log
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val destinations = listOf(
            Destination(1, "Toronto", "Canada", "CN Tower"),
            Destination(2, "Kingston", "Jamaica", "Explorer Bob Marley Museum"),
            Destination(3, "Paris", "France", "See the Eiffel Tower"),
            Destination(4, "Tokyo", "Japan", "Visit Shibuya"),
            Destination(5, "Cape Town", "South Africa", "See Table Mountain")
        )

        setContent {
            TravelExplorerTheme {
                val navController = rememberNavController()
                var favoriteIds by remember { mutableStateOf(setOf<Int>()) }

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") {
                        HomeScreen(
                            destinationList = destinations,
                            favList = favoriteIds,
                            favoriteClicked = { selectedID ->
                                Log.d("selected ID", selectedID.toString())
                                favoriteIds = if (selectedID in favoriteIds) {
                                    favoriteIds - selectedID
                                } else {
                                    favoriteIds + selectedID
                                }
                                Log.d("listOfIDS", favoriteIds.toString())
                            },
                            movetoFavClicked = {
                                navController.navigate("selectedDestinations")
                            }
                        )
                    }

                    composable("selectedDestinations") {
                        SelectedDestinations(
                           // favoriteDestinations = destinations.filter { it.id in favoriteIds },destinations = destinations,
                            //                            favoriteIds = favoriteIds,
                            destinations = destinations,
                            favoriteIds = favoriteIds,
                            favoriteClicked = { selectedID ->
                                favoriteIds = if (selectedID in favoriteIds) {
                                    favoriteIds - selectedID
                                } else {
                                    favoriteIds + selectedID
                                }
                            },
                            onBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
