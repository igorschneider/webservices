package edu.luc.lakezon.dao.customer;

import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.dao.BaseDAO;

public class CustomerDAO extends BaseDAO<Customer> {

	public Customer getById(Integer id) {
		return super.getById(id, "Customer", "customerId");
	}

}
