package travelexplorerKranthiMichelleMary.com

data class Destination(

        val id: Int,
        val name: String,
        val country: String,
        val highlight: String,
        val isFavorite: Boolean = false
    )
