package edu.luc.lakezon.dao.order;
import edu.luc.lakezon.dao.BaseDAO;
import edu.luc.lakezon.order.OrderDetail;

public class OrderDetailDAO extends BaseDAO<OrderDetail>{
	public OrderDetail getById(Integer id1,Integer id2) {
		return super.getById(id1,id2, "OrderDetail", "orderId","productId" );
	}
}
