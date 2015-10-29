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
	
	
	public AddressRepresentation createAddress(String addressLine1, String addressLine2, String city, String country, String state, String zipCode) {
		
		Address addr = new Address();
		addr.setAddressline1(addressLine1);
		addr.setAddressline2(addressLine2);
		addr.setCity(city);
		addr.setCountry(country);
		addr.setState(state);
		addr.setZipcode(Integer.parseInt(zipCode));
	
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
	
	public String deleteAddress(String id) {
		Address addr = dao.getById(Integer.parseInt(id));
		dao.delete(addr);
		
		return "OK";
	}
	
	public String updateAddress(String id, String addressLine1, String addressLine2, String city, String country, String state, String zipCode) {
		
		Address addrUp = new Address();
		addrUp.setAddressId(Integer.parseInt(id));
		addrUp.setAddressline1(addressLine1);
		addrUp.setAddressline2(addressLine2);
		addrUp.setCity(city);
		addrUp.setCountry(country);
		addrUp.setState(state);
		addrUp.setZipcode(Integer.parseInt(zipCode));
		
		dao.update(addrUp);
		
		return "OK";
	}
	

}
