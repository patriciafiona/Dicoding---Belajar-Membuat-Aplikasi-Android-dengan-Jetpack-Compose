package com.patriciafiona.subway.utils

import java.text.NumberFormat
import java.util.*

object Utils {
    fun toRupiah(number: Double): String{
        val localeID =  Locale("in", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)
        return numberFormat.format(number).toString()
    }
}