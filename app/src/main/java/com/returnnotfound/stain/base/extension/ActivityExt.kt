package com.returnnotfound.stain.base.extension

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.returnnotfound.stain.R
import com.returnnotfound.stain.base.*
import com.returnnotfound.stain.base.activity.BaseActivity
import com.returnnotfound.stain.base.fragment.BaseFragment

fun Activity.getContext(): Context = this

fun Activity.getBaseActivity(): BaseActivity = this as BaseActivity

fun Activity.showKeyboard(view: View?) {
  view?.showKeyboard()
}

fun Activity.hideKeyboard() {
  val view = currentFocus ?: findViewById(R.id.content)
  view?.hideKeyboard()
}

fun BaseActivity.showToast(resId: Int) {
  showToast(getString(resId))
}

fun BaseActivity.addFragment(
  fragment: Fragment,
  containerId: Int = FRAGMENT_CONTAINER_ID,
  tag: String = fragment::class.java.name,
  isAddToBackStack: Boolean = true,
  isWithAnim: Boolean = true,
  isReplace: Boolean = false,
  isLoadExisted: Boolean = false,
  enterAnim: Int = ANIM_ENTER_RIGHT_TO_LEFT,
  exitAnim: Int = ANIM_EXIT_RIGHT_TO_LEFT,
  popEnterAnim: Int = ANIM_ENTER_LEFT_TO_RIGHT,
  popExitAnim: Int = ANIM_EXIT_LEFT_TO_RIGHT
) {
  supportFragmentManager.addFragment(
    fragment,
    containerId,
    tag,
    isAddToBackStack,
    isWithAnim,
    isReplace,
    isLoadExisted,
    enterAnim,
    exitAnim,
    popEnterAnim,
    popExitAnim
  )
}

fun BaseActivity.addRootFragment(fragment: BaseFragment) {
  supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
  addFragment(
    fragment = fragment,
    containerId = getContainerId(),
    isAddToBackStack = false,
    isReplace = true,
    isWithAnim = false
  )
}

fun BaseActivity.addFragment(fragment: BaseFragment) {
  addFragment(fragment = fragment, containerId = getContainerId())
}

fun BaseActivity.replaceFragment(fragment: BaseFragment) {
  addFragment(fragment = fragment, containerId = getContainerId(), isReplace = true)
}