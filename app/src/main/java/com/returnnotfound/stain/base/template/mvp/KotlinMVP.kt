package com.returnnotfound.stain.base.template.mvp

//interface IPresenter<V> {
//    fun getView(): V
//}
//
//interface IView<P> {
//    fun getPresenter(): P
//}
//
//abstract class BasePresenter<V : IView<*>> : IPresenter<V>
//
//abstract class BaseFragment<P : IPresenter<*>> : Fragment(), IView<P>
//
//
//interface IMainPresenter : IPresenter<IMainView>
//
//interface IMainView : IView<IMainPresenter>
//
//class MainPresenter : BasePresenter<IMainView>(), IMainPresenter {
//    override fun getView(): IMainView {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}
//
//class MainFragment : BaseFragment<IMainPresenter>(), IMainView {
//    override fun getPresenter(): IMainPresenter {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}