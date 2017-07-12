package com.infy.managedBeans;

import java.io.File;
import java.io.FileInputStream;
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

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;

import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.apache.poi.ss.formula.functions.Count;

import com.infy.TOclasses.GroupDetailsAttachmentTO;
import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.MasterRequirementAttachmentTO;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoSourceAvailableException;
import com.infy.wrapper.FRMS_Wrapper;

public class ViewUpdateGroupDetailsMB 
{
	private String groupId;
	private String initatingGroupId;
	private String sourceId;
	private String locationId;
	/*private String groupName;
	private String groupDescription;
	private String SPOC;
	private String comment;
	private String customer_prospect;*/
	
	/*private String initiatingGroupName;
	private String sourceName;
	private String locationName;*/
	private List<SelectItem> locationList;
	private List<SelectItem> groupNameList;
	private List<GroupDetailsAttachmentTO> attachmentTOList;
	private HtmlDataTable attachmentHtmlDataTable;
	private String message;
	 
	private Integer flag;
	private GroupInfoTO groupInfoTO;
	private GroupInfoTO updateGroupInfoTO;
	
	private List<SelectItem> initatingGroupList;
	private List<SelectItem> sourceList;
	private UploadedFile uploadFile1;
	private UploadedFile uploadFile2;
	private UploadedFile uploadFile3;
	
	
	
