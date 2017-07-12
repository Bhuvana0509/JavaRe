package com.infy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FRMS_SRSData")
public class SRSData {
	@Id
	private String srsId;
	private String productRequirementId;
	private String sRSDocumentName;
	 
	private String srsOwnerEmailId;
	private String srsStatus;
                
	@Temporal(TemporalType.DATE)
	private Date plannedDateForSRS;
	
	@Temporal(TemporalType.DATE)
	private Date actualDateForSRS;
	
	@Temporal(TemporalType.DATE)
	private Date groupReviewDateForSRS;
	private String remarks;
	private String checkedInTFS;
	private String rAAnchor;
	public String getSrsId() {
		return srsId;
	}
	public void setSrsId(String srsId) {
		this.srsId = srsId;
	}
	public String getProductRequirementId() {
		return productRequirementId;
	}
	public void setProductRequirementId(String productRequirementId) {
		this.productRequirementId = productRequirementId;
	}
	public String getSRSDocumentName() {
		return sRSDocumentName;
	}
	public void setSRSDocumentName(String documentName) {
		sRSDocumentName = documentName;
	}
	public String getSrsOwnerEmailId() {
		return srsOwnerEmailId;
	}
	public void setSrsOwnerEmailId(String srsOwnerEmailId) {
		this.srsOwnerEmailId = srsOwnerEmailId;
	}
	public String getSrsStatus() {
		return srsStatus;
	}
	public void setSrsStatus(String srsStatus) {
		this.srsStatus = srsStatus;
	}
	public Date getPlannedDateForSRS() {
		return plannedDateForSRS;
	}
	public void setPlannedDateForSRS(Date plannedDateForSRS) {
		this.plannedDateForSRS = plannedDateForSRS;
	}
	public Date getActualDateForSRS() {
		return actualDateForSRS;
	}
	public void setActualDateForSRS(Date actualDateForSRS) {
		this.actualDateForSRS = actualDateForSRS;
	}
	public Date getGroupReviewDateForSRS() {
		return groupReviewDateForSRS;
	}
	public void setGroupReviewDateForSRS(Date groupReviewDateForSRS) {
		this.groupReviewDateForSRS = groupReviewDateForSRS;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCheckedInTFS() {
		return checkedInTFS;
	}
	public void setCheckedInTFS(String checkedInTFS) {
		this.checkedInTFS = checkedInTFS;
	}
	public String getRAAnchor() {
		return rAAnchor;
	}
	public void setRAAnchor(String anchor) {
		rAAnchor = anchor;
	}

	
}
