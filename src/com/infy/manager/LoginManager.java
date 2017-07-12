package com.infy.manager;

import com.infy.TOclasses.LoginTO;
import com.infy.entity.Login;
import com.infy.exceptions.EmployeeAlradyRegisteredException;
import com.infy.exceptions.IncorrectPasswordException;
import com.infy.exceptions.InvalidEmployeeIdException;
import com.infy.exceptions.InvalidOldPasswordException;
import com.infy.exceptions.SameOldAndNewPasswordException;
import com.infy.exceptions.UserDoesNotExistException;
import com.infy.service.LoginService;

public class LoginManager {
	public LoginTO  authenticate(LoginTO loginTo) throws InvalidEmployeeIdException,IncorrectPasswordException,Exception
	{
		try
		{
		LoginTO loginto=new LoginService().authenticate(loginTo);
		return loginto;
		}
		catch (InvalidEmployeeIdException e) {
			// handle exception
			throw e;
			
		}
		catch(IncorrectPasswordException e) {
			// handle exception
			throw e;
		}
		catch (Exception e) {
			// handle exception
			throw e;
		}
		
	
	}
	
	public boolean changePassword(LoginTO loginTO) throws InvalidEmployeeIdException,SameOldAndNewPasswordException,InvalidOldPasswordException, Exception
	{
		try
		{
			LoginTO loginto=new LoginService().getEmployeeById(loginTO.getEmpId());
			if(loginto==null)
			{
				throw new InvalidEmployeeIdException();
			}
			else if(!(loginto.getPassword().equals(loginTO.getPassword())))
			{
				throw new InvalidOldPasswordException();
			}
		
			if(loginTO.getPassword().equals(loginTO.getNewPassword()))
			{
				throw new SameOldAndNewPasswordException();
			}
			else
			{
				LoginService loginService=new LoginService();
				return loginService.changePassword(loginTO);

			}
		}
		catch (SameOldAndNewPasswordException e) {
			throw e;
		}
		catch (InvalidEmployeeIdException e)
		{
			// handle exception
			throw e;
			
		}
		catch(InvalidOldPasswordException e)
		{
			throw e;
		}
		catch (Exception e) {
			// handle exception
			throw e;
		}
	}
	
	public boolean changeOthersPassword(LoginTO loginTO) throws InvalidEmployeeIdException,SameOldAndNewPasswordException, Exception
	{
		try
		{
			LoginTO loginto=new LoginService().getEmployeeById(loginTO.getEmpId());
			if(loginto==null)
			{
				throw new InvalidEmployeeIdException();
			}
		
			if(loginto.getPassword().equals(loginTO.getNewPassword()))
			{
				throw new SameOldAndNewPasswordException();
			}
			else
			{
				LoginService loginService=new LoginService();
				return loginService.changeOthersPassword(loginTO);

			}
		}
		catch (SameOldAndNewPasswordException e) {
			throw e;
		}
		catch (InvalidEmployeeIdException e)
		{
			// handle exception
			throw e;
			
		}
		catch (Exception e) {
			// handle exception
			throw e;
		}
	}
	
	public LoginTO registerEmployee(LoginTO loginTO) throws EmployeeAlradyRegisteredException,Exception
	{
		LoginTO loginTO2;
		try
		{
			loginTO2=new LoginService().registerEmployee(loginTO);
			if(loginTO2==null)
			{
				throw new EmployeeAlradyRegisteredException();
			}
			else 
			{
				return loginTO2;
			}
		}
		catch(EmployeeAlradyRegisteredException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public LoginTO getEmployeeById(String empId) throws Exception, UserDoesNotExistException
	{
		
		LoginTO loginTO=null;
		try
		{
			LoginService service = new LoginService();
			loginTO=service.getEmployeeById(empId);
			return loginTO;
		}
		catch (UserDoesNotExistException e) {
			throw e;
		}
		catch (Exception e) {
			throw e;
		}
		
	}
	
	
	public LoginTO editEmployeeDetails(LoginTO loginTO) throws Exception
	{
		LoginTO loginTo = new LoginTO();
		try
		{
			LoginService service = new LoginService();
			loginTo=service.editEmployeeDetails(loginTO);
			   
			return loginTo;
		}
		catch (Exception e) {
		
			throw e;
		}
		
	}
}
