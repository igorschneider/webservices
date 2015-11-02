package edu.luc.lakezon.service.customer;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



import edu.luc.lakezon.service.representation.customer.AddressRepresentation;
import edu.luc.lakezon.service.representation.customer.AddressRequest;
import edu.luc.lakezon.service.workflow.customer.AddressActivity;

@Path("/address")
public class AddressResource implements AddressService {

	@GET
	@Produces({"application/xml" , "application/json"})
	public Set<AddressRepresentation> getAddresses() {
		AddressActivity addrActivity = new AddressActivity();
		return addrActivity.getAddresses();	
	}


	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{addressId}")
	@Override
	public AddressRepresentation getAddress(@PathParam("addressId") String addressId) {
		AddressActivity addressActivity = new AddressActivity();
		return addressActivity.getAddress(addressId);
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Override
	public AddressRepresentation createAddress(AddressRequest addressRequest) {
		AddressActivity addressActivity = new AddressActivity();
		return addressActivity.createAddress(addressRequest);
	}

	@PUT
	@Produces({"application/xml" , "application/json"})
	@Path("/{addressId}")
	@Override
	public AddressRepresentation updateAddress(@PathParam("addressId") String addressId, AddressRequest addressRequest) {
		AddressActivity addressActivity = new AddressActivity();
		return addressActivity.updateAddress(addressId, addressRequest);
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/{addressId}")
	@Override
	public Response deleteAddress(@PathParam("addressId") String addressId) {
		AddressActivity addressActivity = new AddressActivity();
		return addressActivity.deleteAddress(addressId);
	}



}
