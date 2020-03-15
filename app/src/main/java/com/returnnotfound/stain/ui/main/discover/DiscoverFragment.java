package com.returnnotfound.stain.ui.main.discover;

import android.os.Bundle;

import com.returnnotfound.stain.R;
import com.returnnotfound.stain.base.fragment.BaseFragment;

public class DiscoverFragment extends BaseFragment implements DiscoverView {

  public static DiscoverFragment newInstance() {
    Bundle args = new Bundle();
    DiscoverFragment fragment = new DiscoverFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public int getLayoutId() {
    return R.layout.fragment_discover;
  }

  @Override
  public void initLayout() {
    super.initLayout();

  }
}
