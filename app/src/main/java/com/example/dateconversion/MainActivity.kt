package com.example.dateconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.AdapterView

import android.view.View

import android.widget.AdapterView.OnItemSelectedListener




class MainActivity : AppCompatActivity() {
    var date1 = "13-02-2017T07:53:51"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myText : TextView = findViewById(R.id.text1)


        val spinner: Spinner = findViewById(R.id.planets_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
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
                   if(position == 1){
                       var dayMonth = date1
                       dayMonth = dayMonth.convertDateToDayMonth(DateFormats.DEFAULT_FORMAT_WITHOUT_TIME.format).toString()
                       myText.text = dayMonth
                   }
                    else if(position == 2){
                        var trimhour = date1
                       trimhour = trimhour.trimHourFromDate(DateFormats.DEPOSIT_FORMAT2.format).toString()
                       myText.text = trimhour
                   }
                   else if(position == 3){
                       var timeAMPM = date1
                       timeAMPM = timeAMPM.convertDateToAmPm(DateFormats.DEPOSIT_FORMAT2.format).toString()
                       myText.text = timeAMPM
                   }

                   else if(position == 3){
                       var timeAMPM = date1
                       timeAMPM = timeAMPM.convertDateToDMYWithCommaSeparator(DateFormats.DEPOSIT_FORMAT2.format, ",").toString()
                       myText.text = timeAMPM
                   }

                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }

    }
}