package com.returnnotfound.stain.presentation.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.returnnotfound.stain.R


class MyService : Service() {
  override fun onBind(intent: Intent?): IBinder? {
    return null
  }

  private fun createNotificationChannel() {
    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val name: CharSequence = "getString(R.string.channel_name)"
      val description = "getString(R.string.channel_description)"
      val importance = NotificationManager.IMPORTANCE_DEFAULT
      val channel = NotificationChannel("123", name, importance)
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
    createNotificationChannel()
    startForeground(
      1,
      NotificationCompat
        .Builder(this, "123")
        .setContentTitle("Title")
        .setContentTitle("Content title")
        .setContentText("Content text")
        .setSmallIcon(R.mipmap.ic_launcher)
        .build()
    )
  }

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    logTag("onStartCommand $intent $flags $startId")
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