package ru.moonvel.kuCoinApi.tools;

import java.util.Comparator;
import ru.moonvel.kuCoinApi.TickerData;

public class HighToLowChangeRateComparator implements Comparator<TickerData> {

  /**
   * Компоратор сравнивает величину изменения стоимости валюты от большей к меньшей.
   * @param o1 the first object to be compared.
   * @param o2 the second object to be compared.
   */
  @Override
  public int compare(TickerData o1, TickerData o2) {
    return Float.compare(Float.parseFloat(o2.getChangeRate()), Float.parseFloat(o1.getChangeRate()));
  }
}
