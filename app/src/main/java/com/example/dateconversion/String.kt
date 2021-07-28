package com.example.dateconversion
import android.util.Patterns
import java.text.SimpleDateFormat
import java.util.*

fun String.times(count: Int): String {
    val builder = StringBuilder()
    for (i in 0 until count) {
        builder.append(this)
    }
    return builder.toString()
}

fun String.checkLength(): Boolean = length in 8..16

fun String.checkIncludesOneLowercaseLetter(): Boolean = "^(.*[a-z].*)$".toRegex().matches(this)

fun String.checkIncludesOneUppercaseLetter(): Boolean = "^(.*[A-Z].*)$".toRegex().matches(this)

fun String.checkIncludesOneNumber(): Boolean = "^(.*[0-9].*)\$".toRegex().matches(this)

fun String.checkIncludesBirthday(birthDate: String): Boolean {
    if (length < 4) return false
    return !contains(birthDate)
}

fun String.checkSameOrConsecutive(): Boolean {
    if (length < 4) return false
    val consecutiveRegex =
        "^.*(0123|1234|2345|3456|4567|5678|6789|3210|4321|5432|6543|7654|8765|9876|0000|1111|2222|3333|4444|5555|6666|7777|8888|9999).*\$".toRegex()
    return !consecutiveRegex.matches(this)
}

/**
 * Basic validation of IBAN with mod-97. If the IBAN is valid, remainder equals 1.
 * for more information: https://en.wikipedia.org/wiki/International_Bank_Account_Number#Algorithms
 */
fun String?.validateIban(): Boolean {
    if (this.isNullOrEmpty())
        return false

    val IBAN_MIN_SIZE = 15
    val IBAN_MAX_SIZE = 34
    val IBAN_MAX: Long = 999999999
    val IBAN_MODULUS: Long = 97

    val trimmed = replace(" ", "")
    if (trimmed.length < IBAN_MIN_SIZE || trimmed.length > IBAN_MAX_SIZE)
        return false

    val reformat = trimmed.substring(4) + trimmed.substring(0, 4)

    var total = 0L
    for (element in reformat) {
        val charValue = Character.getNumericValue(element)
        if (charValue < 0 || charValue > 35) {
            return false
        }
        total = (if (charValue > 9) total * 100 else total * 10) + charValue
        if (total > IBAN_MAX)
            total %= IBAN_MODULUS
    }

    return total % IBAN_MODULUS == 1L
}

fun String.nameValidation() = trim().contains(" ") && length > 4 && !contains("  ")

fun String?.mailValidation() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()


fun String?.formatStringDate(inputFormat : String, outputFormat : String) : String {
    return if (this.isNullOrEmpty()){
        ""
    }else{
        val dateFormatter = SimpleDateFormat(inputFormat, Locale.getDefault())
        val date = dateFormatter.parse(this)
        date?.let { SimpleDateFormat(outputFormat, Locale.getDefault()).format(it) }.orEmpty()
    }
}

fun String.convertDateToDayMonth(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat("dd MMM", Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToDMYWithDotSeperator(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToDMYWithCommaSeparator(inputFormat: String, conversionFormat: String): String? {
    val dateFormat = SimpleDateFormat(inputFormat, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(conversionFormat, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.trimHourFromDate(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val trimmed = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return parsedDate?.let { trimmed.format(parsedDate) }
}

fun String.trimTimeFromDate(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val trimmed = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    return parsedDate?.let { trimmed.format(parsedDate) }
}

fun String.convertDateToAmPm(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertTime(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat("hh:mm", Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun getTodayDate(format: String): String{
    val date = Calendar.getInstance().time
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    return dateFormat.format(date)
}

fun String.groupInFour():String {
    return replace("....(?!$)".toRegex(),"$0 ")
}

/**
 * Extension method that converts date for given format
 */
fun Date.formatToViewTime(customFormat: String = "dd MMMM yyyy"): String {
    val sdf = SimpleDateFormat(customFormat, Locale.getDefault())
    Calendar.getInstance().time
    return sdf.format(this)
}