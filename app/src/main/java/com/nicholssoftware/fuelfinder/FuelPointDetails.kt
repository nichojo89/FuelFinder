package com.nicholssoftware.fuelfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val PLACE_ADDRESS = "PLACE_ADDRESS"
const val PLACE_LATLNG = "PLACE_LATLNG"
const val PLACE_NAME = "PLACE_NAME"
const val PLACE_RATING = "PLACE_RATING"
const val PLACE_POSITION = "PLACE_POSITION"
const val PLACE_SNIPPET = "PLACE_SNIPPET"
const val PLACE_TITLE = "PLACE_TITLE"

class FuelPointDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val address = intent.getStringExtra(PLACE_ADDRESS)
//        val latlng = savedInstanceState!!.get(PLACE_LATLNG)
        val name = intent.getStringExtra(PLACE_NAME)
        val rating = intent.getFloatExtra(PLACE_RATING,0F)
        val position = intent.getStringExtra(PLACE_POSITION)
        val snippet = intent.getStringExtra(PLACE_SNIPPET)
        val title = intent.getStringExtra(PLACE_TITLE)

        setContentView(R.layout.activity_fuel_point_details)
    }
}