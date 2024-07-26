package ru.moonvel.kuCoinApi;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.http.ContentType;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import ru.moonvel.kuCoinApi.tools.HighToLowChangeRateComparator;

public class ApiTests {

  public static final String BASE_URL = "https://api.kucoin.com/";

  public List<TickerData> getTickers() {
    return given()
        .contentType(ContentType.JSON)
        .when()
        .get(BASE_URL + "api/v1/market/allTickers")
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
    getTickers().forEach(ticker -> tickerShort.add(
        new TickerShortData(ticker.getSymbolName(), Float.parseFloat(ticker.getAveragePrice()))));
    tickerShort.forEach(ticker -> assertThat(ticker.getAvgPrice() >= 0).isTrue());
  }
}
