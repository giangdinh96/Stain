package com.returnnotfound.stain.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.returnnotfound.stain.base.extension.getBaseActivity
import com.returnnotfound.stain.base.utils.ViewUtils

abstract class BaseFragment : BaseLogFragment(), BaseFragmentView {
  private var mIsFirstResume = true
  private var mUnBinder: Unbinder? = null

  override fun isTouchHideKeyboard() = false

  override fun getExcludeViewsTouchHideKeyboard(): List<View>? = null

  override fun initLayout() {

  }

  override fun onFirstResume() {
    log("onFirstResume")
  }

  override fun onBackResume() {
    log("onBackResume")
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
}