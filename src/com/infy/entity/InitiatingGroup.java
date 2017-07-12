package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRMS_InitiatingGroup")
public class InitiatingGroup 
{
	@Id
	private String initiatingGroupId;
	private String initiatingGroupName;
	
	public String getInitiatingGroupId() {
		return initiatingGroupId;
	}
	public void setInitiatingGroupId(String initiatingGroupId) {
		this.initiatingGroupId = initiatingGroupId;
	}
	public String getInitiatingGroupName() {
		return initiatingGroupName;
	}
	public void setInitiatingGroupName(String initiatingGroupName) {
		this.initiatingGroupName = initiatingGroupName;
	}
	
}
