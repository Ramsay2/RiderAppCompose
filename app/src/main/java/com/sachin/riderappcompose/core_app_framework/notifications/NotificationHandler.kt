package com.apnamart.apnarider.core_app_framework.notifications

import android.annotation.TargetApi
import android.content.Context
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import androidx.annotation.IntDef
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationChannelGroupCompat
import androidx.core.app.NotificationManagerCompat
import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import javax.inject.Inject


class NotificationHandler @Inject
constructor(private val context: Context) {

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationGroup(
        channelGroupId: String,
        channelGroupName: String,
        channelGroupDescription: String = ""
    ) {
        val notificationChannelGroup =
            NotificationChannelGroupCompat.Builder(channelGroupId).apply {
                setName(channelGroupName)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P && channelGroupDescription.isNotBlank())
                    setDescription(channelGroupDescription)
            }
        with(NotificationManagerCompat.from(context)) {
            createNotificationChannelGroup(notificationChannelGroup.build())
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun removeNotificationGroup(channelGroupId: String) {
        with(NotificationManagerCompat.from(context)) {
            deleteNotificationChannelGroup(channelGroupId)
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(
        channelId: String,
        channelName: String,
        @NotificationImportance channelImportance: Int = NotificationManagerCompat.IMPORTANCE_DEFAULT,
        channelDescription: String? = null,
        groupId: String? = null
    ) {
        val channel = NotificationChannelCompat.Builder(channelId, channelImportance).apply {
            setName(channelName)
            if (!groupId.isNullOrBlank()) {
                setGroup(groupId)
            }
            setDescription(channelDescription)
        }
        with(NotificationManagerCompat.from(context)) {
            createNotificationChannel(channel.build())
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(
        channelId: String,
        channelName: String,
        @NotificationImportance channelImportance: Int = NotificationManagerCompat.IMPORTANCE_DEFAULT,
        channelDescription: String? = null,
        groupId: String? = null,
        soundResource: Uri? = null
    ) {
        val channel = NotificationChannelCompat.Builder(channelId, channelImportance).apply {
            setName(channelName)
            if (!groupId.isNullOrBlank()) {
                setGroup(groupId)
            }
            setDescription(channelDescription)
            soundResource?.let {
                val attributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build()
                setSound(it, attributes)
            }
        }
        with(NotificationManagerCompat.from(context)) {
            createNotificationChannel(channel.build())
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun removeChannel(channelId: String) {
        with(NotificationManagerCompat.from(context)) {
            deleteNotificationChannel(channelId)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addCustomChannel(notificationChannel: NotificationChannelCompat) {
        with(NotificationManagerCompat.from(context)) {
            createNotificationChannel(notificationChannel)
        }
    }

    companion object {
        @RequiresApi(Build.VERSION_CODES.N)
        @IntDef(
            NotificationManagerCompat.IMPORTANCE_DEFAULT,
            NotificationManagerCompat.IMPORTANCE_HIGH,
            NotificationManagerCompat.IMPORTANCE_LOW,
            NotificationManagerCompat.IMPORTANCE_MAX,
            NotificationManagerCompat.IMPORTANCE_MIN,
            NotificationManagerCompat.IMPORTANCE_NONE,
            NotificationManagerCompat.IMPORTANCE_UNSPECIFIED
        )
        @Retention(AnnotationRetention.SOURCE)
        annotation class NotificationImportance
    }
}