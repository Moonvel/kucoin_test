package ru.moonvel.kuCoinApi;

import java.util.List;

public class Root {
	private List<TickerData> ticker;
	private long time;

	public List<TickerData> getTicker(){
		return ticker;
	}

	public long getTime(){
		return time;
	}
}
