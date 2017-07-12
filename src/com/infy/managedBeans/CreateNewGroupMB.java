package com.infy.managedBeans;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import com.infy.TOclasses.GroupDetailsAttachmentTO;
import com.infy.TOclasses.GroupInfoTO;
import com.infy.exceptions.NoSourceAvailableException;
import com.infy.wrapper.FRMS_Wrapper;

public class CreateNewGroupMB 
{
	
	private String groupId;
	private String groupName;
	private String groupDescription;
	private String SPOC;
	private String comment;
	private String customer_prospect;
	private String initatingGroupId;
	private String sourceId;
	private String locationId;
	private List<SelectItem> initatingGroupList;
	private List<SelectItem> sourceList;
	private List<SelectItem> locationList;
	private String successMessage;
	private String failureMessage;
	
	private String initiatingGroupName;
	private String sourceName;
	private String locationName;
	private UploadedFile uploadFile1;
	private UploadedFile uploadFile2;
	private UploadedFile uploadFile3;
	
		
	

	
	public UploadedFile getUploadFile1() {
		return uploadFile1;
	}
	public void setUploadFile1(UploadedFile uploadFile1) {
		this.uploadFile1 = uploadFile1;
	}
	public UploadedFile getUploadFile2() {
		return uploadFile2;
	}
	public void setUploadFile2(UploadedFile uploadFile2) {
		this.uploadFile2 = uploadFile2;
	}
	public UploadedFile getUploadFile3() {
		return uploadFile3;
	}
	public void setUploadFile3(UploadedFile uploadFile3) {
		this.uploadFile3 = uploadFile3;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
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
	public String getCustomer_prospect() {
		return customer_prospect;
	}
	public void setCustomer_prospect(String customer_prospect) {
		this.customer_prospect = customer_prospect;
	}
	public String getInitatingGroupId() {
		return initatingGroupId;
	}
	public void setInitatingGroupId(String initatingGroupId) {
		this.initatingGroupId = initatingGroupId;
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
	public List<SelectItem> getInitatingGroupList() {
		return initatingGroupList;
	}
	public void setInitatingGroupList(List<SelectItem> initatingGroupList) {
		this.initatingGroupList = initatingGroupList;
	}
	public List<SelectItem> getSourceList() {
		return sourceList;
	}
	public void setSourceList(List<SelectItem> sourceList) {
		this.sourceList = sourceList;
	}
	public List<SelectItem> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<SelectItem> locationList) {
		this.locationList = locationList;
	}
	
	
	
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
	public CreateNewGroupMB() 
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		sourceList = new ArrayList<SelectItem>();
		initatingGroupList = new ArrayList<SelectItem>();
		locationList = new ArrayList<SelectItem>();
		
	
		TreeMap<String,String> sourceMap = new TreeMap<String, String>();
		TreeMap<String,String> initatingGroupMap = new TreeMap<String, String>();
		//Map<String,String> locationMap = new TreeMap<String, String>();
		TreeMap<String,String> locationMap = new TreeMap<String, String>();
		try 
		{
			/*sourceMap= wrapper.getAllSource();
			for (Map.Entry<String,String> entry: sourceMap.entrySet())
			{
				sourceList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				
				 
			}*/		
			
			sourceMap = (TreeMap<String, String>) wrapper.getAllSource();
			HashMap<String,String> sourceHashMap = new HashMap<String, String>();
			if(sourceMap!=null)
			sourceHashMap = sortHashMap(sourceMap);
			
			for (Map.Entry<String,String> entry: sourceHashMap.entrySet())
			{
				sourceList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			/*initatingGroupMap = wrapper.getAllInitiatingGroups();
			for (Map.Entry<String,String> entry: initatingGroupMap.entrySet())
			{
				initatingGroupList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				
				 
			}*/
			
			initatingGroupMap = (TreeMap<String, String>) wrapper.getAllInitiatingGroups();
			HashMap<String,String> initiatingGroupHashMap = new HashMap<String, String>();
			if(initatingGroupMap!=null)
			initiatingGroupHashMap = sortHashMap(initatingGroupMap);	
			for (Map.Entry<String,String> entry: initiatingGroupHashMap.entrySet())
			{
				initatingGroupList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }	
			
			/*locationMap = wrapper.getAllLocations();
			for (Map.Entry<String,String> entry: locationMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				
				  
			}*/
			
			locationMap = (TreeMap<String, String>) wrapper.getAllLocations();
			HashMap<String,String> locationHashMap = new HashMap<String, String>();
			if(locationMap!=null)
			locationHashMap = sortHashMap(locationMap);
			
			for (Map.Entry<String,String> entry: locationHashMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
		
		} 
		catch (NoSourceAvailableException e) 
		{
			this.setFailureMessage(e.getMessage());
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			this.setFailureMessage(e.getMessage());
		}
	}
	
	///Sorting Map///////
		private HashMap<String, String> sortHashMap(TreeMap<String, String> input){
		    Map<String, String> tempMap = new HashMap<String, String>();
		    for (String wsState : input.keySet()){
		    	tempMap.put(wsState,input.get(wsState));
		    }

		    List<String> mapKeys = new ArrayList<String>(tempMap.keySet());
		    List<String> mapValues = new ArrayList<String>(tempMap.values());
		    HashMap<String, String> sortedMap = new LinkedHashMap<String, String>();
		    TreeSet<String> sortedSet =new TreeSet<String>();
		    for(int i=0; i<mapValues.size();i++)
		    {
		    	//System.out.println("$$$$$$$$$$"+i+"==="+mapValues.get(i)+"keysss"+mapKeys.get(i));
		    	//System.out.println("keyssss"+mapKeys.get(mapValues.indexOf(mapValues.get(i))));
		    }
		    Collections.sort(mapValues);
		    for (int i=0; i<mapValues.size(); i++){
		    	//System.out.println("key*******"+getKeyByValue(tempMap,(String)mapValues.get(i))+"value*********"+(String)mapValues.get(i));
		        sortedMap.put(getKeyByValue(tempMap,(String)mapValues.get(i)), 
		                      (String)mapValues.get(i));
		    }
		    return sortedMap;
		}

		public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
		    for (Entry<T, E> entry : map.entrySet()) {
		        if (value.equals(entry.getValue())) {
		            return entry.getKey();
		        }
		    }
		    return null;
		}
		/////////////////////
	
		
	public String addGroup()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		 
		
		GroupInfoTO toObj = new GroupInfoTO();
		toObj.setGroupName(this.getGroupName());
		toObj.setDescription(this.getGroupDescription());
		toObj.setComment(this.getComment());
		toObj.setCustomer_prospect(this.getCustomer_prospect());
		toObj.setSPOC(this.getSPOC());
		toObj.setInitatingGroupId(this.getInitatingGroupId());
		toObj.setSourceId(this.getSourceId());
		toObj.setLocationId(this.getLocationId());
		String ownerEmpId=(String)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("EmployeeId");
		
		toObj.setOwnerEmployeeId(ownerEmpId);		
		
		
		try 
		{
			toObj= wrapper.addGroup(toObj);
			this.locationName=toObj.getLocationName();
			this.sourceName=toObj.getSourceName();
			this.initiatingGroupName=toObj.getInitiatingGroupName();
			this.groupId=toObj.getGroupId();
			GroupDetailsAttachmentTO groupDetailsAttachmentTO=new GroupDetailsAttachmentTO();
			groupDetailsAttachmentTO.setGroupId(groupId);
			String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("Group-Attachment");
			if(uploadFile1!=null)
			{
				
				groupDetailsAttachmentTO.setFileName(uploadFile1.getName());
				groupDetailsAttachmentTO=wrapper.uploadGroupAttachment(groupDetailsAttachmentTO);
				
				String fileName= filePath+groupDetailsAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(uploadFile1.getBytes());
				outStream.close();
			}
			if(uploadFile2!=null)
			{
				
				groupDetailsAttachmentTO.setFileName(uploadFile2.getName());
				groupDetailsAttachmentTO.setGroupId(groupId);
				groupDetailsAttachmentTO=wrapper.uploadGroupAttachment(groupDetailsAttachmentTO);
				String fileName= filePath+groupDetailsAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(uploadFile2.getBytes());
				outStream.close();
			}
			if(uploadFile3!=null)
			{
				
				groupDetailsAttachmentTO.setFileName(uploadFile3.getName());
				groupDetailsAttachmentTO.setGroupId(groupId);
				groupDetailsAttachmentTO=wrapper.uploadGroupAttachment(groupDetailsAttachmentTO);
				String fileName= filePath+groupDetailsAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(uploadFile3.getBytes());
				outStream.close();
			}
			
			
			this.setSuccessMessage("Group is successfully registered with group Id: " + this.groupId );
			return "success";
		} 
		catch (Exception e) 
		{
			this.setFailureMessage(e.getMessage());
			return "failure";
		}
	}
	
	public String reset()
	{ 
		CreateNewGroupMB createNewGroupMB=new CreateNewGroupMB();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("createNewGroupMB", createNewGroupMB);
		
		return "reset";
	}
	
	
}
