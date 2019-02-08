package it.univaq.disim.sose.attractionmanager.business.impl.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.attractionmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.attractionmanager.CheckSessionRequest;
import it.univaq.disim.sose.attractionmanager.CheckSessionResponse;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionFault_Exception;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionRequest;
import it.univaq.disim.sose.attractionmanager.DeleteAttractionResponse;
import it.univaq.disim.sose.attractionmanager.InsertAttractionFault_Exception;
import it.univaq.disim.sose.attractionmanager.InsertAttractionRequest;
import it.univaq.disim.sose.attractionmanager.InsertAttractionResponse;
import it.univaq.disim.sose.attractionmanager.UpdateAttractionFault_Exception;
import it.univaq.disim.sose.attractionmanager.UpdateAttractionRequest;
import it.univaq.disim.sose.attractionmanager.UpdateAttractionResponse;
import it.univaq.disim.sose.attractionmanager.business.AttractionManagerService;
import it.univaq.disim.sose.attractionmanager.business.model.Category;
import it.univaq.disim.sose.attractionmanager.business.model.User;
import it.univaq.disim.sose.attractionmanager.business.model.Attraction;
import it.univaq.disim.sose.attractionmanager.business.Utility;

@Service
public class JDBCAttractionManagerServiceImpl implements AttractionManagerService {

	@Autowired
	private DataSource dataSource;

	@Override
	public InsertAttractionResponse insertAttraction(InsertAttractionRequest parameters) throws InsertAttractionFault_Exception {

		Connection connection = null;
		String result = "Attraction not inserted";

		Attraction attraction = new Attraction();
		Utility utility = new Utility();
		Category category = new Category();
		User creator = new User();

		attraction.setName(parameters.getName());
		attraction.setLocality(parameters.getLocality());

		/*----SI DEVE CONTROLLARE CHE ID E NAME CORRISPONDONO PRIMA DI INSERIRE----*/
		category.setId(parameters.getCategoryId());
		category.setName(parameters.getCategoryName());
		creator.setId(parameters.getCreatorId());
		attraction.setCategory(category);
		attraction.setCreator(creator);

		/*-------------------------------------------------------------------------*/
		InsertAttractionResponse responseAttraction = new InsertAttractionResponse();
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			if(insert(connection, attraction.getName(), attraction.getLocality(), attraction.getCategory().getId(), attraction.getCreator().getId())) {
				result = "Attraction inserted";
			}else {
				result = "Attraction not inserted";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new InsertAttractionFault_Exception("Something was wrong with Insert an Attraction..");
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

		responseAttraction.setMessage(result);

		return responseAttraction;
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

	//vedere per quali parametri cancellare un Attractiono, Attractionualmente cambiare il wsdl
	@Override
	public DeleteAttractionResponse deleteAttraction(DeleteAttractionRequest parameters) throws DeleteAttractionFault_Exception {

		Connection connection = null;
		String result = "Attraction not Deleted";

		Attraction attraction = new Attraction();
		User user = new User();

		// PRENDERE ANCHE ID UTENTE CHE VUOLE CANCELLARE E VEDERE SE È LUI IL CREATORE!
		attraction.setId(parameters.getId());
		user.setId(parameters.getUserId());
		
		attraction.setCreator(user);

		DeleteAttractionResponse responseAttraction = new DeleteAttractionResponse();

		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			if(check_creator(connection, attraction.getId(), attraction.getCreator().getId())) {
				if(delete(connection, attraction.getId())) {
					result = "Attraction Deleted!";
				}else {
					result = "Attraction not Deleted!";
				}
			}else {
				result = "Attraction not Deleted : user is not its creator";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DeleteAttractionFault_Exception("Something was wrong with Deleting an Attraction..");
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

		responseAttraction.setMessage(result);

		return responseAttraction;
	}

	@Override
	public UpdateAttractionResponse updateAttraction(UpdateAttractionRequest parameters) throws UpdateAttractionFault_Exception {

		Connection connection = null;
		String result = "Attraction not updated";

		Attraction attraction = new Attraction();
		Utility utility = new Utility();
		Category category = new Category();
		User creator = new User();
		
		attraction.setId(parameters.getId());
		attraction.setName(parameters.getName());
		attraction.setLocality(parameters.getLocality());

		/*----SI DEVE CONTROLLARE CHE ID E NAME CORRISPONDONO PRIMA DI INSERIRE----*/
		category.setId(parameters.getCategoryId());
		category.setName(parameters.getCategoryName());
		creator.setId(parameters.getCreatorId());
		
		attraction.setCategory(category);
		attraction.setCreator(creator);

		/*-------------------------------------------------------------------------*/
		UpdateAttractionResponse responseAttraction = new UpdateAttractionResponse();
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			if(check_creator(connection, attraction.getId(), attraction.getCreator().getId())) {	
				if(update(connection, attraction.getId(), attraction.getName(), attraction.getLocality(), attraction.getCategory().getId(), attraction.getCreator().getId())) {
					result = "Attraction updated";
				}else {
					result = "Attraction not updated";
				}
			}else {
				result = "Attraction not udpated: user is not its creator";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new UpdateAttractionFault_Exception("Something was wrong with Update an Attraction..");
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

		responseAttraction.setMessage(result);

		return responseAttraction;
	}

	
	
	public boolean insert(Connection con, String name, String locality, Long idCategory, Long idCreator) {

		String query = "INSERT INTO attractions (name, locality, id_category, id_creator) VALUES (?,?,?,?)";

		try {

			PreparedStatement sql = con.prepareStatement(query);

			sql.setString(1, name);
			sql.setString(2, locality);
			sql.setLong(3, idCategory);
			sql.setLong(4, idCreator);


			if (sql.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			return false;
		}
	}

	public boolean update(Connection con, Long id, String name, String locality, Long idCategory, Long idCreator) {

		String query = "UPDATE attractions SET name=?, locality=?, id_category=?, id_creator=? WHERE id=?";

		try {

			PreparedStatement sql = con.prepareStatement(query);

			sql.setString(1, name);
			sql.setString(2, locality);
			sql.setLong(3, idCategory);
			sql.setLong(4, idCreator);
			sql.setLong(5, id);


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

		String query = "DELETE FROM attractions WHERE id = ?";

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

	public boolean check_creator(Connection con, Long id, Long userId) {
		String query = "SELECT id_creator FROM attractions WHERE id = ?";

		try {
			PreparedStatement sql = con.prepareStatement(query);

			sql.setLong(1, id);

			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				if (rs.getLong("id_creator") == userId) {
					System.out.println("attraction creator identified");
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
