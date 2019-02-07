package it.univaq.disim.sose.researchmanager.business.impl.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.researchmanager.AttractionElement;
import it.univaq.disim.sose.researchmanager.AttractionsList;
import it.univaq.disim.sose.researchmanager.EventElement;
import it.univaq.disim.sose.researchmanager.EventsList;
import it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorRequest;
import it.univaq.disim.sose.researchmanager.ResearchAttractionByCreatorResponse;
import it.univaq.disim.sose.researchmanager.ResearchAttractionDetailFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchAttractionDetailRequest;
import it.univaq.disim.sose.researchmanager.ResearchAttractionDetailResponse;
import it.univaq.disim.sose.researchmanager.ResearchAttractionFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchAttractionRequest;
import it.univaq.disim.sose.researchmanager.ResearchAttractionResponse;
import it.univaq.disim.sose.researchmanager.ResearchEventByCreatorFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchEventByCreatorRequest;
import it.univaq.disim.sose.researchmanager.ResearchEventByCreatorResponse;
import it.univaq.disim.sose.researchmanager.ResearchEventDetailFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchEventDetailRequest;
import it.univaq.disim.sose.researchmanager.ResearchEventDetailResponse;
import it.univaq.disim.sose.researchmanager.ResearchEventFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchEventRequest;
import it.univaq.disim.sose.researchmanager.ResearchEventResponse;
import it.univaq.disim.sose.researchmanager.business.ResearchManagerService;
import it.univaq.disim.sose.researchmanager.business.Utility;
import it.univaq.disim.sose.researchmanager.business.model.User;

@Service
public class JDBCResearchManagerServiceImpl implements ResearchManagerService {

	@Autowired
	private DataSource dataSource;

	@Override
	public ResearchAttractionByCreatorResponse researchAttractionByCreator(ResearchAttractionByCreatorRequest parameters) throws ResearchAttractionByCreatorFault_Exception {

		Connection connection = null;
		AttractionsList return_list = new AttractionsList();
		User creator = new User();

		creator.setId(parameters.getCreatorId());

		/*-------------------------------------------------------------------------*/
		ResearchAttractionByCreatorResponse responseAttractionByCreator = new ResearchAttractionByCreatorResponse();
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			return_list = selectAttractionByCreator(connection, creator.getId());

		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new ResearchAttractionByCreatorFault_Exception("Something was wrong with Research Attraction for this user..");
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
		
		responseAttractionByCreator.setAttractionsList(return_list);
		responseAttractionByCreator.setMessage("Returned Attraction List for this user");	
		return responseAttractionByCreator;
	}


