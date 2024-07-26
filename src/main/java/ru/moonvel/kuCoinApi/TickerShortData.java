package ru.moonvel.kuCoinApi;

public class TickerShortData {
  private String name;
  private Float avgPrice;

  public TickerShortData(String name, Float changeRate) {
    this.name = name;
    this.avgPrice = changeRate;
  }

  public String getName() {
    return name;
  }

  public Float getAvgPrice() {
    return avgPrice;
  }
}
