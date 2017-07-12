package com.infy.exceptions;


@SuppressWarnings("serial")
public class InvalidDateException extends Exception
{

	public InvalidDateException() 
	{
		super("Date is invalid ");
		
	}
}
