package edu.gac.mcs270.group.addressbook.client;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Class that is shown to user when visiting page, what the user interacts with
 * @author ielletso
 *
 */
public class AddressBookView {
	private AddressBook control;
	
	/**
	 * Default constructor
	 */
	public AddressBookView() {}
	
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
//		We don't need a side bar on the welcome page
//		makeViewSideBar(horizontalPanel);
	}
	
	public void viewBookPage() {
		RootPanel rp = RootPanel.get();
		rp.clear();
		makeMenuBar(rp);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rp.add(horizontalPanel, 10, 79);
		
		makeViewSideBar(horizontalPanel);
	}
	
	public void viewAddEntryPage() {
		RootPanel rp = RootPanel.get();
		rp.clear();
		makeMenuBar(rp);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rp.add(horizontalPanel, 10, 79);
	}

	public void viewSearchPage(){
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
//		TODO: Print click handler
//		print.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				viewPostAdForm();
//			}
//	      });
		sidePanel.add(print);

		Button sortZipButton = new Button("Sort by Zip");
		sortZipButton.setStyleName("sideBarButton");
		sortZipButton.setText("Sort by Zip");
		sidePanel.add(sortZipButton);
		
//		TODO: Add click handler for sort by zip
//		sortZipButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				control.viewAdDataFromServer();
//			}
//	      });
//		sidePanel.add(sortZipButton);
		
		Button sortNameButton = new Button("Sort by Name");
		sortNameButton.setStyleName("sideBarButton");
		sortNameButton.setText("Sort by Name");
//		TODO: add click handler for sort by name
//		sortNameButton.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				control.viewAdDataFromServer();
//			}
//	      });
		sidePanel.add(sortNameButton);
	}

	/**
	 * Make a menu bar on the top of the page that displays commonly used items
	 * @param rp the root panel of the page
	 */
	private void makeMenuBar(RootPanel rp) {
		// TODO Implement methods and button listeners/click handlers
		//  is root panel
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

		// TODO this looks really bad if we have "Address Book" as opposed to book. We need to fix this
		MenuItem menuViewAdBook = new MenuItem("Address Book", false, new Command() {
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
		
		
		MenuItem menuSearchItem = new MenuItem("Search", false, new Command(){
			public void execute() {
				viewSearchPage();
			}
		});
		menuSearchItem.setHTML("Search");
		menuBar.addItem(menuSearchItem);

	}
}

