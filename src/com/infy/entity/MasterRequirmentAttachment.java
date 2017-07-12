package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="frms_MasterRequirementAttachments")
public class MasterRequirmentAttachment {
	@Id
	String mrAttachmentId ;
	String masterRequirementId ;
	String fileName ;
	 
	public String getMrAttachmentId() {
		return mrAttachmentId;
	}
	public void setMrAttachmentId(String mrAttachmentId) {
		this.mrAttachmentId = mrAttachmentId;
	}
	public String getMasterRequirementId() {
		return masterRequirementId;
	}
	public void setMasterRequirementId(String masterRequirementId) {
		this.masterRequirementId = masterRequirementId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	
	

}
