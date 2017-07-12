package com.infy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRMS_Module")
public class Module 
{
	@Id
	private String moduleId;
	private String moduleName;
	@Column(name="anchorEmailID")
	private String anchorName;
	private String anchorEmployeeId;
	private String solutionId;
	private String verticalId;
	
	public String getVerticalId() {
		return verticalId;
	}
	public void setVerticalId(String verticalId) {
		this.verticalId = verticalId;
	}
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
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	}
	
	
	
}
