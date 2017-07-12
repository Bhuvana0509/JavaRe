package com.infy.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.infy.TOclasses.GroupInfoTO;
import com.infy.exceptions.GroupNameNotAvailableException;
import com.infy.wrapper.FRMS_Wrapper;


public class GroupNameValidator implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
		throws ValidatorException {
		// TODO Auto-generated method stub
		String groupName=(String)arg2;
		if(groupName.equals(""))
		{
			FacesMessage facesMessage=new FacesMessage("Please Enter GroupName","Please Enter GroupName");
			facesMessage.setDetail("Please Enter GroupName");
			facesMessage.setSummary("Please Enter GroupName");
			throw new ValidatorException(facesMessage);
		}
		try
		{
			GroupInfoTO groupInfoTO=new FRMS_Wrapper().getGroupByName(groupName);
			FacesMessage  message=new FacesMessage("GroupName Already Exist","GroupName Already Exist");
			message.setDetail("GroupName Already Exist");
			message.setSummary("GroupName Already Exist");
			throw new ValidatorException(message);
		}
		catch(ValidatorException e)
		{
			throw e;
		}
		catch(GroupNameNotAvailableException e)
		{
			return;
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}
