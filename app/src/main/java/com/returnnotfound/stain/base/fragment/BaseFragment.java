package com.returnnotfound.stain.base.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.returnnotfound.stain.base.activity.BaseActivity;
import com.returnnotfound.stain.utils.ViewUtils;
import com.returnnotfound.stain.utils.fragment.FragmentOptions;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends BaseLogFragment implements IBaseFragmentView {

  private boolean mIsFirstResume = true;
  private Unbinder mUnBinder;

  @Override
  public BaseActivity getBaseActivity() {
    return (BaseActivity) getActivity();
  }

  @Override
  public boolean isTouchHideKeyboard() {
    return true;
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
    Log.e("Resume", "onFirstResume: " + this.getClass().getName());
  }

  @Override
  public void onBackResume() {
    Log.e("Resume", "onBackResume: " + this.getClass().getName());
  }

  @Override
  public void onBackPressed() {
    if (getFragmentManager() != null) {
      getFragmentManager().popBackStack();
    }
  }

  @Override
  public void showProgress() {
    getBaseActivity().showProgress();
  }

  @Override
  public void hideProgress() {
    getBaseActivity().hideProgress();
  }

  @Override
  public void showToast(int resMessage) {
    getBaseActivity().showToast(resMessage);
  }

  @Override
  public void showToast(String message) {
    getBaseActivity().showToast(message);
  }

  @Override
  public void showKeyboard(EditText view) {
    getBaseActivity().showKeyboard(view);
  }

  @Override
  public void hideKeyboard() {
    getBaseActivity().hideKeyboard();
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);

    View view = inflater.inflate(getLayoutId(), container, false);
    mUnBinder = ButterKnife.bind(this, view);

    view.setClickable(true);

    if (isTouchHideKeyboard()) {
      ViewUtils.setupUI(view, getActivity(), getExcludeViewsTouchHideKeyboard());
    }

    initLayout();

    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override
  public void onResume() {
    super.onResume();
    if (mIsFirstResume) {
      onFirstResume();
      mIsFirstResume = false;
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
    getBaseActivity().addRootFragment(fragment);
  }

  @Override
  public void addFragment(Fragment fragment) {
    getBaseActivity().addFragment(fragment);
  }

  @Override
  public void replaceFragment(Fragment fragment) {
    getBaseActivity().replaceFragment(fragment);
  }

  @Override
  public void attachFragment(Fragment fragment, FragmentOptions fragmentOptions) {
    getBaseActivity().attachFragment(fragment, fragmentOptions);
  }

  @Override
  public void attachFragment(int containerId, Fragment fragment, FragmentManager fragmentManager, FragmentOptions fragmentOptions) {
    getBaseActivity().attachFragment(containerId, fragment, fragmentManager, fragmentOptions);
  }
}