	public AttractionsList selectAttractionByCreator(Connection con, Long idCreator) {

		AttractionsList return_list = new AttractionsList();
		AttractionElement attraction = new AttractionElement();
		String query = "SELECT * FROM attractions WHERE id_creator=?";

		try {

			PreparedStatement sql = con.prepareStatement(query);

			sql.setLong(1, idCreator);


			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				attraction.setId(rs.getLong("id"));
				attraction.setName(rs.getString("name"));
				attraction.setLocality(rs.getString("locality"));
				attraction.setCategoryId(rs.getLong("id_category"));
				attraction.setCreatorId(rs.getLong("id_creator"));
				return_list.getAttractionElement().add(attraction);
			}
			return return_list;

		} catch (SQLException e) {
			return return_list;
		}
	}


	@Override
	public ResearchAttractionResponse researchAttraction(ResearchAttractionRequest parameters)
			throws ResearchAttractionFault_Exception {
		/* per filtrare le attrazioni in base a : 
		 * - località
		 * - data
		 * - categoria
		 */
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResearchAttractionDetailResponse researchAttractionDetail(ResearchAttractionDetailRequest parameters)
			throws ResearchAttractionDetailFault_Exception {
		Connection connection = null;
		AttractionElement attraction_detail = new AttractionElement();


		/*-------------------------------------------------------------------------*/
		ResearchAttractionDetailResponse responseAttractionDetail = new ResearchAttractionDetailResponse();
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			attraction_detail = selectAttractionDetail(connection, parameters.getId());

		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new ResearchAttractionDetailFault_Exception("Something was wrong with Research Attraction Detail for this attraction..");
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

		responseAttractionDetail.setAttractionElement(attraction_detail);
		responseAttractionDetail.setMessage("Returned Attraction Detail for this Attraction");	
		return responseAttractionDetail;
	}

	public AttractionElement selectAttractionDetail(Connection con, Long idCreator) {

		AttractionElement attraction_detail = new AttractionElement();
		String query = "SELECT * FROM attractions WHERE id=?";

		try {

			PreparedStatement sql = con.prepareStatement(query);

			sql.setLong(1, idCreator);


			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				attraction_detail.setId(rs.getLong("id"));
				attraction_detail.setName(rs.getString("name"));
				attraction_detail.setLocality(rs.getString("locality"));
				attraction_detail.setCategoryId(rs.getLong("id_category"));
				attraction_detail.setCreatorId(rs.getLong("id_creator"));
			}
			return attraction_detail;

		} catch (SQLException e) {
			return attraction_detail;
		}
	}

	@Override
	public ResearchEventResponse researchEvent(ResearchEventRequest parameters) throws ResearchEventFault_Exception {
		/* per filtrare gli eventi in base a : 
		 * - località
		 * - data
		 * - categoria
		 */
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResearchEventDetailResponse researchEventDetail(ResearchEventDetailRequest parameters)
			throws ResearchEventDetailFault_Exception {
		Connection connection = null;
		EventElement event_detail = new EventElement();


		/*-------------------------------------------------------------------------*/
		ResearchEventDetailResponse responseEventDetail = new ResearchEventDetailResponse();
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			event_detail = selectEventDetail(connection, parameters.getId());

		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new ResearchEventDetailFault_Exception("Something was wrong with Research Event Detail for this event..");
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

		responseEventDetail.setEventElement(event_detail);
		responseEventDetail.setMessage("Returned Event Detail for this Attraction");
		return responseEventDetail;
	}

	public EventElement selectEventDetail(Connection con, Long id) {

		EventElement event_detail = new EventElement();
		String query = "SELECT * FROM events WHERE id=?";
		Utility utility = new Utility();

		try {

			PreparedStatement sql = con.prepareStatement(query);

			sql.setLong(1, id);

			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				event_detail.setId(rs.getLong("id"));
				event_detail.setTitle(rs.getString("title"));
				event_detail.setLocality(rs.getString("locality"));
				event_detail.setCategoryId(rs.getLong("id_category"));
				event_detail.setCreatorId(rs.getLong("id_creator"));
				Date startDate = new Date(rs.getTimestamp("startDate").getTime());
				event_detail.setStartDate(utility.convertToXML(startDate));
				Date endDate = new Date(rs.getTimestamp("endDate").getTime());
				event_detail.setEndDate(utility.convertToXML(endDate));
			}
			return event_detail;

		} catch (SQLException e) {
			return event_detail;
		}
	}

	@Override
	public ResearchEventByCreatorResponse researchEventByCreator(ResearchEventByCreatorRequest parameters)
			throws ResearchEventByCreatorFault_Exception {
		Connection connection = null;
		EventsList return_list = new EventsList();
		User creator = new User();

		creator.setId(parameters.getCreatorId());

		/*-------------------------------------------------------------------------*/
		ResearchEventByCreatorResponse responseEventByCreator = new ResearchEventByCreatorResponse();
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			return_list = selectEventByCreator(connection, creator.getId());

		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new ResearchEventByCreatorFault_Exception("Something was wrong with Research Events for this user..");
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

		responseEventByCreator.setEventsList(return_list);
		responseEventByCreator.setMessage("Returned Event List for this user");	
		return responseEventByCreator;
	}

	public EventsList selectEventByCreator(Connection con, Long idCreator) {

		EventsList return_list = new EventsList();
		EventElement event = new EventElement();
		String query = "SELECT * FROM events WHERE id_creator=?";
		Utility utility = new Utility();
		
		try {

			PreparedStatement sql = con.prepareStatement(query);

			sql.setLong(1, idCreator);


			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				event.setId(rs.getLong("id"));
				event.setTitle(rs.getString("title"));
				event.setLocality(rs.getString("locality"));
				event.setCategoryId(rs.getLong("id_category"));
				event.setCreatorId(rs.getLong("id_creator"));
				Date startDate = new Date(rs.getTimestamp("startDate").getTime());
				event.setStartDate(utility.convertToXML(startDate));
				Date endDate = new Date(rs.getTimestamp("endDate").getTime());
				event.setEndDate(utility.convertToXML(endDate));

				return_list.getEventElement().add(event);
			}
			return return_list;

		} catch (SQLException e) {
			return return_list;
		}
	}
	


}
