package edu.luc.lakezon.service.customer;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import edu.luc.lakezon.service.representation.customer.AddressRepresentation;
import edu.luc.lakezon.service.representation.customer.AddressRequest;


@WebService
public interface AddressService {
	
	public Set<AddressRepresentation> getAddresses();
	public AddressRepresentation getAddress(String addressId);
	public AddressRepresentation createAddress(AddressRequest addressRequest);
   
    public AddressRepresentation updateAddress(String addressId, AddressRequest addressRequest);
    public Response deleteAddress(String addressId);
	

}
