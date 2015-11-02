package edu.luc.lakezon.service.customer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.Test;

import edu.luc.lakezon.business.customer.Customer;

public class CustomerServiceTest {

	@Test
	public void testService() {
		
		List<Object> providers = new ArrayList<Object>();
		JacksonJsonProvider provider = new JacksonJsonProvider();
		provider.addUntouchable(Response.class);
		providers.add(provider);

		WebClient getClient = WebClient.create("http://localhost:8090", providers);
        WebClient.getConfig(getClient).getOutInterceptors().add(new LoggingOutInterceptor());
        WebClient.getConfig(getClient).getInInterceptors().add(new LoggingInInterceptor());
        
        getClient = getClient.accept("application/json").type("application/json")
        		.path("/customer/105");
        
        String getRequestURI = getClient.getCurrentURI().toString();
        System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
        String getRequestHeaders = getClient.getHeaders().toString();
        System.out.println("Client GET METHOD Request Headers:  " + getRequestHeaders);
        
        String response = getClient.get(String.class);
        System.out.println("GET METHOD Response: ...." + response);
        
        Customer customer = getClient.get(Customer.class);
        System.out.println("Name:" + customer.getName());
        System.out.println("Gender:" + customer.getGender());
        
        assertTrue(true);
	}

}
