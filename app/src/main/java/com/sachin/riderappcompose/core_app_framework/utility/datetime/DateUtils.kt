package com.apnamart.apnarider.core_app_framework.utility.datetime


import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import java.util.concurrent.TimeUnit
import kotlin.math.abs


const val DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd"
const val DATE_FORMAT_YYYY_MM_DD_HUMAN = "dd MMM yyyy"
const val DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss"

const val DATE_FORMAT_DD_MM_YY = "ddMMyy"
const val DATE_FORMAT_HH_MM_SS = "HH:mm:ss"
const val DATE_FORMAT_HH_MM_AM_PM = "hh:mm a"
const val FORMAT_DATE_SLOT = "EEE, dd MMM"
const val DATE_FORMAT_ISO = "yyyy-MM-dd'T'HH:mm:ss'Z'"
const val DATE_FORMAT_YYYY_MM_DD_HH_MM_AM_PM = "dd MMM yyyy hh:mm a"
const val DATE_FORMAT_DD_MM_YYYY_SLASH = "dd/MM/yyyy"



fun getDateFromFormattedString(dateStr: String?, format: String): Date? {
    if (dateStr == null) return null
    val df = SimpleDateFormat(format, Locale.getDefault())
    df.timeZone = TimeZone.getTimeZone("GMT")
    return try {
        df.parse(dateStr)
    } catch (e: ParseException) {
        e.printStackTrace()
        null
    }
}

fun getFormattedDate(date: Date?, format: String): String {
    if (date == null) return "Invalid Date"
    val df = SimpleDateFormat(format, Locale.getDefault())
    df.timeZone = TimeZone.getDefault()
    return df.format(date)
}


fun getDateFromFormattedStringWithoutTimezone(dateStr: String?, format: String): Date? {
    if (dateStr == null) return null
    val df = SimpleDateFormat(format, Locale.getDefault())
    return try {
        df.parse(dateStr)
    } catch (e: ParseException) {
        e.printStackTrace()
        null
    }
}

fun getFormattedDateWithoutTimeZone(date: Date?, format: String): String {
    if (date == null) return "Invalid Date"
    val df = SimpleDateFormat(format, Locale.getDefault())
    return df.format(date)
}

fun getFormattedDateFromString(dateStr: String?, inputFormat: String, outputFormat: String): String {
    return getFormattedDate(getDateFromFormattedString(dateStr, inputFormat), outputFormat)
}

fun getCurrentTimeLong(): Long {
    return Date().time
}

 fun getCurrentTimeStamp() : Date {
     return Calendar.getInstance().time
 }


fun isCurrentTimeInBetween(startTime : String, endTime : String) : Boolean{
    val sdf =  SimpleDateFormat("HH:mm:ss")
    val currentTime = sdf.parse(sdf.format(Date()))
    val start = sdf.parse(startTime)
    val end = sdf.parse(endTime)
    return try {
        currentTime?.before(end) == true && currentTime.after(start)
    } catch (e :ParseException ) {
        true
    }
}


fun getMonthFromDate(date: Date): Int {
    val calendar = Calendar.getInstance()
    calendar.time = date
    return calendar.get(Calendar.MONTH) + 1
}

fun getYearFromDate(date: Date): Int {
    val calendar = Calendar.getInstance()
    calendar.time = date
    return calendar.get(Calendar.YEAR)
}

fun convertTo12Hours(militaryTime: String): String?{
    val inputFormat = SimpleDateFormat("hh:mm:ss", Locale.getDefault())
    val outputFormat = SimpleDateFormat("hh:mm aa", Locale.getDefault())
    val date = inputFormat.parse(militaryTime)
    return date?.let { outputFormat.format(it) }
}

fun getDayFromDate(date: Date): Int {
    val calendar = Calendar.getInstance()
    calendar.time = date
    return calendar.get(Calendar.DAY_OF_MONTH)
}

fun setDate(param : Int, value : Int): Date {
    val calendar = Calendar.getInstance()
    calendar.set(param, value)
    return calendar.time
}

fun addDate(param : Int, value : Int): Date {
    val calendar = Calendar.getInstance()
    calendar.add(param, value)
    return calendar.time
}

fun getFormattedDateFromLong(time: Long, format: String): String {
    val date = Date(time)
    val df = SimpleDateFormat(format, Locale.getDefault())
    return df.format(date)
}


fun getTimeDifference(timestampOne : Long, timestampTwo: Long): String {
    val difference= abs(timestampOne - timestampTwo)

    val days = TimeUnit.MILLISECONDS.toDays(difference)
    val hours = TimeUnit.MILLISECONDS.toHours(difference) % 24
    val minutes = TimeUnit.MILLISECONDS.toMinutes(difference) % 60
    val seconds =TimeUnit.MILLISECONDS.toSeconds(difference) % 60

    return when {
        days > 0 -> String.format("%d days, %d hours", days, hours)
        hours > 0 -> String.format("%d hours, %d minutes", hours, minutes)
        minutes > 0 -> String.format("%d minutes, %d seconds", minutes, seconds)
        else -> String.format("%d seconds", seconds)
    }
}

