package com.returnnotfound.stain.base

import android.app.Activity
import android.content.Context
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.returnnotfound.stain.base.activity.BaseActivity
import com.returnnotfound.stain.base.fragment.BaseFragment
import com.returnnotfound.stain.utils.ViewUtils

fun Activity.getContext(): Context = this

fun Activity.getBaseActivity(): BaseActivity? = this as BaseActivity?

fun Activity.showKeyboard(editText: EditText?) {
  editText?.let { ViewUtils.showKeyboard(it) }
}

fun Activity.hideKeyboard() {
  ViewUtils.hideKeyboard(this)
}


fun Fragment.getBaseActivity(): BaseActivity? = activity?.getBaseActivity()

fun Fragment.getBaseFragment(): BaseFragment? = this as BaseFragment

fun Fragment.showKeyboard(editText: EditText?) {
  editText?.let { ViewUtils.showKeyboard(it) }
}

fun Fragment.hideKeyboard() {
  activity?.let { ViewUtils.hideKeyboard(it) }
}