package edu.gac.mcs270.group.addressbook.client;

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

/**
 * Class that is shown to user when visiting page, what the user interacts with
 * 
 * @author ielletso
 * 
 */
public class AddressBookView {
	private AddressBook control;

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

	public void viewBookPage() {
		RootPanel rp = RootPanel.get();
		rp.clear();
		makeMenuBar(rp);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rp.add(horizontalPanel, 10, 79);

		makeViewSideBar(horizontalPanel);
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

		// Name input
		HorizontalPanel nameRow = new HorizontalPanel();
		Label nameLabel = new Label("Last name, First name");
		final TextBox nameTextbox = new TextBox();
		nameRow.add(nameLabel);
		nameRow.add(nameTextbox);
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
				String name = nameTextbox.getText();
				String address = addressTextBox.getText();
				String city = cityTextBox.getText();
				String state = stateTextBox.getText();
				int zip = Double.valueOf(zipTextBox.getText()).intValue();
				String phoneNumber = phoneTextBox.getText();
				// Validate entries
				if (name.length() > 0 && city.length() > 0
						&& address.length() > 0 && state.length() > 0
						&& zip >= 0 && phoneNumber.length() == 10) {
					AddressEntry entry = new AddressEntry(name, address, city,
							state, zip, phoneNumber);
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
	}

	private void makeViewSideBar(HorizontalPanel hp) {
		// TODO Make click handlers
		VerticalPanel sidePanel = new VerticalPanel();
		hp.add(sidePanel);
		sidePanel.setSize("72px", "98px");

		Button print = new Button("Print");
		print.setStyleName("sideBarButton");
		print.setText("Print");
		// TODO: Print click handler
		// print.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// viewPostAdForm();
		// }
		// });
		sidePanel.add(print);

		Button sortZipButton = new Button("Sort by Zip");
		sortZipButton.setStyleName("sideBarButton");
		sortZipButton.setText("Sort by Zip");
		sidePanel.add(sortZipButton);

		// TODO: Add click handler for sort by zip
		// sortZipButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// control.viewAdDataFromServer();
		// }
		// });
		// sidePanel.add(sortZipButton);

		Button sortNameButton = new Button("Sort by Name");
		sortNameButton.setStyleName("sideBarButton");
		sortNameButton.setText("Sort by Name");
		// TODO: add click handler for sort by name
		// sortNameButton.addClickHandler(new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// control.viewAdDataFromServer();
		// }
		// });
		sidePanel.add(sortNameButton);
	}

	/**
	 * Make a menu bar on the top of the page that displays commonly used items
	 * 
	 * @param rp
	 *            the root panel of the page
	 */
	private void makeMenuBar(RootPanel rp) {
		// TODO Implement methods and button listeners/click handlers
		// is root panel
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

		// TODO this looks really bad if we have "Address Book" as opposed to
		// book. We need to fix this
		MenuItem menuViewAdBook = new MenuItem("Address Book", false,
				new Command() {
					public void execute() {
						viewBookPage();
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
}
