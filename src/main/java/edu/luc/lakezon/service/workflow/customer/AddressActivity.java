package edu.luc.lakezon.service.workflow.customer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.luc.lakezon.business.customer.Address;
import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.dao.customer.AddressDAO;
import edu.luc.lakezon.service.representation.customer.AddressRepresentation;
import edu.luc.lakezon.service.representation.customer.AddressRequest;
import edu.luc.lakezon.service.representation.customer.CustomerRepresentation;
import edu.luc.lakezon.service.representation.customer.CustomerRequest;

public class AddressActivity {
	
	private AddressDAO dao = new AddressDAO();
	
	public Set<AddressRepresentation> getAddresses() {
		
		Set<Address> addresses = new HashSet<Address>();
		Set<AddressRepresentation> addressRepresentations = new HashSet<AddressRepresentation>();
		addresses = dao.getAll();
		
		Iterator<Address> it = addresses.iterator();
		while(it.hasNext()) {
          Address addr = (Address)it.next();
          AddressRepresentation addressRepresentation = new AddressRepresentation();
          addressRepresentation.setAddressId(addr.getAddressId());
          addressRepresentation.setAddressline1(addr.getAddressline1());
          addressRepresentation.setAddressline2(addr.getAddressline2());
          addressRepresentation.setCity(addr.getCity());
          addressRepresentation.setCountry(addr.getCountry());
          addressRepresentation.setState(addr.getState());
          addressRepresentation.setZipcode(addr.getZipcode());

          addressRepresentations.add(addressRepresentation);
        }
		return addressRepresentations;
	}
	
	public AddressRepresentation getAddress(String id) {
		
		Address addr = dao.getById(Integer.parseInt(id));
		
		AddressRepresentation addrRep = new AddressRepresentation();
		addrRep.setAddressId(addr.getAddressId());
		addrRep.setAddressline1(addr.getAddressline1());
		addrRep.setAddressline2(addr.getAddressline2());
		addrRep.setCity(addr.getCity());
		addrRep.setCountry(addr.getCountry());
		addrRep.setState(addr.getState());
		addrRep.setZipcode(addr.getZipcode());
		
		
		return addrRep;
	}
	
	
	public AddressRepresentation createAddress(AddressRequest addressRequest) {
		
		Address addr = new Address();
		addr.setAddressline1(addressRequest.getAddressline1());
		addr.setAddressline2(addressRequest.getAddressline2());
		addr.setCity(addressRequest.getCity());
		addr.setCountry(addressRequest.getCountry());
		addr.setState(addressRequest.getState());
		addr.setZipcode(Integer.parseInt(addressRequest.getZipcode()));
	
		dao.save(addr);
		
		AddressRepresentation addrRep = new AddressRepresentation();
		addrRep.setAddressId(addr.getAddressId());
		addrRep.setAddressline1(addr.getAddressline1());
		addrRep.setAddressline2(addr.getAddressline2());
		addrRep.setCity(addr.getCity());
		addrRep.setCountry(addr.getCountry());
		addrRep.setState(addr.getState());
		addrRep.setZipcode(addr.getZipcode());
		
		
		return addrRep;
	}
	
	public Response deleteAddress(String id) {
		
		Address addr = dao.getById(Integer.parseInt(id));

		dao.delete(addr);
		
		return Response.status(Status.OK).build();
		
	}
	
	public AddressRepresentation updateAddress(String addressId, AddressRequest addressRequest) {

		Address addrUp = dao.getById(Integer.parseInt(addressId));

		addrUp.setAddressline1(addressRequest.getAddressline1());
		addrUp.setAddressline2(addressRequest.getAddressline2());
		addrUp.setCity(addressRequest.getCity());
		addrUp.setCountry(addressRequest.getCountry());
		addrUp.setState(addressRequest.getState());
		addrUp.setZipcode(Integer.parseInt(addressRequest.getZipcode()));
		
		dao.update(addrUp);
		
		AddressRepresentation addressRepresentation = new AddressRepresentation();

		addressRepresentation.setAddressId(addrUp.getAddressId());
		addressRepresentation.setAddressline1(addrUp.getAddressline1());
		addressRepresentation.setAddressline2(addrUp.getAddressline2());
		addressRepresentation.setCity(addrUp.getCity());
		addressRepresentation.setCountry(addrUp.getCountry());
		addressRepresentation.setState(addrUp.getState());
		addressRepresentation.setZipcode(addrUp.getZipcode());
		

		
		return addressRepresentation;
	}
	

}
