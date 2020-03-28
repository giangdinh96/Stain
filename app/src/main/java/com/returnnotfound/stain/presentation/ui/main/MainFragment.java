package com.returnnotfound.stain.presentation.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.returnnotfound.stain.R;
import com.returnnotfound.stain.base.fragment.BaseFragment;
import com.returnnotfound.stain.base.utils.ViewUtils;
import com.returnnotfound.stain.base.widget.BottomNavigationView;
import com.returnnotfound.stain.base.widget.CompositeOnNavigationItemSelectedListener;
import com.returnnotfound.stain.base.widget.Toolbar;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

public class MainFragment extends BaseFragment implements MainView {
  @BindView(R.id.toolbar_header_title_tv)
  TextView mTitleTv;

  @BindView(R.id.drawer_content_tb)
  Toolbar mDrawerContentTb;
  @BindView(R.id.user_iv)
  ImageView mUserIv;
  @BindView(R.id.drawer_root_dl)
  DrawerLayout mDrawerRootDl;
  @BindView(R.id.drawer_left_menu_tb)
  Toolbar mDrawerLeftMenuTb;
  @BindView(R.id.drawer_right_menu_tb)
  Toolbar mDrawerRightMenuTb;
  @BindView(R.id.main_pager_vp)

  ViewPager2 mMainPagerVp;
  @BindView(R.id.main_bottom_menu_bnv)
  BottomNavigationView mMainBottomMenuBnv;

  public static MainFragment newInstance() {
    Bundle args = new Bundle();
    MainFragment fragment = new MainFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public int getLayoutId() {
    return R.layout.fragment_main;
  }

  @Override
  public void initLayout() {
    super.initLayout();

    initMenuAnimation();
    initMainPager();
  }

  @OnClick(R.id.toolbar_header_action_left_iv)
  @Override
  public void onMenuClick(View view) {
    ViewUtils.delayViewPress(view);
    mDrawerRootDl.openDrawer(GravityCompat.START, true);
  }

  @OnClick(R.id.toolbar_header_action_right_iv)
  @Override
  public void onNotificationClick(View view) {
    ViewUtils.delayViewPress(view);
    mDrawerRootDl.openDrawer(GravityCompat.END, true);
  }

  @Override
  public void initMenuAnimation() {
    mDrawerRootDl.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
      @Override
      public void onDrawerStateChanged(int newState) {
        super.onDrawerStateChanged(newState);
        if (newState == DrawerLayout.STATE_IDLE) {
          if (!mDrawerRootDl.isDrawerOpen(GravityCompat.END) && !mDrawerRootDl.isDrawerOpen(GravityCompat.START)) {
            mDrawerRootDl.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, GravityCompat.START);
            mDrawerRootDl.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, GravityCompat.END);
          }
        }
      }

      @Override
      public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
      }

      @Override
      public void onDrawerSlide(View drawerView, float slideOffset) {
        super.onDrawerSlide(drawerView, slideOffset);
        if (drawerView == mDrawerLeftMenuTb) {
          mDrawerRootDl.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, GravityCompat.END);
          // Content translation
          float valueContentTranslation = slideOffset * drawerView.getWidth();
          mDrawerContentTb.setTranslationX(valueContentTranslation);

          // Content rotate
//          float valueContentRotate = slideOffset * 45;
//          mDrawerContentTb.setRotationY(valueContentRotate);

          // User avatar translation
//        float valueUserAvatarTranslation = (1 - slideOffset) * drawerView.getWidth();
          float valueUserAvatarTranslation = (0.5f - slideOffset * 0.5f) * drawerView.getWidth();
          mUserIv.setTranslationX(valueUserAvatarTranslation);

          float valueUserAvatarRotate = 180 * (1 - slideOffset);
          mUserIv.setRotationX(valueUserAvatarRotate);
        } else {
          mDrawerRootDl.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, GravityCompat.START);
          // Content translation
          float valueContentTranslation = -slideOffset * drawerView.getWidth() * 0.5f;
          mDrawerContentTb.setTranslationX(valueContentTranslation);
        }

        // Menu alpha
        float valueMenuAlpha = 0.75f + slideOffset * 0.25f;
        drawerView.setAlpha(valueMenuAlpha);
      }
    });
  }

  @Override
  public void initMainPager() {
    mMainPagerVp.setAdapter(new MainPagerAdapter(this));
    mMainPagerVp.setOffscreenPageLimit(3);
    mMainPagerVp.setUserInputEnabled(false);
    mMainPagerVp.setPageTransformer(new MarginPageTransformer(20));
    CompositeOnNavigationItemSelectedListener onCompositeNavigationItemSelectedListener = new CompositeOnNavigationItemSelectedListener(2);
    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedConnectViewpagerListener = MainViewPagerConnection.connect(mMainPagerVp);
    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedViewpagerListener = item -> {
      mTitleTv.setText(item.getTitle());
      return true;
    };
    onCompositeNavigationItemSelectedListener.addOnNavigationItemSelectedListener(onNavigationItemSelectedViewpagerListener);
    onCompositeNavigationItemSelectedListener.addOnNavigationItemSelectedListener(onNavigationItemSelectedConnectViewpagerListener);
    mMainBottomMenuBnv.setOnNavigationItemSelectedListener(onCompositeNavigationItemSelectedListener);
  }

  @Override
  public void onBackPressed() {
    if (mDrawerRootDl.isDrawerVisible(GravityCompat.START) || mDrawerRootDl.isDrawerVisible(GravityCompat.END)) {
      if (mDrawerRootDl.isDrawerVisible(GravityCompat.START)) {
        mDrawerRootDl.closeDrawer(GravityCompat.START);
      } else {
        mDrawerRootDl.closeDrawer(GravityCompat.END);
      }
    } else {
      Objects.requireNonNull(getActivity()).finish();
    }
  }
}
