package com.returnnotfound.stain.utils.fragment;

import static com.returnnotfound.stain.CoreDefaultKt.ANIM_ENTER_LEFT_TO_RIGHT;
import static com.returnnotfound.stain.CoreDefaultKt.ANIM_ENTER_RIGHT_TO_LEFT;
import static com.returnnotfound.stain.CoreDefaultKt.ANIM_EXIT_LEFT_TO_RIGHT;
import static com.returnnotfound.stain.CoreDefaultKt.ANIM_EXIT_RIGHT_TO_LEFT;

public class FragmentOptions {
  public static final FragmentOptions ROOT_FRAGMENT_OPTIONS = new Builder()
      .isAddToBackStack(false)
      .isReplace(true)
      .isWithAnim(false)
      .build();

  public static final FragmentOptions ADD_FRAGMENT_OPTIONS = new Builder().build();

  public static final FragmentOptions REPLACE_FRAGMENT_OPTIONS = new Builder()
      .isReplace(true)
      .build();

  private String tag;
  private boolean isAddToBackStack;
  private boolean isLoadExisted;
  private boolean isReplace;
  private boolean isWithAnim;
  private int enterAnim;
  private int exitAnim;
  private int popEnterAnim;
  private int popExitAnim;

  public String getTag() {
    return tag;
  }

  public boolean isAddToBackStack() {
    return isAddToBackStack;
  }

  public boolean isLoadExisted() {
    return isLoadExisted;
  }

  public boolean isReplace() {
    return isReplace;
  }

  public boolean isWithAnim() {
    return isWithAnim;
  }

  public int getEnterAnim() {
    return enterAnim;
  }

  public int getExitAnim() {
    return exitAnim;
  }

  public int getPopEnterAnim() {
    return popEnterAnim;
  }

  public int getPopExitAnim() {
    return popExitAnim;
  }

  public Builder newBuilder() {
    return new Builder()
        .tag(tag)
        .isAddToBackStack(isAddToBackStack)
        .isWithAnim(isWithAnim)
        .isReplace(isReplace)
        .isLoadExisted(isLoadExisted)
        .enterAnim(enterAnim)
        .exitAnim(exitAnim)
        .popEnterAnim(popEnterAnim)
        .popExitAnim(popExitAnim);

  }

  public static final class Builder {
    private String tag;
    private boolean isAddToBackStack = true;
    private boolean isWithAnim = true;
    private boolean isReplace = false;
    private boolean isLoadExisted = false;
    private int enterAnim = ANIM_ENTER_RIGHT_TO_LEFT;
    private int exitAnim = ANIM_EXIT_RIGHT_TO_LEFT;
    private int popEnterAnim = ANIM_ENTER_LEFT_TO_RIGHT;
    private int popExitAnim = ANIM_EXIT_LEFT_TO_RIGHT;

    public Builder() {

    }

    public Builder tag(String tag) {
      this.tag = tag;
      return this;
    }

    public Builder isAddToBackStack(boolean isAddToBackStack) {
      this.isAddToBackStack = isAddToBackStack;
      return this;
    }

    public Builder isLoadExisted(boolean isLoadExisted) {
      this.isLoadExisted = isLoadExisted;
      return this;
    }

    public Builder isReplace(boolean isReplace) {
      this.isReplace = isReplace;
      return this;
    }

    public Builder isWithAnim(boolean isWithAnim) {
      this.isWithAnim = isWithAnim;
      return this;
    }

    public Builder enterAnim(int enterAnim) {
      this.enterAnim = enterAnim;
      return this;
    }

    public Builder exitAnim(int exitAnim) {
      this.exitAnim = exitAnim;
      return this;
    }

    public Builder popEnterAnim(int popEnterAnim) {
      this.popEnterAnim = popEnterAnim;
      return this;
    }

    public Builder popExitAnim(int popExitAnim) {
      this.popExitAnim = popExitAnim;
      return this;
    }

    public FragmentOptions build() {
      FragmentOptions fragmentOptions = new FragmentOptions();
      fragmentOptions.isReplace = this.isReplace;
      fragmentOptions.isWithAnim = this.isWithAnim;
      fragmentOptions.exitAnim = this.exitAnim;
      fragmentOptions.popEnterAnim = this.popEnterAnim;
      fragmentOptions.popExitAnim = this.popExitAnim;
      fragmentOptions.tag = this.tag;
      fragmentOptions.isLoadExisted = this.isLoadExisted;
      fragmentOptions.enterAnim = this.enterAnim;
      fragmentOptions.isAddToBackStack = this.isAddToBackStack;
      return fragmentOptions;
    }
  }
}
