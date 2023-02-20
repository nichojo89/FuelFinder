package com.nicholssoftware.fuelfinder.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nicholssoftware.fuelfinder.R
import com.nicholssoftware.fuelfinder.entities.place.Place

class FuelPointAdapter(private val mList: List<Place>, private val onClickListener: AdapterView.OnItemClickListener) : RecyclerView.Adapter<FuelPointAdapter.ViewHolder>() {
    class ViewHolder(fuelPointView: View) : RecyclerView.ViewHolder(fuelPointView){
        val tvName: TextView = itemView.findViewById(R.id.tvFuelPointName)
        val tvAddress: TextView = itemView.findViewById(R.id.tvAddress)
        val card: CardView = itemView.findViewById(R.id.cvFuelPoint);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fuel_point_card, parent,false);

        return ViewHolder(view);
    }

    override fun getItemCount(): Int =
        mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fuelPoint = mList[position]

        holder.tvName.text = fuelPoint.name
        holder.tvAddress.text = fuelPoint.address
        holder.card.setOnClickListener {
            onClickListener.onItemClick(null,null,position,-1)
        }
    }
}