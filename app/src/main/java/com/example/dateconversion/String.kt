package com.example.dateconversion
import android.text.format.DateUtils
import android.util.Log
import android.util.Patterns
import java.text.SimpleDateFormat
import java.util.*
fun String.convertDefaultWithoutTime(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DEFAULT_FORMAT_WITHOUT_TIME.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToYMDTime(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_TIME_YY_MM_FULL_TIME_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String?.formatStringDate(inputFormat : String, outputFormat : String) : String {
    return if (this.isNullOrEmpty()){
        ""
    }else{
        val dateFormatter = SimpleDateFormat(inputFormat, Locale.getDefault())
        val date = dateFormatter.parse(this)
        date?.let { SimpleDateFormat(outputFormat, Locale.getDefault()).format(it) }.orEmpty()
    }
}

fun String.convertDateToYMDFullTimeDate(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_TIME_YY_MM_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}


fun String.trimTimeFromDateMDY(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val trimmed = SimpleDateFormat(DateFormats.DATE_MM_DD_YY_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { trimmed.format(parsedDate) }
}

fun String.convertDateToDMYFullTimeDate(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.FULL_DATE_TIME_DD_MM_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToYMD(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_YY_MM_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToMonthNameYear(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_MONTH_OF_YEAR_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToWeekNameYear(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DAY_OF_WEEK_MONTH_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}
fun String.convertDateMonthName(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_MONTH_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateCustom(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_TIME_FORMAT_CUSTOM_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToAmPm(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

