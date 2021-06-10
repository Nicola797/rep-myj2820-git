package com.test.spring.mvc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.spring.mvc.model.User;

public class UsersDB {

	public static List<User> users;
	
	static {
		users = new ArrayList<User>();
		User u1 = new User(1, "Alex", "Ivanov", 34, 'm');
		User u2 = new User(13, "Anna", "Ivanova", 55, 'f');
		User u3 = new User(44, "Mike", "Mike", 21, 'm');
		User u4 = new User(21, "John", "Johnson", 21, 'm');
		User u5 = new User(222, "Bill", "Billson", 43, 'm');
		User u6 = new User(17, "Janna", "S", 22, 'f');
		
		users.addAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
		
	}
	
	
	public static User getUser(int id) {
		for (User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	//1. make new Controller 'UsersController'
	// 2. CRUD
	// a. /users/get?id=21   -> view-user.jsp
	// b. /users/viewAll - > view-users.jsp
	// c. /users/remove?id=222 - > ?
	
	// d. /users/add - > via FORM ?
	// e. /users/update - > via FORM  ?
	
	
	
}



