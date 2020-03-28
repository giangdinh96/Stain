package com.returnnotfound.stain.base.activity

import com.returnnotfound.stain.base.fragment.BaseFragment

interface BaseActivityView {
  fun getLayoutId(): Int
  fun getContainerId(): Int
  fun getRootFragment(): BaseFragment
  fun initLayout()
  fun onFirstResume()
  fun onBackResume()
  fun onBackPressed()
  fun showProgress()
  fun hideProgress()
  fun showToast(message: String?)
}