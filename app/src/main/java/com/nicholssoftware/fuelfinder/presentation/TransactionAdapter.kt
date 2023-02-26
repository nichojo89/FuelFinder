package com.nicholssoftware.fuelfinder.presentation

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nicholssoftware.fuelfinder.entities.place.Transaction

class TransactionAdapter(private val transactions: List<Transaction>) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    class ViewHolder(transactionView: View): RecyclerView.ViewHolder(transactionView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}