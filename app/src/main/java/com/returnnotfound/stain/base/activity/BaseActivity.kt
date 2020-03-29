package com.returnnotfound.stain.base.activity

import android.content.Context
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.Unbinder
import com.returnnotfound.stain.base.FRAGMENT_CONTAINER_ID
import com.returnnotfound.stain.base.ROOT_LAYOUT_ID
import com.returnnotfound.stain.base.extension.addRootFragment
import com.returnnotfound.stain.base.extension.getTopFragment
import com.returnnotfound.stain.base.fragment.BaseFragment
import io.github.inflationx.viewpump.ViewPumpContextWrapper

abstract class BaseActivity : BaseLogActivity(), BaseActivityView {
  private var currentBackStackEntryCount = 0
  private var isFirstResume = true
  private var mUnBinder: Unbinder? = null

  override fun getLayoutId() = ROOT_LAYOUT_ID

  override fun getContainerId() = FRAGMENT_CONTAINER_ID

  override fun initLayout() {}

  override fun onFirstResume() {
    log("onFirstResume")
  }

  override fun onBackResume() {
    log("onBackResume")
  }

  override fun onBackPressed() {
    val topFragment = supportFragmentManager.getTopFragment()
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
    currentBackStackEntryCount = supportFragmentManager.backStackEntryCount
    isFirstResume = savedInstanceState == null

    registerOnBackStackChange()

    mUnBinder = ButterKnife.bind(this)
    if (savedInstanceState == null) {
      addRootFragment(getRootFragment())
    }
    initLayout()
  }

  override fun onResume() {
    super.onResume()
    if (isFirstResume) {
      onFirstResume()
      isFirstResume = false
    } else {
      onBackResume()
    }
  }

  // More method
  private fun registerOnBackStackChange() {
    supportFragmentManager.addOnBackStackChangedListener {
      val newCurrentBackStackEntryCount = supportFragmentManager.backStackEntryCount
      if (newCurrentBackStackEntryCount < currentBackStackEntryCount) {
        val topFragment = supportFragmentManager.getTopFragment()
        if (topFragment is BaseFragment) {
          topFragment.onBackResume()
        }
      }
      currentBackStackEntryCount = newCurrentBackStackEntryCount
    }
  }
}