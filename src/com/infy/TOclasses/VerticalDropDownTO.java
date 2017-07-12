package com.infy.TOclasses;

import java.util.ArrayList;
import java.util.List;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

public class VerticalDropDownTO 
{
	public String verticalId;
	public List<SelectItem> verticalList;
	
	
	
	public String getVerticalId() {
		return verticalId;
	}
    public void setVerticalId(String verticalId) {
		this.verticalId = verticalId;
	}

	public List<SelectItem> getVerticalList() {
		return verticalList;
	}

	public void setVerticalList(List<SelectItem> verticalList) {
		this.verticalList = verticalList;
	}
	public VerticalDropDownTO() 
	{
		verticalList = new ArrayList<SelectItem>();
		verticalId = "0";
	}
}
