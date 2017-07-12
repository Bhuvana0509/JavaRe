package com.infy.exceptions;
@SuppressWarnings("serial")
public class InvalidFileExtensionException extends Exception {
	public InvalidFileExtensionException()
	{
	super("Invalid File Type ! only Excel(.xls) file can be uploaded");
	}

}
