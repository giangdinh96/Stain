package com.returnnotfound.stain.base

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.returnnotfound.stain.R


class BaseService : Service() {
  override fun onBind(intent: Intent?): IBinder? {
    return null
  }

  private fun createNotificationChannel() {
    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val name: CharSequence = "MyMusic"
      val description = "My music app channel"
      val importance = NotificationManager.IMPORTANCE_DEFAULT
      val channel = NotificationChannel("1996", name, importance)
      channel.description = description
      // Register the channel with the system; you can't change the importance
      // or other notification behaviors after this
      val notificationManager = getSystemService(NotificationManager::class.java)
      notificationManager?.createNotificationChannel(channel)
    }
  }

  override fun onCreate() {
    logTag("onCreate")
    super.onCreate()
    logTag("onCreate")
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    logTag("onStartCommand $intent $flags $startId")
    createNotificationChannel()
    val pendingIntent = PendingIntent.getService(
      this,
      1,
      Intent(this, BaseService::class.java),
      PendingIntent.FLAG_UPDATE_CURRENT
    )

    startForeground(
      1,
      NotificationCompat
        .Builder(this, "123")
        .addAction(0, "Pre", pendingIntent)
        .addAction(R.drawable.ic_more, null, pendingIntent)
        .addAction(0, "Next", pendingIntent)
        .addAction(0, "Close", pendingIntent)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentText("Content text")
        .setTicker("Ticker")
        .setSubText("Sub text")
        .setContentTitle("content title")
        .build()
    )
    return super.onStartCommand(intent, flags, startId)
  }

  override fun onDestroy() {
    logTag("onDestroy")
    super.onDestroy()
    logTag("onDestroy")
  }

  override fun onLowMemory() {
    logTag("onLowMemory")
    super.onLowMemory()
    logTag("onLowMemory")
  }

  override fun onRebind(intent: Intent?) {
    logTag("onRebind $intent")
    super.onRebind(intent)
    logTag("onRebind $intent")
  }

  override fun onTaskRemoved(rootIntent: Intent?) {
    logTag("onTaskRemoved $rootIntent")
    super.onTaskRemoved(rootIntent)
    logTag("onTaskRemoved $rootIntent")
  }

  override fun onUnbind(intent: Intent?): Boolean {
    logTag("onUnbind $intent")
    return super.onUnbind(intent)
  }

  private fun logTag(message: String) {
    Log.e("Service", "${this.hashCode()}-----$message-------${Thread.currentThread().name}")
  }
}