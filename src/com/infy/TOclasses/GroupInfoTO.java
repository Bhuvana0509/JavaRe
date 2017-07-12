package com.infy.TOclasses;

public class GroupInfoTO 
{
	private String groupId;
	private String groupName;
	private String description;
	private String initiatingGroupId;
	private String sourceId;
	private String locationId;
	private String customer_prospect;
	private String SPOC;
	private String comment;
	private String ownerEmployeeId;
	private String initiatingGroupName;
	private String sourceName;
	private String locationName;
	
	
	public String getInitiatingGroupName() {
		return initiatingGroupName;
	}
	public void setInitiatingGroupName(String initiatingGroupName) {
		this.initiatingGroupName = initiatingGroupName;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
	public String getInitatingGroupId() {
		return initiatingGroupId;
	}
	public void setInitatingGroupId(String initatingGroupId) {
		this.initiatingGroupId = initatingGroupId;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getOwnerEmployeeId() {
		return ownerEmployeeId;
	}
	public void setOwnerEmployeeId(String ownerEmployeeId) {
		this.ownerEmployeeId = ownerEmployeeId;
	}
	
}
