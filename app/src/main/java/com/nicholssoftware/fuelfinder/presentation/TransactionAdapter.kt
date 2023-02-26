package com.nicholssoftware.fuelfinder.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nicholssoftware.fuelfinder.R
import com.nicholssoftware.fuelfinder.entities.place.Transaction

class TransactionAdapter(private val transactions: List<Transaction>, private val onClickListener: AdapterView.OnItemClickListener) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    class ViewHolder(transactionView: View): RecyclerView.ViewHolder(transactionView) {
        val tvName: TextView = itemView.findViewById(R.id.tvTransactionName)
        val tvAddress: TextView = itemView.findViewById(R.id.tvTransactionAddress)
        val tvAmount: TextView = itemView.findViewById(R.id.tvTransactionAmount)
        val tvTax: TextView = itemView.findViewById(R.id.tvTransactionTax)
        val tvTotal: TextView = itemView.findViewById(R.id.tvTransactionTotal)
        val card: CardView = itemView.findViewById(R.id.cvTransaction);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_card,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = transactions.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.tvAddress.text =transaction.address
        holder.tvName.text = transaction.name;
        holder.tvAmount.text = transaction.amount.toString()
        holder.tvTax.text = transaction.tax.toString()
        holder.tvTotal.text = (transaction.amount + transaction.tax).toString()
        holder.card.setOnClickListener {
            onClickListener.onItemClick(null,null,position,-1)
        }
    }
}