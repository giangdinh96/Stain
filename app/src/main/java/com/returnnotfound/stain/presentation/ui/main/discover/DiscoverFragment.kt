package com.returnnotfound.stain.presentation.ui.main.discover

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.returnnotfound.stain.R
import com.returnnotfound.stain.base.fragment.BaseFragment
import com.returnnotfound.stain.base.widget.AutoViewPager
import com.returnnotfound.stain.presentation.AppViewModelFactory
import kotlinx.android.synthetic.main.item_banner_container.*
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

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    banner_vp.adapter = BannerAdapter()
    AutoViewPager().apply {
      viewPager2 = banner_vp
      start()
    }
    banner_indicator.setViewPager2(banner_vp)
  }

  companion object {
    @JvmStatic
    fun newInstance(): DiscoverFragment {
      return DiscoverFragment()
    }
  }
}