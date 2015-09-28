package edu.luc.lakezon.dao.customer;

import java.util.Iterator;

import edu.luc.lakezon.customer.Customer;
import edu.luc.lakezon.dao.BaseDAO;

public class CustomerDAO extends BaseDAO<Customer> {

	public Customer getById(Integer id) {
		return super.getById(id, "Customer", "customerId");
	}

}
