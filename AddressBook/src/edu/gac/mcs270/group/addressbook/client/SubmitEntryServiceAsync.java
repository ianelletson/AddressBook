package edu.gac.mcs270.group.addressbook.client;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.gac.mcs270.group.addressbook.shared.AddressEntry;


public interface SubmitEntryServiceAsync {

	void submitEntryToServer(AddressEntry entry,
			AsyncCallback<String> asyncCallback);
	
}