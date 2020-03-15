package com.returnnotfound.stain.base;

import android.view.View;
import android.widget.EditText;

import com.returnnotfound.stain.base.activity.BaseActivity;

import java.util.List;

public interface IBaseView extends IFragmentTransaction {
  BaseActivity getBaseActivity();

  int getLayoutId();

  boolean isTouchHideKeyboard();

  List<View> getExcludeViewsTouchHideKeyboard();

  void initLayout();

  void onFirstResume();

  void onBackResume();

  void onBackPressed();

  void showProgress();

  void hideProgress();

  void showToast(int resMessage);

  void showToast(String message);

  void showKeyboard(EditText view);

  void hideKeyboard();
}