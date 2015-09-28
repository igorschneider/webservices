package edu.luc.lakezon.dao.order;
import edu.luc.lakezon.dao.BaseDAO;
import edu.luc.lakezon.order.OrderDetail;

public class OrderDetailDAO extends BaseDAO<OrderDetail>{
	public OrderDetail getById(Integer id) {
		return super.getById(id, "OrderDetail", "orderId");
	}
}
