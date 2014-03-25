package edu.gac.mcs270.group.addressbook.client;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.gac.mcs270.group.addressbook.shared.AddressEntry;


public interface SubmitEntryServiceAsync {

	public void sumbitEntryToServer(AddressEntry entry, AsyncCallback<String> asyncCallback);
}
