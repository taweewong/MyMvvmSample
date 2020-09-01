package com.taweewong.mymvvmsample.extension

import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter

fun String?.formatDate(outputFormat: String): String? {
    return try {
        val instant = Instant.parse(this)
        val outputFormatter = DateTimeFormatter.ofPattern(outputFormat)
        val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        localDateTime.format(outputFormatter)
    } catch (ex: Exception) {
        ex.printStackTrace()
        this
    }
}