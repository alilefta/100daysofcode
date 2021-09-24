package com.alilefta.thrillio.dao;

import com.alilefta.thrillio.DataStore;
import com.alilefta.thrillio.entities.User;

public class UserDao {
	// We must use SQL queries in this class
	// Instead we used classes to get info.
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}
