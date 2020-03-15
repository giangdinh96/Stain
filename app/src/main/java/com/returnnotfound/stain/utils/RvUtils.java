package com.returnnotfound.stain.utils;

import android.content.Context;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public abstract class RvUtils {

  public static void setupVerticalRecyclerView(Context context, RecyclerView recyclerView) {
    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setClipToPadding(false);
    recyclerView.setHasFixedSize(true);
  }

  public static void setupHorizontalRecyclerView(Context context, RecyclerView recyclerView) {
    LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setClipToPadding(false);
    recyclerView.setHasFixedSize(true);
  }

  public static void setupStaggeredVerticalRecyclerView(RecyclerView recyclerView, int spanCount) {
    StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
    recyclerView.setLayoutManager(staggeredGridLayoutManager);
    recyclerView.setClipToPadding(false);
    recyclerView.setHasFixedSize(true);
  }

  public static void setupGridRecyclerView(Context context, RecyclerView recyclerView, int spanCount) {
    LinearLayoutManager layoutManager = new GridLayoutManager(context, spanCount);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setClipToPadding(false);
    recyclerView.setHasFixedSize(true);
  }

  public static void setupVerticalRecyclerViewWithDivider(Context context, RecyclerView recyclerView, int orientation) {
    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setClipToPadding(false);
    recyclerView.setHasFixedSize(true);
    recyclerView.addItemDecoration(new DividerItemDecoration(context, orientation));
  }
}