	public HtmlDataTable getAttachmentHtmlDataTable() {
		return attachmentHtmlDataTable;
	}
	public void setAttachmentHtmlDataTable(HtmlDataTable attachmentHtmlDataTable) {
		this.attachmentHtmlDataTable = attachmentHtmlDataTable;
	}
	public List<GroupDetailsAttachmentTO> getAttachmentTOList() {
		return attachmentTOList;
	}
	public void setAttachmentTOList(List<GroupDetailsAttachmentTO> attachmentTOList) {
		this.attachmentTOList = attachmentTOList;
	}
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
	public GroupInfoTO getUpdateGroupInfoTO() {
		return updateGroupInfoTO;
	}
	public void setUpdateGroupInfoTO(GroupInfoTO updateGroupInfoTO) {
		this.updateGroupInfoTO = updateGroupInfoTO;
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


	
	public GroupInfoTO getGroupInfoTO() {
		return groupInfoTO;
	}
	public void setGroupInfoTO(GroupInfoTO groupInfoTO) {
		this.groupInfoTO = groupInfoTO;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	/*public String getGroupName() {
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
	}*/
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
	/*public String getInitiatingGroupName() {
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
	}*/
	public List<SelectItem> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<SelectItem> locationList) {
		this.locationList = locationList;
	}
	public List<SelectItem> getGroupNameList() {
		return groupNameList;
	}
	public void setGroupNameList(List<SelectItem> groupNameList) {
		this.groupNameList = groupNameList;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//constructor
	public ViewUpdateGroupDetailsMB()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		locationList = new ArrayList<SelectItem>();
		this.attachmentTOList=new ArrayList<GroupDetailsAttachmentTO>();
		//Map<String,String> locationMap = new TreeMap<String, String>();
		TreeMap<String,String> locationMap = new TreeMap<String, String>();
		try 
		{
						
			/*locationMap = wrapper.getAllLocations();
			for (Map.Entry<String,String> entry: locationMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				
				 
			}*/
			
			locationMap = (TreeMap<String, String>) wrapper.getAllLocations();
			HashMap<String,String> locationHashMap = new HashMap<String, String>();
			locationHashMap = sortHashMap(locationMap);
			
			for (Map.Entry<String,String> entry: locationHashMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
		
		} 
		catch (NoSourceAvailableException e) 
		{
			this.setMessage(e.getMessage());
		} 
		catch (Exception e)
		{
			this.setMessage(e.getMessage());
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
	
	//view Groups Of Selected Location
	public void viewGroupsOfSelectedLocation(ValueChangeEvent event)
	{
		this.setFlag(0);
		this.message=null;
		this.groupNameList=null;
		this.groupId=null;
		this.groupInfoTO=null;
		String obj= (String) event.getNewValue();
		if(!obj.equals("0"))
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();
			//Map<String,String> groupMap = new TreeMap<String, String>();
			TreeMap<String,String> groupMap = new TreeMap<String, String>();
			groupNameList = new ArrayList<SelectItem>();

			try 
			{
				/*groupMap=wrapper.getGroupNamesByGeography(obj);
				for (Map.Entry<String,String> entry: groupMap.entrySet())
				{
					groupNameList.add(new SelectItem( entry.getKey(),entry.getValue() ) );

				}*/
				
				groupMap = (TreeMap<String, String>) wrapper.getGroupNamesByGeography(obj);
				HashMap<String,String> groupHashMap = new HashMap<String, String>();
				groupHashMap = sortHashMap(groupMap);
				
				for (Map.Entry<String,String> entry: groupHashMap.entrySet())
				{
					groupNameList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
			    }

			} 
			catch (NoGroupsAvailableException e)
			{
				this.setMessage(e.getMessage());

			} 
			catch (Exception e) 
			{
				this.setMessage(e.getMessage());

			}
		}
	}
	
	//group Selected By User
	public void groupSelectedByUser(ValueChangeEvent event)
	{
		
		
		
		
	}
	
	// view Group Detail
	public void viewGroupDetail(ValueChangeEvent event)
	{
		
		this.setGroupId((String) event.getNewValue());
		this.attachmentTOList=new ArrayList<GroupDetailsAttachmentTO>();
		this.groupInfoTO=null;
		if(!this.groupId.equals("0"))
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();

			try
			{
				this.groupInfoTO=wrapper.getGroupDetailsById(this.groupId);
				this.initatingGroupId=this.groupInfoTO.getInitatingGroupId();
				
				this.sourceId=this.groupInfoTO.getSourceId();
				this.attachmentTOList=wrapper.getAttachmentsByGroupId(this.groupId);
				/*this.setComment(groupInfo.getComment());
			this.setCustomer_prospect(groupInfo.getCustomer_prospect());
			this.setGroupDescription(groupInfo.getDescription());
			this.setGroupName(groupInfo.getGroupName());
			this.setInitatingGroupId(groupInfo.getInitatingGroupId());
			this.setLocationId(groupInfo.getLocationId());
			this.setSourceId(groupInfo.getSourceId());
			this.setSPOC(groupInfo.getSPOC());
			this.setInitiatingGroupName(groupInfo.getInitiatingGroupName());
			this.setSourceName(groupInfo.getSourceName());
			this.setLocationName(groupInfo.getLocationName());*/
				
			} 
			catch (NoGroupsAvailableException e) 
			{
				this.setMessage(e.getMessage());
				
			} 
			catch (Exception e) 
			{
				this.setMessage(e.getMessage());
				
			}
		}
		
	}
	// update Group
	public String updateGroup()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
				
		this.attachmentTOList=new ArrayList<GroupDetailsAttachmentTO>();
		updateGroupInfoTO.setInitatingGroupId(this.getInitatingGroupId());
		updateGroupInfoTO.setSourceId(this.getSourceId());
		updateGroupInfoTO.setLocationId(this.getLocationId());
					
		try 
		{
			wrapper.updateGroup(this.updateGroupInfoTO);
			this.setMessage(this.groupInfoTO.getGroupName()+ " Group is successfully Updated "  );			
			groupInfoTO.setComment(updateGroupInfoTO.getComment());
			groupInfoTO.setCustomer_prospect(updateGroupInfoTO.getCustomer_prospect());
			groupInfoTO.setDescription(updateGroupInfoTO.getDescription());
			groupInfoTO.setGroupId(updateGroupInfoTO.getGroupId());
			groupInfoTO.setGroupName(updateGroupInfoTO.getGroupName());
			groupInfoTO.setInitatingGroupId(updateGroupInfoTO.getInitatingGroupId());
			groupInfoTO.setInitiatingGroupName(updateGroupInfoTO.getInitiatingGroupName());
			groupInfoTO.setLocationId(updateGroupInfoTO.getLocationId());
			groupInfoTO.setLocationName(updateGroupInfoTO.getLocationName());
			groupInfoTO.setOwnerEmployeeId(updateGroupInfoTO.getOwnerEmployeeId());
			groupInfoTO.setSourceId(updateGroupInfoTO.getSourceId());
			groupInfoTO.setSourceName(updateGroupInfoTO.getSourceName());
			groupInfoTO.setSPOC(updateGroupInfoTO.getSPOC());
			
			 
			GroupDetailsAttachmentTO groupDetailsAttachmentTO=new GroupDetailsAttachmentTO();
			groupDetailsAttachmentTO.setGroupId(groupInfoTO.getGroupId());
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
				groupDetailsAttachmentTO.setGroupId(groupInfoTO.getGroupId());
				groupDetailsAttachmentTO=wrapper.uploadGroupAttachment(groupDetailsAttachmentTO);
				String fileName= filePath+groupDetailsAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(uploadFile2.getBytes());
				outStream.close();
			}
			if(uploadFile3!=null)
			{
				
				groupDetailsAttachmentTO.setFileName(uploadFile3.getName());
				groupDetailsAttachmentTO.setGroupId(groupInfoTO.getGroupId());
				groupDetailsAttachmentTO=wrapper.uploadGroupAttachment(groupDetailsAttachmentTO);
				String fileName= filePath+groupDetailsAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(uploadFile3.getBytes());
				outStream.close();
			}
			try
			{
				this.attachmentTOList=wrapper.getAttachmentsByGroupId(this.groupInfoTO.getGroupId());
			}
			catch (Exception e) {
				
			} 
			
			return "success";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			this.setMessage(e.getMessage());
			return "failure";
		}
	}
	
