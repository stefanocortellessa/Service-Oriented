package it.univaq.disim.sose.touristicguide.eventmanager.business.impl.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.touristicguide.eventmanager.business.EventManagerService;
import it.univaq.disim.sose.touristicguide.eventmanager.business.Utility;
import it.univaq.disim.sose.touristicguide.eventmanager.business.model.Category;
import it.univaq.disim.sose.touristicguide.eventmanager.business.model.Event;
import it.univaq.disim.sose.touristicguide.eventmanager.business.model.User;
import it.univaq.disim.sose.touristicguide.eventmanager.DeleteEventFault_Exception;
import it.univaq.disim.sose.touristicguide.eventmanager.DeleteEventRequest;
import it.univaq.disim.sose.touristicguide.eventmanager.DeleteEventResponse;
import it.univaq.disim.sose.touristicguide.eventmanager.InsertEventFault_Exception;
import it.univaq.disim.sose.touristicguide.eventmanager.InsertEventRequest;
import it.univaq.disim.sose.touristicguide.eventmanager.InsertEventResponse;
import it.univaq.disim.sose.touristicguide.eventmanager.UpdateEventRequest;
import it.univaq.disim.sose.touristicguide.eventmanager.UpdateEventFault_Exception;
import it.univaq.disim.sose.touristicguide.eventmanager.UpdateEventResponse;

@Service
public class JDBCEventManagerServiceImpl implements EventManagerService {

	@Autowired
	private DataSource dataSource;

