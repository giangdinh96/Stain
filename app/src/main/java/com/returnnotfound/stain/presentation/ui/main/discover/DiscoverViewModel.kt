package com.returnnotfound.stain.presentation.ui.main.discover

import com.returnnotfound.stain.base.BaseViewModel
import com.returnnotfound.stain.domain.model.Banner
import com.returnnotfound.stain.domain.usecase.GetBannerListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class DiscoverViewModel @Inject constructor(private val getBannerListUseCase: GetBannerListUseCase) :
  BaseViewModel() {

  init {
    val disposable = getBannerListUseCase.invoke()
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(this::onGetBannerSuccess, this::onGetBannerError)
    add(disposable)
  }

  private fun onGetBannerSuccess(bannerList: List<Banner>) {
    ""
  }

  private fun onGetBannerError(error: Throwable) {
    ""
  }
}