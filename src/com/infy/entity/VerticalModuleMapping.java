package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRMS_VerticalModuleMapping")
public class VerticalModuleMapping 
{
    @Id
	private String moduleId;
	private String verticalId;
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getVerticalId() {
		return verticalId;
	}
	public void setVerticalId(String verticalId) {
		this.verticalId = verticalId;
	}
	

}
