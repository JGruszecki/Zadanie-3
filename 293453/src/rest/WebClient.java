package rest;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import model.UnmarshallerClass;
import model.RatesList;

public class WebClient {
	

	
	public static RatesList getAnswer(String table, String code, String topCount) {
		
		WebTarget webTarget;
		String answer;
		
		Client client = ClientBuilder.newClient();
		
		URI uri = URI.create("http://api.nbp.pl/api/exchangerates/rates/");
		
		webTarget = client.target(uri);
		webTarget = webTarget.path(table).path(code).path("last").path(topCount);
		
		answer = webTarget.request().accept(MediaType.TEXT_XML).get(String.class);
		RatesList ratesList = UnmarshallerClass.unmarshall(answer);
		return ratesList;
	}
}