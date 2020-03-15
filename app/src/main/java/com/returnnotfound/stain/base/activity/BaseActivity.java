package com.returnnotfound.stain.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.returnnotfound.stain.base.fragment.BaseFragment;
import com.returnnotfound.stain.utils.ViewUtils;
import com.returnnotfound.stain.utils.fragment.FragmentOptions;
import com.returnnotfound.stain.utils.fragment.FragmentUtils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

import static com.returnnotfound.stain.CoreDefaultKt.FRAGMENT_CONTAINER_ID;
import static com.returnnotfound.stain.CoreDefaultKt.ROOT_LAYOUT_ID;

public abstract class BaseActivity extends BaseLogActivity implements IBaseActivityView {

  private int mCurrentBackStackEntryCount = 0;
  private boolean mIsFistResume = true;
  private Unbinder mUnBinder;

  @Override
  public BaseActivity getBaseActivity() {
    return this;
  }

  @Override
  public Context getActivityContext() {
    return this;
  }

  @Override
  public int getLayoutId() {
    return ROOT_LAYOUT_ID;
  }

  @Override
  public int getContainerId() {
    return FRAGMENT_CONTAINER_ID;
  }

  @Override
  public boolean isTouchHideKeyboard() {
    return false;
  }

  @Override
  public List<View> getExcludeViewsTouchHideKeyboard() {
    return null;
  }

  @Override
  public void initLayout() {

  }

  @Override
  public void onFirstResume() {
    Log.d("Resume", "onFirstResume: " + this.getClass().getName());
  }

  @Override
  public void onBackResume() {
    Log.d("Resume", "onBackResume: " + this.getClass().getName());
  }

  @Override
  public void onBackPressed() {
    Fragment topFragment = FragmentUtils.getTopFragment(getSupportFragmentManager());
    if (topFragment instanceof BaseFragment) {
      ((BaseFragment) topFragment).onBackPressed();
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public void showProgress() {

  }

  @Override
  public void hideProgress() {

  }

  @Override
  public void showToast(@StringRes int resMessage) {
    showToast(getString(resMessage));
  }

  @Override
  public void showToast(String message) {

  }

  @Override
  public void showKeyboard(EditText view) {
    ViewUtils.showKeyboard(view);
  }

  @Override
  public void hideKeyboard() {
    ViewUtils.hideKeyboard(this);
  }

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());

    mUnBinder = ButterKnife.bind(this);

    if (isTouchHideKeyboard()) {
      ViewUtils.setupUI(findViewById(android.R.id.content), this, getExcludeViewsTouchHideKeyboard());
    }

    registerOnBackStackChange();

    if (savedInstanceState == null) {
      addRootFragment(createRootFragment());
    }

    initLayout();
  }


  @Override
  public void onResume() {
    super.onResume();
    if (mIsFistResume) {
      onFirstResume();
      mIsFistResume = false;
    } else {
      onBackResume();
    }
  }

  @Override
  public void onDestroy() {
    if (mUnBinder != null) {
      mUnBinder.unbind();
    }
    super.onDestroy();
  }

  @Override
  public void addRootFragment(Fragment fragment) {
    attachFragment(fragment, FragmentOptions.ROOT_FRAGMENT_OPTIONS);
  }

  @Override
  public void addFragment(Fragment fragment) {
    attachFragment(fragment, FragmentOptions.ADD_FRAGMENT_OPTIONS);
  }

  @Override
  public void replaceFragment(Fragment fragment) {
    attachFragment(fragment, FragmentOptions.REPLACE_FRAGMENT_OPTIONS);
  }

  @Override
  public void attachFragment(Fragment fragment, FragmentOptions fragmentOptions) {
    attachFragment(getContainerId(), fragment, getSupportFragmentManager(), fragmentOptions);
  }

  @Override
  public void attachFragment(int containerId, Fragment fragment, FragmentManager fragmentManager, FragmentOptions fragmentOptions) {
    if (fragment == null)
      return;
    FragmentUtils.addFragment(
        fragmentManager,
        fragment,
        containerId,
        fragmentOptions
    );
  }

  // More method
  private void registerOnBackStackChange() {
    getSupportFragmentManager().addOnBackStackChangedListener(() -> {
      int newCurrentBackStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
      if (newCurrentBackStackEntryCount < mCurrentBackStackEntryCount) {
        Fragment topFragment = FragmentUtils.getTopFragment(getSupportFragmentManager());
        if (topFragment instanceof BaseFragment) {
          ((BaseFragment) topFragment).onBackResume();
        }
      }
      mCurrentBackStackEntryCount = newCurrentBackStackEntryCount;
    });
  }
}
