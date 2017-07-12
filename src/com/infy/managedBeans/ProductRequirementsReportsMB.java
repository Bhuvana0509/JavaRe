package com.infy.managedBeans;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.infy.TOclasses.ProductRequirementTO;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoModuleFoundException;
import com.infy.exceptions.NoProductReqAvailableException;
import com.infy.exceptions.NoSubModuleAvailableForGivenModuleException;
import com.infy.exceptions.NoVersionFoundException;
import com.infy.wrapper.FRMS_Wrapper;

public class ProductRequirementsReportsMB 
{
	
	private List<ProductRequirementTO> productReqList;
	private String productReqMessage;
	private List<SelectItem> groupNamesList;
	private List<SelectItem> modulesList;
	private List<SelectItem> versionList;
	private String groupId;
	private String moduleId;
	private String version;
	private String assignedToEmpId;
	private Boolean unassignedProductReqStatus;
	private Boolean allProductReqStatus;
	
	private HtmlSelectOneMenu groupSelectMenu;
	private HtmlSelectOneMenu moduleSelectMenu;
	private HtmlSelectOneMenu versionSelectMenu;
	private HtmlInputText assignedToInputText;
	private HtmlSelectBooleanCheckbox unassignedProductReqCheckBox;
	private HtmlSelectBooleanCheckbox allProductReqCheckBox;
	private Integer pageNumber;
	private Integer rowsPerPage;
	private List<SelectItem> pageNumberList;
	private List<ProductRequirementTO> viewProductReqPerPageList;
	private Integer displayPageNumber;
	private String pageMessage;
	
	// Changes made by Bhuvana start
	
	private String locationId;
	private List<SelectItem> locationList;
	private HtmlSelectOneMenu locationSelectMenu;	
	
	private String verticalId;
	private List<SelectItem> verticalList;
	private HtmlSelectOneMenu verticalSelectMenu;
	
	public String getVerticalId() {
		return verticalId;
	}
	public void setVerticalId(String verticalId) {
		this.verticalId = verticalId;
	}
	public List<SelectItem> getVerticalList() {
		return verticalList;
	}
	public void setVerticalList(List<SelectItem> verticalList) {
		this.verticalList = verticalList;
	}
	public HtmlSelectOneMenu getVerticalSelectMenu() {
		return verticalSelectMenu;
	}
	public void setVerticalSelectMenu(HtmlSelectOneMenu verticalSelectMenu) {
		this.verticalSelectMenu = verticalSelectMenu;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public List<SelectItem> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<SelectItem> locationList) {
		this.locationList = locationList;
	}
	public HtmlSelectOneMenu getLocationSelectMenu() {
		return locationSelectMenu;
	}
	public void setLocationSelectMenu(HtmlSelectOneMenu locationSelectMenu) {
		this.locationSelectMenu = locationSelectMenu;
	}
	
	// Changes completed
	
	private String initiatingGroupId;
	private List<SelectItem> initiatingGroupList;
	private HtmlSelectOneMenu initiatingGroupSelectMenu;
	private String subModuleId;
	private HtmlSelectOneMenu subModuleSelectMenu;
	private List<SelectItem> subModuleList;
	
