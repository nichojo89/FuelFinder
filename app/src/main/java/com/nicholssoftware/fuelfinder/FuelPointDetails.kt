package com.nicholssoftware.fuelfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.nicholssoftware.fuelfinder.databinding.ActivityFuelPointDetailsBinding

const val PLACE_ADDRESS = "PLACE_ADDRESS"
const val PLACE_NAME = "PLACE_NAME"

class FuelPointDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuel_point_details)

        findViewById<TextView>(R.id.tvName).text = intent.getStringExtra(PLACE_NAME)
        findViewById<TextView>(R.id.tvAddress).text = intent.getStringExtra(PLACE_ADDRESS)
    }

}