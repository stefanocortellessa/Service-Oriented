package it.univaq.disim.sose.touristicguide.accountmanager.business.impl.jdbc;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

import it.univaq.disim.sose.touristicguide.accountmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.touristicguide.accountmanager.CheckSessionRequest;
import it.univaq.disim.sose.touristicguide.accountmanager.CheckSessionResponse;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLoginFault_Exception;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLoginRequest;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLoginResponse;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLogoutFault_Exception;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLogoutRequest;
import it.univaq.disim.sose.touristicguide.accountmanager.UserLogoutResponse;
import it.univaq.disim.sose.touristicguide.accountmanager.UserSignupFault_Exception;
import it.univaq.disim.sose.touristicguide.accountmanager.UserSignupRequest;
import it.univaq.disim.sose.touristicguide.accountmanager.UserSignupResponse;
import it.univaq.disim.sose.touristicguide.accountmanager.business.AccountManagerService;
import it.univaq.disim.sose.touristicguide.accountmanager.business.Utility;
import it.univaq.disim.sose.touristicguide.accountmanager.business.model.User;

@Service
public class JDBCAccountManagerServiceImpl implements AccountManagerService {

	@Autowired
	private DataSource dataSource;

	@Override
	public UserSignupResponse userSignup(UserSignupRequest parameters) throws UserSignupFault_Exception {

		Connection connection = null;
		PreparedStatement user = null; 
		PreparedStatement session = null;
		UserSignupResponse response = new UserSignupResponse();
		String sql = "SELECT * FROM users WHERE email = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, parameters.getEmail());
			
			rs = ps.executeQuery();
			rs.last();
			
			int num_rows = rs.getRow();
			
			rs.first();
			
			if(num_rows > 0 ) {
				
				response.setToken(null);
				response.setMessage("E-Mail already registered! Change it.");
			
			}else {
				
				user = connection.prepareStatement("INSERT INTO users (name,surname,email,password) VALUES (?,?,?,?)",
													Statement.RETURN_GENERATED_KEYS);
	
				user.setString(1, parameters.getName());
				user.setString(2, parameters.getSurname());
				user.setString(3, parameters.getEmail());
				user.setString(4, this.hashPwd(parameters.getPassword()));
	
				if(user.executeUpdate() == 1) {
					
					long idUtente = 0;
					
					try (ResultSet keys = user.getGeneratedKeys()) {
						if (keys.next()) {
							
							idUtente = keys.getLong(1);
						}
	
						session = connection.prepareStatement("INSERT INTO sessions (token,id_user) VALUES (?,?)");
						String token = Utility.generateToken();
	
						session.setString(1, token);
						session.setLong(2, idUtente);
	
						if(session.executeUpdate() == 1) {
							
							response.setId(idUtente);
							response.setToken(token);
							response.setMessage("User correctly signed up!");
						}
						else {
							
							response.setToken(null);
							response.setMessage("Something went wrong with User Signup");
						}
					}
				} else {
					
					response.setToken(null);
					response.setMessage("Something went wrong with User Signup..");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserSignupFault_Exception("Something went wrong with User Signup");
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
		return response;
	}

	@Override
	public UserLoginResponse userLogin(UserLoginRequest parameters) throws UserLoginFault_Exception {

		UserLoginResponse response = new UserLoginResponse();
		String sql = "SELECT * FROM users WHERE email = ?";
		String sqlSession = "INSERT into sessions(token, id_user) VALUES(?,?)";

		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;

		try {

			User user = new User();

			connection = dataSource.getConnection();
			ps = connection.prepareStatement(sql);

			ps.setString(1, parameters.getEmail());
			rs = ps.executeQuery();
			rs.last();
			
			int num_rows = rs.getRow();
			
			rs.first();
			
			if(num_rows != 0 && this.hashPwd(parameters.getPassword()).equals(rs.getString("password"))) {

				long idUtente = rs.getLong("id");
				
				user.setId(idUtente);
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));

				String token = Utility.generateToken();

				ps1 = connection.prepareStatement(sqlSession);
				ps1.setString(1, token);
				ps1.setLong(2, user.getId());

				if(ps1.executeUpdate() == 1) {
					
					response.setId(idUtente);
					response.setToken(token);
				} else {
					
					response.setToken(null);
				}
			} else {
				
				response.setToken(null);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserLoginFault_Exception("Something was wrong with User Login");
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		return response;
	}

	@Override
	public CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception {

		CheckSessionResponse response = new CheckSessionResponse();
		String sql = "SELECT * FROM sessions WHERE token = ?";
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {			
			
			connection = dataSource.getConnection();
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, parameters.getToken());
			rs = ps.executeQuery();
			rs.last();
			
			int num_rows = rs.getRow();

			if(num_rows != 0) {
			
				response.setResponse(true);
			} else {
				
				response.setResponse(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CheckSessionFault_Exception("Something was wrong with Checking Session");
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		return response;
	}

	@Override
	public UserLogoutResponse userLogout(UserLogoutRequest parameters) throws UserLogoutFault_Exception {

		UserLogoutResponse response = new UserLogoutResponse();
		String sql = "DELETE FROM sessions WHERE token = ?";
		Connection connection = null;
		PreparedStatement ps = null;

		try {			
			connection = dataSource.getConnection();
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, parameters.getToken());
			
			if(ps.executeUpdate() == 1) {
			
				response.setResponse("Logout Success");
			} else {
				
				response.setResponse("Logout went Wrong");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserLogoutFault_Exception("Something was wrong with User Logout");
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		return response;
	}
	
	//Method to encode the password
	public String hashPwd(String originalString) {
		
		String sha256hex = Hashing.sha256()
				.hashString(originalString, StandardCharsets.UTF_8)
				.toString();
		
		return sha256hex;
	}

}
