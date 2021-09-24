package com.alilefta.thrillio;

import com.alilefta.thrillio.entities.Bookmark;
import com.alilefta.thrillio.entities.User;
import com.alilefta.thrillio.entities.WebLink;
import com.alilefta.thrillio.managers.BookmarkManager;
import com.alilefta.thrillio.managers.UserManager;

public class Launch {
	
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		System.out.println("1. Loading data ...");
		DataStore.loadData();
		
		
		users = UserManager.getInstance().getUsers(); 
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
//		System.out.println("Printing data ... ");
//		printUserData();
//		printBookmarkData();
	}


	private static void printUserData() {
		for(User user: users) {
			System.out.println(user);
		}
	}

	private static void printBookmarkData() {
		for(Bookmark[] bookmarkList: bookmarks) {
			for(Bookmark bookmark: bookmarkList) {
				System.out.println(bookmark);
			}
		}
	}
	
//	private static void launchBook() {
//		
//		WebLink webLink = BookmarkManager.getInstance().createWebLink(2000,	"Taming Tiger, Part 2", "",	"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
//		System.out.println(webLink.getItemData());
//	}

	private static void start() {
//		System.out.println("\n2. Bookmarking ...");
		for(User user: users) {
			View.browse(user, bookmarks);
		}
	}

	public static void main(String[] args) {
		loadData();
		start();
	}


	

}
