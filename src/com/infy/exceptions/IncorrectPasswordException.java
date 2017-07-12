package com.infy.exceptions;

@SuppressWarnings("serial")
public class IncorrectPasswordException extends Exception {
	
	public IncorrectPasswordException()
	{
		super("Incorrect Password !!!");
	}
}
