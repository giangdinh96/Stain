package com.returnnotfound.stain.base.extension

import android.app.Activity
import android.content.Context
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import com.returnnotfound.stain.base.activity.BaseActivity
import com.returnnotfound.stain.base.fragment.BaseFragment
import com.returnnotfound.stain.base.utils.ViewUtils

fun Activity.getContext(): Context = this

fun Activity.getBaseActivity(): BaseActivity? = this as BaseActivity?

fun Activity.showKeyboard(editText: EditText?) {
  editText?.let { ViewUtils.showKeyboard(it) }
}

fun Activity.hideKeyboard() {
  ViewUtils.hideKeyboard(this)
}

fun BaseActivity.showToast(resId: Int) {
  showToast(getString(resId))
}

fun BaseActivity.addRootFragment(fragment: BaseFragment) {
  supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
  supportFragmentManager.addFragment(
    fragment = getRootFragment(),
    containerId = getContainerId(),
    isAddToBackStack = false,
    isReplace = true,
    isWithAnim = false
  )
}