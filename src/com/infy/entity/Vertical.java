package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRMS_Vertical")
public class Vertical 
{
	@Id
	private String verticalId;
	private String verticalName;
	private String solutionId;
	
	public String getVerticalId() {
		return verticalId;
	}
	public void setVerticalId(String verticalId) {
		this.verticalId = verticalId;
	}
	public String getVerticalName() {
		return verticalName;
	}
	public void setVerticalName(String verticalName) {
		this.verticalName = verticalName;
	}
	public String getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	} 
	
	
}
