package com.returnnotfound.stain.base.extension

import android.widget.EditText
import androidx.fragment.app.Fragment
import com.returnnotfound.stain.base.activity.BaseActivity
import com.returnnotfound.stain.base.fragment.BaseFragment
import com.returnnotfound.stain.base.utils.ViewUtils


fun Fragment.getBaseActivity(): BaseActivity? = activity?.getBaseActivity()

fun Fragment.getBaseFragment(): BaseFragment? = this as BaseFragment

fun Fragment.showKeyboard(editText: EditText?) {
  editText?.let { ViewUtils.showKeyboard(it) }
}

fun Fragment.hideKeyboard() {
  activity?.let { ViewUtils.hideKeyboard(it) }
}

fun BaseFragment.showToast(resId: Int) {
  showToast(getString(resId))
}