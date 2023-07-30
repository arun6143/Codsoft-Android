package com.arun.notificationapp

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.arun.notificationapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Define a notification channel (required for Android 8.0 and above)
        val CHANNEL_ID = "notification_channel"
        val CHANNEL_NAME = "Notification Channel"

        // Create an intent for the notification
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        // Build the notification
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification) // Replace with your app's icon
            .setContentTitle("NOTIFICATION") // Replace with your title
            .setContentText("notification runs") // Replace with your message
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        // Display the notification
        with(NotificationManagerCompat.from(this)) {
            // Create the notification channel for Android 8.0 and above
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                channel.description = "Notification Channel Description"
                channel.enableLights(true)
                channel.lightColor = Color.RED
                createNotificationChannel(channel)
            }

            if (ActivityCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling ActivityCompat#requestPermissions here to request the missing permissions
                return
            }
            notify(1, builder.build()) // Use a unique notification ID
        }
    }
}
