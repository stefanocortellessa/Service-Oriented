package it.univaq.disim.sose.touristicguide.routingrequests.model.Utility;

import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Utility {

	//Method that converts Date to XMLGregorianCalendar
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