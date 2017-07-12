package com.infy.exceptions;

@SuppressWarnings("serial")
public class UserDoesNotExistException extends Exception
{

	public UserDoesNotExistException() {
		super("No such User Exist in the system !");
		// TODO Auto-generated constructor stub
	}

}
