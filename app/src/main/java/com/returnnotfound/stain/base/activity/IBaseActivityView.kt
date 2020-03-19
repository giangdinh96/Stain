package com.returnnotfound.stain.base.activity

import com.returnnotfound.stain.base.IBaseView
import com.returnnotfound.stain.base.fragment.BaseFragment

interface IBaseActivityView : IBaseView {
  fun getRootFragment(): BaseFragment

  fun getContainerId(): Int
}