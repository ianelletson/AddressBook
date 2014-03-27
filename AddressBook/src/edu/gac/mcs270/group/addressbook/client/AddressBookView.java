package edu.gac.mcs270.group.addressbook.client;

import java.util.List;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.gac.mcs270.group.addressbook.shared.AddressEntry;
import edu.gac.mcs270.group.addressbook.shared.FieldVerifier;

/**
 * Class that is shown to user when visiting page, what the user interacts with
 * 
 * @author ielletso
 * 
 */
public class AddressBookView {
	private AddressBook control;
	private FieldVerifier fv = new FieldVerifier();

	/**
	 * Default constructor
	 */
	public AddressBookView() {
	}

	public void setController(AddressBook adBook) {
		control = adBook;
	}

	/**
	 * Sets up welcome page i.e. first loaded page on visit
	 */
	public void viewWelcomePage() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 79);
		// We don't need a side bar on the welcome page
		// makeViewSideBar(horizontalPanel);
	}

	public void viewBookPage(List<AddressEntry> entries) {
		if (entries == null)
			return;

		RootPanel rp = RootPanel.get();
		rp.clear();
		makeMenuBar(rp);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rp.add(horizontalPanel, 10, 79);

		makeViewSideBar(horizontalPanel);

		VerticalPanel dataListPanel = new VerticalPanel();
		horizontalPanel.add(dataListPanel);

		FlowPanel flowPanel = new FlowPanel();
		dataListPanel.add(flowPanel);

		// Label progTitlebar = new Label("GusList");
		// progTitlebar.addStyleName("appTitleBar");
		// progTitlebar.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		// flowPanel.add(progTitlebar);

		makePostTable(entries, flowPanel);
	}

	private void makePostTable(List<AddressEntry> entry, FlowPanel flowPanel) {
		for (AddressEntry ent : entry) {
			flowPanel.add(makePostRow(ent));
		}
	}

	private HorizontalPanel makePostRow(final AddressEntry entry) {
		HorizontalPanel row = new HorizontalPanel();
		Label nameLabel = new Label(entry.getName() + " ");
		nameLabel.addStyleName("postLabel");
		Label addressLabel = new Label(entry.getAddress() + " ");
		addressLabel.addStyleName("postLabel");
		Label cityLabel = new Label(entry.getCity() + ", " + entry.getState());
		cityLabel.addStyleName("postLabel");
		Button infoButton = new Button("More Info");
		infoButton.addStyleName("postInfoButton");
		infoButton.setText("More Info");
		infoButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				viewEntryData(entry);

			}
		});
		row.add(nameLabel);
		row.add(addressLabel);
		row.add(cityLabel);
		row.add(infoButton);
		return row;
	}

	private void viewEntryData(final AddressEntry entry) {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 79);

		VerticalPanel dataListPanel = new VerticalPanel();
		horizontalPanel.add(dataListPanel);

		FlowPanel flowPanel = new FlowPanel();
		dataListPanel.add(flowPanel);

		// Title TextBox
		HorizontalPanel titlePanel = new HorizontalPanel();
		Label titleLabel = new Label(entry.getName());
		titleLabel.addStyleName("postTitle");
		titlePanel.add(titleLabel);
		flowPanel.add(titlePanel);

		// Phone Number TextArea
		HorizontalPanel phonePanel = new HorizontalPanel();
		String phone = entry.getPhoneNumber();
		Label phoneLabel = new Label("Phone Number: " + phone.substring(0, 3)
				+ "-" + phone.substring(3, 6) + "-" + phone.substring(6, 10));
		phoneLabel.addStyleName("postBody");
		phonePanel.add(phoneLabel);
		flowPanel.add(phonePanel);

		// AddressTextArea
		HorizontalPanel addressPanel = new HorizontalPanel();
		Label addressLabel = new Label("Address: " + entry.getAddress());
		addressLabel.addStyleName("postBody");
		addressPanel.add(addressLabel);
		flowPanel.add(addressPanel);

		// Zip TextBox
		HorizontalPanel zipPanel = new HorizontalPanel();
		Label zipLabel = new Label("Zip Code: " + entry.getZip());
		zipLabel.addStyleName("postBody");
		zipPanel.add(zipLabel);
		flowPanel.add(zipPanel);

		// City TextBox
		HorizontalPanel cityPanel = new HorizontalPanel();
		Label cityLabel = new Label("City: " + entry.getCity());
		cityLabel.addStyleName("postBody");
		cityPanel.add(cityLabel);
		flowPanel.add(cityPanel);

		// State TextBox
		HorizontalPanel statePanel = new HorizontalPanel();
		Label stateLabel = new Label("State: " + entry.getState());
		stateLabel.addStyleName("postBody");
		statePanel.add(stateLabel);
		flowPanel.add(statePanel);

		// Edit Post Button
		Button editPostButton = new Button("Edit Ad");
		editPostButton.setStyleName("sideBarButton");
		editPostButton.setText("Edit Ad");

		// Edit Post Click Handler
		editPostButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// TODO:Create viewEditEntry(entry)
				// viewEditPostAdForm(entry);
			}
		});

		// Delete Post Button
		Button deletePostButton = new Button("Delete Ad");
		deletePostButton.setStyleName("sideBarButton");
		deletePostButton.setText("Delete Ad");

		// Delete Post Click Handler
		deletePostButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				control.handleDeleteRequest(entry);
			}
		});

		flowPanel.add(editPostButton);
		flowPanel.add(deletePostButton);
	}

	/**
	 * Make the Add Entry view
	 */
	public void viewAddEntryPage() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 79);

		VerticalPanel postFormPanel = new VerticalPanel();
		horizontalPanel.add(postFormPanel);

		// First name input
		HorizontalPanel nameRow = new HorizontalPanel();
		Label firstNameLabel = new Label("First name");
		final TextBox firstNameTextBox = new TextBox();
		nameRow.add(firstNameLabel);
		nameRow.add(firstNameTextBox);
		// postFormPanel.add(nameRow);

		// Last name input
		Label lastNameLabel = new Label("Last name");
		final TextBox lastNameTextBox = new TextBox();
		nameRow.add(lastNameLabel);
		nameRow.add(lastNameTextBox);
		postFormPanel.add(nameRow);

		// Address input
		HorizontalPanel addressRow = new HorizontalPanel();
		Label addressLabel = new Label("Street Address");
		final TextBox addressTextBox = new TextBox();
		addressRow.add(addressLabel);
		addressRow.add(addressTextBox);
		postFormPanel.add(addressRow);

		// City input
		HorizontalPanel cityRow = new HorizontalPanel();
		Label cityLabel = new Label("City");
		final TextBox cityTextBox = new TextBox();
		cityRow.add(cityLabel);
		cityRow.add(cityTextBox);
		postFormPanel.add(cityRow);

		// State input
		HorizontalPanel stateRow = new HorizontalPanel();
		Label stateLabel = new Label("State");
		final TextBox stateTextBox = new TextBox();
		stateRow.add(stateLabel);
		stateRow.add(stateTextBox);
		postFormPanel.add(stateRow);

		// Zip input
		HorizontalPanel zipRow = new HorizontalPanel();
		Label zipLabel = new Label("Zip");
		final TextBox zipTextBox = new TextBox();
		zipRow.add(zipLabel);
		zipRow.add(zipTextBox);
		postFormPanel.add(zipRow);

		// Phone Number input
		HorizontalPanel phoneRow = new HorizontalPanel();
		Label phoneLabel = new Label("Phone Number");
		final TextBox phoneTextBox = new TextBox();
		phoneRow.add(phoneLabel);
		phoneRow.add(phoneTextBox);
		postFormPanel.add(phoneRow);

		// Submit button
		Button submitButton = new Button("Add Entry");
		submitButton.setStyleName("sideBarButton");
		submitButton.setText("Add Entry");

		submitButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String firstName = firstNameTextBox.getText();
				String lastName = lastNameTextBox.getText();
				String address = addressTextBox.getText();
				String city = cityTextBox.getText();
				String state = stateTextBox.getText();
				String zip = zipTextBox.getText();
				String phoneNumber = phoneTextBox.getText();
				// Validate entries
				// TODO field verifier
				if (firstName.length() > 0 && lastName.length() > 0
						&& city.length() > 0 && address.length() > 0
						&& state.length() > 0 && zip.length() >= 0
						&& phoneNumber.length() == 10) {
					AddressEntry entry = new AddressEntry(lastName, firstName,
							address, city, state, zip, phoneNumber);
					control.handleEntrySubmit(entry);
					// TODO
					// control.handlePostSubmit();
				} else {
					Window.alert("Fail");
					// Should send error message to user
				}
			}
		});
		postFormPanel.add(submitButton);
	}

	public void viewSearchPage() {
		RootPanel rp = RootPanel.get();
		rp.clear();
		makeMenuBar(rp);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rp.add(horizontalPanel, 10, 79);
		VerticalPanel searchFormPanel = new VerticalPanel();
		horizontalPanel.add(searchFormPanel);

		// Search input
		HorizontalPanel searchRow = new HorizontalPanel();
		Button searchButton = new Button("Search");
		searchButton.setStyleName("sideBarButton");
		searchButton.setText("Search");
		final TextBox searchBox = new TextBox();
		searchRow.add(searchButton);
		searchRow.add(searchBox);
		searchFormPanel.add(searchRow);
		searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String searchString = searchBox.getText();
				control.searchData(searchString);
			}
		});
	}

	private void makeViewSideBar(HorizontalPanel hp) {

		VerticalPanel sidePanel = new VerticalPanel();
		hp.add(sidePanel);
		sidePanel.setSize("72px", "98px");

		Button print = new Button("Print");
		print.setStyleName("sideBarButton");
		print.setText("Print");

		print.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				control.handlePrintRequest();
			}
		});
		sidePanel.add(print);

		Button sortZipButton = new Button("Sort by Zip");
		sortZipButton.setStyleName("sideBarButton");
		sortZipButton.setText("Sort by Zip");
		sidePanel.add(sortZipButton);

		// TODO: Add click handler for sort by zip
		sortZipButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				control.viewDataByZipFromServer();
			}
		});

		Button sortNameButton = new Button("Sort by Name");
		sortNameButton.setStyleName("sideBarButton");
		sortNameButton.setText("Sort by Name");
		// TODO: add click handler for sort by name
		sortNameButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				control.viewDataByNameFromServer();
			}
		});
		sidePanel.add(sortNameButton);
	}

	/**
	 * Make a menu bar on the top of the page that displays commonly used items
	 * 
	 * @param rp
	 *            the root panel of the page
	 */
	private void makeMenuBar(RootPanel rp) {

		MenuBar menuBar = new MenuBar(false);
		rp.add(menuBar, 94, 39);
		menuBar.setSize("400px", "32px");

		MenuItem menuHomeItem = new MenuItem("Home", false, new Command() {
			public void execute() {
				viewWelcomePage();
			}
		});
		menuHomeItem.setHTML("Home");
		menuBar.addItem(menuHomeItem);
		menuBar.addSeparator(new MenuItemSeparator());

		MenuItem menuViewAdBook = new MenuItem("Address Book", false,
				new Command() {
					public void execute() {
						control.viewEntryDataFromServer();
					}
				});
		menuViewAdBook.setHTML("Address Book");
		menuBar.addItem(menuViewAdBook);
		menuBar.addSeparator(new MenuItemSeparator());

		MenuItem menuAddEntry = new MenuItem("Add Entry", false, new Command() {
			public void execute() {
				viewAddEntryPage();
			}
		});

		menuAddEntry.setHTML("Add Entry");
		menuBar.addItem(menuAddEntry);
		menuBar.addSeparator(new MenuItemSeparator());

		MenuItem menuSearchItem = new MenuItem("Search", false, new Command() {
			public void execute() {
				viewSearchPage();
			}
		});
		menuSearchItem.setHTML("Search");
		menuBar.addItem(menuSearchItem);

	}

	public void sendSuccessfulPostMessage() {
		Window.alert("Successfully stored");
	}

	public void sendSuccessfulDeletePostMessage() {
		Window.alert("DELETED!! -- Bye Bye");
	}

	public void sendSuccessfulPrintMessage() {
		Window.alert("Sucessfully Printed Address Book");
	}
}
