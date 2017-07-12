package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRMS_ModuleSubModuleMapping")
public class ModuleSubModuleMapping 
{
    @Id
	private String subModuleId;
	private String moduleId;
	public String getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	

}
