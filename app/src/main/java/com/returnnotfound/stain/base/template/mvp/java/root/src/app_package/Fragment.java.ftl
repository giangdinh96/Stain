package ${packageName};

import android.os.Bundle;
import ${pkName}.base.BaseFragment;
import ${applicationPackage}.R;

public class ${className}Fragment extends BaseFragment<I${className}Presenter> implements I${className}View {

  I${className}Presenter mI${className}Presenter;

  public static ${className}Fragment newInstance() {
    return new ${className}Fragment();
  }

  public static ${className}Fragment newInstance(Bundle data) {
    ${className}Fragment fragment = new ${className}Fragment();
    fragment.setArguments(data);
    return fragment;
  }

  @Override
  public int getLayoutId() {
    return R.layout.${layoutName};
  }

  @Override
  public I${className}Presenter getPresenter() {
    return mI${className}Presenter;
  }

}