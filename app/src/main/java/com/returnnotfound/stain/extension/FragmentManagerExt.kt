package com.returnnotfound.stain.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.returnnotfound.stain.base.*
import com.returnnotfound.stain.base.fragment.BaseFragment

fun FragmentManager.isBackStackContains(tag: String): Boolean {
  val backStackEntryCount = this.backStackEntryCount
  if (backStackEntryCount <= 0) return false
  for (i in 0 until backStackEntryCount) {
    val backStackEntry = this.getBackStackEntryAt(i)
    if (tag.equals(backStackEntry.name, ignoreCase = true)) return true
  }
  return false
}

fun FragmentManager.getTopFragment(): Fragment? {
  val backStackEntryCount = this.backStackEntryCount
  if (backStackEntryCount > 0) {
    val lastIndex = backStackEntryCount - 1
    val backStackEntry = getBackStackEntryAt(lastIndex)
    return findFragmentByTag(backStackEntry.name)
  } else {
    if (fragments.isNotEmpty()) {
      return fragments[0]
    }
  }
  return null
}

fun FragmentManager.addFragment(
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
  commit {
    // Anim
    if (isWithAnim) setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim)
    // BackStack
    if (isAddToBackStack) addToBackStack(tag)

    // LoadExisted
    if (isLoadExisted) {
      val existingFragment = findFragmentByTag(tag)
      if (existingFragment != null) {
        for (f in fragments) {
          hide(f)
        }
        show(existingFragment)
        if (existingFragment is BaseFragment) {
          existingFragment.onBackResume()
        }
      } else {
        add(containerId, fragment, tag)
      }
    } else {
      if (isReplace) {
        replace(containerId, fragment, tag)
      } else {
        add(containerId, fragment, tag)
      }
    }
  }
}
