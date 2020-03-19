package com.returnnotfound.stain.base

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.returnnotfound.stain.utils.fragment.FragmentOptions

interface IFragmentTransaction {
  fun addRootFragment(fragment: Fragment)
  fun addFragment(fragment: Fragment)
  fun replaceFragment(fragment: Fragment)
  fun attachFragment(
    fragment: Fragment,
    fragmentOptions: FragmentOptions
  )

  fun attachFragment(
    @IdRes containerId: Int,
    fragment: Fragment,
    fragmentManager: FragmentManager,
    fragmentOptions: FragmentOptions
  )
}