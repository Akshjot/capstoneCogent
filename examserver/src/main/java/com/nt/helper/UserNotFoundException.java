package com.nt.helper;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException() {
		super("User with this username is not in databse");
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
