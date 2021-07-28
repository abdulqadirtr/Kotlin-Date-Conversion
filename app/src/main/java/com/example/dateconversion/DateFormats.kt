package com.example.dateconversion

enum class DateFormats(val format: String) {
    DEFAULT_FORMAT("yyyy-MM-dd'T'HH:mm:ss'Z'"), //2021-05-20T11:28:24Z
    DEFAULT_FORMAT_WITHOUT_TIME("yyyy-MM-dd"), //2021-05-20
    DEFAULT_TRANSACTION_FORMAT("yyyy-MM-dd'T'HH:mm"), //2021-05-20T11:28
    TRANSACTION_FILTER_FORMAT("yyyy-MM-dd'T'HH:mm:ss"), //2021-05-20T11:28:24
    MATURITY_DATE_FORMAT("MMM dd, yyyy"), //May 20, 2021
    DEPOSIT_FORMAT("yyyy-MM-dd'T'HH:mm:ss"), //2021-05-20T11:28:24
    DEPOSIT_FORMAT2("dd-MM-yyyy'T'HH:mm:ss"), //2021-05-20T11:28:24
    STATEMENT_FORMAT("yyyy-MM-dd"), //2021-05-20
    TRAFFIC_FINE_RESPONSE_FORMAT("yyyy-MM-dd"), //2021-05-20
    TRAFFIC_FINE_TEXT_FORMAT("d MMMM, yyyy"), //20 May, 2021
    EXECUTE_PAYMENT_FORMAT("EEE, d MMM"), //Thu, 20 May
    DAY_MONTH_ONLY_FORMAT("d MMM"), // 20 MAY
    QUEUE_TICKET_DATE_FORMAT("dd.MM.yyyy' - ' HH:mm:ss"), //21.06.2021 - 10:10:18
    DATE_MONTH_YEAR_WITH_DOTS_FORMAT("dd.MM.yyyy"), //21.06.2021 - 10:10:18
    QUEUE_TICKET_INPUT_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSS") //2021-06-21T08:34:26.406574
}