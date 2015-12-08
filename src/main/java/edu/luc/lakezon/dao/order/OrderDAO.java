package edu.luc.lakezon.dao.order;
import java.util.Set;

import edu.luc.lakezon.business.order.Order;
import edu.luc.lakezon.dao.BaseDAO;

public class OrderDAO extends BaseDAO<Order>{

	public Order getById(Integer id) {
		return super.getById(id, "Order", "orderId");
	}
	
	public Set<Order> getAll() {
		return super.getAll("Order");
	}

	public Set<Order> getAllById(Integer customerId) {
		return super.getAllById(customerId, "Order", "customerId");
	}

}
