package edu.luc.lakezon.dao.order;
import edu.luc.lakezon.business.order.Order;
import edu.luc.lakezon.dao.BaseDAO;

public class OrderDAO extends BaseDAO<Order>{

	public Order getById(Integer id) {
		return super.getById(id, "Order", "orderId");
	}
}
