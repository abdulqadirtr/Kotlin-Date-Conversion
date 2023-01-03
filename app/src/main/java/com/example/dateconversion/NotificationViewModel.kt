package com.example.dateconversion

import android.app.AlarmManager
import android.app.Application
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.CountDownTimer
import android.os.SystemClock
import androidx.core.app.AlarmManagerCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dateconversion.receiver.AlarmReceiver
import com.example.dateconversion.utils.sendNotification
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotificationViewModel(private val app: Application): AndroidViewModel(app) {

    private val REQUEST_CODE = 0
    private val TRIGGER_TIME = "TRIGGER_AT"

    private lateinit var timer: CountDownTimer

    private val minute: Long = 60_000L
    private val second: Long = 1_000L

    private val alarmManager = app.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    private var prefs =
        app.getSharedPreferences("com.example.android.eggtimernotifications", Context.MODE_PRIVATE)
    private val notifyIntent = Intent(app, AlarmReceiver::class.java)

    private val _timeSelection = MutableLiveData<Int>()
    val timeSelection: LiveData<Int>
        get() = _timeSelection

    private val _elapsedTime = MutableLiveData<Long>()
    val elapsedTime: LiveData<Long>
        get() = _elapsedTime

    private var _alarmOn = MutableLiveData<Boolean>()
    val isAlarmOn: LiveData<Boolean>
        get() = _alarmOn



    /**
     * Creates a new alarm, notification and timer
     */
     fun startTimer(timerLengthSelection: Int) {
        // TODO: Step 1.5 get an instance of NotificationManager and call sendNotification
        val notificationManager = ContextCompat.getSystemService(
            getApplication(),
            NotificationManager::class.java
        ) as NotificationManager
        notificationManager.sendNotification(app.getString(R.string.timer_running), app)

    }

    fun createTimer(){
        var triggerTimer = 20000L
        viewModelScope.launch {
            timer = object : CountDownTimer(triggerTimer, 1000){
                override fun onTick(milliSeconds: Long) {
                    _elapsedTime.value = milliSeconds / 1000
                }

                override fun onFinish() {
                    val notificationManager = ContextCompat.getSystemService(
                        getApplication(),
                        NotificationManager::class.java
                    ) as NotificationManager
                    notificationManager.sendNotification(app.getString(R.string.timer_running), app)
                    timer.cancel()
                }
            }
            timer.start()
        }
    }

}