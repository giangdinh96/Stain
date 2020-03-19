package com.returnnotfound.stain.base

import android.view.View
import android.widget.EditText

interface IBaseView : IFragmentTransaction {
  fun getLayoutId(): Int
  fun isTouchHideKeyboard(): Boolean
  fun getExcludeViewsTouchHideKeyboard(): List<View>?

  fun initLayout()
  fun onFirstResume()
  fun onBackResume()
  fun onBackPressed()
  fun showProgress()
  fun hideProgress()
  fun showToast(resMessage: Int)
  fun showToast(message: String?)
  fun showKeyboard(view: EditText?)
  fun hideKeyboard()
}