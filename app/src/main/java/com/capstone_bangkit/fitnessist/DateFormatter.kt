package com.capstone_bangkit.fitnessist

import org.threeten.bp.Instant
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

object DateFormatter {
    fun formatDate(currentDateString: String?, targetTimeZone: String): String {
        val instant = Instant.parse(currentDateString)
        val zoneId = ZoneId.of(targetTimeZone)
        val zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId)
        val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy | HH:mm")
        return formatter.format(zonedDateTime)
    }
}