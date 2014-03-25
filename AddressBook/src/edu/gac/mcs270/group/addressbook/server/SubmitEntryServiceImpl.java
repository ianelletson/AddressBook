package edu.gac.mcs270.group.addressbook.server;
import edu.gac.mcs270.group.addressbook.client.SubmitEntryService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.gac.mcs270.group.addressbook.shared.AddressEntry;


@SuppressWarnings("serial")
public class SubmitEntryServiceImpl extends RemoteServiceServlet implements SubmitEntryService {
	
	//TODO: create the correct methods for to store data	
@Override
public String submitEntryToServer(AddressEntry entry) {
	AddressBookModel.storePost(entry);
	return "Entry submitted okay";
}
//
//@Override
//public String changePostToServer(long postId, PostData newPost) {
//	GusListModel.changePostData(postId, newPost);
//	return "post changed okay";
//}
//
//
//@Override
//public String deletePostFromServer(PostData post) {
//	GusListModel.deletePostData(post);
//	return "post deleted okay";
//}
}