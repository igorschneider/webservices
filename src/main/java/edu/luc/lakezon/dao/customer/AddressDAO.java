package edu.luc.lakezon.dao.customer;

import edu.luc.lakezon.business.customer.Address;
import edu.luc.lakezon.dao.BaseDAO;

public class AddressDAO  extends BaseDAO<Address> {

	public Address getById(Integer id) {
		return super.getById(id, "Address", "addressId");
	}

}
