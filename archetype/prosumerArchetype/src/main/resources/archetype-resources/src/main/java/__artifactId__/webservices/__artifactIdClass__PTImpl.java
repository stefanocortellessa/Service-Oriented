package ${package}.${artifactId}.webservices;

import org.springframework.stereotype.Component;

import ${package}.${artifactId}.Fault_Exception;
import ${package}.${artifactId}.Request;
import ${package}.${artifactId}.Response;
import ${package}.${artifactId}.${artifactIdClass}PT;

@Component(value = "${artifactIdClass}PTImpl")
public class ${artifactIdClass}PTImpl implements ${artifactIdClass}PT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(${artifactIdClass}PTImpl.class);

	@Override
	public Response operationName(Request parameters) throws Fault_Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
