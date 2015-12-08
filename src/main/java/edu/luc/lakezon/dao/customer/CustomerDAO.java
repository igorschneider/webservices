package edu.luc.lakezon.dao.customer;

import java.util.Set;

import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.dao.BaseDAO;

public class CustomerDAO extends BaseDAO<Customer> {

	public Customer getById(Integer id) {
		return super.getById(id, "Customer", "customerId");
	}

	public Set<Customer> getAll() {
		return super.getAll("Customer");
	}

	public Set<Customer> getAllByString(String search) {
		return super.getAllByString(search, "Customer", "name");
	}

}
