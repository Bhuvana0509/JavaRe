package com.infy.TOclasses;
//changes done by sanket mehta
public class SubModuleTO 
{
	
	private String subModuleId;
	private String subModuleName;
		
	//changes done by Bhuvana starts
	private String anchorName;
	private String anchorEmployeeId;
	//changes completed
	
	public String getSubModuleId() {
		return subModuleId;
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
//changes completed
