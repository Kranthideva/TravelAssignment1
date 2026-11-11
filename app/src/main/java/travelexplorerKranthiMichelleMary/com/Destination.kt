package travelexplorerKranthiMichelleMary.com

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
