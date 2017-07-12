package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRMS_GroupInfo")
public class GroupInfo
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String groupId;
	private String groupName;
	private String description;
	private String initiatingGroupId;
	private String sourceId;
	private String locationId;
	private String customer_prospect;
	private String SPOC;
	private String comments;
	private String ownerEmployeeId;
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getOwnerEmployeeId() {
		return ownerEmployeeId;
	}
	public void setOwnerEmployeeId(String ownerEmployeeId) {
		this.ownerEmployeeId = ownerEmployeeId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInitiatingGroupId() {
		return initiatingGroupId;
	}
	public void setInitatingGroupId(String initiatingGroupId) {
		this.initiatingGroupId = initiatingGroupId;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getCustomer_prospect() {
		return customer_prospect;
	}
	public void setCustomer_prospect(String customer_prospect) {
		this.customer_prospect = customer_prospect;
	}
	public String getSPOC() {
		return SPOC;
	}
	public void setSPOC(String spoc) {
		SPOC = spoc;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
		
	
}
