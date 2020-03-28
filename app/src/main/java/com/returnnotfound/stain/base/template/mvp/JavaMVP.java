package com.returnnotfound.stain.base.template.mvp;

public class JavaMVP {
//  interface IPresenter<V extends IView> {
//    V getView();
//
//    void attachView(V view);
//  }
//
//  interface IView<P extends IPresenter> {
//    P getPresenter();
//  }
//
//  interface IMainPresenter extends IPresenter<IMainView> {
//
//  }
//
//  interface IMainView extends IView<IMainPresenter> {
//
//  }
//
//  abstract class BasePresenter<V extends IView> implements IPresenter<V> {
//    private V view;
//
//    @Override
//    public V getView() {
//      return view;
//    }
//
//    @Override
//    public void attachView(V view) {
//      this.view = view;
//    }
//  }
//
//  abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView<P> {
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//      super.onAttach(context);
//      getPresenter().attachView(this);
//    }
//  }
//
//  class MainPresenter extends BasePresenter<IMainView> implements IMainPresenter {
//
//  }
//
//  class MainFragment extends BaseFragment<IMainPresenter> implements IMainView {
//
//    @Override
//    public IMainPresenter getPresenter() {
//      return null;
//    }
//  }
}