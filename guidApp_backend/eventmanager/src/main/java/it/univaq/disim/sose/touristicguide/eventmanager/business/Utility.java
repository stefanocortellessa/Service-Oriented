package it.univaq.disim.sose.touristicguide.eventmanager.business;

import java.security.SecureRandom;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

public class Utility {

	protected static SecureRandom random = new SecureRandom();

	//Method that generates a Token
	public static String generateToken() {
		
		long longToken = Math.abs(random.nextLong());
		
		return Long.toString(longToken, 200);
	}

	//Method that converts date from XMLGregorianCalendar to Date
	public Date convertDate(XMLGregorianCalendar calendar){

		if(calendar == null) {
			return null;
		}

		Date date = (Date) calendar.toGregorianCalendar().getTime();
		date.setTime(date.getTime() - 3600 * 1000);

		return date;
	}
}


