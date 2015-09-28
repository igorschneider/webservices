package edu.luc.lakezon.factory;

import java.util.Calendar;
import edu.luc.lakezon.customer.Address;
import edu.luc.lakezon.customer.Customer;

public final class TestFactory {
	private static Customer customerTest = new Customer();
	private static Address addressTest = new Address();
	
	public static  boolean isSameDay(Calendar cal1, Calendar cal2) {
		if (cal1 == null || cal2 == null)
			return false;
		return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
	}
	
	public static Customer initCustomer (){
	
		addressTest.setAddressline1("N SHERIDAN AVE");
		addressTest.setAddressline2("APT 1324");
		addressTest.setCity("Chicago");
		addressTest.setCountry("US");
		addressTest.setState("Illinois");
		addressTest.setZipcode(666666);
		customerTest.setAddress(addressTest);
		customerTest.setBirthdate(Calendar.getInstance());
		customerTest.setGender("M");
		customerTest.setName("Eduard Smith");
		customerTest.setPassword("4588");
		return customerTest;
		
	}

}
