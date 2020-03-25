package com.returnnotfound.stain.presentation.ui.main.love;

import android.os.Bundle;

import com.returnnotfound.stain.R;
import com.returnnotfound.stain.base.fragment.BaseFragment;

public class LoveFragment extends BaseFragment implements LoveView {

  public static LoveFragment newInstance() {
    Bundle args = new Bundle();
    LoveFragment fragment = new LoveFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public int getLayoutId() {
    return R.layout.fragment_love;
  }

  @Override
  public void initLayout() {
    super.initLayout();

  }
}
