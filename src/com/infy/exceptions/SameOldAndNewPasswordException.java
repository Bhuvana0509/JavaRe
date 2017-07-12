package com.infy.exceptions;

@SuppressWarnings("serial")
public class SameOldAndNewPasswordException extends Exception {
	public SameOldAndNewPasswordException() {
		super("Old And New Password should not be same");
	}
}
