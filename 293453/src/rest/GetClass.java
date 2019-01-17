package rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.MarshallerClass;
import model.RatesInfo;
import model.RatesList;

@Path("exchangerates/rates/{table}/{code}/{topCount}")
public class GetClass{ 

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getXML(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount){
		RatesInfo ratesInfo = getData(table, code, topCount);
		return Response.status(Response.Status.OK).type(MediaType.APPLICATION_XML).entity(ratesInfo).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJSON(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount) {
		RatesInfo ratesInfo = getData(table, code, topCount);
		return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(ratesInfo).build();
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public Response getHTML(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount) {
		RatesInfo ratesInfo = getData(table, code, topCount);
		String s = 				
				"<html><body>"
				+ "<p>Name: " + ratesInfo.getName() + "</p>"
				+ "<p>Code: " + ratesInfo.getCode() + "</p>"
				+ "<p>Mid: " + ratesInfo.getAverageMid() + "</p>"
				+ "<p>Bid: " + ratesInfo.getAverageBid() + "</p>"
				+ "<p>Ask: " + ratesInfo.getAverageAsk() + "</p>"
				+ "</body></html>";
		return Response.status(Response.Status.OK).type(MediaType.TEXT_HTML).entity(s).build();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPlainText(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") String topCount) {
		RatesInfo ratesInfo = getData(table, code, topCount);
		String s = 	"Name: " + ratesInfo.getName() + "   Code: " + ratesInfo.getCode() + "   Mid: " + ratesInfo.getAverageMid() + "   Bid: " + ratesInfo.getAverageBid() + "   Ask: " + ratesInfo.getAverageAsk();
		return s;
	}
	
	public static RatesInfo getData(String table, String code, String topCount) {
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
		return ratesInfo;
		//return MarshallerClass.marshallToXml(ratesInfo);
	}
}
