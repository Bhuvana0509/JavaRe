package com.infy.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.infy.TOclasses.LoginTO;
import com.infy.entity.Login;
import com.infy.exceptions.IncorrectPasswordException;
import com.infy.exceptions.InvalidEmployeeIdException;
import com.infy.exceptions.UserDoesNotExistException;

public class LoginService {
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("FRMS");
	EntityManager em=null;
	public LoginTO  authenticate(LoginTO loginTo) throws InvalidEmployeeIdException,IncorrectPasswordException,Exception
	{
		
		em=emf.createEntityManager();
		try
		{
		Login loginEntity=(Login)em.find(Login.class,loginTo.getEmpId());
		if(loginEntity==null)
		{
			// thorw invaldi username exception
			throw new InvalidEmployeeIdException();
		}
		else if(!(loginTo.getPassword().equals(loginEntity.getPassword())))
		{
			// throw invalid password exception
			throw new IncorrectPasswordException();
		}
		else
		{
			loginTo.setEmpName(loginEntity.getEmpName());
			loginTo.setRole(loginEntity.getRole());
			loginTo.setDescription(loginEntity.getDescription());
			loginTo.setEmailId(loginEntity.getEmailId());
			return loginTo;

		}
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
		finally
		{
			if(em!=null)
				em.close();
		}
		
	}
	
	public boolean changePassword(LoginTO loginTO) throws InvalidEmployeeIdException, Exception
	{
		em=emf.createEntityManager();
		try
		{
			em.getTransaction().begin();
			
			Login loginEntity=(Login)em.find(Login.class,loginTO.getEmpId());
			if(loginEntity==null)
			{
				// thorw invaldi username exception
				throw new InvalidEmployeeIdException();
			}
			else
			{
				loginEntity.setPassword((loginTO.getNewPassword()));
				em.getTransaction().commit();
				return true;
			}
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
		finally
		{
			if(em!=null)
				em.close();
		}
	}
	
	public boolean changeOthersPassword(LoginTO loginTO) throws InvalidEmployeeIdException,Exception
	{
		em=emf.createEntityManager();
		try
		{
			em.getTransaction().begin();
			 
			Login loginEntity=(Login)em.find(Login.class,loginTO.getEmpId());
			if(loginEntity==null)
			{
				// thorw invaldi username exception
				throw new InvalidEmployeeIdException();
			}
			else
			{
				loginEntity.setPassword((loginTO.getNewPassword()));
				em.getTransaction().commit();
				return true;
			}
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
		finally
		{
			if(em!=null)
				em.close();
		}
		
	}
	
	public LoginTO getEmployeeById(String empId) throws Exception, UserDoesNotExistException
	{
		em=emf.createEntityManager();
		LoginTO loginTO=null;
		try
		{
			Login loginEntity=(Login)em.find(Login.class,empId);
			if(loginEntity !=null)
			{
				loginTO=new LoginTO();
				loginTO.setEmpId(loginEntity.getEmpId());
				loginTO.setEmpName(loginEntity.getEmpName());
				loginTO.setRole(loginEntity.getRole());
				loginTO.setPassword(loginEntity.getPassword());
				loginTO.setDescription(loginEntity.getDescription());
				loginTO.setEmailId(loginEntity.getEmailId());
			}
			else
			{
				throw new UserDoesNotExistException();
			}
			return loginTO;
		}
		catch (UserDoesNotExistException e) {
			throw e;
		}
		catch (Exception e) {
			throw e;
		}
		finally
		{
			if(em!=null)
			{
				em.close();
			}
		}
	}
	
	public LoginTO editEmployeeDetails(LoginTO loginTO) throws Exception
	{
		em=emf.createEntityManager();
		 
		try
		{
			
			    Login loginEntity= new Login();
					
				em.getTransaction().begin();
				loginEntity = (Login)em.find(Login.class, loginTO.getEmpId());
							
				loginEntity.setEmpName(loginTO.getEmpName());
				loginEntity.setEmailId(loginTO.getEmailId());
				if(loginTO.getRole().equals("Admin"))
					{
						loginEntity.setRole("A");
						loginEntity.setDescription("Admin");
					}
				else if(loginTO.getRole().equals("Product Manager"))
				{
						loginEntity.setRole("PM");
						loginEntity.setDescription("Product Manager");
				}
				else if(loginTO.getRole().equals("Product Team"))
				{
					loginEntity.setRole("PT");
					loginEntity.setDescription("Product Team");
				}
				else
				{
					loginEntity.setRole("GU");
					loginEntity.setDescription("General User");
				}
				em.merge(loginEntity);
				 
				
				em.getTransaction().commit();
				 
				loginTO.setDescription(loginEntity.getDescription());
				return loginTO;
			

		}
		catch (Exception e) {
	 
		
			throw e;
		}
		finally
		{
			if(em!=null)
			{
				em.close();
			}
		}
	}
	
	public LoginTO registerEmployee(LoginTO loginTO) throws Exception
	{
		em=emf.createEntityManager();
		 
		try
		{
			Login loginEntity=(Login)em.find(Login.class,loginTO.getEmpId());
			if(loginEntity !=null)
			{
				 
				return null;
				
			}
			else
			{
				 
				
				em.getTransaction().begin();
				loginEntity=new Login();
				loginEntity.setDescription(loginTO.getDescription());
				loginEntity.setEmpId(loginTO.getEmpId());
				loginEntity.setEmpName(loginTO.getEmpName());
				loginEntity.setPassword(loginTO.getPassword());
				loginEntity.setEmailId(loginTO.getEmailId());
				if(loginTO.getRole().equals("Admin"))
					loginEntity.setRole("A");
				else if(loginTO.getRole().equals("Admin"))
					loginEntity.setRole("A");
				else if(loginTO.getRole().equals("Product Manager"))
					loginEntity.setRole("PM");
				else if(loginTO.getRole().equals("Product Team"))
					loginEntity.setRole("PT");
				else
					loginEntity.setRole("GU");
				em.persist(loginEntity);
			
				
				em.getTransaction().commit();
				 
				
				return loginTO;
			}

		}
		catch (Exception e) {
		
			throw e;
		}
		finally
		{
			if(em!=null)
			{
				em.close();
			}
		}
	}

}
