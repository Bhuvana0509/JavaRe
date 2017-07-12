package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRMS_GroupDetailsAttachment")
public class GroupDetailsAttachment {
	@Id
	private String groupAttachmentId;
	private String groupId;
	private String fileName;
	
	public String getGroupAttachmentId() {
		return groupAttachmentId;
	}
	public void setGroupAttachmentId(String groupAttachmentId) {
		this.groupAttachmentId = groupAttachmentId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}
