package com.infy.exceptions;

@SuppressWarnings("serial")
public class InvalidOldPasswordException extends Exception {
	public InvalidOldPasswordException() {
		super("Current password is incorrect");
	}
}