	public String getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}
	public HtmlSelectOneMenu getSubModuleSelectMenu() {
		return subModuleSelectMenu;
	}
	public void setSubModuleSelectMenu(HtmlSelectOneMenu subModuleSelectMenu) {
		this.subModuleSelectMenu = subModuleSelectMenu;
	}
	public List<SelectItem> getSubModuleList() {
		return subModuleList;
	}
	public void setSubModuleList(List<SelectItem> subModuleList) {
		this.subModuleList = subModuleList;
	}
	public String getInitiatingGroupId() {
		return initiatingGroupId;
	}
	public void setInitiatingGroupId(String initiatingGroupId) {
		this.initiatingGroupId = initiatingGroupId;
	}
	public List<SelectItem> getInitiatingGroupList() {
		return initiatingGroupList;
	}
	public void setInitiatingGroupList(List<SelectItem> initiatingGroupList) {
		this.initiatingGroupList = initiatingGroupList;
	}
	public HtmlSelectOneMenu getInitiatingGroupSelectMenu() {
		return initiatingGroupSelectMenu;
	}
	public void setInitiatingGroupSelectMenu(
			HtmlSelectOneMenu initiatingGroupSelectMenu) {
		this.initiatingGroupSelectMenu = initiatingGroupSelectMenu;
	}
	public List<SelectItem> getVersionList() {
		return versionList;
	}
	public void setVersionList(List<SelectItem> versionList) {
		this.versionList = versionList;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAssignedToEmpId() {
		return assignedToEmpId;
	}
	public void setAssignedToEmpId(String assignedToEmpId) {
		this.assignedToEmpId = assignedToEmpId;
	}
	public Boolean getUnassignedProductReqStatus() {
		return unassignedProductReqStatus;
	}
	public void setUnassignedProductReqStatus(Boolean unassignedProductReqStatus) {
		this.unassignedProductReqStatus = unassignedProductReqStatus;
	}
	public Boolean getAllProductReqStatus() {
		return allProductReqStatus;
	}
	public void setAllProductReqStatus(Boolean allProductReqStatus) {
		this.allProductReqStatus = allProductReqStatus;
	}
	public HtmlSelectOneMenu getGroupSelectMenu() {
		return groupSelectMenu;
	}
	public void setGroupSelectMenu(HtmlSelectOneMenu groupSelectMenu) {
		this.groupSelectMenu = groupSelectMenu;
	}
	public HtmlSelectOneMenu getModuleSelectMenu() {
		return moduleSelectMenu;
	}
	public void setModuleSelectMenu(HtmlSelectOneMenu moduleSelectMenu) {
		this.moduleSelectMenu = moduleSelectMenu;
	}
	public HtmlSelectOneMenu getVersionSelectMenu() {
		return versionSelectMenu;
	}
	public void setVersionSelectMenu(HtmlSelectOneMenu versionSelectMenu) {
		this.versionSelectMenu = versionSelectMenu;
	}
	public HtmlInputText getAssignedToInputText() {
		return assignedToInputText;
	}
	public void setAssignedToInputText(HtmlInputText assignedToInputText) {
		this.assignedToInputText = assignedToInputText;
	}
	public HtmlSelectBooleanCheckbox getUnassignedProductReqCheckBox() {
		return unassignedProductReqCheckBox;
	}
	public void setUnassignedProductReqCheckBox(
			HtmlSelectBooleanCheckbox unassignedProductReqCheckBox) {
		this.unassignedProductReqCheckBox = unassignedProductReqCheckBox;
	}
	public HtmlSelectBooleanCheckbox getAllProductReqCheckBox() {
		return allProductReqCheckBox;
	}
	public void setAllProductReqCheckBox(
			HtmlSelectBooleanCheckbox allProductReqCheckBox) {
		this.allProductReqCheckBox = allProductReqCheckBox;
	}
	public List<SelectItem> getGroupNamesList() {
		return groupNamesList;
	}
	public void setGroupNamesList(List<SelectItem> groupNamesList) {
		this.groupNamesList = groupNamesList;
	}
	public List<SelectItem> getModulesList() {
		return modulesList;
	}
	public void setModulesList(List<SelectItem> modulesList) {
		this.modulesList = modulesList;
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
	
	public List<ProductRequirementTO> getProductReqList() {
		return productReqList;
	}
	public void setProductReqList(List<ProductRequirementTO> productReqList) {
		this.productReqList = productReqList;
	}
	
	public String getProductReqMessage() {
		return productReqMessage;
	}
	public void setProductReqMessage(String productReqMessage) {
		this.productReqMessage = productReqMessage;
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
	
	public List<ProductRequirementTO> getViewProductReqPerPageList() {
		return viewProductReqPerPageList;
	}
	public void setViewProductReqPerPageList(
			List<ProductRequirementTO> viewProductReqPerPageList) {
		this.viewProductReqPerPageList = viewProductReqPerPageList;
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
	public ProductRequirementsReportsMB()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		
		modulesList = new ArrayList<SelectItem>();
		groupNamesList = new ArrayList<SelectItem>();
		versionList= new ArrayList<SelectItem>();		
		
		// Changes made by Bhuvana starts
		locationList= new ArrayList<SelectItem>();
		// Changes made by Bhuvana ends
		 
		TreeMap<String,String> modulesMap = new TreeMap<String, String>();
		TreeMap<String,String> groupNamesMap = new TreeMap<String, String>();
		TreeMap<String,String> verticalMap = new TreeMap<String, String>();
		// Changes made by Bhuvana starts
		TreeMap<String,String> locationNamesMap = new TreeMap<String, String>();
		TreeMap<String,String> initiatingGroupMap = new TreeMap<String,String>();
		// Changes made by Bhuvana ends
		
		this.initiatingGroupSelectMenu = new HtmlSelectOneMenu();
		this.initiatingGroupList = new ArrayList<SelectItem>();
		this.versionSelectMenu = new HtmlSelectOneMenu();
		this.subModuleSelectMenu  = new HtmlSelectOneMenu();
		this.subModuleList = new ArrayList<SelectItem>();
		this.verticalSelectMenu  = new HtmlSelectOneMenu();
		this.verticalList = new ArrayList<SelectItem>();
		//changes complete
		
		//changes done by Bhuvana starts
		this.version = "0";
		
		List<String> versionList = new ArrayList<String>();
		try 
		{
			/*groupNamesMap= wrapper.getAllGroupNames();
			for (Map.Entry<String,String> entry: groupNamesMap.entrySet())
			{
				groupNamesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );

			 
			}*/
	
			groupNamesMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllGroupsMap();
			HashMap<String,String> groupHashMap = new HashMap<String, String>();
			groupHashMap = sortHashMap(groupNamesMap);	
			for (Map.Entry<String,String> entry: groupHashMap.entrySet())
			{
				groupNamesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			/*modulesMap= wrapper.getAllModules();
			for (Map.Entry<String,String> entry: modulesMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				 
			}*/
			
			modulesMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllModules();
			HashMap<String,String> moduleHashMap = new HashMap<String, String>();
			moduleHashMap = sortHashMap(modulesMap);	
			for (Map.Entry<String,String> entry: moduleHashMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			/*verticalMap= wrapper.getAllVerticals();
			for (Map.Entry<String,String> entry: verticalMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				 
			}*/
			verticalMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllVerticals();
			HashMap<String,String> verticalHashMap = new HashMap<String, String>();
			verticalHashMap = sortHashMap(verticalMap);	
			for (Map.Entry<String,String> entry: verticalHashMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			// Changes made by Bhuvana starts
			/*locationNamesMap= wrapper.getAllLocations();
			for (Map.Entry<String,String> entry: locationNamesMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );				 
			}*/
			locationNamesMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllLocations();
			HashMap<String,String> locationHashMap = new HashMap<String, String>();
			locationHashMap = sortHashMap(locationNamesMap);	
			for (Map.Entry<String,String> entry: locationHashMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			// Changes made by Bhuvana ends

			//get the list of all initiating groups
			/*initiatingGroupMap = wrapper.getAllInitiatingGroups();
			for (Map.Entry<String, String> entry : initiatingGroupMap.entrySet()) 
			{				
				initiatingGroupList.add(new SelectItem(entry.getKey(),entry.getValue()));
			}*/
			initiatingGroupMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllInitiatingGroups();
			HashMap<String,String> initiatingGroupHashMap = new HashMap<String, String>();
			initiatingGroupHashMap = sortHashMap(initiatingGroupMap);	
			for (Map.Entry<String,String> entry: initiatingGroupHashMap.entrySet())
			{
				initiatingGroupList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }

			// get list of all versions
			versionList= wrapper.getAllVersions();
			Iterator<String> it=versionList.iterator();
			while (it.hasNext()) 
			{
				String string = (String) it.next();
				this.versionList.add(new SelectItem(string,string));	
				
			}
		} 
		
		catch (NoGroupsAvailableException e) 
		{
			// TODO Auto-generated catch block
			
		} 
		catch (NoModuleFoundException e)
		{
			// TODO Auto-generated catch block
			
		}
		catch (NoVersionFoundException e) 
		{
			// TODO Auto-generated catch block
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			
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
	
	//changes done by sanket mehta
	public void getAllSubModulesByModule(ValueChangeEvent e)
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		Map<String,String> subModuleMap = new TreeMap<String, String>();
		String moduleId = this.moduleSelectMenu.getValue().toString();
				
		try {
				subModuleMap = wrapper.getAllSubModulesByModule(moduleId);

				for (Map.Entry<String,String> entry: subModuleMap.entrySet())
				{
					subModuleList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				}
			} catch (NoSubModuleAvailableForGivenModuleException e1) {
		 
					//e1.printStackTrace();
					this.setProductReqMessage(e1.getMessage());
					
				} catch (Exception e1) {
					
					//e1.printStackTrace();
					this.setProductReqMessage(e1.getMessage());
				}
			}
			//changes completed
	
	
	public void getAllModulesByVertical(ValueChangeEvent e)
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		Map<String,String> moduleMap = new TreeMap<String, String>();
		String verticalId = this.verticalSelectMenu.getValue().toString();
		
		try {
			moduleMap = wrapper.getAllModulesByVertical(verticalId);

			for (Map.Entry<String,String> entry: moduleMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
		} catch (NoSubModuleAvailableForGivenModuleException e1) {
 
			//e1.printStackTrace();
			this.setProductReqMessage(e1.getMessage());
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
			this.setProductReqMessage(e1.getMessage());
		}
	}
	
	public void selectallProductReqCheckBox(ValueChangeEvent e)
	{
		 
		boolean flag=Boolean.parseBoolean(e.getNewValue().toString());
		this.groupId="0";
		this.moduleId="0";
		this.version="0";
		this.groupSelectMenu.setDisabled(flag);
		this.moduleSelectMenu.setDisabled(flag);
		this.versionSelectMenu.setDisabled(flag);
		// Changes made by Bhuvana starts
		this.locationSelectMenu.setDisabled(flag);    
		this.initiatingGroupSelectMenu.setDisabled(flag);
		this.subModuleSelectMenu.setDisabled(flag);
		// Changes made by Bhuvana ends
		
		this.unassignedProductReqCheckBox.setDisabled(flag);
		this.productReqList=new ArrayList<ProductRequirementTO>();
		this.productReqMessage=null;
		
	}
	
	public void selectUnassignedProductReqCheckBox(ValueChangeEvent e)
	{
		 
		boolean flag=Boolean.parseBoolean(e.getNewValue().toString());
		
		
		this.assignedToInputText.setDisabled(flag);
		this.assignedToInputText.setValue(null);
		if(this.allProductReqCheckBox.isSelected())
		{
			 
			this.allProductReqCheckBox.setSelected(false);
			
		}
		this.productReqList=new ArrayList<ProductRequirementTO>();
		this.productReqMessage=null;
		
	}
	
	public String viewProductRequirementsDetails()
	{
		this.productReqList=new ArrayList<ProductRequirementTO>();
		this.productReqMessage=null;
				
		FRMS_Wrapper wrapper=new FRMS_Wrapper(); 
		int flag=0;
		try
		{
			
			 if(this.allProductReqStatus==true)
				{
					this.productReqList=wrapper.getAllProductRequirements();
				}
			 else
			 {
				 List<String> arguementList=new ArrayList<String>();
				 if(!this.groupId.equals("0") )
					{
						arguementList.add("groupId");
						arguementList.add(this.groupId);
					}
					if(!this.moduleId.equals("0"))
					{
						arguementList.add("moduleId");
						arguementList.add(this.moduleId);
					}
					// changes done by Bhuvana starts
					/*if(!this.subModuleId.equals("0"))
					{
						arguementList.add("subModuleId");
						arguementList.add(this.subModuleId);
					}*/
					if(!this.verticalId.equals("0"))
					{
						arguementList.add("verticalId");
						arguementList.add(this.verticalId);
					}
					//changes completed
					if(!this.version.equals("0"))
					{
						arguementList.add("productVersion");
						arguementList.add(this.version);
					}
					
					if(this.unassignedProductReqStatus==true)
					{
						arguementList.add("assignedTo");
						arguementList.add("");
					}
					if(this.assignedToEmpId!=null && !this.assignedToEmpId.equals(""))
					{
						arguementList.add("assignedTo");
						arguementList.add(this.assignedToEmpId);
					}
					// Changes made by Bhuvana starts
					if(!this.locationId.equals("0"))
					{
						arguementList.add("locationId");
						arguementList.add(this.locationId);
					}
					// Changes made by Bhuvana ends
					
					// Changes done by Sanket
					if(!this.initiatingGroupId.equals("0"))
					{
						arguementList.add("initiatingGroupId");
						arguementList.add(this.initiatingGroupId);
					}
					// Changes completed
					
					if(!arguementList.isEmpty())
					{
						String arguementString=arguementList.toString(); 
						String[] arguementArray=arguementString.substring(1, arguementString.length()-1).split(",");
						
						for (int i=0;i<arguementArray.length;i++) {
							arguementArray[i]=arguementArray[i].replaceAll(" ", "");

						}
						this.productReqList=wrapper.getProductRequirements(arguementArray);
					}
					else
					{
						flag=1;
						this.productReqMessage="Please Select an option";
					}

			 }
			
			 
			if(flag==0)
			{
				this.pageNumber=1;
				this.rowsPerPage=10;
				int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
				int endRowNumber=this.pageNumber*this.rowsPerPage;
				if(endRowNumber>=this.productReqList.size())
				{
					endRowNumber=this.productReqList.size();
				}
				
				this.viewProductReqPerPageList=this.productReqList.subList(startRowNumner, endRowNumber);
				this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.productReqList.size();
				this.pageNumberList=new ArrayList<SelectItem>();
				int totalPageNumbers=(this.productReqList.size()-1)/10;
				totalPageNumbers++;
				for(Integer i=1;i<=totalPageNumbers;i++)
				{
					this.pageNumberList.add(new SelectItem(i.toString(),i.toString()));
				}
			}
			return "success";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			this.productReqMessage=e.getMessage();
			
			return "fail";
		}
		
	}
	public String showNextRecord()
	{
		this.productReqMessage=null;
		this.pageNumber++;
		int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
		int endRowNumber=(this.pageNumber*this.rowsPerPage);
		if(startRowNumner<productReqList.size())
		{
			if(endRowNumber>=this.productReqList.size())
			{
				endRowNumber=this.productReqList.size();
			}
			
			this.viewProductReqPerPageList=this.productReqList.subList(startRowNumner, endRowNumber);
			 
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.productReqList.size();
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
		this.productReqMessage=null;
		if(pageNumber>1)
		{
			this.pageNumber--;
			int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
			int endRowNumber=(this.pageNumber*this.rowsPerPage);
			 
			this.viewProductReqPerPageList=this.productReqList.subList(startRowNumner, endRowNumber);
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.productReqList.size();
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
			this.productReqMessage=ex.getMessage();
		}

	}

	
	public String downloadProductReqList()
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();
			
			try
			{
				
				String fName=wrapper.downloadProductRequirementsReport(this.productReqList);
				FileInputStream fileInputStream = new FileInputStream(fName);
				String fileName="ProductRequirementsReport.xls";
				
			 
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
			catch (NoProductReqAvailableException e) 
			{
				
				this.setProductReqMessage(e.getMessage());
				return"fail";
			} 
			catch (Exception e)
			{
				
				this.setProductReqMessage(e.getMessage());
				return"fail";		
			}
	   }
	
	//Added for Download as RCD Tracker	
		public String downloadProductReqListAsRCDTracker()
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();
			
			try
			{
				String fName=wrapper.downloadProductReqListAsRCDTracker(this.productReqList);
				FileInputStream fileInputStream = new FileInputStream(fName);
				String fileName="ProductRequirementsReportAsRCDTracker.xls";
				
				
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
			catch (NoProductReqAvailableException e) 
			{
				
				this.setProductReqMessage(e.getMessage());
				return"fail";
			} 
			catch (Exception e)
			{
		
				this.setProductReqMessage(e.getMessage());
				return"fail";		
			}
	   }
		
		// //Added for Download as RS Tracker	
		public String downloadProductReqListAsRSTracker()
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();
			
			try
			{
				String fName=wrapper.downloadProductReqListAsRSTracker(this.productReqList);
				FileInputStream fileInputStream = new FileInputStream(fName);
				String fileName="ProductRequirementsReportAsRSTracker.xls";
				
				
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
			catch (NoProductReqAvailableException e) 
			{
				
				this.setProductReqMessage(e.getMessage());
				return"fail";
			} 
			catch (Exception e)
			{
		
				this.setProductReqMessage(e.getMessage());
				return"fail";		
			}
	   }
		
		
				
		
}
