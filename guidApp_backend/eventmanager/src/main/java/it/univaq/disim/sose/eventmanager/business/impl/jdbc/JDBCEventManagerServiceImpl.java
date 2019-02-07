package it.univaq.disim.sose.eventmanager.business.impl.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.eventmanager.business.EventManagerService;
import it.univaq.disim.sose.eventmanager.business.Utility;
import it.univaq.disim.sose.eventmanager.business.model.Category;
import it.univaq.disim.sose.eventmanager.business.model.Event;
import it.univaq.disim.sose.eventmanager.business.model.User;
import it.univaq.disim.sose.eventmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.eventmanager.CheckSessionRequest;
import it.univaq.disim.sose.eventmanager.CheckSessionResponse;
import it.univaq.disim.sose.eventmanager.DeleteEventFault_Exception;
import it.univaq.disim.sose.eventmanager.DeleteEventRequest;
import it.univaq.disim.sose.eventmanager.DeleteEventResponse;
import it.univaq.disim.sose.eventmanager.InsertEventFault_Exception;
import it.univaq.disim.sose.eventmanager.InsertEventRequest;
import it.univaq.disim.sose.eventmanager.InsertEventResponse;
import it.univaq.disim.sose.eventmanager.UpdateEventRequest;
import it.univaq.disim.sose.eventmanager.UpdateEventFault_Exception;
import it.univaq.disim.sose.eventmanager.UpdateEventResponse;

@Service
public class JDBCEventManagerServiceImpl implements EventManagerService {

	@Autowired
	private DataSource dataSource;

	@Override
	public InsertEventResponse insertEvent(InsertEventRequest parameters) throws InsertEventFault_Exception {

		Connection connection = null;
		String result = "Event not inserted";

		Event event = new Event();
		Utility utility = new Utility();
		Category category = new Category();
		User creator = new User();

		event.setTitle(parameters.getTitle());
		event.setLocality(parameters.getLocality());
		event.setStartDate(utility.convertDate(parameters.getStartDate()));
		event.setEndDate(utility.convertDate(parameters.getEndDate()));
		/*----SI DEVE CONTROLLARE CHE ID E NAME CORRISPONDONO PRIMA DI INSERIRE----*/
		category.setId(parameters.getCategoryId());
		category.setName(parameters.getCategoryName());
		creator.setId(parameters.getCreatorId());
		event.setCategory(category);
		event.setCreator(creator);
		/*-------------------------------------------------------------------------*/
		InsertEventResponse responseEvent = new InsertEventResponse();
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			if(insert(connection, event.getTitle(), event.getLocality(), event.getStartDate(), event.getEndDate(), event.getCategory().getId(), event.getCreator().getId())) {

				result = "Event inserted";

			}else {
				result = "Event not inserted";
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
		User user = new User();
		// PRENDERE ANCHE ID UTENTE CHE VUOLE CANCELLARE E VEDERE SE È LUI IL CREATORE!
		event.setId(parameters.getId());
		user.setId(parameters.getUserId());
		event.setCreator(user);
		DeleteEventResponse responseEvent = new DeleteEventResponse();

		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			if(check_creator(connection, event.getId(), event.getCreator().getId())) {
				if(delete(connection, event.getId())) {
					result = "Event Deleted!";
				}else {
					result = "Event not Deleted!";
				}
			}else {
				result = "Event not Deleted : user is not its creator";
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

	@Override
	public UpdateEventResponse updateEvent(UpdateEventRequest parameters) throws UpdateEventFault_Exception {

		Connection connection = null;
		String result = "Event not updated";

		Event event = new Event();
		Utility utility = new Utility();
		Category category = new Category();
		User creator = new User();

		event.setId(parameters.getId());
		event.setTitle(parameters.getTitle());
		event.setLocality(parameters.getLocality());
		event.setStartDate(utility.convertDate(parameters.getStartDate()));
		event.setEndDate(utility.convertDate(parameters.getEndDate()));
		/*----SI DEVE CONTROLLARE CHE ID E NAME CORRISPONDONO PRIMA DI INSERIRE----*/
		category.setId(parameters.getCategoryId());
		category.setName(parameters.getCategoryName());
		creator.setId(parameters.getCreatorId());
		event.setCategory(category);
		event.setCreator(creator);
		/*-------------------------------------------------------------------------*/
		UpdateEventResponse responseEvent = new UpdateEventResponse();
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			if(check_creator(connection, event.getId(), event.getCreator().getId())) {
				if(update(connection, event.getId(), event.getTitle(), event.getLocality(), event.getStartDate(), event.getEndDate(), event.getCategory().getId(), event.getCreator().getId())) {

					result = "Event updated";

				}else {
					result = "Event not updated";
				}
			}else {
				result = "Event not updated: user is not its creator";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new UpdateEventFault_Exception("Something was wrong with Update an Event..");
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


	public boolean insert(Connection con, String title, String locality, Timestamp startDate, Timestamp endDate, Long idCategory, Long idCreator) {

		String query = "INSERT INTO events (title, locality, startDate, endDate, id_category, id_creator) VALUES (?,?,?,?,?,?)";

		try {

			PreparedStatement sql = con.prepareStatement(query);

			sql.setString(1, title);
			sql.setString(2, locality);
			sql.setTimestamp(3, startDate);
			sql.setTimestamp(4, endDate);
			sql.setLong(5, idCategory);
			sql.setLong(6, idCreator);

			if (sql.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			return false;
		}
	}

	public boolean delete(Connection con, Long id) {

		String query = "DELETE FROM events WHERE id = ?";

		try {

			PreparedStatement sql = con.prepareStatement(query);

			sql.setLong(1, id);

			if (sql.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean update(Connection con, Long id, String title, String locality, Timestamp startDate, Timestamp endDate, Long idCategory, Long idCreator) {

		String query = "UPDATE events SET title=?, locality=?, startDate=?, endDate=?, id_category=?, id_creator=? WHERE id=?";

		try {

			PreparedStatement sql = con.prepareStatement(query);
			
			sql.setString(1, title);
			sql.setString(2, locality);
			sql.setTimestamp(3, startDate);
			sql.setTimestamp(4, endDate);
			sql.setLong(5, idCategory);
			sql.setLong(6, idCreator);
			sql.setLong(7, id);
			
			if (sql.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			return false;
		}
	}

	public boolean check_creator(Connection con, Long id, Long userId) {
		String query = "SELECT id_creator FROM events WHERE id = ?";

		try {
			PreparedStatement sql = con.prepareStatement(query);

			sql.setLong(1, id);

			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				if (rs.getLong("id_creator") == userId) {
					System.out.println("event creator identified");
					return true;
				} else {
					return false;
				}
			} return false;
		} catch (SQLException e) {
			return false;
		}
	}

}
