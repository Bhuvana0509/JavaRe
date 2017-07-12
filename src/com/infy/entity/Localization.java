package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRMS_Localization")
public class Localization 
{
	@Id
	private String localizationId;
	private String localizationName;
	public String getLocalizationId() {
		return localizationId;
	}
	public void setLocalizationId(String localizationId) {
		this.localizationId = localizationId;
	}
	public String getLocalizationName() {
		return localizationName;
	}
	public void setLocalizationName(String localizationName) {
		this.localizationName = localizationName;
	}
		
	
}
