package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRMS_SubModule")
public class SubModule 
{
	@Id
	private String subModuleId;
	private String subModuleName;
	private String anchorName;
	private String anchorEmployeeId;
	public String getAnchorName() {
		return anchorName;
	}
	public void setAnchorName(String anchorName) {
		this.anchorName = anchorName;
	}
	public String getAnchorEmployeeId() {
		return anchorEmployeeId;
	}
	public void setAnchorEmployeeId(String anchorEmployeeId) {
		this.anchorEmployeeId = anchorEmployeeId;
	}
	public String getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}
	public String getSubModuleName() {
		return subModuleName;
	}
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	
	
}
