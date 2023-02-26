package com.nicholssoftware.fuelfinder.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicholssoftware.fuelfinder.R
import com.nicholssoftware.fuelfinder.databinding.ActivityFuelPointDetailsBinding
import com.nicholssoftware.fuelfinder.framework.TransactionRepository
import com.nicholssoftware.fuelfinder.presentation.TransactionAdapter

const val PLACE_ADDRESS = "PLACE_ADDRESS"
const val PLACE_NAME = "PLACE_NAME"

class FuelPointDetails : AppCompatActivity() {

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
                val intent = Intent(this,Receipt::class.java)
                startActivity(intent)
            }
        rv.adapter = TransactionAdapter(transactions,onClickListener)
    }

}