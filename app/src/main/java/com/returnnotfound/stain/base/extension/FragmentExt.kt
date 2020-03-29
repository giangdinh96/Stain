package com.returnnotfound.stain.base.extension

import android.view.View
import androidx.fragment.app.Fragment
import com.returnnotfound.stain.base.activity.BaseActivity
import com.returnnotfound.stain.base.fragment.BaseFragment


fun Fragment.getBaseActivity(): BaseActivity = requireActivity().getBaseActivity()

fun Fragment.getBaseFragment(): BaseFragment = this as BaseFragment

fun Fragment.showKeyboard(view: View?) {
  view?.showKeyboard()
}

fun Fragment.hideKeyboard() {
  activity?.hideKeyboard()
}

fun BaseFragment.showToast(resId: Int) {
  showToast(getString(resId))
}

fun BaseFragment.addFragment(fragment: BaseFragment) {
  getBaseActivity().addFragment(fragment)
}

fun BaseFragment.replaceFragment(fragment: BaseFragment) {
  getBaseActivity().replaceFragment(fragment)
}

fun BaseFragment.addChildFragment(fragment: BaseFragment, containerId: Int) {
  childFragmentManager.addFragment(
    fragment = fragment, containerId = containerId
  )
}

fun BaseFragment.replaceFragment(fragment: BaseFragment, containerId: Int) {
  childFragmentManager.addFragment(
    fragment = fragment, containerId = containerId, isReplace = true
  )
}