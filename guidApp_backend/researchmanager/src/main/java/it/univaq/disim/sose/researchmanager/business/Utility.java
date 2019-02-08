package it.univaq.disim.sose.researchmanager.business;

import java.security.SecureRandom;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Utility {

	protected static SecureRandom random = new SecureRandom();

	public static String generateToken() {
		long longToken = Math.abs(random.nextLong());
		return Long.toString(longToken, 200);

	}


	public Date convertDate(XMLGregorianCalendar calendar){

		if(calendar == null) {
			return null;
		}

		Date date = (Date) calendar.toGregorianCalendar().getTime();
		date.setTime(date.getTime() - 3600 * 1000);

		return date;
	}

	public XMLGregorianCalendar convertToXML(Date date){

		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(date);
		XMLGregorianCalendar xmlCalendar = null;
		try {
			xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
		} catch (DatatypeConfigurationException ex) {
		}
		return xmlCalendar;
	}
}


