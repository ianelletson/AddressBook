package edu.gac.mcs270.group.addressbook.client;


import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.gac.mcs270.group.addressbook.shared.AddressEntry;;

@RemoteServiceRelativePath("submitentry") 
public interface SubmitEntryService extends RemoteService {

	public String submitEntryToServer(AddressEntry entry);
}