package com.example.cardofferrecord.util

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(time: Date): String {
    val format = SimpleDateFormat("dd/MM/yyyy",
        Locale.getDefault())
    return format.format(time)
}