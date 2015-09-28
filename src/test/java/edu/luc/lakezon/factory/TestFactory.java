package edu.luc.lakezon.factory;

import java.util.Calendar;

import edu.luc.lakezon.customer.Address;
import edu.luc.lakezon.customer.Customer;
import edu.luc.lakezon.dao.product.ProductOwnerDAO;
import edu.luc.lakezon.order.Order;
import edu.luc.lakezon.order.OrderDetail;
import edu.luc.lakezon.order.Status;
import edu.luc.lakezon.product.Product;
import edu.luc.lakezon.product.ProductOwner;
import edu.luc.lakezon.product.Review;

public final class TestFactory {
	private static Customer customerTest;
	private static Address addressTest;
	private static Review reviewTest;
	private static Product productTest;
	private static ProductOwner prodOwnerTest;
	private static Order orderTest;
	private static OrderDetail orderDetailTest;
	
	public static Customer initCustomer() {

		if (customerTest == null) {
			customerTest = new Customer();
			customerTest.setAddress(initAddress());
			customerTest.setBirthdate(Calendar.getInstance());
			customerTest.setGender("M");
			customerTest.setName("Bob Louis");
			customerTest.setPassword("4588");
		}
		return customerTest;

	}

	public static Address initAddress() {

		if (addressTest == null) {
			addressTest = new Address();
			addressTest.setAddressline1("Rua tal");
			addressTest.setAddressline2("Numero tal");
			addressTest.setCity("Chicagouo");
			addressTest.setCountry("USA");
			addressTest.setState("Illinois");
			addressTest.setZipcode(666666);
		}

		return addressTest;
	}
	
	public static Product initProduct(){
		if(productTest == null){
		 productTest = new Product();
		 productTest.setDescription("Large Table");	
		 productTest.setImg("img.jpg");
		 productTest.setName("American Table");
		 productTest.setProductOwner(initProductOwner());
		 productTest.setQuantity(4);	
		}
		
		return productTest;
	}
	
	
	
	public static Review initReview(){
		if(reviewTest == null){
			reviewTest = new Review();
			reviewTest.setCustomer(initCustomer());
			reviewTest.setDescription("Best item ever!");
			reviewTest.setRating(4);
			reviewTest.setProduct(initProduct());
			reviewTest.setReviewDate(Calendar.getInstance());	
		
		}
		
		return reviewTest;		
	}
	
	public static ProductOwner initProductOwner(){
		if(prodOwnerTest == null){
			prodOwnerTest = new ProductOwner();
			prodOwnerTest.setName("Amazon Warehouse");
		}
		return prodOwnerTest;
	}
	public static Order initOrder(){
		if(orderTest == null){
			orderTest = new Order();
			orderTest.setCustomer(initCustomer());
			orderTest.setOrderDate(Calendar.getInstance());
			orderTest.setStatus(Status.PROCESSING);
		}
		return orderTest;
	}
	
	public static OrderDetail initOrderDetail(){
		if(orderDetailTest == null){
			orderDetailTest = new OrderDetail();
			orderDetailTest.setOrder(initOrder());
			orderDetailTest.setProduct(initProduct());
			orderDetailTest.setQuantity(55);
		}
		return orderDetailTest;
	}

	
}
