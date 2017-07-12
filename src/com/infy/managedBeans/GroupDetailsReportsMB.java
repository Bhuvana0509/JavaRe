package com.infy.managedBeans;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoLocationsAvailableException;
import com.infy.wrapper.FRMS_Wrapper;

public class GroupDetailsReportsMB 
{
	
	private List<GroupInfoTO> groupList;
	private String groupMessage;
	private List<SelectItem> locationList;
	private String locationId;
	private boolean allGroupsDetailStatus;
	private HtmlSelectOneMenu locationSelectMenu;
	private HtmlSelectBooleanCheckbox allGroupDetailsCheckBox;
	private Integer pageNumber;
	private Integer rowsPerPage;
	private List<SelectItem> pageNumberList;
	private List<GroupInfoTO> viewGroupInfoPerPageList;
	private Integer displayPageNumber;
	private String pageMessage;
	
		
	public HtmlSelectOneMenu getLocationSelectMenu() {
		return locationSelectMenu;
	}
	public void setLocationSelectMenu(HtmlSelectOneMenu locationSelectMenu) {
		this.locationSelectMenu = locationSelectMenu;
	}
	public HtmlSelectBooleanCheckbox getAllGroupDetailsCheckBox() {
		return allGroupDetailsCheckBox;
	}
	public void setAllGroupDetailsCheckBox(
			HtmlSelectBooleanCheckbox allGroupDetailsCheckBox) {
		this.allGroupDetailsCheckBox = allGroupDetailsCheckBox;
	}
	public List<GroupInfoTO> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<GroupInfoTO> groupList) {
		this.groupList = groupList;
	}
	
	public String getGroupMessage() {
		return groupMessage;
	}
	public List<SelectItem> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<SelectItem> locationList) {
		this.locationList = locationList;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public boolean isAllGroupsDetailStatus() {
		return allGroupsDetailStatus;
	}
	public void setAllGroupsDetailStatus(boolean allGroupsDetailStatus) {
		this.allGroupsDetailStatus = allGroupsDetailStatus;
	}
	public void setGroupMessage(String groupMessage) {
		this.groupMessage = groupMessage;
	}
		
	
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(Integer rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	public List<SelectItem> getPageNumberList() {
		return pageNumberList;
	}
	public void setPageNumberList(List<SelectItem> pageNumberList) {
		this.pageNumberList = pageNumberList;
	}
	public List<GroupInfoTO> getViewGroupInfoPerPageList() {
		return viewGroupInfoPerPageList;
	}
	public void setViewGroupInfoPerPageList(
			List<GroupInfoTO> viewGroupInfoPerPageList) {
		this.viewGroupInfoPerPageList = viewGroupInfoPerPageList;
	}
	public String getPageMessage() {
		return pageMessage;
	}
	public void setPageMessage(String pageMessage) {
		this.pageMessage = pageMessage;
	}
		
	public Integer getDisplayPageNumber() {
		return displayPageNumber;
	}
	public void setDisplayPageNumber(Integer displayPageNumber) {
		this.displayPageNumber = displayPageNumber;
	}
	public GroupDetailsReportsMB()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		this.locationList = new ArrayList<SelectItem>();
		Map<String,String> locationMap = new TreeMap<String, String>();
				
		try 
		{
			locationMap= wrapper.getAllLocations();
			for (Map.Entry<String,String> entry: locationMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );

				 
			}
			
		} 
		catch (NoLocationsAvailableException e) 
		{
			// TODO Auto-generated catch block
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			
		}
				
		
	}
	
	public String viewGroupDetails()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		this.groupList=null;
		int flag=0;
		try 
		{
			if(this.allGroupsDetailStatus == true)
			{
				this.setLocationId("0");
				this.groupList=wrapper.getAllGroups();
			}
		
			else if(!this.locationId.equalsIgnoreCase("0"))
			{
				this.groupList=wrapper.getAllGroupsByLocation(locationId);
			}
		
			else
			{
				flag=1;
				this.groupList = new ArrayList<GroupInfoTO>();
				this.setGroupMessage("Please select an Option !");
			}
			if(flag==0)
			{
				this.pageNumber=1;
				this.rowsPerPage=10;
				int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
				int endRowNumber=this.pageNumber*this.rowsPerPage;
				if(endRowNumber>=this.groupList.size())
				{
					endRowNumber=this.groupList.size();
				}
				
				this.viewGroupInfoPerPageList=this.groupList.subList(startRowNumner, endRowNumber);
				this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.groupList.size();
				this.pageNumberList=new ArrayList<SelectItem>();
				int totalPageNumbers=(this.groupList.size()-1)/10;
				totalPageNumbers++;
				for(Integer i=1;i<=totalPageNumbers;i++)
				{
					this.pageNumberList.add(new SelectItem(i.toString(),i.toString()));
				}
			}
			return "success";
		}
		catch (NoGroupsAvailableException e) 
		{
			this.setGroupMessage(e.getMessage());
			return "fail";
		}
		catch (Exception e) 
		{
			this.setGroupMessage(e.getMessage());
			return "fail";
		}
	}
	public String showNextRecord()
	{
		this.setGroupMessage(null);
		this.pageNumber++;
		int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
		int endRowNumber=(this.pageNumber*this.rowsPerPage);
		if(startRowNumner<groupList.size())
		{
			if(endRowNumber>=this.groupList.size())
			{
				endRowNumber=this.groupList.size();
			}
			
			this.viewGroupInfoPerPageList=this.groupList.subList(startRowNumner, endRowNumber);
			 
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.groupList.size();
		}
		else
		{
			pageNumber--;
		}

		this.displayPageNumber=this.pageNumber;
		return "show";
	}
	
	public String showPreviousRecord()
	{
		this.setGroupMessage(null);
		if(pageNumber>1)
		{
			this.pageNumber--;
			int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
			int endRowNumber=(this.pageNumber*this.rowsPerPage);
			 
			this.viewGroupInfoPerPageList=this.groupList.subList(startRowNumner, endRowNumber);
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.groupList.size();
			this.displayPageNumber=this.pageNumber;
		}
		
		
		return "show";
	}
	public void selectPageNumber(ValueChangeEvent e)
	{
		try
		{ 
			Integer val=(Integer)e.getNewValue();
			if(val!=null)
			{ 
				if(val!=0)
				{
					this.pageNumber=val;
					this.pageNumber--;
					this.showNextRecord();
				}
			}
		}
		catch (Exception ex) {
			this.groupMessage=ex.getMessage();
		}

	}
	
	public void selectAllGroupDetailsCheckBox(ValueChangeEvent event)
	{
		Boolean flag= Boolean.parseBoolean(event.getNewValue().toString());
		this.locationId="0";
		this.locationSelectMenu.setDisabled(flag);
		this.groupList = new ArrayList<GroupInfoTO>();
		this.groupMessage=null;
	}
		
		//download group list

	public String downloadGroupList()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();

		try
		{	
			String fName=wrapper.downloadGroupDetailsReport(this.groupList);
			FileInputStream fileInputStream = new FileInputStream(fName);
			String fileName="GroupDetailsReport.xls";


			POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
			HSSFWorkbook groupsReport =    new HSSFWorkbook(fsFileSystem); 

			// Prepare response to show a Save As dialogue with Excel report.   
			FacesContext facesContext = FacesContext.getCurrentInstance();  
			ExternalContext externalContext = facesContext.getExternalContext();   

			HttpServletResponse response=(HttpServletResponse)externalContext.getResponse();
			response.setContentType("application/vnd.ms-excel");    
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); 
			// Write Excel report to response body.     
			groupsReport.write(response.getOutputStream());     
			// Inform JSF that response is completed and it thus doesn't have to navigate.  
			facesContext.responseComplete(); 
			fileInputStream.close();

			return"success";
		}
		catch (NoGroupsAvailableException e) 
		{
			this.setGroupMessage(e.getMessage());
			return"fail";
		} 
		catch (Exception e)
		{
			this.setGroupMessage(e.getMessage());
			return"fail";		
		}
	}


		
}