	// store event on db
	@Override
	public InsertEventResponse insertEvent(InsertEventRequest parameters) throws InsertEventFault_Exception {
		
		Connection connection = null;
		InsertEventResponse response = new InsertEventResponse();
		String result = "Event not inserted";
		Utility utility = new Utility();
		Event event = new Event();
		Category category = new Category();
		User creator = new User();
		
		// construct event object using request parameters
		event.setTitle(parameters.getTitle());
		event.setLocality(parameters.getLocality());
		event.setStartDate(utility.convertDate(parameters.getStartDate()));
		event.setEndDate(utility.convertDate(parameters.getEndDate()));
		
		category.setId(parameters.getCategoryId());
		category.setName(parameters.getCategoryName());

		creator.setId(parameters.getCreatorId());

		event.setCategory(category);
		event.setCreator(creator);
		event.setLat(parameters.getLat());
		event.setLng(parameters.getLng());

		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			// store event on db
			if (insert(connection, 
					   event.getTitle(), 
					   event.getLocality(), 
					   event.getStartDate(), 
					   event.getEndDate(),
					   event.getCategory().getId(), 
					   event.getCreator().getId(), 
					   event.getLat(), 
					   event.getLng())) {

				result = "Event Inserted";

			} else {
				
				result = "Event NOT Inserted";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new InsertEventFault_Exception("Something went wrong with Insert Event..");
		} finally {
			if (connection != null) {
				try {
					
					connection.setAutoCommit(true);
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		response.setMessage(result);

		return response;
	}

	// delete event from db 
	@Override
	public DeleteEventResponse deleteEvent(DeleteEventRequest parameters) throws DeleteEventFault_Exception {

		Connection connection = null;
		DeleteEventResponse response = new DeleteEventResponse();
		String result = "Event NOT Deleted";
		Event event = new Event();
		User user = new User();
		
		event.setId(parameters.getId());
		
		user.setId(parameters.getUserId());
		
		event.setCreator(user);

		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			// first of all check that user requiring event delete is the same that created the event 
			// if it is not, the deletion in not allowed
			if (check_creator(connection, 
							  event.getId(), 
						   	  event.getCreator().getId())) {
				// if user is the creator, require deletion from db
				if (delete(connection, 
						   event.getId())) {
					
					result = "Event Deleted!";
				} else {
					result = "Event NOT Deleted!";
				}
			} else {
				result = "Event NOT Deleted: user is NOT its creator";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DeleteEventFault_Exception("Something went wrong with Deleting an Event..");
		} finally {
			if (connection != null) {
				try {
					connection.setAutoCommit(true);
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		response.setMessage(result);

		return response;
	}

	// update event on db
	@Override
	public UpdateEventResponse updateEvent(UpdateEventRequest parameters) throws UpdateEventFault_Exception {

		Connection connection = null;
		UpdateEventResponse response = new UpdateEventResponse();
		String result = "Event NOT Updated";
		Event event = new Event();
		Utility utility = new Utility();
		Category category = new Category();
		User creator = new User();
		
		// construct event using request parameters
		event.setId(parameters.getId());
		event.setTitle(parameters.getTitle());
		event.setLocality(parameters.getLocality());
		event.setStartDate(utility.convertDate(parameters.getStartDate()));
		event.setEndDate(utility.convertDate(parameters.getEndDate()));

		category.setId(parameters.getCategoryId());
		category.setName(parameters.getCategoryName());

		creator.setId(parameters.getCreatorId());

		event.setCategory(category);
		event.setCreator(creator);
		event.setLat(parameters.getLat());
		event.setLng(parameters.getLng());

		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			// user requiring the update has to be the event creator
			if (check_creator(connection, 
							  event.getId(), 
							  event.getCreator().getId())) {
				// if it is, then require the update
				if (update(connection, 
						   event.getId(), 
						   event.getTitle(), 
						   event.getLocality(), 
						   event.getStartDate(),
						   event.getEndDate(), 
						   event.getCategory().getId(), 
						   event.getCreator().getId(), 
						   event.getLat(),
						   event.getLng())) {

					result = "Event Updated";

				} else {
					result = "Event NOT Updated";
				}
			} else {
				
				result = "Event NOT updated: user is NOT its creator";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UpdateEventFault_Exception("Something went wrong with Update Event..");
		} finally {
			if (connection != null) {
				try {
					
					connection.setAutoCommit(true);
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		response.setMessage(result);

		return response;
	}

	//Method that queries the database inserting an event in it
	public boolean insert(Connection con, String title, String locality, Timestamp startDate, Timestamp endDate,
			Long idCategory, Long idCreator, String lat, String lng) {

		String query = "INSERT INTO events (title, locality, startDate, endDate, id_category, id_creator, lat, lng) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement sql = null;
		
		try {

			sql = con.prepareStatement(query);

			sql.setString(1, title);
			sql.setString(2, locality);
			sql.setTimestamp(3, startDate);
			sql.setTimestamp(4, endDate);
			sql.setLong(5, idCategory);
			sql.setLong(6, idCreator);
			sql.setString(7, lat);
			sql.setString(8, lng);

			System.out.println(sql.toString());
			if (sql.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			return false;
		} finally {
			if (sql != null) {
				try {
					sql.close();
				} catch (SQLException e) {
				}
			}
		}
	}
	
	//Method that queries the database deleting an event in it
	public boolean delete(Connection con, Long id) {

		String query = "DELETE FROM events WHERE id = ?";
		PreparedStatement sql = null;
		
		try {

			sql = con.prepareStatement(query);

			sql.setLong(1, id);

			if (sql.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		} finally {
			if (sql != null) {
				try {
					sql.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	//Method that queries the database updating an event in it
	public boolean update(Connection con, Long id, String title, String locality, Timestamp startDate,
			Timestamp endDate, Long idCategory, Long idCreator, String lat, String lng) {

		String query = "UPDATE events SET title=?, locality=?, startDate=?, endDate=?, id_category=?, id_creator=?, lat=?, lng=? WHERE id=?";
		PreparedStatement sql = null;
		try {

			sql = con.prepareStatement(query);

			sql.setString(1, title);
			sql.setString(2, locality);
			sql.setTimestamp(3, startDate);
			sql.setTimestamp(4, endDate);
			sql.setLong(5, idCategory);
			sql.setLong(6, idCreator);
			sql.setString(7, lat);
			sql.setString(8, lng);
			sql.setLong(9, id);

			if (sql.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			return false;
		} finally {
			if (sql != null) {
				try {
					sql.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	//Method that queries the database checking if the user 
	//that want to do something on an event is its creator
	public boolean check_creator(Connection con, Long id, Long userId) {
		
		String query = "SELECT id_creator FROM events WHERE id = ?";
		PreparedStatement sql = null;
		
		try {
			sql = con.prepareStatement(query);

			sql.setLong(1, id);

			ResultSet rs = sql.executeQuery();
			
			while (rs.next()) {
				if (rs.getLong("id_creator") == userId) {
					
					System.out.println("Event Creator Identified");
					
					return true;
				} else {
					
					return false;
				}
			}
			return false;
		} catch (SQLException e) {
			return false;
		} finally {
			if (sql != null) {
				try {
					sql.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
