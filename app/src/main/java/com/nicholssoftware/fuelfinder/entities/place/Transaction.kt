package com.nicholssoftware.fuelfinder.entities.place

import android.os.Build
import android.os.Build.VERSION_CODES.O
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
@RequiresApi(O)
data class Transaction @RequiresApi(Build.VERSION_CODES.O) constructor(val id: Int, val amount: Double, val tax: Double, val name: String, val address: String,
                                                                       val pricePerGallon: Double,
                                                                       val pumpNumber: Int,
                                                                       val fuelGrade: String,
                                                                       val date: LocalDateTime = LocalDateTime.now(ZoneId.systemDefault()))
