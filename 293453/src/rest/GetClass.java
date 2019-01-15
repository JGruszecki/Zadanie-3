package rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import model.MarshallerClass;
import model.RatesInfo;
import model.RatesList;

@Path("exchangerates/rates/{table}/{code}/{topCount}")
public class GetClass{ 

	@GET
	@Produces({ MediaType.APPLICATION_XML })
	public String getXML(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount){

		return getData(table, code, topCount);
	}
	
	
	public static String getData(String table, String code, String topCount) {
		RatesList rates = WebClient.getAnswer(table, code, topCount);
		RatesInfo ratesInfo = new RatesInfo();
		ratesInfo.setCode(rates.getCode());
		ratesInfo.setName(rates.getName());
		ratesInfo.setTable(rates.getTable());
		if(rates.calculateAverageMid() > 0) {
			ratesInfo.setAverageMid(Double.toString(rates.calculateAverageMid()));}
		else 
			ratesInfo.setAverageMid("BRAK DANYCH");
		if(rates.calculateAverageBid() > 0) {
			ratesInfo.setAverageBid(Double.toString(rates.calculateAverageBid()));}
		else
			ratesInfo.setAverageBid("BRAK DANYCH");
		if(rates.calculateAverageAsk() > 0) {
			ratesInfo.setAverageAsk(Double.toString(rates.calculateAverageAsk()));}
		else
			ratesInfo.setAverageAsk("BRAK DANYCH");
		return MarshallerClass.marshallToXml(ratesInfo);
	}
}
