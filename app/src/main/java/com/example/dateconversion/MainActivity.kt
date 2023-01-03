package com.example.dateconversion

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope


class MainActivity : AppCompatActivity() {
    //var date1 = "01-02-2022T07:53:51"
    var date1 = "2022-02-13T00:10:00"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(NotificationViewModel::class.java)

        var myText: TextView = findViewById(R.id.text1)

        var timerText: TextView = findViewById(R.id.welcomeFormatText)

        val spinner: Spinner = findViewById(R.id.planets_spinner)

        viewModel.createTimer()
        viewModel.elapsedTime.observe(this) {
            timerText.text = it.toString()
        }

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
                            //viewModel.startTimer(4)
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

        createChannel(
            getString(R.string.egg_notification_channel_id),
            getString(R.string.egg_notification_channel_name)
        )
    }
    private fun createChannel(channelId: String, channelName: String) {
        // TODO: Step 1.6 START create a channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId,
                channelName,
                // TODO: Step 2.4 change importance
                NotificationManager.IMPORTANCE_HIGH
            )
            // TODO: Step 2.6 disable badges for this channel

            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.description = "Time for breakfast"

            val notificationManager = this@MainActivity.getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(notificationChannel)

        }

    }
}













