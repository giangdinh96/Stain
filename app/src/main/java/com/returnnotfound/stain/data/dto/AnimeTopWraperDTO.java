package com.returnnotfound.stain.data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnimeTopWraperDTO {
  @SerializedName("error")
  private String error;
  @SerializedName("top")
  private List<AnimeTopDTO> topList;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public List<AnimeTopDTO> getTopList() {
    return topList;
  }

  public void setTopList(List<AnimeTopDTO> topList) {
    this.topList = topList;
  }
}
