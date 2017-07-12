package com.infy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FRMS_MasterRequirement")
public class MasterRequirement 
{
	@Id
	private String masterRequirementId;	
	private String masterRequirementTitle;
	private String externalReferenceNumber;
	private String groupId;
	private String moduleId;
	private String verticalId;
	public String getVerticalId() {
		return verticalId;
	}
	public void setVerticalId(String verticalId) {
		this.verticalId = verticalId;
	}
	//changes done by sanket mehta
	//private String subModuleId;
	
	//changes completed
	private String solutionId;
	@Column(name="requirementDescription")
	private String description;
	private String contactPerson;
	private String status;
	private String ownerEmployeeId;	
	private String comments;
	
	@Column(name="ModuleAnchor")
	private String productManager;
	
	
	public String getProductManager() {
		return productManager;
	}
	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}

	// New requirement added by Bhuvana
	private String customization;		
	@Temporal(TemporalType.DATE)
	private Date MRDate;
	
	
	public Date getMRDate() {
		return MRDate;
	}
	public void setMRDate(Date mRDate) {
		MRDate = mRDate;
	}
	public String getCustomization() {
		return customization;
	}
	public void setCustomization(String customization) {
		this.customization = customization;
	}
	public String getMasterRequirementTitle() {
		return masterRequirementTitle;
	}
	public void setMasterRequirementTitle(String masterRequirementTitle) {
		this.masterRequirementTitle = masterRequirementTitle;
	}
	public String getMasterRequirementId() {
		return masterRequirementId;
	}
	public void setMasterRequirementId(String masterRequirementId) {
		this.masterRequirementId = masterRequirementId;
	}
	public String getTmasterRequirementTitleitle() {
		return masterRequirementTitle;
	}
	public void masterRequirementTitle(String masterRequirementTitle) {
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
	/*//changes done by sanket mehta
	public String getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}
	//changes completed
*/	public String getSolutionId() {
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
