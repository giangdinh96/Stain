package com.returnnotfound.stain.presentation.main.rank;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.returnnotfound.stain.AppViewModelFactory;
import com.returnnotfound.stain.R;
import com.returnnotfound.stain.base.fragment.BaseFragment;
import com.returnnotfound.stain.utils.RvUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;

import static com.returnnotfound.stain.CoreDefaultKt.COLOR_REFRESH_PROGRESS;

public class RankFragment extends BaseFragment implements RankView {

  @Inject
  AppViewModelFactory mAppViewModelFactory;

  @BindView(R.id.refresh_srl)
  SwipeRefreshLayout mRefreshSrl;
  @BindView(R.id.rank_rv)
  RecyclerView mRankRv;
  private RankAdapter mRankAdapter;

  private RankVMImpl mRankVMImpl;

  public static RankFragment newInstance() {
    Bundle args = new Bundle();
    RankFragment fragment = new RankFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public int getLayoutId() {
    return R.layout.fragment_rank;
  }

  @Override
  public void initLayout() {
    super.initLayout();

    initRankList();
    showEmptyLoading();
    initRefreshLayout();

    mRankVMImpl = new ViewModelProvider(this, mAppViewModelFactory).get(RankVMImpl.class);

    mRankVMImpl.getmAnimeTopList().observe(this, animeTops -> {
      mRefreshSrl.setRefreshing(false);
      showEmptyView();
      mRankAdapter.replaceData(animeTops);
    });
  }

  @Override
  public void initRefreshLayout() {
    mRefreshSrl.setColorSchemeResources(COLOR_REFRESH_PROGRESS);
    mRefreshSrl.setOnRefreshListener(() -> {
      mRefreshSrl.setRefreshing(false);
      showEmptyLoading();
      mRankAdapter.replaceData(new ArrayList<>());
      mRankVMImpl.refreshAnimeList();
    });
  }

  @Override
  public void initRankList() {
    mRankAdapter = new RankAdapter(R.layout.item_anime_top);
    RvUtils.setupVerticalRecyclerView(getContext(), mRankRv);
    mRankRv.setAdapter(mRankAdapter);
  }

  @Override
  public void showEmptyLoading() {
    mRankAdapter.setEmptyView(R.layout.layout_loading, mRankRv);
  }

  @Override
  public void showEmptyView() {
    mRankAdapter.setEmptyView(R.layout.layout_empty, mRankRv);
  }
}
