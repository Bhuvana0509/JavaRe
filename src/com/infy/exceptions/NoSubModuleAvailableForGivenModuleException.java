package com.infy.exceptions;

public class NoSubModuleAvailableForGivenModuleException extends Exception 
{
	public NoSubModuleAvailableForGivenModuleException() 
	{
		super("No SubModule Available for given module");
	}
}
