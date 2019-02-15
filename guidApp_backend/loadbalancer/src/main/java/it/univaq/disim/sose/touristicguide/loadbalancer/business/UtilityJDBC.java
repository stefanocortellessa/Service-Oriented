package it.univaq.disim.sose.touristicguide.loadbalancer.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import it.univaq.disim.sose.touristicguide.loadbalancer.business.model.Provider;
import it.univaq.disim.sose.touristicguide.loadbalancer.business.model.Server;

public class UtilityJDBC {
	
	public List<Provider> selectProviders(DataSource dataSource) {

		Connection connection = null;
		List<Provider> return_list = new ArrayList<Provider>();
		
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String query = "SELECT * FROM providers";
		PreparedStatement sql = null;
		
		try {

			sql = connection.prepareStatement(query);

			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				Provider provider = new Provider();
				provider.setName(rs.getString("name"));
				provider.setId(rs.getLong("id"));
				provider.setEndpoint(rs.getString("endpoint"));
				return_list.add(provider);
			}
			sql.close();
			connection.close();
			
			return return_list;
		} catch (SQLException e) {
			
			return return_list;
		}finally {
			if (sql != null) {
				try {
					sql.close();
					connection.close();
					
					return return_list;
				} catch (SQLException e) {
				}
			}
		}						
	}
	
	public List<Server> selectServers(DataSource dataSource) {

		Connection connection = null;
		List<Server> return_list = new ArrayList<Server>();

		try {
			
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String query = "SELECT * FROM servers";
		PreparedStatement sql = null;
		
		try {

			sql = connection.prepareStatement(query);

			ResultSet rs = sql.executeQuery();
			
			while(rs.next()) {
				Server server = new Server();
				server.setPort(rs.getString("port"));
				server.setId(rs.getLong("id"));
				server.setUrl(rs.getString("url"));
				return_list.add(server);
			}
			sql.close();
			connection.close();
			
			return return_list;
		} catch (SQLException e) {
			
			return return_list;
		}finally {
			if (sql != null) {
				try {
					sql.close();
					connection.close();
					
					return return_list;
				} catch (SQLException e) {
				}
			}
		}						
	}

}
