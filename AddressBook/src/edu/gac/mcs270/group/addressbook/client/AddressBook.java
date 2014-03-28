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
	private final AddressBookView abView = new AddressBookView();
	private final SubmitEntryServiceAsync eServ = GWT
			.create(SubmitEntryService.class);

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	@SuppressWarnings("unused")
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	@SuppressWarnings("unused")
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method. This will also have some changes.
	 */
	public void onModuleLoad() {
		abView.setController(AddressBook.this);
		abView.viewWelcomePage();
	};

	/**
	 * Submit an address entry
	 * 
	 * @param entry
	 *            the AddressEntry class
	 */
	public void handleEntrySubmit(AddressEntry entry) {
		eServ.submitEntryToServer(entry, new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				return;
			}

			@Override
			public void onSuccess(String result) {
				abView.sendSuccessfulPostMessage();
			}
		});
	}

	/**
	 * For displaying stored entries
	 */
	public void viewEntryDataFromServer() {
		eServ.getEntryDataFromServer(new AsyncCallback<List<AddressEntry>>() {
			public void onFailure(Throwable caught) {
				return;
			}

			@Override
			public void onSuccess(List<AddressEntry> data) {
				abView.viewBookPage(data);
			}
		});
	}

	/**
	 * Sorting by last name
	 */
	public void viewDataByNameFromServer() {
		eServ.getByName(new AsyncCallback<List<AddressEntry>>() {
			public void onFailure(Throwable caught) {
				return;
			}

			@Override
			public void onSuccess(List<AddressEntry> data) {
				abView.viewBookPage(data);
			}
		});
	}

	/**
	 * Sorting by ZIP
	 */
	public void viewDataByZipFromServer() {
		eServ.getByZip(new AsyncCallback<List<AddressEntry>>() {
			public void onFailure(Throwable caught) {
				return;
			}

			@Override
			public void onSuccess(List<AddressEntry> data) {
				abView.viewBookPage(data);
			}
		});
	}

	/**
	 * Search for selected string in any part of stored AddressEntry data
	 * 
	 * @param searchString
	 *            client input search string
	 */
	public void searchData(String searchString) {
		eServ.getSearchResult(searchString,
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

	/**
	 * Delete data from server
	 * 
	 * @param entry
	 */
	public void handleDeleteRequest(AddressEntry entry) {
		eServ.deleteEntryFromServer(entry, new AsyncCallback<String>() {
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

	/**
	 * Print data to system console
	 */
	public void handlePrintRequest() {
		eServ.getEntryDataFromServer(new AsyncCallback<List<AddressEntry>>() {
			public void onFailure(Throwable caught) {
				return;
			}

			@Override
			public void onSuccess(List<AddressEntry> data) {
				for (AddressEntry ent : data) {
					System.out.println(ent);
					System.out.println();
				}

				abView.viewBookPage(data);
				abView.sendSuccessfulPrintMessage();
			}
		});
	}

}
