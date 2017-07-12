package com.infy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
@Table(name="FRMS_FRSData")
public class FRSData {
		@Id
		private String frsId;
		private String productRequirementId;
		private String fRSDocumentName;
		private String 	projectCode;

		private String 	frsOwnerEmailId;
		private String 	frsStatus;
		
		@Temporal(TemporalType.DATE)                
		private Date 	plannedDateForFRS;
		@Temporal(TemporalType.DATE)
		private Date 	actualDateForFRS;
		@Temporal(TemporalType.DATE)
		private Date 	groupReviewDateForFRS;
		private String remarks;
		private String 	checkedInTFS;
		public String getFrsId() {
			return frsId;
		}
		public void setFrsId(String frsId) {
			this.frsId = frsId;
		}
		public String getProductRequirementId() {
			return productRequirementId;
		}
		public void setProductRequirementId(String productRequirementId) {
			this.productRequirementId = productRequirementId;
		}
		public String getFRSDocumentName() {
			return fRSDocumentName;
		}
		public void setFRSDocumentName(String documentName) {
			fRSDocumentName = documentName;
		}
		public String getProjectCode() {
			return projectCode;
		}
		public void setProjectCode(String projectCode) {
			this.projectCode = projectCode;
		}
		public String getFrsOwnerEmailId() {
			return frsOwnerEmailId;
		}
		public void setFrsOwnerEmailId(String frsOwnerEmailId) {
			this.frsOwnerEmailId = frsOwnerEmailId;
		}
		public String getFrsStatus() {
			return frsStatus;
		}
		public void setFrsStatus(String frsStatus) {
			this.frsStatus = frsStatus;
		}
		public Date getPlannedDateForFRS() {
			return plannedDateForFRS;
		}
		public void setPlannedDateForFRS(Date plannedDateForFRS) {
			this.plannedDateForFRS = plannedDateForFRS;
		}
		public Date getActualDateForFRS() {
			return actualDateForFRS;
		}
		public void setActualDateForFRS(Date actualDateForFRS) {
			this.actualDateForFRS = actualDateForFRS;
		}
		
		public Date getGroupReviewDateForFRS() {
			return groupReviewDateForFRS;
		}
		public void setGroupReviewDateForFRS(Date groupReviewDateForFRS) {
			this.groupReviewDateForFRS = groupReviewDateForFRS;
		}
		 
		public String getCheckedInTFS() {
			return checkedInTFS;
		}
		public void setCheckedInTFS(String checkedInTFS) {
			this.checkedInTFS = checkedInTFS;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		
		
		

}
