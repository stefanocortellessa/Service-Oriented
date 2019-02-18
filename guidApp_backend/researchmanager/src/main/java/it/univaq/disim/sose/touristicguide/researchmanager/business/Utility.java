package it.univaq.disim.sose.touristicguide.researchmanager.business;

import java.security.SecureRandom;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Utility {

	protected static SecureRandom random = new SecureRandom();

	//Method that generates a Token
	public static String generateToken() {
		
		long longToken = Math.abs(random.nextLong());
		
		return Long.toString(longToken, 200);
	}

	//Method that converts XMLGregorianCalendar to Date
	public Date convertDate(XMLGregorianCalendar calendar){

		if(calendar == null) {
			return null;
		}
		Date date = (Date) calendar.toGregorianCalendar().getTime();
		date.setTime(date.getTime() - 3600 * 1000);

		return date;
	}

	//Method that converts Date to XMLGregorianCalendar
	public XMLGregorianCalendar convertToXML(Date date){

		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(date);
		XMLGregorianCalendar xmlCalendar = null;
		try {
			xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
			xmlCalendar.setTimezone(1);
		} catch (DatatypeConfigurationException ex) {
		}
		return xmlCalendar;
	}
}


