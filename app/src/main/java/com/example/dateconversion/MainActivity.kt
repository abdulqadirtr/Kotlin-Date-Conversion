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
    var date1 = "2022-02-13T00:10:00"

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myText: TextView = findViewById(R.id.text1)

        val spinner: Spinner = findViewById(R.id.planets_spinner)

        var formattedDate = date1.formatStringDate(DateFormats.DEFAULT_FORMAT_WITHOUT_TIME.format,DateFormats.DEFAULT_FORMAT.format)

        ArrayAdapter.createFromResource(
            this,
            R.array.format_date,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter


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
                                dayMonth.convertDefaultWithoutTime(DateFormats.DEFAULT_FORMAT.format)
                                    .toString()
                            myText.text = dayMonth
                        }
                        2 -> {
                            var trimhour = date1
                            trimhour =
                                trimhour.convertDateToYMDFullTimeDate(DateFormats.DEFAULT_FORMAT.format).toString()
                            myText.text = trimhour
                        }
                        3 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToYMDFullTimeDate(DateFormats.DEFAULT_FORMAT.format)
                                .toString()
                            myText.text = timeAMPM
                        }
                        4 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.trimTimeFromDateMDY(
                                DateFormats.DEFAULT_FORMAT.format,
                            ).toString()
                            myText.text = timeAMPM
                        }

                        5 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToDMYFullTimeDate(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }
                        6 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToYMD(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }

                        7 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToMonthNameYear(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }

                        8 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToWeekNameYear(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }

                        9 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateMonthName(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }
                        10 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateCustom(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }
                        11 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToAmPm(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }
                    }
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }

    }
}













