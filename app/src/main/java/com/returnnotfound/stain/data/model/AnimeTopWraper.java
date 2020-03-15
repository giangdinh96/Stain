package com.returnnotfound.stain.data.model;

import java.util.List;

public class AnimeTopWraper {
  private String error;
  private List<AnimeTop> topList;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public List<AnimeTop> getTopList() {
    return topList;
  }

  public void setTopList(List<AnimeTop> topList) {
    this.topList = topList;
  }
}
