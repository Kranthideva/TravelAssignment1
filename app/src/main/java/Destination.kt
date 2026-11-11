package com.example.Travelassignment1


data class Destination
    (

    val id: Int,
    val name: String,
    val country:String,
    val highlight: String,
    val isFavorite: Boolean = false
)