package com.infy.TOclasses;

import org.apache.myfaces.custom.fileupload.UploadedFile;


public class MasterRequirementAttachmentTO {
	private  String MRAttachmentId ;
	private String MasterRequirementId;
	private String FileName;
	private UploadedFile uploadedFile;
	
	
	
	public String getMRAttachmentId() {
		return MRAttachmentId;
	}
	public void setMRAttachmentId(String attachmentId) {
		MRAttachmentId = attachmentId;
	}
	public String getMasterRequirementId() {
		return MasterRequirementId;
	}
	public void setMasterRequirementId(String masterRequirementId) {
		MasterRequirementId = masterRequirementId;
	}
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
 
}
