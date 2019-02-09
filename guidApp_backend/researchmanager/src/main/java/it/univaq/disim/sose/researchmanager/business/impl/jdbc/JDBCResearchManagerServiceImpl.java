package it.univaq.disim.sose.researchmanager.business.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.researchmanager.AttractionElement;
import it.univaq.disim.sose.researchmanager.AttractionsList;
import it.univaq.disim.sose.researchmanager.CategoryElement;
import it.univaq.disim.sose.researchmanager.CategoryList;
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
import it.univaq.disim.sose.researchmanager.ResearchCategoryFault_Exception;
import it.univaq.disim.sose.researchmanager.ResearchCategoryRequest;
import it.univaq.disim.sose.researchmanager.ResearchCategoryResponse;
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
import it.univaq.disim.sose.researchmanager.business.model.Attraction;
import it.univaq.disim.sose.researchmanager.business.model.Category;
import it.univaq.disim.sose.researchmanager.business.model.Event;
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
		String query = "SELECT * FROM attractions WHERE id_creator=?";

		try {

			PreparedStatement sql = con.prepareStatement(query);

			sql.setLong(1, idCreator);


			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				AttractionElement attraction = new AttractionElement();
				attraction.setId(rs.getLong("id"));
				attraction.setName(rs.getString("name"));
				attraction.setLocality(rs.getString("locality"));
				attraction.setCategoryId(rs.getLong("id_category"));
				attraction.setCreatorId(rs.getLong("id_creator"));
				attraction.setLat(rs.getString("lat"));
				attraction.setLng(rs.getString("lng"));
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
		 * - name
		 * - località
		 * - categoria
		 */
		Connection connection = null;
		AttractionsList return_list = new AttractionsList();
		Attraction attraction = new Attraction();
		Category category = new Category();

		attraction.setLocality(parameters.getLocality());
		attraction.setName(parameters.getName());
		category.setId(parameters.getCategoryId());
		attraction.setCategory(category);

		/*-------------------------------------------------------------------------*/
		ResearchAttractionResponse responseAttractionByFilter = new ResearchAttractionResponse();
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			return_list = selectAttractionByFilter(connection, attraction.getName(), attraction.getLocality(), attraction.getCategory().getId());

		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new ResearchAttractionFault_Exception("Something was wrong with Research Attraction for this filters..");
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

		responseAttractionByFilter.setAttractionsList(return_list);
		responseAttractionByFilter.setMessage("Returned Attraction List for this filter");	
		return responseAttractionByFilter;

	}


	public AttractionsList selectAttractionByFilter(Connection con, String name, String locality, Long categoryId) {

		AttractionsList return_list = new AttractionsList();
		String query = "SELECT * FROM attractions WHERE ";

		int counter = 0; 
		int name_pos = 0; 
		int locality_pos = 0;
		int category_pos = 0;
		if(name != null) {
			query = query + "name LIKE ? AND ";
			counter += 1;
			name_pos = counter;
		}
		if(locality != null) {
			query = query + "locality LIKE ? AND ";
			counter += 1;
			locality_pos = counter;
		}
		if(categoryId != null) {
			query = query + "id_category=? AND ";
			counter += 1;
			category_pos = counter;
		}
		query = query + "id=id";
		
		try {
			PreparedStatement sql = con.prepareStatement(query);

			if(name_pos != 0) {
				sql.setString(name_pos, "%"+name+"%");
			}
			if(locality_pos != 0) {
				sql.setString(locality_pos, "%"+locality+"%");
			}
			if(category_pos != 0) {
				sql.setLong(category_pos, categoryId);
			}
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				AttractionElement attraction = new AttractionElement();
				attraction.setId(rs.getLong("id"));
				attraction.setName(rs.getString("name"));
				attraction.setLocality(rs.getString("locality"));
				attraction.setCategoryId(rs.getLong("id_category"));
				attraction.setCreatorId(rs.getLong("id_creator"));
				attraction.setLat(rs.getString("lat"));
				attraction.setLng(rs.getString("lng"));
				return_list.getAttractionElement().add(attraction);
			}
			return return_list;

		} catch (SQLException e) {
			return return_list;
		}
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
		if(attraction_detail.getId() != 0) {
			responseAttractionDetail.setAttractionElement(attraction_detail);
		
			responseAttractionDetail.setMessage("Returned Attraction Detail for this Attraction");	
		}else {
			responseAttractionDetail.setMessage("Attraction Detail Not Found for this Attraction");	

		}
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
				attraction_detail.setLat(rs.getString("lat"));
				attraction_detail.setLng(rs.getString("lng"));
			}
			return attraction_detail;

		} catch (SQLException e) {
			return attraction_detail;
		}
	}

	@Override
	public ResearchEventResponse researchEvent(ResearchEventRequest parameters) throws ResearchEventFault_Exception {
		/* per filtrare gli eventi in base a : 
		 * - titolo
		 * - località
		 * - data
		 * - categoria
		 */
		Connection connection = null;
		EventsList return_list = new EventsList();
		Event event = new Event();
		Category category = new Category();
		Utility utility = new Utility();

		event.setLocality(parameters.getLocality());
		event.setTitle(parameters.getTitle());
		category.setId(parameters.getCategoryId());
		if(parameters.getDate() != null) {
			event.setStartDate(utility.convertDate(parameters.getDate()));
		}
		event.setCategory(category);

		/*-------------------------------------------------------------------------*/
		ResearchEventResponse responseEventByFilter = new ResearchEventResponse();
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			return_list = selectEventByFilter(connection, event.getTitle(), event.getLocality(), event.getCategory().getId(), event.getStartDate());

		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new ResearchEventFault_Exception("Something was wrong with Research Event for this filters..");
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

		responseEventByFilter.setEventsList(return_list);
		responseEventByFilter.setMessage("Returned Event List for this filter");	
		return responseEventByFilter;

	}


	public EventsList selectEventByFilter(Connection con, String name, String locality, Long categoryId, Timestamp date) {

		EventsList return_list = new EventsList();
		String query = "SELECT * FROM events WHERE ";
		Utility utility = new Utility();
		//date BETWEEN date(events.startDate) AND date(events.endDate) AND name LIKE ? AND locality LIKE ? AND id_category=?";
		int counter = 0; 
		int name_pos = 0; 
		int locality_pos = 0;
		int category_pos = 0;
		int date_pos = 0;
		if(name != null) {
			query = query + "title LIKE ? AND ";
			counter += 1;
			name_pos = counter;
		}
		if(locality != null) {
			query = query + "locality LIKE ? AND ";
			counter += 1;
			locality_pos = counter;
		}
		if(categoryId != null) {
			query = query + "id_category=? AND ";
			counter += 1;
			category_pos = counter;
		}
		if(date != null) {
			query = query + "date(?) BETWEEN date(events.startDate) AND date(events.endDate) AND ";
			counter += 1;
			date_pos = counter;
		}
		query = query + "id=id";


		try {
			PreparedStatement sql = con.prepareStatement(query);
			if(name_pos != 0) {
				sql.setString(name_pos, "%"+name+"%");
			}
			if(locality_pos != 0) {
				sql.setString(locality_pos, "%"+locality+"%");
			}
			if(category_pos != 0) {
				sql.setLong(category_pos, categoryId);
			}
			if(date_pos != 0) {
				sql.setTimestamp(date_pos, date);
			}
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				EventElement event = new EventElement();
				event.setId(rs.getLong("id"));
				event.setTitle(rs.getString("title"));
				event.setLocality(rs.getString("locality"));
				event.setCategoryId(rs.getLong("id_category"));
				event.setCreatorId(rs.getLong("id_creator"));
				Date startDate = new Date(rs.getTimestamp("startDate").getTime());
				event.setStartDate(utility.convertToXML(startDate));
				Date endDate = new Date(rs.getTimestamp("endDate").getTime());
				event.setEndDate(utility.convertToXML(endDate));
				event.setLat(rs.getString("lat"));
				event.setLng(rs.getString("lng"));
				return_list.getEventElement().add(event);
			}
			return return_list;

		} catch (SQLException e) {
			return return_list;
		}
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

		if(event_detail.getId() != 0) {
			responseEventDetail.setEventElement(event_detail);
		
			responseEventDetail.setMessage("Returned Event Detail for this Attraction");	
		}else {
			responseEventDetail.setMessage("Event Detail Not Found for this Attraction");	

		}
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
				event_detail.setLat(rs.getString("lat"));
				event_detail.setLng(rs.getString("lng"));
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
		
		System.out.println("RETURN_LST : " + return_list);
		responseEventByCreator.setEventsList(return_list);
		
		System.out.println("RETURN_LST_FATTA : " + responseEventByCreator.getEventsList().toString());
		responseEventByCreator.setMessage("Returned Event List for this user");	
		
		return responseEventByCreator;
	}

	public EventsList selectEventByCreator(Connection con, Long idCreator) {

		EventsList return_list = new EventsList();
		//EventElement event = new EventElement();
		String query = "SELECT * FROM events WHERE id_creator=?";
		Utility utility = new Utility();

		try { 

			PreparedStatement sql = con.prepareStatement(query);

			sql.setLong(1, idCreator);


			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				EventElement event = new EventElement();
				event.setId(rs.getLong("id"));
				event.setTitle(rs.getString("title"));
				event.setLocality(rs.getString("locality"));
				event.setCategoryId(rs.getLong("id_category"));
				event.setCreatorId(rs.getLong("id_creator"));
				Date startDate = new Date(rs.getTimestamp("startDate").getTime());
				event.setStartDate(utility.convertToXML(startDate));
				Date endDate = new Date(rs.getTimestamp("endDate").getTime());
				event.setEndDate(utility.convertToXML(endDate));
				event.setLat(rs.getString("lat"));
				event.setLng(rs.getString("lng"));
									
				return_list.getEventElement().add(event);
				
			}
			return return_list;

		} catch (SQLException e) {
			return return_list;
		}
	}
	
	
	@Override
	public ResearchCategoryResponse researchCategory(ResearchCategoryRequest parameters) throws ResearchCategoryFault_Exception {
		
		Connection connection = null;
		CategoryList return_list = new CategoryList();
		Category category = new Category();
		category.setId(parameters.getId());

		/*-------------------------------------------------------------------------*/
		ResearchCategoryResponse responseCategory = new ResearchCategoryResponse();
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			return_list = selectCategory(connection, category.getId());

		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new ResearchCategoryFault_Exception("Something was wrong with Research Category for this filters..");
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

		responseCategory.setCategoryList(return_list);
		responseCategory.setMessage("Returned Category List for this filter");	
		return responseCategory;

	}
	
	public CategoryList selectCategory(Connection con, Long id) {

		CategoryList return_list = new CategoryList();
		String query = "SELECT * FROM categories WHERE ";
		//date BETWEEN date(events.startDate) AND date(events.endDate) AND name LIKE ? AND locality LIKE ? AND id_category=?";

		if(id != null) {
			query = query + "id=?";
		}else {
			query = query + "id=id";
		}

		try {
			PreparedStatement sql = con.prepareStatement(query);
			if(id != null) {
				sql.setLong(1, id);
			}
			ResultSet rs = sql.executeQuery();
			while(rs.next()) {
				CategoryElement category = new CategoryElement();
				category.setId(rs.getLong("id"));
				category.setName(rs.getString("name"));
				return_list.getCategoryElement().add(category);
			}
			return return_list;

		} catch (SQLException e) {
			return return_list;
		}
	}




}
