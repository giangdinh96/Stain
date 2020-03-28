package com.returnnotfound.stain.base.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.widget.ImageViewCompat;

import com.returnnotfound.stain.R;
import com.returnnotfound.stain.base.utils.FontUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Toolbar extends MotionLayout implements View.OnClickListener {

  @BindView(R.id.toolbar_header_background_iv)
  ImageView mHeaderBackgroundIv;

  @BindView(R.id.toolbar_header_content_container_v)
  View mHeaderContentContainerV;

  @BindView(R.id.toolbar_header_top_space_v)
  View mTopSpaceV;

  @BindView(R.id.toolbar_header_action_left_iv)
  ImageView mActionLeftIv;
  @BindView(R.id.toolbar_header_action_left_tv)
  TextView mActionLeftTv;

  @BindView(R.id.toolbar_header_action_right_iv)
  ImageView mActionRightIv;
  @BindView(R.id.toolbar_header_action_right_tv)
  TextView mActionRightTv;

  @BindView(R.id.toolbar_header_title_tv)
  TextView mTitleTv;

  OnClickListener mOnActionLeftClickListener;
  OnClickListener mOnActionRightClickListener;

  public Toolbar(Context context) {
    super(context);
    init(null, 0);
  }

  public Toolbar(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs, 0);
  }

  public Toolbar(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs, defStyleAttr);
  }

  private void init(AttributeSet attrs, int defStyleAttr) {
    LayoutInflater.from(getContext()).inflate(R.layout.toolbar, this, true);
    ButterKnife.bind(this);

    TypedArray input = getContext().obtainStyledAttributes(attrs, R.styleable.Toolbar, 0, 0);

    //------------------------------------------------- Header ----------------------------------------------------------------//
    // Drawable
    if (input.hasValue(R.styleable.Toolbar_tbl_header_drawable)) {
      Drawable drawable = input.getDrawable(R.styleable.Toolbar_tbl_header_drawable);
      setHeaderBackgroundDrawable(drawable);
    }

    //------------------------------------------------- Header top space ------------------------------------------------------//
    // Drawable
    if (input.hasValue(R.styleable.Toolbar_tbl_header_top_space_drawable)) {
      Drawable drawable = input.getDrawable(R.styleable.Toolbar_tbl_header_top_space_drawable);
      setTopSpaceDrawable(drawable);
    }
    // Height
    float topSpaceHeightDefault = Build.VERSION.SDK_INT > 19 ? getStatusBarHeight() : 0;
    if (input.hasValue(R.styleable.Toolbar_tbl_header_top_space_visible)) {
      float height = input.getDimension(R.styleable.Toolbar_tbl_header_top_space_height, topSpaceHeightDefault);
      setTopSpaceHeight(height);
    } else {
      setTopSpaceHeight(topSpaceHeightDefault);
    }
    // Visibility
    if (input.hasValue(R.styleable.Toolbar_tbl_header_top_space_visible)) {
      boolean isVisible = input.getBoolean(R.styleable.Toolbar_tbl_header_top_space_visible, true);
      setTopSpaceVisible(isVisible);
    } else {
      setTopSpaceVisible(true);
    }

    //------------------------------------------------- Header content container ------------------------------------------------------//
    // Drawable
    if (input.hasValue(R.styleable.Toolbar_tbl_header_content_container_drawable)) {
      Drawable drawable = input.getDrawable(R.styleable.Toolbar_tbl_header_content_container_drawable);
      setHeaderContentContainerDrawable(drawable);
    }
    // Height
    if (input.hasValue(R.styleable.Toolbar_tbl_header_content_container_height)) {
      float height = input.getDimension(R.styleable.Toolbar_tbl_header_content_container_height, dp2Px(48));
      setHeaderContentContainerHeight(height);
    }

    //------------------------------------------------- Display Style -------------------------------------------------//
    resetVisibility();
    ActionStyle actionLeftStyle = ActionStyle.getActionStyle(input.getInt(R.styleable.Toolbar_tbl_header_action_left_style, ActionStyle.NONE.input));
    ActionStyle actionRightStyle = ActionStyle.getActionStyle(input.getInt(R.styleable.Toolbar_tbl_header_action_right_style, ActionStyle.NONE.input));
    initActionStyle(actionLeftStyle, actionRightStyle);


    //------------------------------------------------- Title ---------------------------------------------------------//
    // Style
    if (input.hasValue(R.styleable.Toolbar_tbl_header_title_style)) {
      int titleStyle = input.getInt(R.styleable.Toolbar_tbl_header_title_style, TextStyle.BOLD.input);
      setTitleStyle(TextStyle.getTextStyle(titleStyle).value);
    }
    // Text
    if (input.hasValue(R.styleable.Toolbar_tbl_header_title)) {
      String title = input.getString(R.styleable.Toolbar_tbl_header_title);
      setTitle(title);
    }
    // Color
    if (input.hasValue(R.styleable.Toolbar_tbl_header_title_color)) {
      int titleColor = input.getColor(R.styleable.Toolbar_tbl_header_title_color, Color.BLACK);
      setTitleColor(titleColor);
    }
    // Size
    if (input.hasValue(R.styleable.Toolbar_tbl_header_title_size)) {
      float titleSize = input.getDimension(R.styleable.Toolbar_tbl_header_title_size, sp2Px(12));
      setTitleSize(titleSize);
    }
    // AllCaps
    if (input.hasValue(R.styleable.Toolbar_tbl_header_title_all_caps)) {
      boolean titleAllCaps = input.getBoolean(R.styleable.Toolbar_tbl_header_title_all_caps, false);
      setTitleAllCaps(titleAllCaps);
    } else {
      setTitleAllCaps(false);
    }

    // Marquee
    setTitleMarquee();


    //------------------------------------------------- Action left ----------------------------------------------------//
    // Style
    if (input.hasValue(R.styleable.Toolbar_tbl_header_left_text_style)) {
      int textLeftStyle = input.getInt(R.styleable.Toolbar_tbl_header_left_text_style, TextStyle.NORMAL.input);
      setTextActionLeftStyle(TextStyle.getTextStyle(textLeftStyle).value);
    }
    // Text
    if (input.hasValue(R.styleable.Toolbar_tbl_header_left_text)) {
      String leftText = input.getString(R.styleable.Toolbar_tbl_header_left_text);
      setTextActionLeft(leftText);
    }
    // Color
    if (input.hasValue(R.styleable.Toolbar_tbl_header_left_text_color)) {
      int textLeftColor = input.getColor(R.styleable.Toolbar_tbl_header_left_text_color, Color.BLACK);
      setTextActionLeftColor(textLeftColor);
    }
    // Size
    if (input.hasValue(R.styleable.Toolbar_tbl_header_left_text_size)) {
      float textLeftSize = input.getDimension(R.styleable.Toolbar_tbl_header_left_text_size, sp2Px(12));
      setTextActionLeftSize(textLeftSize);
    }
    // AllCaps
    if (input.hasValue(R.styleable.Toolbar_tbl_header_left_text_all_caps)) {
      boolean textLeftAllCaps = input.getBoolean(R.styleable.Toolbar_tbl_header_left_text_all_caps, false);
      setTextActionLeftAllCaps(textLeftAllCaps);
    }
    // Left image
    if (input.hasValue(R.styleable.Toolbar_tbl_header_left_image)) {
      Drawable imageLeft = input.getDrawable(R.styleable.Toolbar_tbl_header_left_image);
      setImageActionLeft(imageLeft);
    }
    // Left image tint
    if (input.hasValue(R.styleable.Toolbar_tbl_header_left_image_tint)) {
      int imageLeftTint = input.getColor(R.styleable.Toolbar_tbl_header_left_image_tint, Color.WHITE);
      setImageActionLeftTint(imageLeftTint);
    }
    // Left image size
    if (input.hasValue(R.styleable.Toolbar_tbl_header_left_image_size)) {
      float imageLeftSize = input.getDimension(R.styleable.Toolbar_tbl_header_left_image_size, dp2Px(24));
      setImageActionLeftSize(imageLeftSize);
    }
    // Left image background
    if (input.hasValue(R.styleable.Toolbar_tbl_header_left_image_background)) {
      Drawable imageLeftBackground = input.getDrawable(R.styleable.Toolbar_tbl_header_left_image_background);
      setImageActionLeftBackground(imageLeftBackground);
    }


    //------------------------------------------------- Action right -------------------------------------------------//
    // Style
    if (input.hasValue(R.styleable.Toolbar_tbl_header_right_text_style)) {
      int textRightStyle = input.getInt(R.styleable.Toolbar_tbl_header_right_text_style, TextStyle.NORMAL.input);
      setTextActionRightStyle(TextStyle.getTextStyle(textRightStyle).value);
    }
    // Text
    if (input.hasValue(R.styleable.Toolbar_tbl_header_right_text)) {
      String rightText = input.getString(R.styleable.Toolbar_tbl_header_right_text);
      setTextActionRight(rightText);
    }
    // Color
    if (input.hasValue(R.styleable.Toolbar_tbl_header_right_text_color)) {
      int textRightColor = input.getColor(R.styleable.Toolbar_tbl_header_right_text_color, Color.BLACK);
      setTextActionRightColor(textRightColor);
    }
    // Size
    if (input.hasValue(R.styleable.Toolbar_tbl_header_right_text_size)) {
      float textRightSize = input.getDimension(R.styleable.Toolbar_tbl_header_right_text_size, sp2Px(12));
      setTextActionRightSize(textRightSize);
    }
    // AllCaps
    if (input.hasValue(R.styleable.Toolbar_tbl_header_right_text_all_caps)) {
      boolean textRightAllCaps = input.getBoolean(R.styleable.Toolbar_tbl_header_right_text_all_caps, false);
      setTextActionRightAllCaps(textRightAllCaps);
    }
    // Right image
    if (input.hasValue(R.styleable.Toolbar_tbl_header_right_image)) {
      Drawable imageRight = input.getDrawable(R.styleable.Toolbar_tbl_header_right_image);
      setImageActionRight(imageRight);
    }
    // Right image tint
    if (input.hasValue(R.styleable.Toolbar_tbl_header_right_image_tint)) {
      int imageLeftTint = input.getColor(R.styleable.Toolbar_tbl_header_right_image_tint, Color.WHITE);
      setImageActionRightTint(imageLeftTint);
    }
    // Right image size
    if (input.hasValue(R.styleable.Toolbar_tbl_header_right_image_size)) {
      float imageRightSize = input.getDimension(R.styleable.Toolbar_tbl_header_right_image_size, dp2Px(24));
      setImageActionRightSize(imageRightSize);
    }
    // Right image background
    if (input.hasValue(R.styleable.Toolbar_tbl_header_right_image_background)) {
      Drawable imageRightBackground = input.getDrawable(R.styleable.Toolbar_tbl_header_right_image_background);
      setImageActionRightBackground(imageRightBackground);
    }

    //------------------------------------------------- Notification --------------------------------------------------//
//    setupLeftNotification();
//    setupRightNotification();

    //------------------------------------------------- recycle -------------------------------------------------------//
    input.recycle();
  }


  //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

  //------------------------------------------------- Header ----------------------------------------------------------//
  public void setHeaderBackgroundDrawable(Drawable drawable) {
    mHeaderBackgroundIv.setImageDrawable(drawable);
  }

  //------------------------------------------------- Top space -------------------------------------------------------//
  public void setTopSpaceDrawable(Drawable drawable) {
    mTopSpaceV.setBackground(drawable);
  }

  public void setTopSpaceHeight(float height) {
    setViewHeight(mTopSpaceV, height);
  }

  public void setTopSpaceVisible(boolean isVisible) {
    mTopSpaceV.setVisibility(isVisible ? VISIBLE : GONE);
  }

  //------------------------------------------------- Header content container ----------------------------------------//
  public void setHeaderContentContainerDrawable(Drawable drawable) {
    mHeaderContentContainerV.setBackground(drawable);
  }

  public void setHeaderContentContainerHeight(float height) {
    setViewHeight(mHeaderContentContainerV, height);
  }

  //------------------------------------------------- Display Style ---------------------------------------------------//
  private void resetVisibility() {
    setActionLeftImageVisibility(View.INVISIBLE);
    setActionLeftTextVisibility(View.GONE);
    setActionRightImageVisibility(View.INVISIBLE);
    setActionRightTextVisibility(View.GONE);
  }

  private void initActionLeftStyle(ActionStyle actionLeftStyle) {
    switch (actionLeftStyle) {
      case TEXT:
        setActionLeftTextVisibility(VISIBLE);
        break;
      case IMAGE:
        setActionLeftImageVisibility(VISIBLE);
        break;
    }
  }

  private void initActionRightStyle(ActionStyle actionRightStyle) {
    switch (actionRightStyle) {
      case TEXT:
        setActionRightTextVisibility(VISIBLE);
        break;
      case IMAGE:
        setActionRightImageVisibility(VISIBLE);
        break;
    }
  }

  private void initActionStyle(ActionStyle actionLeftStyle, ActionStyle actionRightStyle) {
    resetVisibility();
    initActionLeftStyle(actionLeftStyle);
    initActionRightStyle(actionRightStyle);
  }

  public String getTextActionLeft() {
    return mActionLeftTv.getText().toString();
  }

  //------------------------------------------------- Action left -----------------------------------------------------//
  // Text action left
  public void setTextActionLeft(String action) {
    mActionLeftTv.setText(action);
  }

  public void setTextActionLeft(@StringRes int actionLeftStringId) {
    mActionLeftTv.setText(actionLeftStringId);
  }

  public void setTextActionRightColor(int color) {
    mActionRightTv.setTextColor(color);
  }

  public void setTextActionRightSize(float size) {
    mActionRightTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
  }

  public void setTextActionRightStyle(String font) {
    loadFont(mActionRightTv, font);
  }

  public void setTextActionRightAllCaps(boolean allCaps) {
    mActionRightTv.setAllCaps(allCaps);
  }

  // Image action left
  public void setImageActionLeft(Drawable drawable) {
    mActionLeftIv.setImageDrawable(drawable);
  }

  public void setImageActionLeft(@DrawableRes int idRes) {
    mActionLeftIv.setImageResource(idRes);
  }

  public void setImageActionLeftTint(int color) {
    ImageViewCompat.setImageTintList(mActionLeftIv, ColorStateList.valueOf(color));
  }

  public void setImageActionLeftSize(float size) {
    ViewGroup.LayoutParams layoutParams = mActionLeftIv.getLayoutParams();
    layoutParams.width = (int) size;
    layoutParams.height = (int) size;
    mActionLeftIv.setLayoutParams(layoutParams);
  }

  public void setImageActionLeftBackground(Drawable background) {
    mActionLeftIv.setBackground(background);
  }

  public String getTextActionRight() {
    return mActionRightTv.getText().toString();
  }

  //------------------------------------------------- Action Right ------------------------------------------------------//
  // Text action right
  public void setTextActionRight(String action) {
    mActionRightTv.setText(action);
  }

  public void setTextActionRight(@StringRes int actionRightStringId) {
    mActionRightTv.setText(actionRightStringId);
  }

  public void setTextActionLeftColor(int color) {
    mActionLeftTv.setTextColor(color);
  }

  public void setTextActionLeftSize(float size) {
    mActionLeftTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
  }

  public void setTextActionLeftStyle(String font) {
    loadFont(mActionLeftTv, font);
  }

  public void setTextActionLeftAllCaps(boolean allCaps) {
    mActionLeftTv.setAllCaps(allCaps);
  }

  // Image action right
  public void setImageActionRight(Drawable drawable) {
    mActionRightIv.setImageDrawable(drawable);
  }

  public void setImageActionRight(@DrawableRes int idRes) {
    mActionRightIv.setImageResource(idRes);
  }

  public void setImageActionRightTint(int color) {
    ImageViewCompat.setImageTintList(mActionRightIv, ColorStateList.valueOf(color));
  }

  public void setImageActionRightSize(float size) {
    ViewGroup.LayoutParams layoutParams = mActionRightIv.getLayoutParams();
    layoutParams.width = (int) size;
    layoutParams.height = (int) size;
    mActionRightIv.setLayoutParams(layoutParams);
  }

  public void setImageActionRightBackground(Drawable background) {
    mActionRightIv.setBackground(background);
  }

  public String getTitle() {
    return mTitleTv.getText().toString();
  }

  //------------------------------------------------- Title --------------------------------------------------------------//
  public void setTitle(String title) {
    mTitleTv.setText(title);
  }

  public void setTitle(@StringRes int idRes) {
    mTitleTv.setText(idRes);
  }

  public void setTitleColor(int color) {
    mTitleTv.setTextColor(color);
  }

  public void setTitleSize(float size) {
    mTitleTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
  }

  public void setTitleStyle(String font) {
    loadFont(mTitleTv, font);
  }

  public void setTitleAllCaps(boolean allCaps) {
    mTitleTv.setAllCaps(allCaps);
  }

  public void setTitleMarquee() {
    mTitleTv.setSelected(true);
  }

  //------------------------------------------------- Visibility -----------------------------------------------------------//
  public void setActionLeftTextVisibility(int visibility) {
    mActionLeftTv.setVisibility(visibility);
  }

  public void setActionLeftImageVisibility(int visibility) {
    mActionLeftIv.setVisibility(visibility);
  }

  public void setActionRightTextVisibility(int visibility) {
    mActionRightTv.setVisibility(visibility);
  }

  public void setActionRightImageVisibility(int visibility) {
    mActionRightIv.setVisibility(visibility);
  }


  //------------------------------------------------- Notification ---------------------------------------------------------//
