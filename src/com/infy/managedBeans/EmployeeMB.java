package com.infy.managedBeans;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.infy.TOclasses.LoginTO;
import com.infy.exceptions.UserDoesNotExistException;
import com.infy.wrapper.FRMS_Wrapper;

public class EmployeeMB {
	private String employeeId;
	private String employeeName;
	private String emailId;
	private String password;
	private String newPassword;
	private String confirmPassowrd;
	private String role;
	private String message;
	private String roleDescription;
	private Integer flag=0;
	
	private FacesContext facesContext;
	private ExternalContext externalContext;
	private HttpSession session;
	
	
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassowrd() {
		return confirmPassowrd;
	}
	public void setConfirmPassowrd(String confirmPassowrd) {
		this.confirmPassowrd = confirmPassowrd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public String changePassword()
	{
		LoginTO loginTO=new LoginTO();
		loginTO.setPassword(this.password);
		loginTO.setNewPassword(this.newPassword);
		facesContext=FacesContext.getCurrentInstance();
		externalContext=facesContext.getExternalContext();
		session=(HttpSession)externalContext.getSession(true);
		this.employeeId=(String)this.session.getAttribute("EmployeeId");
		
		loginTO.setEmpId(this.employeeId);
		try
		{
			if(!(newPassword.equals(confirmPassowrd)))
			{
				this.message="New Password and Confirm password did not match";
				return "fail";
			}
			new FRMS_Wrapper().changePassword(loginTO);
			this.message="Password changed successfully";
			return "success";
		}
		/*catch(InvalidEmployeeIdException e)
		{
			this.message=e.getMessage();
		}
		catch(SameOldAndNewPasswordException e)
		{
			this.message=e.getMessage();
		}*/
		catch(Exception e )
		{
			this.message=e.getMessage();
			return "fail";
		}
		
	}
	public String changeOthersPassword()
	{
		LoginTO loginTO=new LoginTO();
		
		loginTO.setNewPassword(this.newPassword);
		
		loginTO.setEmpId(this.employeeId);
		try
		{
			
			if(!(newPassword.equals(confirmPassowrd)))
			{
			
				this.message="New Password and Confirm password does not match";
				return "fail";
			}
			
			new FRMS_Wrapper().changeOthersPassword(loginTO);
			
			this.message="Password changed successfully";
			return "success";
		}
		/*catch(InvalidEmployeeIdException e)
		{
			this.message=e.getMessage();
		}
		catch(SameOldAndNewPasswordException e)
		{
			this.message=e.getMessage();
		}*/
		catch(Exception e )
		{
			
			this.message=e.getMessage();
			return "fail";
		}
		
	}
	
	
	public String registerEmployee()
	{
		LoginTO loginTO=new LoginTO();
		loginTO.setDescription(this.role);
		loginTO.setEmpId(this.employeeId);
		loginTO.setEmpName(this.employeeName);
		loginTO.setEmailId(this.emailId+"@infosys.com");
		loginTO.setPassword("Infosys123");
		loginTO.setRole(this.role);
		try
		{
		@SuppressWarnings("unused")
		LoginTO loginTO2= new FRMS_Wrapper().registerEmployee(loginTO);
		this.message="Memebr, "+this.employeeName+" added successfully with default  password : Infosys123";
		return "success";
		}
		catch(Exception e)
		{
			this.message=e.getMessage();
			return "fail";
		}
		
	}
	
	public String resetButton()
	{
		/*this.message=null;
		this.emailId=null;
		this.employeeName=null;
		this.role="0";
		this.employeeId=null;*/
		EmployeeMB employeeMB=new EmployeeMB();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("employeeMB", employeeMB);
		return "reset";
	}
	
	public String viewEmployeeDetails()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		LoginTO loginTO=new LoginTO();
		this.setMessage(null);
		try 
		{
			loginTO=wrapper.getEmployeeById(this.employeeId);
			this.setEmployeeName(loginTO.getEmpName());
			this.setEmailId(loginTO.getEmailId());
			this.setRole(loginTO.getRole());
			this.setEmployeeId(loginTO.getEmpId());
			this.setRoleDescription(loginTO.getDescription());
			this.setFlag(1);
			return "view";
			
		} 
		catch (UserDoesNotExistException e)
		{
			this.setFlag(0);
			this.setMessage(e.getMessage());
			return "failure";
		} 
		catch (Exception e) 
		{
			this.setFlag(0);
			this.setMessage(e.getMessage());
			
			return "failure";
		}
		
	}
	
	public String saveEditedEmployeeDetails()
	{
		LoginTO loginTO=new LoginTO();
	//	loginTO.setDescription(this.roleDescription);
		loginTO.setEmpId(this.employeeId);
		loginTO.setEmpName(this.employeeName);
		loginTO.setEmailId(this.emailId);
		loginTO.setRole(this.role);
		this.setMessage(null);
		
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		try 
		{
			loginTO=wrapper.editEmployeeDetails(loginTO);
			this.roleDescription= loginTO.getDescription();
			this.setMessage("Employee details Updated Successfully !");
			return "success";
		} 
		catch (Exception e) 
		{
			this.setMessage(e.getMessage());
			return "failure";
		}
		
		
	}
	
	
	public String cancelEmployeeDetailChanges()
	{
		this.flag=0;
		this.role="0";
		return "cancelEmpDetails";
	}
	

}
