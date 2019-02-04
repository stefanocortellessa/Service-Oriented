package it.univaq.disim.sose.insertevent.business.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.insertevent.CheckSessionFault_Exception;
import it.univaq.disim.sose.insertevent.CheckSessionRequest;
import it.univaq.disim.sose.insertevent.CheckSessionResponse;
import it.univaq.disim.sose.insertevent.DeleteEventFault_Exception;
import it.univaq.disim.sose.insertevent.DeleteEventRequest;
import it.univaq.disim.sose.insertevent.DeleteEventResponse;
import it.univaq.disim.sose.insertevent.InsertEventFault_Exception;
import it.univaq.disim.sose.insertevent.InsertEventRequest;
import it.univaq.disim.sose.insertevent.InsertEventResponse;
import it.univaq.disim.sose.insertevent.business.InsertEventService;
import it.univaq.disim.sose.insertevent.business.model.Event;

@Service
public class JDBCEventManagerServiceImpl implements InsertEventService {
		
	@Autowired
	private DataSource dataSource;
	
	@Override
	public InsertEventResponse insertEvent(InsertEventRequest parameters) throws InsertEventFault_Exception {
				
		Connection connection = null;
		String result = "Event not inserted";
		
		Event event = new Event();
		
		event.setTitle(parameters.getTitle());
		event.setPlace(parameters.getPlace());
		event.setCity(parameters.getCity());
		event.setStartDate(toDate(parameters.getStartDate()));
		event.setEndDate(toDate(parameters.getEndDate()));
		
		InsertEventResponse responseEvent = new InsertEventResponse();
		
		try {
			
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			if(insert(connection, event.getTitle(), event.getPlace(), event.getCity(), event.getStartDate(), event.getEndDate())) {
				
				result = "Event inserted";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new InsertEventFault_Exception("Something was wrong with Insert an Event..");
		}
		finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			
		responseEvent.setMessage(result);
			
		return responseEvent;
	}
	
	@Override
	public CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception {
		
		CheckSessionResponse responseSession = new CheckSessionResponse();
		
		String sql = "SELECT * FROM sessions WHERE token = ?";
		
		Connection connection = null;
		PreparedStatement par = null;
		ResultSet rs = null;
		
		try {			
			connection = dataSource.getConnection();
			par = connection.prepareStatement(sql);
			
			par.setString(1, parameters.getToken());
			rs = par.executeQuery();
			
			rs.last();
			int num_rows = rs.getRow();
			
			if(num_rows != 0) {
				responseSession.setResponse(true);
			} else {
				responseSession.setResponse(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CheckSessionFault_Exception("Something was wrong with Checking Session..");
		} finally {
			if (par != null) {
				try {
					par.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		return responseSession;
	}

	//vedere per quali parametri cancellare un evento, eventualmente cambiare il wsdl
	@Override
	public DeleteEventResponse deleteEvent(DeleteEventRequest parameters) throws DeleteEventFault_Exception {
				
		Connection connection = null;
		String result = "Event not Deleted";
		
		Event event = new Event();
		
		event.setTitle(parameters.getTitle());
		event.setCity(parameters.getCity());
		
		DeleteEventResponse responseEvent = new DeleteEventResponse();
		
		try {
			
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			if(delete(connection, event.getTitle(), event.getCity())) {
				
				result = "Event Deleted!";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DeleteEventFault_Exception("Something was wrong with Deleting an Event..");
		}
		finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			
		responseEvent.setMessage(result);
			
		return responseEvent;
	}
	
	public boolean insert(Connection con, String title, String place, String city, Timestamp startDate, Timestamp endDate) {

		String query = "INSERT INTO events (title, place, city, startDate, endDate) VALUES (?,?,?,?,?)";

		try {

			PreparedStatement sql = con.prepareStatement(query);
			
			sql.setString(1, title);
			sql.setString(2, place);
			sql.setString(3, city);
			sql.setTimestamp(4, startDate);
			sql.setTimestamp(5, endDate);
						
			if (sql.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
 
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean delete(Connection con, String title, String city) {

		String query = "DELETE FROM events WHERE title = ? AND city = ?";

		try {

			PreparedStatement sql = con.prepareStatement(query);
			
			sql.setString(1, title);
			sql.setString(2, city);
						
			if (sql.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
	
	public static Date toDate(XMLGregorianCalendar calendar){
        
		if(calendar == null) {
			return null;
        }
		
        Date date = (Date) calendar.toGregorianCalendar().getTime();
        date.setTime(date.getTime() - 3600 * 1000);
        
        return date;
    }
}
