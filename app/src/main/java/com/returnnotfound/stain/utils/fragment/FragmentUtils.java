package com.returnnotfound.stain.utils.fragment;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.returnnotfound.stain.base.fragment.BaseFragment;
import com.returnnotfound.stain.utils.StringUtils;

import java.util.List;

public abstract class FragmentUtils {

  public static boolean isBackStackContains(FragmentManager fragmentManager, String tag) {
    int backStackEntryCount = fragmentManager.getBackStackEntryCount();
    if (backStackEntryCount <= 0)
      return false;
    for (int i = 0; i < backStackEntryCount; i++) {
      FragmentManager.BackStackEntry backStackEntry = fragmentManager.getBackStackEntryAt(i);
      if (tag.equalsIgnoreCase(backStackEntry.getName()))
        return true;
    }
    return false;
  }

  public static Fragment getTopFragment(FragmentManager fragmentManager) {
    if (fragmentManager != null) {
      int backStackEntryCount = fragmentManager.getBackStackEntryCount();
      if (backStackEntryCount > 0) {
        FragmentManager.BackStackEntry backStackEntry = fragmentManager.getBackStackEntryAt(backStackEntryCount - 1);
        return fragmentManager.findFragmentByTag(backStackEntry.getName());
      } else {
        List<Fragment> fragments = fragmentManager.getFragments();
        if (!fragments.isEmpty()) {
          return fragments.get(0);
        }
      }
    }
    return null;
  }

  public static void addFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int frameId, FragmentOptions fragmentOptions) {
    if (fragmentOptions == null) {
      fragmentOptions = FragmentOptions.ADD_FRAGMENT_OPTIONS;
    }
    boolean isWithAnim = fragmentOptions.isWithAnim();
    boolean isAddToBackStack = fragmentOptions.isAddToBackStack();
    boolean isLoadExisted = fragmentOptions.isLoadExisted();
    boolean isReplace = fragmentOptions.isReplace();
    String tag = StringUtils.isNullOrEmpty(fragmentOptions.getTag()) ? fragment.getClass().getName() : fragmentOptions.getTag();
    int enterAnim = fragmentOptions.getEnterAnim();
    int exitAnim = fragmentOptions.getExitAnim();
    int popEnterAnim = fragmentOptions.getPopEnterAnim();
    int popExitAnim = fragmentOptions.getPopExitAnim();

    FragmentTransaction transaction = fragmentManager.beginTransaction();

    // Anim
    if (isWithAnim) {
      transaction.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
    }

    // BackStack
    if (isAddToBackStack) {
      transaction.addToBackStack(tag);
    }

    // LoadExisted
    if (isLoadExisted) {
      final Fragment existingFragment = fragmentManager.findFragmentByTag(tag);
      if (existingFragment != null) {
        for (Fragment f : fragmentManager.getFragments()) {
          transaction.hide(f);
        }
        transaction.show(existingFragment);
        if (existingFragment instanceof BaseFragment) {
          ((BaseFragment) existingFragment).onBackResume();
        }
      } else {
        transaction.add(frameId, fragment, tag);
      }
    } else {
      if (isReplace) {
        transaction.replace(frameId, fragment, tag);
      } else {
        transaction.add(frameId, fragment, tag);
      }
    }
    // Commit
    transaction.commit();
  }
}