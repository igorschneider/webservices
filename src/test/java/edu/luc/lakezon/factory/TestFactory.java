package edu.luc.lakezon.factory;

import java.util.Calendar;

import edu.luc.lakezon.customer.Address;
import edu.luc.lakezon.customer.Customer;

public final class TestFactory {
	private static Customer customerTest;
	private static Address addressTest;
	
	public static Customer initCustomer (){
	
		if(customerTest==null){		
		customerTest = new Customer();
		addressTest = new Address();
		addressTest.setAddressline1("N SHERIDAN AVE");
		addressTest.setAddressline2("APT 1324");
		addressTest.setCity("Chicago");
		addressTest.setCountry("US");
		addressTest.setState("Illinois");
		addressTest.setZipcode(666666);
		customerTest.setAddress(addressTest);
		customerTest.setBirthdate(Calendar.getInstance());
		customerTest.setGender("M");
		customerTest.setName("Bob Louis");
		customerTest.setPassword("4588");
		}
		return customerTest;
		
	}

}
