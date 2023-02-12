package com.example.fuelfinder.data.place

import com.google.android.gms.maps.model.LatLng

data class PlaceResponse(
    //TODO this may be a problem
    val geometry: Geometry,
    val name: String,
    val vicinity: String,
    val rating: Float
) {

    data class Geometry(
        val location: GeometryLocation
        )

    data class GeometryLocation(
        val lat: Double,
        val long: Double)
}

fun PlaceResponse.toPlace(): Place = Place(
    name = name,
    latLng = LatLng(
        geometry.location.lat,
        geometry.location.long
    ),
    address =  vicinity,
    rating = rating
)
