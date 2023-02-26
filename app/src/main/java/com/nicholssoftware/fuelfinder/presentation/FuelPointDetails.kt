package com.nicholssoftware.fuelfinder.presentation

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicholssoftware.fuelfinder.R
import com.nicholssoftware.fuelfinder.databinding.ActivityFuelPointDetailsBinding
import com.nicholssoftware.fuelfinder.framework.TransactionRepository
import com.nicholssoftware.fuelfinder.presentation.TransactionAdapter

const val PLACE_ADDRESS = "PLACE_ADDRESS"
const val PLACE_NAME = "PLACE_NAME"

class FuelPointDetails : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fuel_point_details)
        val name = intent.getStringExtra(PLACE_NAME)!!
        val address = intent.getStringExtra(PLACE_ADDRESS)!!
        findViewById<TextView>(R.id.tvName).text = name
        findViewById<TextView>(R.id.tvAddress).text = address
        //get fake repo
        //TODO this should use HILT for dependency injection of repository
        val repo = TransactionRepository()
        val transactions = repo.getTransactionsForPlace(name,address)


        val rv = findViewById<RecyclerView>(R.id.rvTransactions)
        rv.layoutManager = LinearLayoutManager(this)

        val onClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                //name,address,phone||Transaction
                val intent = Intent(this,Receipt::class.java)

                val bundle = Bundle()
                val transaction = transactions[position]
                bundle.putString(PLACE_NAME,transaction.name)
                bundle.putString(PLACE_ADDRESS,transaction.address)
                bundle.putInt(PUMP_NUMBER,transaction.pumpNumber)
                bundle.putString(FUEL_GRADE, transaction.fuelGrade)
                bundle.putDouble(PRICE_PER_GALLON, transaction.pricePerGallon)
                val total = transaction.tax + transaction.amount
                bundle.putDouble(TOTAL_AMOUNT, total)
                intent.putExtras(bundle)

                startActivity(intent)
            }
        rv.adapter = TransactionAdapter(transactions,onClickListener)
    }
}