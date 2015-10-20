package edu.luc.lakezon.service.representation.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Address")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class AddressRepresentation {
	
	private Integer addressId;
	private String addressline1;
	private String addressline2;
	private String city;
	private String country;
	private String state;
	private Integer zipcode;

	public AddressRepresentation() {}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressline1() {
		return addressline1;
	}
	
	public String getAddressline2() {
		return addressline2;
	}


	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
