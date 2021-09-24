package com.alilefta.thrillio.dao;

import com.alilefta.thrillio.DataStore;
import com.alilefta.thrillio.entities.Bookmark;
import com.alilefta.thrillio.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
