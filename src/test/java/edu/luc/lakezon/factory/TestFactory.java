package edu.luc.lakezon.factory;

import java.util.Calendar;

import edu.luc.lakezon.business.customer.Address;
import edu.luc.lakezon.business.customer.Customer;
import edu.luc.lakezon.business.order.Order;
import edu.luc.lakezon.business.order.OrderDetail;
import edu.luc.lakezon.business.order.Status;
import edu.luc.lakezon.business.product.Product;
import edu.luc.lakezon.business.product.ProductOwner;
import edu.luc.lakezon.business.product.Review;

public final class TestFactory {

	public static Address initAddress() {

		Address addressTest = new Address();

		addressTest.setAddressline1("Rua tal");
		addressTest.setAddressline2("Numero tal");
		addressTest.setCity("Chicagouo");
		addressTest.setCountry("USA");
		addressTest.setState("Illinois");
		addressTest.setZipcode(666666);

		return addressTest;
	}

	public static Customer initCustomer() {

		Customer customerTest = new Customer();

		customerTest.setAddress(initAddress());
		customerTest.setBirthdate(Calendar.getInstance());
		customerTest.setGender("M");
		customerTest.setName("Bob Louis");
		customerTest.setPassword("4588");

		return customerTest;
	}

	public static Product initProduct() {

		Product productTest = new Product();

		productTest.setDescription("Large Table");
		productTest.setImg("img.jpg");
		productTest.setName("American Table");
		productTest.setProductOwner(initProductOwner());
		productTest.setQuantity(4);
		productTest.setPrice(8.88);

		return productTest;
	}

	public static Review initReview(){

		Review reviewTest = new Review();

		reviewTest.setCustomer(initCustomer());
		reviewTest.setDescription("Best item ever!");
		reviewTest.setRating(4);
		reviewTest.setProduct(initProduct());
		reviewTest.setReviewDate(Calendar.getInstance());	

		return reviewTest;
	}

	public static ProductOwner initProductOwner() {

		ProductOwner prodOwnerTest = new ProductOwner();

		prodOwnerTest.setName("Amazon Warehouse");

		return prodOwnerTest;
	}

	public static Order initOrder() {

		Order orderTest = new Order();

		orderTest.setCustomer(initCustomer());
		orderTest.setOrderDate(Calendar.getInstance());
		orderTest.setStatus(Status.PROCESSING);

		return orderTest;
	}

	public static OrderDetail initOrderDetail() {

		OrderDetail orderDetailTest = new OrderDetail();

		orderDetailTest.setOrder(initOrder());
		orderDetailTest.setProduct(initProduct());
		orderDetailTest.setQuantity(55);

		return orderDetailTest;
	}

}
