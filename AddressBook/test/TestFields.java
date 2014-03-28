import static org.junit.Assert.*;

import org.junit.Test;

import edu.gac.mcs270.group.addressbook.shared.FieldVerifier;

/**
 * JUnit testing to make sure field verifier works as intended
 */

/**
 * @author ielletso
 * 
 */
public class TestFields {

	@Test
	public void testValidName() {
		String passFirstName = "Jackie";
		String passLastName = "Chan";
		String failFirstName = "";
		String failLastName = "";
		assertEquals(FieldVerifier.isValidName(passFirstName), true);
		assertEquals(FieldVerifier.isValidName(passLastName), true);
		assertEquals(FieldVerifier.isValidName(failFirstName), false);
		assertEquals(FieldVerifier.isValidName(failLastName), false);
	}

	@Test
	public void testValidCity() {
		String passCity = "Hong Kong";
		String failCity = "";
		assertEquals(FieldVerifier.isValidCity(passCity), true);
		assertEquals(FieldVerifier.isValidCity(failCity), false);
	}

	@Test
	public void testValidState() {
		String passState = "Alaska";
		String failState = "";
		assertEquals(FieldVerifier.isValidCity(passState), true);
		assertEquals(FieldVerifier.isValidCity(failState), false);
	}

	@Test
	public void testValidAddress() {
		String passAddress = "123 Easy Street";
		String failAddress = "";
		assertEquals(FieldVerifier.isValidAddress(passAddress), true);
		assertEquals(FieldVerifier.isValidAddress(failAddress), false);
	}

	@Test
	public void testValidPhone() {
		String passPhone = "5079338080";
		String failPhone = "01234";
		assertEquals(FieldVerifier.isValidPhoneNumber(passPhone), true);
		assertEquals(FieldVerifier.isValidPhoneNumber(failPhone), false);
	}

	@Test
	public void testValidZIP() {
		String passZIP = "54016";
		String failZIP = "1234";

		assertEquals(FieldVerifier.isValidZIP(passZIP), true);
		assertEquals(FieldVerifier.isValidZIP(failZIP), false);
	}
}