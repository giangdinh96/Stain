package com.returnnotfound.stain.presentation.ui

import com.returnnotfound.stain.base.activity.BaseActivity
import com.returnnotfound.stain.base.fragment.BaseFragment
import com.returnnotfound.stain.presentation.ui.main.MainFragment

class MainActivity : BaseActivity() {

  override fun getRootFragment(): BaseFragment {
    return MainFragment.newInstance()
  }
}