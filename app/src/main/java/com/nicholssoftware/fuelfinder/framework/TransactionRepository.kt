package com.nicholssoftware.fuelfinder.framework

import android.os.Build
import androidx.annotation.RequiresApi
import com.nicholssoftware.fuelfinder.entities.place.Place
import com.nicholssoftware.fuelfinder.entities.place.Transaction

class TransactionRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getTransactionsForPlace(name: String, address: String): List<Transaction>
    = listOf(
        Transaction(1,20.00,1.20,name,address,6.89,3,"Diesel"),
        Transaction(1,40.00,2.40,name,address, 6.12,5,"Diesel"),
        Transaction(1,60.00,3.60,name,address, 6.69,6,"Diesel"),
        Transaction(1,80.00,4.80,name,address,6.89,1,"Diesel"),
        Transaction(1,100.00,6.00,name,address, 6.22,5,"Diesel"),
    )
}