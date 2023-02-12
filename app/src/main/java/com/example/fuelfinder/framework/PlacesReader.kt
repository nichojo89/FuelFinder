package com.example.fuelfinder.framework

import android.content.Context
import com.example.fuelfinder.R
import com.example.fuelfinder.data.place.Place
import com.example.fuelfinder.data.place.PlaceResponse
import com.example.fuelfinder.data.place.toPlace
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.io.InputStreamReader

class PlacesReader(private val context: Context){
    private val gson = Gson()

    private val inputStream: InputStream get() =
        context.resources.openRawResource(R.raw.places)

    fun read(): List<Place>{
        val placeType = object : TypeToken<List<PlaceResponse>>() {}.type
        //read places from json??
        val read = InputStreamReader(inputStream)
        //map to DTO
        return gson
            .fromJson<List<PlaceResponse>>(read,placeType)
            .map { it.toPlace() }
    }
}