package com.returnnotfound.stain.presentation.main.rank;

import android.os.Bundle;

import com.returnnotfound.stain.AppViewModelFactory;
import com.returnnotfound.stain.R;
import com.returnnotfound.stain.base.fragment.BaseFragment;

import javax.inject.Inject;

public class RankFragment extends BaseFragment implements RankView {

  @Inject
  AppViewModelFactory mAppViewModelFactory;

  public static RankFragment newInstance() {
    Bundle args = new Bundle();
    RankFragment fragment = new RankFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public int getLayoutId() {
    return R.layout.fragment_rank;
  }

  @Override
  public void initLayout() {
    super.initLayout();

  }
}
