package com.returnnotfound.stain.base;

import io.reactivex.disposables.Disposable;

public interface IBaseViewModel {
  void addTask(Disposable disposable);

  void start();

  void onFirstResume();

  void onBackResume();

  void finish();
}
