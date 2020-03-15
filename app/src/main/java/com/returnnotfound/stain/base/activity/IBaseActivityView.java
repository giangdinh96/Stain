package com.returnnotfound.stain.base.activity;

import android.content.Context;

import com.returnnotfound.stain.base.IBaseView;
import com.returnnotfound.stain.base.fragment.BaseFragment;

public interface IBaseActivityView extends IBaseView {
  BaseFragment createRootFragment();

  int getContainerId();

  Context getActivityContext();
}
