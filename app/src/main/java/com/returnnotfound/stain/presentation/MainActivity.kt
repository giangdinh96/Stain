package com.returnnotfound.stain.presentation

import com.returnnotfound.stain.base.activity.BaseActivity
import com.returnnotfound.stain.base.fragment.BaseFragment
import com.returnnotfound.stain.presentation.main.MainFragment

class MainActivity : BaseActivity() {
  override fun createRootFragment(): BaseFragment {
    return MainFragment.newInstance()
  }
}