package model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CurrencyInfo")
public class RatesInfo {
	
	String name;
	String code;
	String table;
	String averageMid;
	String averageBid;
	String averageAsk;
	
	@XmlElement(name = "Currency")
	public String getName() {
		return name;
	}
	
	@XmlElement(name = "Code")
	public String getCode() {
		return code;
	}
		
	@XmlElement(name = "Table")
	public String getTable() {
		return table;
	}
	
	@XmlElement(name = "Mid")
	public String getAverageMid() {
		return averageMid;
	}
		
	@XmlElement(name = "Bid")
	public String getAverageBid() {
		return averageBid;
	}
		
	@XmlElement(name = "Ask")
	public String getAverageAsk() {
		return averageAsk;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setTable(String table) {
		this.table = table;
	}
	
	public void setAverageMid(String averageMid) {
		this.averageMid = averageMid;
	}

	public void setAverageBid(String averageBid) 
	{
		this.averageBid = averageBid;
	}

	public void setAverageAsk(String averageAsk) {
		this.averageAsk = averageAsk;
	}
	
}
