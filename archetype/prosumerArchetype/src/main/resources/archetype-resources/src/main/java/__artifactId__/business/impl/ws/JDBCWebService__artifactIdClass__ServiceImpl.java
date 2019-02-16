package ${package}.${artifactId}.business.impl.ws;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${package}.${artifactId}.Fault_Exception;
import ${package}.${artifactId}.Request;
import ${package}.${artifactId}.Response;
import ${package}.${artifactId}.business.${artifactIdClass}Service;

@Service
public class JDBCWebService${artifactIdClass}ServiceImpl implements ${artifactIdClass}Service {

	@Autowired
	private DataSource dataSource;

	@Override
	public Response operationName(Request parameters) throws Fault_Exception {

		Connection connection = null;
		Response response = new Response();
		String result = "";
		
		try {

			connection = dataSource.getConnection();
			connection.setAutoCommit(false);

			// query -> result

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Fault_Exception("Something went wrong..");
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
		response.setParam(result);

		return response;
	}
}

