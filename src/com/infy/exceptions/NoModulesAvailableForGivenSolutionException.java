package com.infy.exceptions;

@SuppressWarnings("serial")
public class NoModulesAvailableForGivenSolutionException extends Exception
{

	public NoModulesAvailableForGivenSolutionException() 
	{
		super("No Modules Available for selected Solution ");
		
	}
}
