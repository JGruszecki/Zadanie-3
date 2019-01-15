package model;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.StringWriter;

public class MarshallerClass {
	
	public static String marshallToXml(RatesInfo currencyInfo)	{
		try {
			JAXBContext jaXBContext = JAXBContext.newInstance(RatesInfo.class);
			Marshaller marshaler = jaXBContext.createMarshaller();
			StringWriter stringWriter = new StringWriter();
			marshaler.marshal( currencyInfo, stringWriter);
			String currencyInfoXML = stringWriter.toString();
			return currencyInfoXML;

		}
		catch(JAXBException exception){
			return null;
		}
	}
}
