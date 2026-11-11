package travelexplorerKranthiMichelleMary.com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import travelexplorerKranthiMichelleMary.com.ui.theme.TravelExplorerTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
data class Destination(
    val id: Int,
    val name: String,
    val country: String,
    val highlight: String,
    val isFavorite: Boolean =false
)
val sampleDestinations = listOf (Destination (1, "Toronto", "Canada", "CN Tower"),
    Destination (2,"Kingston","Jamaica", "Explorer Bob Marley Museum"),
    Destination (3,"Paris", "France", "See the Eiffel Tower"),
    Destination (4,"Tokyo", "Japan", "Visit Shibuya"),
    Destination (5,"Cape Town", "South Africa", "See Table Mountain"))
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelExplorerTheme {
                val destinations = remember {mutableStateOf(sampleDestinations)
                }
                fun toggleFavorite(destinationId: Int){
                    destinations.value = destinations.value.map {
                        destination ->
                        if (destination.id == destinationId){
                            destination.copy(isFavorite = ! destination.isFavorite)
                        }
                        else {
                            destination
                        }
                    }
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TravelExplorerTheme {
        Greeting("Android")
    }
}