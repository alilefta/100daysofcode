package com.alilefta.thrillio.managers;

import com.alilefta.thrillio.dao.UserDao;
import com.alilefta.thrillio.entities.User;

public class UserManager {

	/*
	 * Applying Singleton design pattern, Which means to restrict instantiate
	 * objects from the class. - Only one object to be created as it singleton
	 * Private constructor can help us. - If it is a private constructor, how do we
	 * create our single object? - By instantiate the object here in the class, from
	 * a method that return that object.
	 */

	// static, for the purpose of invoking in static context.
	private static UserManager userManagerInstance = new UserManager();
	
	private static UserDao dao = new UserDao();

	private UserManager() {
	}

	/*
	 * Singleton method, return single object of the class. Provide a global point
	 * of access. When it invoked, JVM was already created that instance. before
	 * blocking instantiation.
	 */
	public static UserManager getInstance() {
		return userManagerInstance;
	}
	
	public User createUser(long id, String email, String password, String firstName, String LastName, int gender, String userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(LastName);
		user.setGender(gender);
		user.setUserType(userType);
		return user;
	}
	
	public User[] getUsers() {
		return dao.getUsers();
	}
}
