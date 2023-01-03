package com.example.dateconversion.utils

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.example.dateconversion.MainActivity
import com.example.dateconversion.R

// Notification ID.
private val NOTIFICATION_ID = 0
private val REQUEST_CODE = 0
private var FLAGS : Int = 0


fun NotificationManager.sendNotification(message : String, applicationContext: Context){

    val contentIntent = Intent(applicationContext, MainActivity::class.java)

    // NotificationUtils.kt
    // TODO: Step 1.12 create PendingIntent
    val contentPendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )

    val eggImage = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.cooked_egg)
    val bigPictureStyle = NotificationCompat.BigPictureStyle()
        .bigPicture(eggImage)
        .bigLargeIcon(null)

    val builder = NotificationCompat.Builder(applicationContext,
        applicationContext.getString(R.string.egg_notification_channel_id))
        .setSmallIcon(R.drawable.cooked_egg)
        .setContentTitle(applicationContext.getString(R.string.notification_title))
        .setContentText(applicationContext.getString(R.string.notification_text))
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true)
        .setStyle(bigPictureStyle)
        .setLargeIcon(eggImage)
        .setPriority(NotificationCompat.PRIORITY_HIGH)





    notify(NOTIFICATION_ID, builder.build())

}