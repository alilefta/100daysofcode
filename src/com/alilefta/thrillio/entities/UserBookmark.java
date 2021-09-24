package com.alilefta.thrillio.entities;

public class UserBookmark {
	/*
	 * This class will maintain the relationship between User and Bookmark If there
	 * was a database used, then this entity will have its own table
	 */
	private User user;
	private Bookmark bookmark;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bookmark getBookmark() {
		return bookmark;
	}

	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}
}
