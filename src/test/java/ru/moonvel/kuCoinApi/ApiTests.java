package ru.moonvel.kuCoinApi;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.moonvel.kuCoinApi.tools.HighToLowChangeRateComparator;
import ru.moonvel.kuCoinApi.tools.ApiSpecification;

public class ApiTests {

  public static final String BASE_URL = "https://api.kucoin.com/";

  public List<TickerData> getTickers() {
    ApiSpecification.installSpecification(ApiSpecification.requestSpec(BASE_URL), ApiSpecification.responseSpecOK200());
    return given()
        .when()
        .get("api/v1/market/allTickers")
        .then()
        .extract().jsonPath().getList("data.ticker", TickerData.class);
  }

  @Test
  public void numberOfBtcPairsIsMoreThan100Test() {
    List<TickerData> usdtTickers = getTickers().stream()
        .filter(ticker -> ticker.getSymbol().endsWith("BTC")).toList();
    assertThat(
        usdtTickers.size() > 100).isTrue();
  }

  @Test
  public void changeRateIsGreaterThan10Test() {
    List<TickerData> topFiveHighToLowChangeRate = getTickers().stream()
        .filter(ticker -> ticker.getSymbol().endsWith("BTC"))
        .sorted(new HighToLowChangeRateComparator())
        .limit(5)
        .toList();
    assertThat
        (topFiveHighToLowChangeRate.get(0).getChangeRate()).isGreaterThan("0.1");
  }

  @Test
  public void isPriceOfFirstCurrencyIsNonNegativeTest() {
    List<TickerShortData> tickerShort = new ArrayList<>();
    getTickers().stream().limit(10).forEach(ticker -> tickerShort.add(
        new TickerShortData(ticker.getSymbolName(), Float.parseFloat(ticker.getAveragePrice()))));
    tickerShort.forEach(ticker -> assertThat(ticker.getAvgPrice() >= 0).isTrue());
  }
}
