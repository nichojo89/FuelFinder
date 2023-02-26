package com.nicholssoftware.fuelfinder.framework

import com.nicholssoftware.fuelfinder.entities.place.Place
import com.nicholssoftware.fuelfinder.entities.place.Transaction

class TransactionRepository {
    fun getTransactionsForPlace(place: Place): List<Transaction>
    = listOf(
        Transaction(1,20.00,1.20,place),
        Transaction(1,40.00,2.40,place),
        Transaction(1,60.00,3.60,place),
        Transaction(1,80.00,4.80,place),
        Transaction(1,100.00,6.00,place),
    )
}