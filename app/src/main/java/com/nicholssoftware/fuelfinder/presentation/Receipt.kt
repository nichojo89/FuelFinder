package com.nicholssoftware.fuelfinder.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nicholssoftware.fuelfinder.R
import kotlinx.android.synthetic.main.activity_receipt.*

const val TOTAL_AMOUNT = "TOTAL_AMOUNT"
const val TOTAL_TAX = "TOTAL_TAX"
const val TRANSACTION_DATE = "TRANSACTION_DATE"
const val PUMP_NUMBER = "PUMP_NUMBER"
const val FUEL_GRADE = "FUEL_GRADE"
const val PRICE_PER_GALLON = "PRICE_PER_GALLON"
class Receipt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)
        val name = intent.getStringExtra(PLACE_NAME)
        val address = intent.getStringExtra(PLACE_ADDRESS)
        val pumpNumber = intent.getIntExtra(PUMP_NUMBER,0)
        val fuelGrade = intent.getStringExtra(FUEL_GRADE)
        val ppg = intent.getDoubleExtra(PRICE_PER_GALLON,0.0)
        val total = intent.getDoubleExtra(TOTAL_AMOUNT,0.0)
        tvName.text = name
        tvMerchant.text = name
        tvAddress.text = address
        tvReceiptAddress.text = address
        tvPumpNumber.text = pumpNumber.toString()
        tvFuelGrade.text = fuelGrade
        tvPPG.text = ppg.toString()
        tvTotal.text = total.toString()
    }
}