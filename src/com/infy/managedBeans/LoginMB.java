package com.infy.managedBeans;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.infy.TOclasses.LoginTO;
import com.infy.exceptions.IncorrectPasswordException;
import com.infy.exceptions.InvalidEmployeeIdException;
import com.infy.wrapper.FRMS_Wrapper;

public class LoginMB {
	private String userId;
	private String password;
	private String message;
	private String empName;
	private FacesContext facesContext;
	private ExternalContext externalContext;
	private HttpSession session;
	private String newPassword;
	private String confirmPassowrd;
	private String emailId;
 
	private String role;
	private String linkName;
	
	
	
	
	public String getConfirmPassowrd() {
		return confirmPassowrd;
	}
	public void setConfirmPassowrd(String confirmPassowrd) {
		this.confirmPassowrd = confirmPassowrd;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public FacesContext getFacesContext() {
		return facesContext;
	}
	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}
	public ExternalContext getExternalContext() {
		return externalContext;
	}
	public void setExternalContext(ExternalContext externalContext) {
		this.externalContext = externalContext;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
		
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	 
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String authenticate()
	{
		LoginTO loginTO=new LoginTO();
		loginTO.setEmpId(this.userId);
		loginTO.setPassword(this.password);
		this.message=null;
		try
		{
			loginTO=new FRMS_Wrapper().authenticate(loginTO);
			this.empName=loginTO.getEmpName();
			
			facesContext=FacesContext.getCurrentInstance();
			externalContext=facesContext.getExternalContext();
			session=(HttpSession)externalContext.getSession(true);
			session.setAttribute("EmployeeId", loginTO.getEmpId());
			session.setAttribute("Role", loginTO.getRole());
			session.setAttribute("Name",loginTO.getEmpName());
			session.setAttribute("emailId",loginTO.getEmailId());
			this.emailId=loginTO.getEmailId();
			this.empName=loginTO.getEmpName();
			return "success";
			
		}
		catch (InvalidEmployeeIdException e) {
			// handle exception
			e.printStackTrace();
			this.message=e.getMessage();
			return "fail";
		}
		catch(IncorrectPasswordException e)
		{
			this.message=e.getMessage();
			return "fail";
		}
		catch(Exception e)
		{
			this.message="There is some problem with database connectivity, Please try again later!";
			return "fail";
		}
		
	}
	
	 
	
	 
	
	public String resetButton()
	{
		this.message=null;
		this.emailId=null;
		this.empName=null;
		this.role="0";
		this.userId=null;
		return "reset";
	}
}
