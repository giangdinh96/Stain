package com.returnnotfound.stain.base.widget

import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class CompositeOnNavigationItemSelectedListener(capacity: Int) :
  BottomNavigationView.OnNavigationItemSelectedListener {
  private val mCallbacks: MutableList<BottomNavigationView.OnNavigationItemSelectedListener>

  init {
    mCallbacks = ArrayList(capacity)
  }

  fun addOnNavigationItemSelectedListener(listener: BottomNavigationView.OnNavigationItemSelectedListener) {
    mCallbacks.add(listener)
  }

  fun removeOnNavigationItemSelectedListener(listener: BottomNavigationView.OnNavigationItemSelectedListener?) {
    mCallbacks.remove(listener)
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    if (mCallbacks.isEmpty()) {
      return true
    }
    val lastIndex = mCallbacks.lastIndex
    for (i in 0 until lastIndex) {
      mCallbacks[i].onNavigationItemSelected(item)
    }
    return mCallbacks.last().onNavigationItemSelected(item)
  }
}