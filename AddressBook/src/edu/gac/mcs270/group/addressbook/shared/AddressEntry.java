package edu.gac.mcs270.group.addressbook.shared;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 
 * @author ielletso class with fields for name, address, city, state, zip, phone
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class AddressEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	/**
	 * Our private fields that are persistent and save-able
	 */
	@Persistent
	private String name = "No name";
	@Persistent
	private String address = "No address";
	@Persistent
	private String city = "Nowhere";
	@Persistent
	private String state = "Missouri";
	@Persistent
	private int zip = 0;
	@Persistent
	private String phoneNumber = "No phone";

	/**
	 * Default constructor for AddressEntry
	 */
	public AddressEntry() {
	}

	/**
	 * Create a new AddressEntry object that holds the contact information of some entity
	 * @param name the entity's name
	 * @param address the entity's address
	 * @param city the entity's city
	 * @param state the entity's state
	 * @param zip the entity's ZIP code
	 * @param phoneNumber the entity's phone number
	 */
	public AddressEntry(String name, String address, String city, String state,
			int zip, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	// TODO make this print out in label form.
	public String toString() {
		return name + "\n" + address + "\n" + city + ", " + state + " " + zip + "\n" + phoneNumber;
	}

}
