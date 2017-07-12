package com.infy.TOclasses;

import java.util.ArrayList;
import java.util.List;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

public class ModuleDropDownTO 
{
	public String moduleId;
	public List<SelectItem> moduleList;
	
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public List<SelectItem> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<SelectItem> moduleList) {
		this.moduleList = moduleList;
	}
	
	public ModuleDropDownTO() 
	{
		moduleList = new ArrayList<SelectItem>();
		moduleId = "0";
	}
}
