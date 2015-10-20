package edu.luc.lakezon.service.workflow.customer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



import edu.luc.lakezon.business.customer.Address;
import edu.luc.lakezon.dao.customer.AddressDAO;
import edu.luc.lakezon.service.representation.customer.AddressRepresentation;

public class AddressActivity {
	
	private static AddressDAO dao = new AddressDAO();
	
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
	
	public AddressRepresentation getAddress(Integer id) {
		
		Address addr = dao.getById(id);
		
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
	
	
	public AddressRepresentation createAddress(String addressLine1, String addressLine2, String city, String country, String state, Integer zipCode) {
		
		Address addr = new Address();
		addr.setAddressline1(addressLine1);
		addr.setAddressline2(addressLine2);
		addr.setCity(city);
		addr.setCountry(country);
		addr.setState(state);
		addr.setZipcode(zipCode);
	
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
	
	public String deleteAddress(Integer id) {
		Address addr = dao.getById(id);
		dao.delete(addr);
		
		return "OK";
	}
	
	public String updateAddress(Address addr) {
		
		dao.delete(addr);
		
		return "OK";
	}
	

}
