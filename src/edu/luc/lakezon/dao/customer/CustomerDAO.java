package edu.luc.lakezon.dao.customer;

import java.util.Iterator;

import edu.luc.lakezon.customer.Customer;
import edu.luc.lakezon.dao.BaseDAO;

public class CustomerDAO extends BaseDAO<Customer> {

	public Customer getById(Integer id) {
		Customer customer = null;
		
		session.beginTransaction();

		query = session.createQuery("from Customer where customerId = :customerID");
		query.setParameter("customerID", id);
		
		try {
			Iterator<Customer> i = (Iterator<Customer>) query.list().iterator();
			if (i != null && i.hasNext()) {
				customer = (Customer) i.next();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		session.getTransaction().commit();

		return customer;
	}
	
}
