package edu.luc.lakezon.dao.order;
import edu.luc.lakezon.dao.BaseDAO;
import edu.luc.lakezon.order.Order;

public class OrderDAO extends BaseDAO<Order>{

	public Order getById(Integer id) {
		return super.getById(id, "Order", "orderId");
	}
}
