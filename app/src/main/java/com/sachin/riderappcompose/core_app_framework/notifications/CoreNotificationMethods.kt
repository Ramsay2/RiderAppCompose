package com.apnamart.apnarider.core_app_framework.notifications

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.ServiceCompat.startForeground


fun <T> showNotification(
    context: Context,
    className: Class<T>,
    notificationChannel: String,
    title: String,
    content: String,
    smallIcon: Int,
    category: String,
    priority: Int,
    ongoing: Boolean = false
) {
    val notificationIntent = Intent(context, className)
    val pendingIntent: PendingIntent = if (SDK_INT >= Build.VERSION_CODES.M) {
        PendingIntent.getActivity(
            context,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    } else {
        PendingIntent.getActivity(
            context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )
    }
    val notification =
        NotificationCompat.Builder(context, notificationChannel).setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(smallIcon)
            .setContentIntent(pendingIntent)
            .setCategory(category)
            .setPriority(priority)
            .setOngoing(ongoing)
    with(NotificationManagerCompat.from(context)) {
        if (SDK_INT >= Build.VERSION_CODES.TIRAMISU
        ) {
            return
        }
        notify(System.currentTimeMillis().toInt(), notification.build())
    }
}

fun <T> launchActivity(
    context: Context,
    className: Class<T>,
    options: Bundle? = null,
    flags: Int = Intent.FLAG_ACTIVITY_NEW_TASK
) {
    val notificationIntent = Intent(context, className)
    options?.let { notificationIntent.putExtra("bundle", it) }
    notificationIntent.flags = flags
    context.startActivity(notificationIntent)
}

fun <T> startNotificationService(
    service: Service,
    id: Int,
    context: Context,
    className: Class<T>,
    notificationChannel: String,
    title: String,
    content: String,
    smallIcon: Int,
    category: String,
    priority: Int,
    ongoing: Boolean = false,
    foregroundServiceType: Int
) {
    val notificationIntent = Intent(context, className)
    val pendingIntent: PendingIntent =
        if (SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.getActivity(
                context, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        } else {
            PendingIntent.getActivity(
                context,
                0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT
            )
        }
    val notification: Notification = NotificationCompat.Builder(context, notificationChannel)
        .setContentTitle(title)
        .setContentText(content)
        .setSmallIcon(smallIcon)
        .setContentIntent(pendingIntent)
        .setPriority(priority)
        .setOngoing(ongoing)
        .build()
    startForeground(service, id, notification, foregroundServiceType)
}
