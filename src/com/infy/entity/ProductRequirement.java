package com.infy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FRMS_ProductRequirement")
public class ProductRequirement 
{
	@Id
	private String productRequirementId;
	private String masterRequirementId;
	private String productRequirementTitle;
	private String groupId;
	private String productVersion;
	private String productRequirementDescription;
	private String frsName;
	
	@Temporal(TemporalType.DATE)
	private Date frsClosureDate;
	
	private String srsName;
	
	@Temporal(TemporalType.DATE)
	private Date srsClosureDate;
	
	private String comments;
	private String approvedStatus;
	private String remark;
	private String localization;
	private String functionalEffort;
	private String developmentEffort;
	private String dgOwner;
	
	private String ownerEmployeeId;
	
	public String getOwnerEmployeeId() {
		return ownerEmployeeId;
	}
	public void setOwnerEmployeeId(String ownerEmployeeId) {
		this.ownerEmployeeId = ownerEmployeeId;
	}
	public String getProductRequirementId() {
		return productRequirementId;
	}
	public void setProductRequirementId(String productRequirementId) {
		this.productRequirementId = productRequirementId;
	}
	public String getMasterRequirementId() {
		return masterRequirementId;
	}
	public void setMasterRequirementId(String masterRequirementId) {
		this.masterRequirementId = masterRequirementId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getProductVersion() {
		return productVersion;
	}
	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}
	public String getProductRequirementDescription() {
		return productRequirementDescription;
	}
	public void setProductRequirementDescription(
			String productRequirementDescription) {
		this.productRequirementDescription = productRequirementDescription;
	}
	public String getFrsName() {
		return frsName;
	}
	public void setFrsName(String frsName) {
		this.frsName = frsName;
	}
	public Date getFrsClosureDate() {
		return frsClosureDate;
	}
	public void setFrsClosureDate(Date frsClosureDate) {
		this.frsClosureDate = frsClosureDate;
	}
	public String getSrsName() {
		return srsName;
	}
	public void setSrsName(String srsName) {
		this.srsName = srsName;
	}
	public Date getSrsClosureDate() {
		return srsClosureDate;
	}
	public void setSrsClosureDate(Date srsClosureDate) {
		this.srsClosureDate = srsClosureDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getApprovedStatus() {
		return approvedStatus;
	}
	public void setApprovedStatus(String approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	
	
	public String getProductRequirementTitle() {
		return productRequirementTitle;
	}
	public void setProductRequirementTitle(String productRequirementTitle) {
		this.productRequirementTitle = productRequirementTitle;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLocalization() {
		return localization;
	}
	public void setLocalization(String localization) {
		this.localization = localization;
	}
	public String getFunctionalEffort() {
		return functionalEffort;
	}
	public void setFunctionalEffort(String functionalEffort) {
		this.functionalEffort = functionalEffort;
	}
	public String getDevelopmentEffort() {
		return developmentEffort;
	}
	public void setDevelopmentEffort(String developmentEffort) {
		this.developmentEffort = developmentEffort;
	}
	public String getDgOwner() {
		return dgOwner;
	}
	public void setDgOwner(String dgOwner) {
		this.dgOwner = dgOwner;
	}
	
}