//  public void setupLeftNotification() {
//    mLeftNotification = new QBadgeView(getContext())
//        .setShowShadow(false)
//        .setBadgeBackgroundColor(Color.BLACK)
//        .setBadgePadding(0, true)
//        .bindTarget(mActionLeftNotificationContainerV);
//  }
//
//  public void setupRightNotification() {
//    mRightNotification = new QBadgeView(getContext())
//        .setShowShadow(false)
//        .setBadgeBackgroundColor(Color.BLACK)
//        .setBadgePadding(0, true)
//        .bindTarget(mActionRightNotificationContainerV);
//  }
//
//  public void addLeftNotiDot() {
//    mLeftNotification
//        .setBadgeText("")
//        .setBadgePadding(4, true)
//        .setGravityOffset(14, 12, true);
//  }
//
//  public void addRightNotiDot() {
//    mRightNotification
//        .setBadgeText("")
//        .setBadgePadding(4, true)
//        .setGravityOffset(14, 12, true);
//  }
//
//  public void addLeftNotiCount(String text) {
//    mLeftNotification
//        .setBadgeText(text)
//        .setBadgeTextSize(10, true)
//        .setBadgePadding(4, true)
//        .setGravityOffset(10, 4, true);
//  }
//
//  public void addRightNotiCount(String text) {
//    mRightNotification
//        .setBadgeText(text)
//        .setBadgeTextSize(10, true)
//        .setBadgePadding(4, true)
//        .setGravityOffset(10, 4, true);
//  }
//
//  public void clearLeftNotification() {
//    mLeftNotification.setBadgeText("")
//        .setBadgePadding(0, true);
//  }
//
//  public void clearRightNotification() {
//    mRightNotification.setBadgeText("")
//        .setBadgePadding(0, true);
//  }


  //------------------------------------------------- Listener -------------------------------------------------------------//
  @Override
  @OnClick({R.id.toolbar_header_action_left_iv,
      R.id.toolbar_header_action_left_tv,
      R.id.toolbar_header_action_right_iv,
      R.id.toolbar_header_action_right_tv,
  })
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.toolbar_header_action_left_iv:
      case R.id.toolbar_header_action_left_tv:
        if (mOnActionLeftClickListener != null) {
          mOnActionLeftClickListener.onClick(v);
        }
        break;
      case R.id.toolbar_header_action_right_iv:
      case R.id.toolbar_header_action_right_tv:
        if (mOnActionRightClickListener != null) {
          mOnActionRightClickListener.onClick(v);
        }
        break;
    }
  }

  public void setOnActionLeftClickListener(OnClickListener onActionLeftClickListener) {
    this.mOnActionLeftClickListener = onActionLeftClickListener;
  }

  public void setOnActionRightClickListener(OnClickListener onActionRightClickListener) {

    this.mOnActionRightClickListener = onActionRightClickListener;
  }


  //------------------------------------------------- More ------------------------------------------------------------------//
  private void setViewHeight(View view, float height) {
    ViewGroup.LayoutParams currentLayoutParams = view.getLayoutParams();
    currentLayoutParams.height = (int) height;
    view.setLayoutParams(currentLayoutParams);
  }

  private void setViewWidth(View view, float width) {
    ViewGroup.LayoutParams currentLayoutParams = view.getLayoutParams();
    currentLayoutParams.width = (int) width;
    view.setLayoutParams(currentLayoutParams);
  }

  private void setViewSize(View view, float width, float height) {
    ViewGroup.LayoutParams currentLayoutParams = view.getLayoutParams();
    currentLayoutParams.width = (int) width;
    currentLayoutParams.height = (int) height;
    view.setLayoutParams(currentLayoutParams);
  }

  private void loadFont(TextView textView, String font) {
    String root = "fonts/";
    Typeface typeface = FontUtils.get(getContext(), root.concat(font));
    textView.setTypeface(typeface);
  }

  private float dp2Px(float dp) {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
  }

  public float sp2Px(float sp) {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
  }

  private int getStatusBarHeight() {
    int result = 0;
    int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
      result = getResources().getDimensionPixelSize(resourceId);
    }
    return result;
  }


  public enum ActionStyle {
    NONE(0), TEXT(1), IMAGE(2);
    int input;

    ActionStyle(int input) {
      this.input = input;
    }

    static ActionStyle getActionStyle(int input) {
      for (ActionStyle actionStyle : values()) {
        if (actionStyle.input == input) {
          return actionStyle;
        }
      }
      return NONE;
    }
  }

  public enum TextStyle {
    NORMAL(0, "BeVietnam-Regular.ttf"),
    MEDIUM(1, "BeVietnam-Medium.ttf"),
    BOLD(2, "BeVietnam-Bold.ttf"),
    NORMAL_ITALIC(3, "BeVietnam-RegularItalic.ttf"),
    MEDIUM_ITALIC(4, "BeVietnam-MediumItalic.ttf"),
    BOLD_ITALIC(5, "BeVietnam-BoldItalic.ttf");

    int input;
    String value;

    TextStyle(int input, String value) {
      this.input = input;
      this.value = value;
    }

    static TextStyle getTextStyle(int input) {
      for (TextStyle textStyle : values()) {
        if (textStyle.input == input) {
          return textStyle;
        }
      }
      return NORMAL;
    }
  }
}