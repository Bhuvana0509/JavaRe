package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRMS_ModuleAnchor")
public class ModuleAnchor 
{
	@Id
	private String moduleId;
	private String moduleName;
	private String anchorName;
	private String anchorEmployeeId;
	private String solutionId;
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
	public String getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	} 
	
	
}
