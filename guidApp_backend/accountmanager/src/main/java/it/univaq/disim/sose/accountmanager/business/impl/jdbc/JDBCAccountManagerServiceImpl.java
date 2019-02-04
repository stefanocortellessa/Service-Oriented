package it.univaq.disim.sose.accountmanager.business.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.accountmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.accountmanager.CheckSessionRequest;
import it.univaq.disim.sose.accountmanager.CheckSessionResponse;
import it.univaq.disim.sose.accountmanager.UserLoginFault_Exception;
import it.univaq.disim.sose.accountmanager.UserLoginRequest;
import it.univaq.disim.sose.accountmanager.UserLoginResponse;
import it.univaq.disim.sose.accountmanager.UserLogoutFault_Exception;
import it.univaq.disim.sose.accountmanager.UserLogoutRequest;
import it.univaq.disim.sose.accountmanager.UserLogoutResponse;
import it.univaq.disim.sose.accountmanager.UserSignupFault_Exception;
import it.univaq.disim.sose.accountmanager.UserSignupRequest;
import it.univaq.disim.sose.accountmanager.UserSignupResponse;
import it.univaq.disim.sose.accountmanager.business.AccountManagerService;
import it.univaq.disim.sose.accountmanager.business.Utility;
import it.univaq.disim.sose.accountmanager.business.model.User;


@Service
public class JDBCAccountManagerServiceImpl implements AccountManagerService {
		
	@Autowired
	private DataSource dataSource;
	
	@Override
	public UserSignupResponse userSignup(UserSignupRequest parameters) throws UserSignupFault_Exception {
		
		Connection connection = null;
		PreparedStatement user = null; 
		PreparedStatement session = null;
		
		UserSignupResponse responseUser = new UserSignupResponse();
		
		try {
			connection = dataSource.getConnection();
			user = connection.prepareStatement(
				"INSERT INTO users (name,surname,email,password,username) VALUES (?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		
			user.setString(1, parameters.getName());
			user.setString(2, parameters.getSurname());
			user.setString(3, parameters.getEmail());
			user.setString(4, parameters.getPassword());
			user.setString(5, parameters.getUsername());
		
		if(user.executeUpdate() == 1) {
			int idUtente = 0;
			try (ResultSet keys = user.getGeneratedKeys()) {
				if (keys.next()) {
					idUtente = keys.getInt(1);
				}
				
				session = connection.prepareStatement("INSERT INTO sessions (token,user) VALUES (?,?)");
				
				String token = Utility.generateToken();
				
				session.setString(1, token);
				session.setInt(2, idUtente);
				
				if(session.executeUpdate() == 1) {
					responseUser.setId(idUtente);
					responseUser.setToken(token);
				}
				else {
					responseUser.setToken(null);
				}
			}
		} else {
			responseUser.setToken(null);
		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserSignupFault_Exception("Something was wrong with User Signup");
		} finally {
			if (user != null) {
				try {
					user.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		return responseUser;
	}

	@Override
	public UserLoginResponse userLogin(UserLoginRequest parameters) throws UserLoginFault_Exception {
		
		UserLoginResponse responseUser = new UserLoginResponse();
		
		String sql = "SELECT * FROM users WHERE email = ?";
		String sqlSession = "INSERT into sessions(token, user) VALUES(?,?)";
		
		Connection connection = null;
		PreparedStatement par = null;
		PreparedStatement par1 = null;
		
		ResultSet rs = null;
		
		try {
			
			User user = new User();
			
			connection = dataSource.getConnection();
			par = connection.prepareStatement(sql);
			
			par.setString(1, parameters.getEmail());
			rs = par.executeQuery();
			rs.last();
			int num_rows = rs.getRow();
			rs.first();
			
			if(num_rows != 0 && parameters.getPassword().equals(rs.getString("password"))) {
			
				long idUtente = rs.getLong("user_id");
				user.setId(idUtente);
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setUsername(rs.getString("username"));
				
				String token = Utility.generateToken();
				
				par1 = connection.prepareStatement(sqlSession);
				par1.setString(1, token);
				par1.setLong(2, user.getId());
				
				if(par1.executeUpdate() == 1) {
					responseUser.setId(idUtente);
					responseUser.setToken(token);
				} else {
					responseUser.setToken(null);
				}
			} else {
				responseUser.setToken(null);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserLoginFault_Exception("Something was wrong with User Login");
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
		return responseUser;
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
			throw new CheckSessionFault_Exception("Something was wrong with Checking Session");
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

	@Override
	public UserLogoutResponse userLogout(UserLogoutRequest parameters) throws UserLogoutFault_Exception {
		
		UserLogoutResponse responseUser = new UserLogoutResponse();
		String sql = "DELETE FROM sessions WHERE token = ?";
		
		Connection connection = null;
		PreparedStatement par = null;
		
		try {			
			connection = dataSource.getConnection();
			par = connection.prepareStatement(sql);
			
			par.setString(1, parameters.getToken());
			if(par.executeUpdate() == 1) {
				responseUser.setResponse("Logout Success");
			} else {
				responseUser.setResponse("Logout went Wrong");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserLogoutFault_Exception("Something was wrong with User Logout");
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
		return responseUser;
	}
}