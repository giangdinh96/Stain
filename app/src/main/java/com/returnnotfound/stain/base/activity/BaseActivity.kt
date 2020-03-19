package com.returnnotfound.stain.base.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import butterknife.ButterKnife
import butterknife.Unbinder
import com.returnnotfound.stain.FRAGMENT_CONTAINER_ID
import com.returnnotfound.stain.R
import com.returnnotfound.stain.ROOT_LAYOUT_ID
import com.returnnotfound.stain.base.fragment.BaseFragment
import com.returnnotfound.stain.utils.ViewUtils
import com.returnnotfound.stain.utils.fragment.FragmentOptions
import com.returnnotfound.stain.utils.fragment.FragmentUtils
import io.github.inflationx.viewpump.ViewPumpContextWrapper

abstract class BaseActivity : BaseLogActivity(), IBaseActivityView {
  private var mCurrentBackStackEntryCount = 0
  private var mIsFirstResume = true
  private var mUnBinder: Unbinder? = null

  override fun getLayoutId() = ROOT_LAYOUT_ID

  override fun getContainerId() = FRAGMENT_CONTAINER_ID

  override fun isTouchHideKeyboard() = false

  override fun getExcludeViewsTouchHideKeyboard(): List<View>? = null

  override fun initLayout() {}

  override fun onFirstResume() {
    Log.d("Resume", "onFirstResume: " + this.javaClass.name)
  }

  override fun onBackResume() {
    Log.d("Resume", "onBackResume: " + this.javaClass.name)
  }

  override fun onBackPressed() {
    val topFragment =
      FragmentUtils.getTopFragment(supportFragmentManager)
    if (topFragment is BaseFragment) {
      topFragment.onBackPressed()
    } else {
      super.onBackPressed()
    }
  }

  override fun showProgress() {}

  override fun hideProgress() {}

  override fun showToast(message: String?) {}

  override fun attachBaseContext(newBase: Context) {
    super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayoutId())
    mUnBinder = ButterKnife.bind(this)
    if (isTouchHideKeyboard()) {
      ViewUtils.setupUI(findViewById(R.id.content), this, getExcludeViewsTouchHideKeyboard())
    }
    registerOnBackStackChange()
    if (savedInstanceState == null) {
      addRootFragment(getRootFragment())
    }

    mCurrentBackStackEntryCount = supportFragmentManager.backStackEntryCount
    mIsFirstResume = savedInstanceState == null
    initLayout()
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
    attachFragment(fragment, FragmentOptions.ROOT_FRAGMENT_OPTIONS)
  }

  override fun addFragment(fragment: Fragment) {
    attachFragment(fragment, FragmentOptions.ADD_FRAGMENT_OPTIONS)
  }

  override fun replaceFragment(fragment: Fragment) {
    attachFragment(fragment, FragmentOptions.REPLACE_FRAGMENT_OPTIONS)
  }

  override fun attachFragment(
    fragment: Fragment,
    fragmentOptions: FragmentOptions
  ) {
    attachFragment(getContainerId(), fragment, supportFragmentManager, fragmentOptions)
  }

  override fun attachFragment(
    containerId: Int,
    fragment: Fragment,
    fragmentManager: FragmentManager,
    fragmentOptions: FragmentOptions
  ) {
    FragmentUtils.addFragment(
      fragmentManager,
      fragment,
      containerId,
      fragmentOptions
    )
  }

  // More method
  private fun registerOnBackStackChange() {
    supportFragmentManager.addOnBackStackChangedListener {
      val newCurrentBackStackEntryCount = supportFragmentManager.backStackEntryCount
      if (newCurrentBackStackEntryCount < mCurrentBackStackEntryCount) {
        val topFragment = FragmentUtils.getTopFragment(supportFragmentManager)
        if (topFragment is BaseFragment) {
          topFragment.onBackResume()
        }
      }
      mCurrentBackStackEntryCount = newCurrentBackStackEntryCount
    }
  }
}