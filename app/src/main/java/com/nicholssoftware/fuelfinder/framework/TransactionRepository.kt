package com.nicholssoftware.fuelfinder.framework

import com.nicholssoftware.fuelfinder.entities.place.Place
import com.nicholssoftware.fuelfinder.entities.place.Transaction

class TransactionRepository {
    fun getTransactionsForPlace(name: String, address: String): List<Transaction>
    = listOf(
        Transaction(1,20.00,1.20,name,address),
        Transaction(1,40.00,2.40,name,address),
        Transaction(1,60.00,3.60,name,address),
        Transaction(1,80.00,4.80,name,address),
        Transaction(1,100.00,6.00,name,address),
    )
}