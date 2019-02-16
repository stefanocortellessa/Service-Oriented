package ${package}.${artifactId}.webservices;

import org.springframework.stereotype.Component;

import ${package}.${artifactId}.Fault_Exception;
import ${package}.${artifactId}.Request;
import ${package}.${artifactId}.Response;
import ${package}.${artifactId}.${artifactId}PT;

@Component(value = "${artifactId}PTImpl")
public class ${artifactId}PTImpl implements ${artifactId}PT {

	@Override
	public Response operationName(Request parameters) throws Fault_Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
