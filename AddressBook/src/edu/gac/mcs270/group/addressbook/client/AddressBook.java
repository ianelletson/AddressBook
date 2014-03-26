package edu.gac.mcs270.group.addressbook.client;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.gac.mcs270.group.addressbook.shared.AddressEntry;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AddressBook implements EntryPoint {
	/**
	 * This variables are our view and communications
	 */
	// TODO: Create class, see below
	private final AddressBookView abView = new AddressBookView();
	private final SubmitEntryServiceAsync eServ = GWT
			.create(SubmitEntryService.class);

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method. This will also have some changes.
	 */
	public void onModuleLoad() {
		abView.setController(AddressBook.this);
		abView.viewWelcomePage();
	};

	// TODO: handleAddressSubmit
	public void handleEntrySubmit(AddressEntry entry) {
		eServ.submitEntryToServer(entry,
				new AsyncCallback<String>() {
			public void onFailure(Throwable caught) { 
				return;
			}

			@Override
			public void onSuccess(String result) {
				abView.sendSuccessfulPostMessage();
			}
		});
	}

	public void viewEntryDataFromServer(){
		eServ.getEntryDataFromServer(
				new AsyncCallback<List<AddressEntry>>() {
					public void onFailure(Throwable caught) {
						return;
					}

					@Override
					public void onSuccess(List<AddressEntry> data) {
						abView.viewBookPage(data);
					}
				});
	}
	
	public void viewDataByNameFromServer(){
		eServ.getByName(
				new AsyncCallback<List<AddressEntry>>() {
					public void onFailure(Throwable caught) {
						return;
					}

					@Override
					public void onSuccess(List<AddressEntry> data) {
						abView.viewBookPage(data);
					}
				});
	}
	
	public void viewDataByZipFromServer(){
		eServ.getByZip(
				new AsyncCallback<List<AddressEntry>>() {
					public void onFailure(Throwable caught) {
						return;
					}

					@Override
					public void onSuccess(List<AddressEntry> data) {
						abView.viewBookPage(data);
					}
				});
	}
	
	
	
	public void handleDeleteRequest(AddressEntry entry) {
		eServ.deleteEntryFromServer(entry,
				new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						return;
					}

					@Override
					public void onSuccess(String result) {
						abView.sendSuccessfulDeletePostMessage();
						viewEntryDataFromServer();
					}
				});
	}

	// TODO: handleSearchRequest
	// TODO: handleSortRequest

	public void handlePrintRequest() {
		eServ.getEntryDataFromServer(
				new AsyncCallback<List<AddressEntry>>() {
					public void onFailure(Throwable caught) {
						return;
					}

					@Override
					public void onSuccess(List<AddressEntry> data) {
						for(AddressEntry ent: data){
							System.out.println(ent);
							System.out.println();
						}
						
						abView.viewBookPage(data);
						abView.sendSuccessfulPrintMessage();
					}
				});
	}

}
