package com.returnnotfound.stain.base.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import butterknife.ButterKnife
import butterknife.Unbinder
import com.returnnotfound.stain.base.getBaseActivity
import com.returnnotfound.stain.utils.ViewUtils
import com.returnnotfound.stain.utils.fragment.FragmentOptions

abstract class BaseFragment : BaseLogFragment(), IBaseFragmentView {
  private var mIsFirstResume = true
  private var mUnBinder: Unbinder? = null

  override fun isTouchHideKeyboard() = false

  override fun getExcludeViewsTouchHideKeyboard(): List<View>? = null

  override fun initLayout() {

  }

  override fun onFirstResume() {
    Log.e("Resume", "onFirstResume: " + this.javaClass.name)
  }

  override fun onBackResume() {
    Log.e("Resume", "onBackResume: " + this.javaClass.name)
  }

  override fun onBackPressed() {
    parentFragmentManager.popBackStack()
  }

  override fun showProgress() {
    getBaseActivity()?.showProgress()
  }

  override fun hideProgress() {
    getBaseActivity()?.hideProgress()
  }

  override fun showToast(message: String?) {
    getBaseActivity()?.showToast(message)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    val view = inflater.inflate(getLayoutId(), container, false)
    mUnBinder = ButterKnife.bind(this, view)
    view.isClickable = true
    if (isTouchHideKeyboard()) {
      ViewUtils.setupUI(view, activity, getExcludeViewsTouchHideKeyboard())
    }

    mIsFirstResume = savedInstanceState == null

    initLayout()
    return view
  }

  override fun onResume() {
    super.onResume()
    if (mIsFirstResume) {
      onFirstResume()
      mIsFirstResume = false
    } else {
      onBackResume()
    }
  }

  override fun onDestroy() {
    if (mUnBinder != null) {
      mUnBinder!!.unbind()
    }
    super.onDestroy()
  }

  override fun addRootFragment(fragment: Fragment) {
    getBaseActivity()?.addRootFragment(fragment)
  }

  override fun addFragment(fragment: Fragment) {
    getBaseActivity()?.addFragment(fragment)
  }

  override fun replaceFragment(fragment: Fragment) {
    getBaseActivity()?.replaceFragment(fragment)
  }

  override fun attachFragment(
    fragment: Fragment,
    fragmentOptions: FragmentOptions
  ) {
    getBaseActivity()?.attachFragment(fragment, fragmentOptions)
  }

  override fun attachFragment(
    containerId: Int,
    fragment: Fragment,
    fragmentManager: FragmentManager,
    fragmentOptions: FragmentOptions
  ) {
    getBaseActivity()?.attachFragment(containerId, fragment, fragmentManager, fragmentOptions)
  }
}