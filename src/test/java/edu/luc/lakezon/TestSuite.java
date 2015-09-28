package edu.luc.lakezon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.luc.lakezon.customer.AddressTest;
import edu.luc.lakezon.customer.CustomerTest;
import edu.luc.lakezon.order.OrderDetailTest;
import edu.luc.lakezon.order.OrderTest;
import edu.luc.lakezon.product.ProductOwnerTest;
import edu.luc.lakezon.product.ProductTest;
import edu.luc.lakezon.product.ReviewTest;

@RunWith(Suite.class)
@SuiteClasses({
	AddressTest.class,
	CustomerTest.class,
	OrderDetailTest.class,
	OrderTest.class,
	ProductOwnerTest.class,
	ProductTest.class,
	ReviewTest.class
})
public class TestSuite {

}
