package com.returnnotfound.stain.presentation.ui.main.discover

import com.returnnotfound.stain.base.BaseViewModel
import com.returnnotfound.stain.domain.usecase.GetBannerListUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class DiscoverViewModel @Inject constructor(private val getBannerListUseCase: GetBannerListUseCase) :
  BaseViewModel() {

  init {
    GlobalScope.launch {
      getBannerListUseCase.invoke()
    }
  }
}