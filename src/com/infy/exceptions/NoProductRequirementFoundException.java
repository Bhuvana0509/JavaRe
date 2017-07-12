package com.infy.exceptions;

@SuppressWarnings("serial")
public class NoProductRequirementFoundException extends Exception {

	public NoProductRequirementFoundException() {
		super("No Product Requirement Available");
	}

}
