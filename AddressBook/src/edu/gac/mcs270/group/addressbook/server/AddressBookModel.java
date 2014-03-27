package edu.gac.mcs270.group.addressbook.server;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public static List<AddressEntry> getSearchResult(String searchString) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(AddressEntry.class);
		List<AddressEntry> posts = (List<AddressEntry>) query.execute();
		List<AddressEntry> searchResult = new ArrayList<AddressEntry>();
		for(int i=0; i<posts.size(); i++){
			if (posts.get(i).getName().toLowerCase().contains(searchString.toLowerCase())||posts.get(i).getAddress().toLowerCase().contains(searchString.toLowerCase())||posts.get(i).getCity().toLowerCase().contains(searchString.toLowerCase())||posts.get(i).getState().toLowerCase().contains(searchString.toLowerCase())||posts.get(i).getZip().toLowerCase().contains(searchString.toLowerCase())||posts.get(i).getPhoneNumber().toLowerCase().contains(searchString.toLowerCase())) {
				searchResult.add(posts.get(i));
			}
		}
			return new ArrayList<AddressEntry>(searchResult);
		
	}
	
	public static List<AddressEntry> getSortedByName() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(AddressEntry.class);
		List<AddressEntry> posts = (List<AddressEntry>) query.execute();
		
		//Sort by Name Algorithm
		Collections.sort(posts, AddressEntry.COMPARE_BY_NAME);
		
		return new ArrayList<AddressEntry>(posts);
	}
	
	public static List<AddressEntry> getSortedByZip() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query query = pm.newQuery(AddressEntry.class);
		List<AddressEntry> posts = (List<AddressEntry>) query.execute();
		
		//Sort by Zip Algorithm
		Collections.sort(posts, AddressEntry.COMPARE_BY_ZIP);
		return new ArrayList<AddressEntry>(posts);
	}

	public static void storePost(AddressEntry entry) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(entry);
	}
	
	public static void deletePostData(AddressEntry entry){
		long entryId= entry.getId();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		AddressEntry ent = pm.getObjectById(AddressEntry.class, entryId);
		pm.deletePersistent(ent);
		
	}
}