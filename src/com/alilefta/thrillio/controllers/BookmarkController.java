package com.alilefta.thrillio.controllers;

import com.alilefta.thrillio.entities.Bookmark;
import com.alilefta.thrillio.entities.User;
import com.alilefta.thrillio.managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();

	private BookmarkController() {
	}

	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
	}

	/*
	 * This method was moved from View to Controller, to prevent business logic to
	 * be on front end, instead be on back end. Invocation: Model part
	 * [BookmarkManager]
	 */
	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user, bookmark);
	}

}
