package com.example.dateconversion

enum class DateFormats(val format: String) {
    DEFAULT_FORMAT("yyyy-MM-dd'T'HH:mm:ss"), //2021-05-20T11:28:24Z


    DEFAULT_FORMAT_WITHOUT_TIME("yyyy-MM-dd"), //2021-05-20
    DATE_TIME_YY_MM_FORMAT("yyyy-MM-dd'T'HH:mm"), //2021-05-20T11:28
    DATE_TIME_YY_MM_FULL_TIME_FORMAT("yyyy-MM-dd'T'HH:mm:ss"), //2021-05-20T11:28
    DATE_MM_DD_YY_FORMAT("MM-dd-yyyy"), //05-20-2021
    DATE_MM_DD_FORMAT("MMM dd, yyyy"), //May 20, 2021
    FULL_DATE_TIME_DD_MM_FORMAT("dd-MM-yyyy'T'HH:mm:ss"), //2021-05-20T11:28:24
    DATE_YY_MM_FORMAT("yyyy-MM-dd"), //2021-05-20
    DATE_MONTH_OF_YEAR_FORMAT("d MMMM, yyyy"), //20 May, 2021
    DAY_OF_WEEK_MONTH_FORMAT("EEE, d MMM"), //Thu, 20 May
    DATE_MONTH_FORMAT("d MMM"), // 20 MAY
    DATE_TIME_FORMAT_CUSTOM_FORMAT("dd.MM.yyyy' - ' HH:mm:ss"), //21.06.2021 - 10:10:18
    TIME_AM_PM_FORMAT("hh:mm a"), // 10:10:18 hh:mm aa
}