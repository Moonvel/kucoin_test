package ru.moonvel.kuCoinApi;

public class TickerData {
	private String symbol;
	private String last;
	private String makerFeeRate;
	private String bestBidSize;
	private String buy;
	private String sell;
	private String makerCoefficient;
	private String volValue;
	private String high;
	private String vol;
	private String low;
	private String changePrice;
	private String takerFeeRate;
	private String takerCoefficient;
	private String symbolName;
	private String averagePrice;
	private String changeRate;
	private String bestAskSize;

	public TickerData() {
	}

	public TickerData(String symbol, String last, String makerFeeRate, String bestBidSize, String buy,
			String sell, String makerCoefficient, String volValue, String high, String vol, String low,
			String changePrice, String takerFeeRate, String takerCoefficient, String symbolName,
			String averagePrice, String changeRate, String bestAskSize) {
		this.symbol = symbol;
		this.last = last;
		this.makerFeeRate = makerFeeRate;
		this.bestBidSize = bestBidSize;
		this.buy = buy;
		this.sell = sell;
		this.makerCoefficient = makerCoefficient;
		this.volValue = volValue;
		this.high = high;
		this.vol = vol;
		this.low = low;
		this.changePrice = changePrice;
		this.takerFeeRate = takerFeeRate;
		this.takerCoefficient = takerCoefficient;
		this.symbolName = symbolName;
		this.averagePrice = averagePrice;
		this.changeRate = changeRate;
		this.bestAskSize = bestAskSize;
	}

	public String getSymbol(){
		return symbol;
	}

	public String getLast(){
		return last;
	}

	public String getMakerFeeRate(){
		return makerFeeRate;
	}

	public String getBestBidSize(){
		return bestBidSize;
	}

	public String getBuy(){
		return buy;
	}

	public String getSell(){
		return sell;
	}

	public String getMakerCoefficient(){
		return makerCoefficient;
	}

	public String getVolValue(){
		return volValue;
	}

	public String getHigh(){
		return high;
	}

	public String getVol(){
		return vol;
	}

	public String getLow(){
		return low;
	}

	public String getChangePrice(){
		return changePrice;
	}

	public String getTakerFeeRate(){
		return takerFeeRate;
	}

	public String getTakerCoefficient(){
		return takerCoefficient;
	}

	public String getSymbolName(){
		return symbolName;
	}

	public String getAveragePrice(){
		return averagePrice;
	}

	public String getChangeRate(){
		return changeRate;
	}

	public String getBestAskSize(){
		return bestAskSize;
	}

}
