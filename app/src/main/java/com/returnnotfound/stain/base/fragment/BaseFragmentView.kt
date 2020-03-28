package com.returnnotfound.stain.base.fragment

import android.view.View

interface BaseFragmentView {
  fun getLayoutId(): Int
  fun isTouchHideKeyboard(): Boolean
  fun getExcludeViewsTouchHideKeyboard(): List<View>?
  fun initLayout()
  fun onFirstResume()
  fun onBackResume()
  fun onBackPressed()
  fun showProgress()
  fun hideProgress()
  fun showToast(message: String?)
}