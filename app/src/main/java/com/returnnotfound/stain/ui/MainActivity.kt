package com.returnnotfound.stain.ui

import com.returnnotfound.stain.base.activity.BaseActivity
import com.returnnotfound.stain.base.fragment.BaseFragment
import com.returnnotfound.stain.ui.main.MainFragment

class MainActivity : BaseActivity() {
  override fun createRootFragment(): BaseFragment {
    return MainFragment.newInstance()
  }
}