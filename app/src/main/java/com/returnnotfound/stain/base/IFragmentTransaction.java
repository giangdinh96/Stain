package com.returnnotfound.stain.base;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.returnnotfound.stain.utils.fragment.FragmentOptions;

public interface IFragmentTransaction {

  void addRootFragment(Fragment fragment);

  void addFragment(Fragment fragment);

  void replaceFragment(Fragment fragment);

  void attachFragment(Fragment fragment, FragmentOptions fragmentOptions);

  void attachFragment(@IdRes int containerId, Fragment fragment, FragmentManager fragmentManager, FragmentOptions fragmentOptions);
}