	// call to edit group requirement
	
	public String editGroupDetails()
	{
		this.message=null;
		
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		sourceList = new ArrayList<SelectItem>();
		initatingGroupList = new ArrayList<SelectItem>();
		locationList = new ArrayList<SelectItem>();
		this.attachmentTOList=new ArrayList<GroupDetailsAttachmentTO>();
		
		Map<String,String> sourceMap = new TreeMap<String, String>();
		Map<String,String> initatingGroupMap = new TreeMap<String, String>();
		Map<String,String> locationMap = new TreeMap<String, String>();
		try 
		{
			sourceMap= wrapper.getAllSource();
			for (Map.Entry<String,String> entry: sourceMap.entrySet())
			{
				sourceList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				
				 
			}
			
			initatingGroupMap = wrapper.getAllInitiatingGroups();
			for (Map.Entry<String,String> entry: initatingGroupMap.entrySet())
			{
				initatingGroupList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				
				 
			}
			
			locationMap = wrapper.getAllLocations();
			for (Map.Entry<String,String> entry: locationMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				
				  
			}
			this.updateGroupInfoTO=new GroupInfoTO();
			updateGroupInfoTO.setComment(groupInfoTO.getComment());
			updateGroupInfoTO.setCustomer_prospect(groupInfoTO.getCustomer_prospect());
			updateGroupInfoTO.setDescription(groupInfoTO.getDescription());
			updateGroupInfoTO.setGroupId(groupInfoTO.getGroupId());
			updateGroupInfoTO.setGroupName(groupInfoTO.getGroupName());
			updateGroupInfoTO.setInitatingGroupId(groupInfoTO.getInitatingGroupId());
			updateGroupInfoTO.setInitiatingGroupName(groupInfoTO.getInitiatingGroupName());
			updateGroupInfoTO.setLocationId(groupInfoTO.getLocationId());
			updateGroupInfoTO.setLocationName(groupInfoTO.getLocationName());
			updateGroupInfoTO.setOwnerEmployeeId(groupInfoTO.getOwnerEmployeeId());
			updateGroupInfoTO.setSourceId(groupInfoTO.getSourceId());
			updateGroupInfoTO.setSourceName(groupInfoTO.getSourceName());
			updateGroupInfoTO.setSPOC(groupInfoTO.getSPOC());
			
			
			
			
			return "edit";
		
		} 
		catch (NoSourceAvailableException e) 
		{
			this.setMessage(e.getMessage());
			return "fail";
		} 
		catch (Exception e)
		{
			this.setMessage(e.getMessage());
			return "fail";
		}
	}
	public String downloadAttachment()
	{
		try
		{
			GroupDetailsAttachmentTO attachmentTO=(GroupDetailsAttachmentTO)attachmentHtmlDataTable.getRowData();
			String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("Group-Attachment");
			String fileName= filePath+attachmentTO.getFileName();
			 
			FileInputStream fileInputStream = new FileInputStream(fileName);

			byte[] byteArray=new byte[20000000];
			int i=fileInputStream.read(byteArray);
			
			// Prepare response to show a Save As dialogue with Excel report.   
			FacesContext facesContext = FacesContext.getCurrentInstance();  
			ExternalContext externalContext = facesContext.getExternalContext();   

			HttpServletResponse response=(HttpServletResponse)externalContext.getResponse();
			response.setContentType("application/download");    
			response.setHeader("Content-Disposition", "attachment; filename=\"" + attachmentTO.getFileName() + "\""); 
			// Write Excel report to response body.     
			//bidsReport.write(response.getOutputStream());    
			response.getOutputStream().write(byteArray,0,i);
			// Inform JSF that response is completed and it thus doesn't have to navigate.  
			facesContext.responseComplete(); 
			return "success";
		}
		catch(Exception e)
		{
			this.message=e.getMessage();
			
			return "fail";
		}
		
	}
	
	public String removeGroupAttachment()
	{
		try
		{
			this.attachmentTOList=new ArrayList<GroupDetailsAttachmentTO>();
			GroupDetailsAttachmentTO attachmentTO=(GroupDetailsAttachmentTO)attachmentHtmlDataTable.getRowData();
			String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("Group-Attachment");
			String fileName= filePath+attachmentTO.getFileName();
			FRMS_Wrapper wrapper=new FRMS_Wrapper();
			int count=wrapper.removeGroupAttachmentById(attachmentTO.getGroupAttachmentId());
			File file=new File(fileName);
			file.delete();
			
			try
			{
				this.attachmentTOList=wrapper.getAttachmentsByGroupId(attachmentTO.getGroupId());
			}
			catch (Exception e) {
				 
			}
			return "deleted";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			this.message=e.getMessage();
			
			return "fail";
		}
		
	}


}
