package com.infy.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.ModuleAnchorTO;
import com.infy.exceptions.GroupNameNotAvailableException;
import com.infy.wrapper.FRMS_Wrapper;

public class EmailValidator implements Validator{
	
	public void validate(FacesContext facesContext, UIComponent uIComponent, Object object) throws ValidatorException {
		
		String email = (String) object; 
		String domain = null;
		String userId =null;
		
		
	if(email.length()>12){
		
		 domain = email.substring(email.length()-12, email.length());
		 userId = email.substring(0, email.length()-12);
	} else{
		
		FacesMessage facesMessage=new FacesMessage("Invalid email format","Invalid email format");
		
		facesMessage.setDetail("Invalid email format");
		facesMessage.setSummary("Invalid email format");
		
		throw new ValidatorException(facesMessage);
	}
		 
	char[] userIdArray = userId.toCharArray();
	int firstValueCheck = userIdArray[0];
	
	System.out.println("Domain"+domain);
	//System.out.println("first valuew "+firstValueCheck);
	//System.out.println("userId "+userId);
	
			if(!domain.equalsIgnoreCase("@infosys.com")){
			FacesMessage facesMessage=new FacesMessage("Invalid domain name","Invalid domain name");
			
			facesMessage.setDetail("Invalid domain name");
			facesMessage.setSummary("Invalid domain name");
			
			throw new ValidatorException(facesMessage);
			

		}else if( ((firstValueCheck>32 && firstValueCheck<64) || (firstValueCheck>91 && firstValueCheck<96) || (firstValueCheck>123 && firstValueCheck<126  )) ){
			
        FacesMessage facesMessage=new FacesMessage("Invalid email format","Invalid email format");
			
			facesMessage.setDetail("Invalid email format");
			facesMessage.setSummary("Invalid email format");
			
			throw new ValidatorException(facesMessage);
		}
		
		for (int i=1 ; i<userIdArray.length;i++){
			
			int value = userIdArray[i];
			//System.out.println("value  "+value);
			if((value>=32 && value <=47)||(value>=58 && value <=64) || (value>=91 && value<=94)||(value>=123 && value <=126) ){
				FacesMessage facesMessage=new FacesMessage("Invalid email format","Invalid email format");
				
				facesMessage.setDetail("Invalid email format");
				facesMessage.setSummary("Invalid email format");
				throw new ValidatorException(facesMessage);
			}
			
		}
		
	/*	
		if(!email.contains("@")) {
			FacesMessage facesMessage=new FacesMessage("Please Enter Valid EmailId","Please Enter Valid EmailId");
				
			facesMessage.setDetail("Please Enter Valid EmailId");
			facesMessage.setSummary("Please Enter Valid EmailId");
			
			throw new ValidatorException(facesMessage);

		}*/
		

	}

}
