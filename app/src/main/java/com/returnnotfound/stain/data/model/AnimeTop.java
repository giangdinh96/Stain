package com.returnnotfound.stain.data.model;

public class AnimeTop {
  private int malId;
  private int rank;
  private String title;
  private String url;
  private String imageUrl;
  private String type;
  private int members;
  private int score;
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

  public String getRankColor() {
    switch (rank) {
      case 1:
        return "#218517";
      case 2:
        return "#E91E63";
      case 3:
        return "#772363";
      default:
        return "#A5743F";
    }
  }
}
