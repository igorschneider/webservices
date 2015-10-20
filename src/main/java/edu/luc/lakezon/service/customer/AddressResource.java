package edu.luc.lakezon.service.customer;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.luc.lakezon.service.representation.customer.AddressRepresentation;
import edu.luc.lakezon.service.representation.customer.AddressRequest;

@Path("/addressservice/")
public class AddressResource implements AddressService {

	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/address")
	public Set<AddressRepresentation> getAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	public AddressRepresentation getEmployee(Integer addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	public AddressRepresentation createEmployee(AddressRequest addressRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response updateAddress(AddressRequest addressRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response deleteAddress(Integer addressId) {
		// TODO Auto-generated method stub
		return null;
	}

}
