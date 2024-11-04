package com.example.push

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import java.time.Duration

@RequiresApi(Build.VERSION_CODES.O)
fun showIncomingCallNotification(context: Context) {
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    // 알림 채널 생성
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            "call_channel", "Incoming Call", NotificationManager.IMPORTANCE_HIGH
        )
        notificationManager.createNotificationChannel(channel)
    }

    val notificationBuilder = NotificationCompat.Builder(context, "call_channel")
    notificationBuilder.setCategory(NotificationCompat.CATEGORY_CALL)
    notificationBuilder.priority = NotificationCompat.PRIORITY_MAX
    notificationBuilder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
    notificationBuilder.setSmallIcon(R.drawable.img)
    notificationBuilder.setAutoCancel(false)
    notificationBuilder.setTimeoutAfter(Duration.ofSeconds(60).toMillis())
    val remoteViews = RemoteViews(context.packageName,R.layout.call_notification)
    remoteViews.setTextViewText(R.id.tvNameCaller,"name")
    remoteViews.setTextViewText(R.id.tvNumber,"number")

    notificationBuilder.setCustomContentView(remoteViews)

    notificationManager.notify(1, notificationBuilder.build())
}