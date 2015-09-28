package edu.luc.lakezon.factory;

import java.util.Calendar;

import edu.luc.lakezon.customer.Address;
import edu.luc.lakezon.customer.Customer;

public final class TestFactory {
	private static Customer customerTest;
	private static Address addressTest;

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
}
