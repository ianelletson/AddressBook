package edu.gac.mcs270.group.addressbook.server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import edu.gac.mcs270.group.addressbook.shared.AddressEntry;

public class AddressBookModel {
	static final PersistenceManagerFactory pmf = PMF.get();

	
	
	public static List<AddressEntry> getAddressEntry() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(AddressEntry.class);
		List<AddressEntry> posts = (List<AddressEntry>) query.execute();
		return new ArrayList<AddressEntry>(posts);
	}

	public static void storePost(AddressEntry entry) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(entry);
	}
}
