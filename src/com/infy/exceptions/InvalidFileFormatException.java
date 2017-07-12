package com.infy.exceptions;

public class InvalidFileFormatException extends Exception {
	public InvalidFileFormatException() {
		super("Uploaded File Format does not match the Template.Please download the template and enter the list of requirements.");

	}

}
