package com.infy.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class SelectMenuValidator implements Validator
{

	public void validate(FacesContext faceContext, UIComponent component, Object object)
			throws ValidatorException 
	{
			
			if(!(component instanceof UIInput))
			{
				return;
			}
			String val=(String)object;
			if(val.equals("0")==true)
			{
				FacesMessage message=new FacesMessage();
				message.setSummary("Selection from the List is Mandatory!!");
				message.setDetail("Selection from the List is Mandatory!!");
				throw new ValidatorException(message);
			}
		
	}

}
