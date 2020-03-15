package com.returnnotfound.stain.base.activity

import android.os.Bundle
import android.util.Log
import com.returnnotfound.stain.LOG_TAG_LIFECYCLE
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseLogActivity : DaggerAppCompatActivity() {
  private fun log(log: String) {
    Log.d(LOG_TAG_LIFECYCLE, "$this-$log")
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    log("onCreate_1")
    supportFragmentManager.addOnBackStackChangedListener { log("OnBackStackChange") }
    super.onCreate(savedInstanceState)
    log("onCreate_2")
  }

  override fun onRestart() {
    log("onRestart_1")
    super.onRestart()
    log("onRestart_2")
  }

  public override fun onStart() {
    log("onStart_1")
    super.onStart()
    log("onStart_2")
  }

  override fun onRestoreInstanceState(savedInstanceState: Bundle) {
    log("onRestoreInstanceState_1")
    super.onRestoreInstanceState(savedInstanceState)
    log("onRestoreInstanceState_2")
  }

  public override fun onResume() {
    log("onResume_1")
    super.onResume()
    log("onResume_2")
  }

  public override fun onPause() {
    log("onPause_1")
    super.onPause()
    log("onPause_2")
  }

  public override fun onSaveInstanceState(outState: Bundle) {
    log("onSaveInstanceState_1")
    super.onSaveInstanceState(outState)
    log("onSaveInstanceState_2")
  }

  public override fun onStop() {
    log("onStop_1")
    super.onStop()
    log("onStop_2")
  }

  public override fun onDestroy() {
    log("onDestroy_1")
    super.onDestroy()
    log("onDestroy_2")
  }
}