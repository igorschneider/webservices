package edu.luc.lakezon.dao.customer;

import java.util.Set;

import edu.luc.lakezon.business.customer.Address;
import edu.luc.lakezon.dao.BaseDAO;

public class AddressDAO  extends BaseDAO<Address> {

	public Address getById(Integer id) {
		return super.getById(id, "Address", "addressId");
	}
	
	public Set<Address> getAll() {
		return super.getAll("Address");
	}


}
