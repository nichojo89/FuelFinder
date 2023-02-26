package com.nicholssoftware.fuelfinder.presentation

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nicholssoftware.fuelfinder.R
import com.nicholssoftware.fuelfinder.entities.place.Transaction
import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatterBuilder
import java.util.*

class TransactionAdapter(private val transactions: List<Transaction>, private val onClickListener: AdapterView.OnItemClickListener) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    class ViewHolder(transactionView: View): RecyclerView.ViewHolder(transactionView) {
        val tvAmount: TextView = itemView.findViewById(R.id.tvTransactionAmount)
        val tvDate: TextView = itemView.findViewById(R.id.tvTransactionDate);
        val card: CardView = itemView.findViewById(R.id.cvTransaction);
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private val _dateTimeFormatter = DateTimeFormatterBuilder()
        .parseCaseInsensitive() // add pattern
        .appendPattern("MM/DD, hh:mm a")
        .toFormatter(Locale.ENGLISH)

    private val _currencyFormatter = NumberFormat.getCurrencyInstance()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_card,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = transactions.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.tvAmount.text = _currencyFormatter.format(transaction.amount)
        holder.tvDate.text  = transaction.date.format(_dateTimeFormatter)

        holder.card.setOnClickListener {
            onClickListener.onItemClick(null,null,position,-1)
        }
    }
}