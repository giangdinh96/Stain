package com.returnnotfound.stain.presentation.ui.main.discover

import androidx.lifecycle.ViewModelProvider
import com.returnnotfound.stain.AppViewModelFactory
import com.returnnotfound.stain.R
import com.returnnotfound.stain.base.fragment.BaseFragment
import javax.inject.Inject

class DiscoverFragment : BaseFragment(), DiscoverView {

  @Inject
  lateinit var appViewModelFactory: AppViewModelFactory

  lateinit var discoverViewModel: DiscoverViewModel

  override fun getLayoutId() = R.layout.fragment_discover

  override fun initLayout() {
    super.initLayout()

    discoverViewModel = ViewModelProvider(this, appViewModelFactory)[DiscoverViewModel::class.java]

  }

  companion object {
    @JvmStatic
    fun newInstance(): DiscoverFragment {
      return DiscoverFragment()
    }
  }
}