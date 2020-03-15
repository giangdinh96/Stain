package com.returnnotfound.stain.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseViewModel extends ViewModel implements IBaseViewModel {
  private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

  @Override
  public void addTask(Disposable disposable) {
    mCompositeDisposable.add(disposable);
  }

  @Override
  public void start() {

  }

  @Override
  public void onFirstResume() {

  }

  @Override
  public void onBackResume() {

  }

  @Override
  public void finish() {

  }

  @Override
  protected void onCleared() {
    mCompositeDisposable.dispose();
    super.onCleared();
  }
}
