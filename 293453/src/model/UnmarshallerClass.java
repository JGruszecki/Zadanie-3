package model;


import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import java.io.StringReader;

public class UnmarshallerClass {

	public static RatesList unmarshall(String answer) {
		try {
			JAXBContext jaXBContext = JAXBContext.newInstance(RatesList.class, Rate.class);
			Unmarshaller unmarshaller = jaXBContext.createUnmarshaller();
			StringReader stringReader = new StringReader(answer);
			RatesList ratesList = (RatesList) unmarshaller.unmarshal(stringReader);
			return ratesList;
		} catch (Exception e) {
			return null;
		}
	}
}
