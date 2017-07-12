package com.infy.TOclasses;

import java.util.Date;

public class MasterRequirementTO 
{
	
	private String masterRequirementId;
	private String masterRequirementTitle;
	private String externalReferenceNumber;
	private String groupId;
	private String moduleId;
	//changes done by sanket mehta
	private String subModuleId;
	private String subModuleName;
	//changes completed
	private String solutionId;
	private String description;
	private String contactPerson;
	private String status;
	private String ownerEmployeeId;
	private String groupName;
	private String moduleName;
	private String solutionName;
	private String comments;
	private String attachmentStatus;
	
	// Changes made by Bhuvana starts	
	private String customization;
	private String locationId;
	private String locationName;
	private String initiatingGroupName;
	private Date mrDate;
	private String verticalId;
	private String verticalName;
	
	private String empId;
	private String emailId;
	private String productManager;
	
	
	public String getProductManager() {
		return productManager;
	}
	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	private String searchMRByTitle;	
	
	public String getSearchMRByTitle() {
		return searchMRByTitle;
	}
	public void setSearchMRByTitle(String searchMRByTitle) {
		this.searchMRByTitle = searchMRByTitle;
	}
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
	public Date getMrDate() {
		return mrDate;
	}
	public void setMrDate(Date mrDate) {
		this.mrDate = mrDate;
	}
	public String getInitiatingGroupName() {
		return initiatingGroupName;
	}
	public void setInitiatingGroupName(String initiatingGroupName) {
		this.initiatingGroupName = initiatingGroupName;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getCustomization() {
		return customization;
	}
	public void setCustomization(String customization) {
		this.customization = customization;
	}
	// Changes made by Bhuvana ends
	
	public String getAttachmentStatus() {
		return attachmentStatus;
	}
	public void setAttachmentStatus(String attachmentStatus) {
		this.attachmentStatus = attachmentStatus;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	//changes done by sanket mehta 
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
	//changes completed
	public String getSolutionName() {
		return solutionName;
	}
	public void setSolutionName(String solutionName) {
		this.solutionName = solutionName;
	}
	public String getMasterRequirementId() {
		return masterRequirementId;
	}
	public void setMasterRequirementId(String masterRequirementId) {
		this.masterRequirementId = masterRequirementId;
	}
	public String getMasterRequirementTitle() {
		return masterRequirementTitle;
	}
	public void setMasterRequirementTitle(String masterRequirementTitle) {
		this.masterRequirementTitle = masterRequirementTitle;
	}
	public String getExternalReferenceNumber() {
		return externalReferenceNumber;
	}
	public void setExternalReferenceNumber(String externalReferenceNumber) {
		this.externalReferenceNumber = externalReferenceNumber;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOwnerEmployeeId() {
		return ownerEmployeeId;
	}
	public void setOwnerEmployeeId(String ownerEmployeeId) {
		this.ownerEmployeeId = ownerEmployeeId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
