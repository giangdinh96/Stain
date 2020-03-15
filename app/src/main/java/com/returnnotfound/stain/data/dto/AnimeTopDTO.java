package com.returnnotfound.stain.data.dto;

import com.google.gson.annotations.SerializedName;

public class AnimeTopDTO {
  @SerializedName("mal_id")
  private int malId;
  @SerializedName("rank")
  private int rank;
  @SerializedName("title")
  private String title;
  @SerializedName("url")
  private String url;
  @SerializedName("image_url")
  private String imageUrl;
  @SerializedName("type")
  private String type;
  @SerializedName("members")
  private int members;
  @SerializedName("score")
  private int score;
  @SerializedName("start_date")
  private String startDate;

  public int getMalId() {
    return malId;
  }

  public void setMalId(int malId) {
    this.malId = malId;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getMembers() {
    return members;
  }

  public void setMembers(int members) {
    this.members = members;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }
}
