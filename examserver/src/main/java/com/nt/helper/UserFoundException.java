package com.nt.helper;

public class UserFoundException extends Exception {
	public UserFoundException() {
		super("User with this uername is already there");
	}
	
	public UserFoundException(String msg) {
		super(msg);
	}
}
