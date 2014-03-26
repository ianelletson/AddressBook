package edu.gac.mcs270.group.addressbook.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.gac.mcs270.group.addressbook.shared.AddressEntry;

public interface SubmitEntryServiceAsync {

	void submitEntryToServer(AddressEntry entry,
			AsyncCallback<String> asyncCallback);

	void getEntryDataFromServer(AsyncCallback<List<AddressEntry>> asyncCallback);

	void deleteEntryFromServer(AddressEntry entry,AsyncCallback<String> asyncCallback);

	void getByName(AsyncCallback<List<AddressEntry>> asyncCallback);
	void getByZip(AsyncCallback<List<AddressEntry>> asyncCallback);
	
}