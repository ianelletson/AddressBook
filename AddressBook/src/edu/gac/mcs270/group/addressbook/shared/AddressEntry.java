package edu.gac.mcs270.group.addressbook.shared;

import java.io.Serializable;
import java.util.Comparator;

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
	private String lastName = "No last name";
	@Persistent
	private String firstName = "No first name";
	@Persistent
	private String address = "No address";
	@Persistent
	private String city = "Nowhere";
	@Persistent
	private String state = "Missouri";
	@Persistent
	private String zip ="00000";
	@Persistent
	private String phoneNumber = "0000000000";
	
	/**
	 * defines the Comparators for sorting
	 */

	public static Comparator<AddressEntry> COMPARE_BY_NAME = new Comparator<AddressEntry>() {
        public int compare(AddressEntry one, AddressEntry other) {
            return one.lastName.compareTo(other.lastName);
        }
    };

    public static Comparator<AddressEntry> COMPARE_BY_ZIP = new Comparator<AddressEntry>() {
        public int compare(AddressEntry one, AddressEntry other) {
            return one.zip.compareTo(other.zip);
        }
    };

	/**
	 * Default constructor for AddressEntry
	 */
	public AddressEntry() {
	}

	/**
	 * Create a new AddressEntry object that holds the contact information of some entity
	 * @param lastName the entity's name
	 * @param address the entity's address
	 * @param city the entity's city
	 * @param state the entity's state
	 * @param zip the entity's ZIP code
	 * @param phoneNumber the entity's phone number
	 */
	public AddressEntry(String lastName, String firstName, String address, String city, String state,
			String zip, String phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return lastName + ", " + firstName;
	}

	public void setLastName(String name) {
		this.lastName = name;
	}
	
	public void setFirstname(String name) {
		this.firstName = name;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
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
		return lastName + "\n" + address + "\n" + city + ", " + state + " " + zip + "\n" + phoneNumber;
	}

}
