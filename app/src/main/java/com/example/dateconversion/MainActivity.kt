package com.example.dateconversion

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.AdapterView

import android.view.View

import android.widget.AdapterView.OnItemSelectedListener
import androidx.annotation.RequiresApi
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY


class MainActivity : AppCompatActivity() {
    //var date1 = "01-02-2022T07:53:51"
    var date1 = "2022-02-13T00:00:00"
    //2022-01-26T00:00:00
    //2022-01-26
    var username = "qadirabdul20@yahoo.com"
    var mailCount = "this format"

    //format string
    var usernameFormate = "qadirabdul20@yahoo.com"
    var mailCountFormate = 10

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myText: TextView = findViewById(R.id.text1)


        var formatTextValue: TextView = findViewById(R.id.welcomeFormatText)

        val spinner: Spinner = findViewById(R.id.planets_spinner)

        var mytext = getString(R.string.welcome_messages2, usernameFormate, mailCountFormate)

        //for escape character

        val styledText: Spanned = Html.fromHtml(mytext, FROM_HTML_MODE_LEGACY)

        formatTextValue.text = styledText

       // for yesterday and today first we need to formate the date, our date date1 is already in correct format
        //if not we can format the date as below
         var formattedDate = date1.formatStringDate(DateFormats.DEFAULT_FORMAT_WITHOUT_TIME.format,DateFormats.TRANSACTION_FILTER_FORMAT.format)
         var isTodayYesterday = date1.getYesterdayToday(date1, DateFormats.TRANSACTION_FILTER_FORMAT.format)



        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter

      //TODO date part needs for future
            //to remove dublicate date to show only single date like in messenger


      /*      for (claim in customerClaimList) {
                if (claim.creationDate.equals(customerClaim.creationDate) || claim.equals(customerClaim)) {
                    isFound = true
                    break
                }
            }
            if (!isFound) {
                customerClaimList.add(Claim(customerClaim.allowFeedback, customerClaim.caseId, customerClaim.caseStatus, customerClaim.category, customerClaim.creationDate, formattedDateTime, customerClaim.creationTime, customerClaim.customerNumber, customerClaim.description))
            }
            else
                customerClaimList.add(Claim(customerClaim.allowFeedback, customerClaim.caseId, customerClaim.caseStatus, customerClaim.category, "", formattedDateTime, customerClaim.creationTime, customerClaim.customerNumber, customerClaim.description))
        }
        if (customerClaimList.find {
                it.creationDate == customerClaim.creationDate
            } != null) {
            isFound = true
        }

        customerClaimList.add(Claim(customerClaim.allowFeedback, customerClaim.caseId, customerClaim.caseStatus, customerClaim.category,  when(isFound) {true -> "" false -> customerClaim.creationDate }, formattedDateTime, customerClaim.creationTime, customerClaim.customerNumber, customerClaim.description))
*/

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(
                    parentView: AdapterView<*>?,
                    selectedItemView: View,
                    position: Int,
                    id: Long
                ) {
                    myText.text = date1
                    when (position) {
                        1 -> {
                            var dayMonth = date1
                            dayMonth =
                                dayMonth.convertDateToDayMonth(DateFormats.DEFAULT_FORMAT_WITHOUT_TIME.format)
                                    .toString()
                            myText.text = dayMonth
                            formatTextValue.text =
                                getString(R.string.welcome_messages, myText.text, mailCount)
                        }
                        2 -> {
                            var trimhour = date1
                            trimhour =
                                trimhour.trimHourFromDate(DateFormats.DEPOSIT_FORMAT2.format).toString()
                            myText.text = trimhour
                            formatTextValue.text =
                                getString(R.string.welcome_messages, myText.text, mailCount)
                        }
                        3 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToAmPm(DateFormats.DEPOSIT_FORMAT2.format)
                                .toString()
                            myText.text = timeAMPM
                        }
                        4 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToDMYWithCommaSeparator(
                                DateFormats.DEPOSIT_FORMAT2.format,
                                ","
                            ).toString()
                            myText.text = timeAMPM
                            formatTextValue.text =
                                getString(R.string.welcome_messages, myText, mailCount)
                        }
                        5 -> {
                            //check if date is today or yesterday
                            when(isTodayYesterday) {
                                TODAY -> {
                                    myText.text = TODAY
                                }
                                YESTERDAY -> {
                                    myText.text = YESTERDAY
                                }
                            }
                            formatTextValue.text =
                                getString(R.string.welcome_messages, myText.toString(), mailCount)
                        }
                    }


                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }

    }
    companion object {
        private const val TODAY = "today"
        private const val YESTERDAY = "yesterday"
    }
}