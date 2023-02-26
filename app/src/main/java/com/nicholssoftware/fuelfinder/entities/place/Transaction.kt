package com.nicholssoftware.fuelfinder.entities.place

data class Transaction(val id: Int, val amount: Double, val tax: Double, val name: String, val address: String)
