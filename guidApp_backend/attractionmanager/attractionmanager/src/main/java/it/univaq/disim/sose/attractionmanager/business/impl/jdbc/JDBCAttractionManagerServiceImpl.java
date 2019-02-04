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
import it.univaq.disim.sose.attractionmanager.business.AttractionManagerService;
import it.univaq.disim.sose.attractionmanager.business.model.Category;
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
		
		attraction.setName(parameters.getName());
		attraction.setCity(parameters.getCity());
		attraction.setAddress(parameters.getAddress());
		
		/*----SI DEVE CONTROLLARE CHE ID E NAME CORRISPONDONO PRIMA DI INSERIRE----*/
		category.setId(parameters.getCategoryId());
		category.setName(parameters.getCategoryName());
		attraction.setCategory(category);
		/*-------------------------------------------------------------------------*/
		InsertAttractionResponse responseAttraction = new InsertAttractionResponse();
		try {
			
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			if(insert(connection, attraction.getName(), attraction.getCity(), attraction.getAddress(), attraction.getCategory().getId())) {
				
				result = "Attraction inserted";
				
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
		
		Attraction Attraction = new Attraction();
		
		// PRENDERE ANCHE ID UTENTE CHE VUOLE CANCELLARE E VEDERE SE È LUI IL CREATORE!
		Attraction.setId(parameters.getId());
		
		DeleteAttractionResponse responseAttraction = new DeleteAttractionResponse();
		
		try {
			
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			
			if(delete(connection, Attraction.getId())) {
				
				result = "Attraction Deleted!";
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
	
	public boolean insert(Connection con, String name, String city, String address, Long idCategory) {
        
		String query = "INSERT INTO attractions (name, city, address, id_category) VALUES (?,?,?,?)";

		try {

			PreparedStatement sql = con.prepareStatement(query);
			
			sql.setString(1, name);
			sql.setString(2, city);
			sql.setString(3, address);
			sql.setLong(4, idCategory);
				
			
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
	
}
