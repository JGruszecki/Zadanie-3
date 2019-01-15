package model;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ExchangeRatesSeries")
public class RatesList {
	
	private String table;
	private String name;
	private String code;
	
	private List<Rate> ratesList = new ArrayList<>();
	
	
	public RatesList() {	}
	
	public RatesList(String name, String code, String table, List<Rate> ratesList) {
		this.table = table;
		this.name = name;
		this.code = code;
		this.ratesList = ratesList;
	}
	
	@XmlElement(name = "Table")
	public String getTable() {
		return table;
	}
	
	@XmlElement(name = "Currency")
	public String getName() {
		return name;
	}
	
	@XmlElement(name = "Code")
	public String getCode() {
		return code;
	}
	
	@XmlElementWrapper(name = "Rates" )
	@XmlElement(name = "Rate")
	public List<Rate> getRatesList() 
	{
		return ratesList;
	}
	
	public void setTable(String table) {
		this.table = table;
	}
	
	public void setCurrencyName(String currencyName) {
		this.name = currencyName;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setRatesList(List<Rate> ratesList) {
		this.ratesList = ratesList;
	}
	
	public double calculateAverageMid() {
		double averageMid = 0.0;
		for(Rate rate: ratesList) {
			averageMid = averageMid + rate.getMid();
		}
		averageMid = averageMid / ratesList.size();
		if(averageMid < 0)
			return 0.0;
		else return averageMid;
	}
	
	public double calculateAverageBid() {
		double avBid = 0.0;
		for(Rate rate: ratesList) {
			avBid += rate.getBid();
		}
		avBid /= ratesList.size();
		if(avBid < 0)
			return 0.0;
		else return avBid;
	}
	
	public double calculateAverageAsk() {
		double avAsk = 0.0;
		for(Rate rate: ratesList) {
			avAsk += rate.getAsk();
		}
		avAsk /= ratesList.size();
		if(avAsk < 0)
			return 0.0;
		else return avAsk;
	}
}
