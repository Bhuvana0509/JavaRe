package com.infy.managedBeans;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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

import com.infy.TOclasses.MasterRequirementTO;
import com.infy.exceptions.InvalidDateException;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoMasterReqAvailableException;
import com.infy.exceptions.NoModuleFoundException;
import com.infy.exceptions.NoSubModuleAvailableForGivenModuleException;
import com.infy.wrapper.FRMS_Wrapper;


public class MasterRequirementsReportsMB 
{
	private List<MasterRequirementTO> masterReqList;
	private String masterReqMessage;
	private List<SelectItem> groupNamesList;
	private List<SelectItem> modulesList;
	private String groupId;
	private String moduleId;
	private String reqStatus;
	private boolean allMasterReqStatus;
	private HtmlSelectOneMenu groupSelectMenu;
	private HtmlSelectOneMenu moduleSelectMenu;
	private HtmlSelectOneMenu statusSelectMenu;
	private HtmlSelectBooleanCheckbox allMasterReqCheckBox;
	private Integer pageNumber;
	private Integer rowsPerPage;
	private List<SelectItem> pageNumberList;
	private List<MasterRequirementTO> viewMasterReqPerPageList;
	private Integer displayPageNumber;
	private String pageMessage;
	
	//changes made by sanket mehta
	private HtmlSelectOneMenu customizationSelectMenu;
	private HtmlSelectOneMenu subModuleSelectMenu;
	private List<SelectItem> subModuleList;
	private String subModuleId;
	
	private String verticalId;
	private List<SelectItem> verticalList;
	private HtmlSelectOneMenu verticalSelectMenu;
	
	public HtmlSelectOneMenu getSubModuleSelectMenu() {
		return subModuleSelectMenu;
	}
	public void setSubModuleSelectMenu(HtmlSelectOneMenu subModuleSelectMenu) {
		this.subModuleSelectMenu = subModuleSelectMenu;
	}
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
	public List<SelectItem> getSubModuleList() {
		return subModuleList;
	}
	public void setSubModuleList(List<SelectItem> subModuleList) {
		this.subModuleList = subModuleList;
	}
	public String getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
	}
	public HtmlSelectOneMenu getCustomizationSelectMenu() {
		return customizationSelectMenu;
	}
	public void setCustomizationSelectMenu(HtmlSelectOneMenu customizationSelectMenu) {
		this.customizationSelectMenu = customizationSelectMenu;
	}	
    //changes done
	
	// changes made by Bhuvana starts
	private String customization;
	private String locationId;
	private List<SelectItem> locationList;
	private HtmlSelectOneMenu locationSelectMenu;
	private String initiatingGroupId;
	private List<SelectItem> initiatingGroupList;
	private HtmlSelectOneMenu initiatingGroupSelectMenu;	
	private Date fromDate;
	private Date toDate;
	private HtmlInputText fromDateInputText;
	private HtmlInputText toDateInputText;
	private HtmlSelectBooleanCheckbox fromDateCheckBox;
	private boolean dateStatus;	
	private String searchBy;
	private HtmlInputText searchByInputText;
		
	public String getSearchBy() {
		return searchBy;
	}
	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	public HtmlInputText getSearchByInputText() {
		return searchByInputText;
	}
	public void setSearchByInputText(HtmlInputText searchByInputText) {
		this.searchByInputText = searchByInputText;
	}
	public boolean isDateStatus() {
		return dateStatus;
	}
	public void setDateStatus(boolean dateStatus) {
		this.dateStatus = dateStatus;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public HtmlInputText getFromDateInputText() {
		return fromDateInputText;
	}
	public void setFromDateInputText(HtmlInputText fromDateInputText) {
		this.fromDateInputText = fromDateInputText;
	}
	public HtmlInputText getToDateInputText() {
		return toDateInputText;
	}
	public void setToDateInputText(HtmlInputText toDateInputText) {
		this.toDateInputText = toDateInputText;
	}
	public HtmlSelectBooleanCheckbox getFromDateCheckBox() {
		return fromDateCheckBox;
	}
	public void setFromDateCheckBox(HtmlSelectBooleanCheckbox fromDateCheckBox) {
		this.fromDateCheckBox = fromDateCheckBox;
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
	public String getCustomization() {
		return customization;
	}
	public void setCustomization(String customization) {
		this.customization = customization;
	}
	public HtmlSelectOneMenu getLocationSelectMenu() {
		return locationSelectMenu;
	}
	public void setLocationSelectMenu(HtmlSelectOneMenu locationSelectMenu) {
		this.locationSelectMenu = locationSelectMenu;
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
	// changes made by Bhuvana ends
	public Integer getDisplayPageNumber() {
		return displayPageNumber;
	}
	public void setDisplayPageNumber(Integer displayPageNumber) {
		this.displayPageNumber = displayPageNumber;
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
	public HtmlSelectOneMenu getStatusSelectMenu() {
		return statusSelectMenu;
	}
	public void setStatusSelectMenu(HtmlSelectOneMenu statusSelectMenu) {
		this.statusSelectMenu = statusSelectMenu;
	}
	public HtmlSelectBooleanCheckbox getAllMasterReqCheckBox() {
		return allMasterReqCheckBox;
	}
	public void setAllMasterReqCheckBox(
			HtmlSelectBooleanCheckbox allMasterReqCheckBox) {
		this.allMasterReqCheckBox = allMasterReqCheckBox;
	}
	public boolean isAllMasterReqStatus() {
		return allMasterReqStatus;
	}
	public void setAllMasterReqStatus(boolean allMasterReqStatus) {
		this.allMasterReqStatus = allMasterReqStatus;
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
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public List<MasterRequirementTO> getMasterReqList() {
		return masterReqList;
	}
	public void setMasterReqList(List<MasterRequirementTO> masterReqList) {
		this.masterReqList = masterReqList;
	}
		
	public String getMasterReqMessage() {
		return masterReqMessage;
	}
	public void setMasterReqMessage(String masterReqMessage) {
		this.masterReqMessage = masterReqMessage;
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
	public String getPageMessage() {
		return pageMessage;
	}
	public void setPageMessage(String pageMessage) {
		this.pageMessage = pageMessage;
	}
	
	public List<MasterRequirementTO> getViewMasterReqPerPageList() {
		return viewMasterReqPerPageList;
	}
	public void setViewMasterReqPerPageList(
			List<MasterRequirementTO> viewMasterReqPerPageList) {
		this.viewMasterReqPerPageList = viewMasterReqPerPageList;
	}
	public MasterRequirementsReportsMB()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		//this.customization = "No";
		modulesList = new ArrayList<SelectItem>();
		groupNamesList = new ArrayList<SelectItem>();
		subModuleList = new ArrayList<SelectItem>();
		// changes made by Bhuvana
		locationList = new ArrayList<SelectItem>();
		this.initiatingGroupList = new ArrayList<SelectItem>();
		this.initiatingGroupSelectMenu=new HtmlSelectOneMenu();
		this.subModuleSelectMenu = new HtmlSelectOneMenu();
		this.verticalSelectMenu=new HtmlSelectOneMenu();
		this.verticalList=new ArrayList<SelectItem>();
		this.fromDateInputText=new HtmlInputText();
		this.fromDateInputText.setDisabled(true);
		
		this.searchByInputText=new HtmlInputText();
		
		this.toDateInputText = new HtmlInputText();
		this.toDateInputText.setDisabled(true);
		// set default fromDate		
		if(getFromDate()== null)
		{
			this.fromDate = new Date(); 
			
		}
		
		//set default toDate
		if(getToDate()== null)
		{
			this.toDate = new Date();
       	    //this.masterRequirementTO.setMrDate(fromDate);
		}
		
		TreeMap<String,String> modulesMap = new TreeMap<String, String>();
		TreeMap<String,String> groupNamesMap = new TreeMap<String, String>();
		// changes made by Bhuvana
		TreeMap<String,String> locationNamesMap = new TreeMap<String, String>();
		TreeMap<String,String> intiatingGroupMap = new TreeMap<String, String>();
		TreeMap<String,String> verticalNamesMap = new TreeMap<String, String>();
		try 
		{
			/*groupNamesMap= wrapper.getAllGroupNames();
			for (Map.Entry<String,String> entry: groupNamesMap.entrySet())
			{
				groupNamesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				 
			}*/
			
			groupNamesMap=(TreeMap<String, String>) wrapper.getAllGroupNames();
			HashMap<String,String> groupNamesHashMap = new HashMap<String, String>();
			groupNamesHashMap = sortHashMap(groupNamesMap);	
			for (Map.Entry<String,String> entry: groupNamesHashMap.entrySet())
			{
				groupNamesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			/*modulesMap= wrapper.getAllModules();
			for (Map.Entry<String,String> entry: modulesMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );				 
			}*/
			
			modulesMap=(TreeMap<String, String>) wrapper.getAllModules();
			HashMap<String,String> moduleHashMap = new HashMap<String, String>();
			moduleHashMap = sortHashMap(modulesMap);	
			for (Map.Entry<String,String> entry: moduleHashMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			// Changes made by Bhuvana starts
			/*locationNamesMap= wrapper.getAllLocations();
			for (Map.Entry<String,String> entry: locationNamesMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				 
			}*/
			
			locationNamesMap=(TreeMap<String, String>) wrapper.getAllLocations();
			HashMap<String,String> locationNamesHashMap = new HashMap<String, String>();
			locationNamesHashMap = sortHashMap(locationNamesMap);	
			for (Map.Entry<String,String> entry: locationNamesHashMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			/*verticalNamesMap= wrapper.getAllVerticals();
			for (Map.Entry<String,String> entry: verticalNamesMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				 
			}*/
			
			verticalNamesMap=(TreeMap<String, String>) wrapper.getAllVerticals();
			HashMap<String,String> verticalHashMap = new HashMap<String, String>();
			verticalHashMap = sortHashMap(verticalNamesMap);	
			for (Map.Entry<String,String> entry: verticalHashMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			
			/*intiatingGroupMap= wrapper.getAllInitiatingGroups();
			for (Map.Entry<String,String> entry: intiatingGroupMap.entrySet())
			{
				initiatingGroupList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				
			}*/
			
			intiatingGroupMap=(TreeMap<String, String>) wrapper.getAllInitiatingGroups();
			HashMap<String,String> initiatingGroupHashMap = new HashMap<String, String>();
			initiatingGroupHashMap = sortHashMap(intiatingGroupMap);	
			for (Map.Entry<String,String> entry: initiatingGroupHashMap.entrySet())
			{
				initiatingGroupList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			// changes completed
		} 
		catch (NoGroupsAvailableException e) 
		{
			this.setMasterReqMessage(e.getMessage());
		} 
		catch (NoModuleFoundException e)
		{
			this.setMasterReqMessage(e.getMessage());
		}
		catch (Exception e) 
		{
			this.setMasterReqMessage(e.getMessage());
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
	public void getSubModuleListByModule(ValueChangeEvent e)
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
			this.setMasterReqMessage(e1.getMessage());
			
		} catch (Exception e1) {
			
			//e1.printStackTrace();
			this.setMasterReqMessage(e1.getMessage());
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
			this.setMasterReqMessage(e1.getMessage());
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
			this.setMasterReqMessage(e1.getMessage());
		}
	}
	
	public void selectallMasterReqCheckBox(ValueChangeEvent e)
	{
		 
		boolean flag=Boolean.parseBoolean(e.getNewValue().toString());
		this.groupId="0";
		this.moduleId="0";
		this.reqStatus="0";
		this.groupSelectMenu.setDisabled(flag);
		this.moduleSelectMenu.setDisabled(flag);
		this.statusSelectMenu.setDisabled(flag);
		// Changes made by Bhuvana starts
		this.locationSelectMenu.setDisabled(flag);
		this.customizationSelectMenu.setDisabled(flag);
		this.initiatingGroupSelectMenu.setDisabled(flag);
		//changes done by Bhuvana starts
		this.subModuleSelectMenu.setDisabled(flag);
		this.verticalSelectMenu.setDisabled(flag);
		//changes completed
		
		// Changes made by Bhuvana ends
		this.masterReqList = new ArrayList<MasterRequirementTO>();
		this.masterReqMessage=null;
				
		//changes done by sanket mehta
		if(dateStatus)
		{
			//this.fromDateInputText.setValue(null);
			this.fromDateInputText.setDisabled(flag);
			//this.toDateInputText.setValue(null);
			this.toDateInputText.setDisabled(flag);
		}
		// Changes completed
	}
	
	public void enableCustomization(ValueChangeEvent e)
	{
		String StatusString = this.statusSelectMenu.getValue().toString();
		if(!StatusString.equalsIgnoreCase("Entered") && !StatusString.equalsIgnoreCase("0"))
		{
			this.customizationSelectMenu.setDisabled(true);
		}
		else
		{
			this.customizationSelectMenu.setDisabled(false);
		}
	}
	
	//changes done by sanket mehta
	public void enableDateFields(ValueChangeEvent e)
	{
		boolean flag=Boolean.parseBoolean(e.getNewValue().toString());
		if(!allMasterReqStatus)
		{
			this.fromDateInputText.setDisabled(!flag);
			this.toDateInputText.setDisabled(!flag);
		}
	}
	//changes completed
		
	// view master requirement details 
	public String viewMasterRequirementsDetails()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		this.masterReqList=null;
		int flag=0;
		try
		{
			if(this.allMasterReqStatus == true)
			{
				this.masterReqList=wrapper.getAllMasterRequirements();
			}
			
		 	// Changes made by sanket mehta
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
				//changes done by sanket mehta
				
				if(!this.verticalId.equals("0"))
				{
					arguementList.add("verticalId");
					arguementList.add(this.verticalId);
				}
				
				/*if(!this.subModuleId.equals("0"))
				{
					arguementList.add("subModuleId");
					arguementList.add(this.subModuleId);
				}*/		
				
				//changes completed
				if(!this.reqStatus.equals("0"))
				{
					arguementList.add("status");
					arguementList.add(this.reqStatus);
				}
				if(!this.customization.equals("0") && (this.reqStatus.equals("0") || this.reqStatus.equals("Entered")))
				{
					arguementList.add("customization");
					arguementList.add(this.customization);
				}
				if(!this.locationId.equals("0"))
				{
					arguementList.add("locationId");
					arguementList.add(this.locationId);
				}
				// Changes made by Bhuvana
				if(!this.initiatingGroupId.equals("0"))
				{
					arguementList.add("initiatingGroupId");
					arguementList.add(this.initiatingGroupId);
				}
				
				//added for search field
				if(!this.searchBy.equals(""))
				{
					System.out.println("master requirement title ***"+this.searchBy);
					////arguementList.add("masterRequirementTitle");
					
					
					arguementList.add("searchBy");
					arguementList.add(this.searchBy);
				}
				//added for search field complted
				
				// Changes complete					
				//changes done by sanket mehta
				//filter requirements according to given date range
				if(dateStatus)
				{
					if(this.fromDate != null && this.toDate != null)
					{
						//check for the validity of dates
						if(this.fromDate.after(this.toDate))
						{
							throw new InvalidDateException();
						}
						
						DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
						String formatedFromDate = df.format(fromDate);
						String formatedToDate = df.format(toDate);
						System.out.println(formatedFromDate.toUpperCase());
						System.out.println(formatedToDate.toUpperCase());
						
						arguementList.add("fromDate");
						arguementList.add("" + formatedFromDate);
						
						arguementList.add("toDate");
						arguementList.add("" + formatedToDate);
					}
					else
					{
						throw new InvalidDateException();
					}		
				}
				//changes complete
				if(!arguementList.isEmpty())
				{
					String arguementString=arguementList.toString(); 
					String[] arguementArray=arguementString.substring(1, arguementString.length()-1).split(",");

					for (int i=0;i<arguementArray.length;i++) {
						arguementArray[i]=arguementArray[i].trim();//replaceAll(" ", "");

					}
					this.masterReqList=wrapper.getMasterRequirements(arguementArray);
				}
				//	Changes made by Sanket ends
			
				else
				{
					flag=1;
					this.masterReqList= new ArrayList<MasterRequirementTO>();
					this.setMasterReqMessage("Please Select as Option !");
				}
			
				if(flag==0)
				{
					this.pageNumber=1;
					this.rowsPerPage=10;
					int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
					int endRowNumber=this.pageNumber*this.rowsPerPage;
					if(endRowNumber>=this.masterReqList.size())
					{
						endRowNumber=this.masterReqList.size();
					}

					this.viewMasterReqPerPageList=this.masterReqList.subList(startRowNumner, endRowNumber);
					this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.masterReqList.size();
					this.pageNumberList=new ArrayList<SelectItem>();
					int totalPageNumbers=(this.masterReqList.size()-1)/10;
					totalPageNumbers++;
					for(Integer i=1;i<=totalPageNumbers;i++)
					{
						this.pageNumberList.add(new SelectItem(i.toString(),i.toString()));
					}
				}
			}
		}
		catch (NoMasterReqAvailableException e)
		{
			this.setMasterReqMessage(e.getMessage());
			return"fail";
		}		
		//changes done by sanket mehta
		catch (InvalidDateException e)
		{
			this.setMasterReqMessage(e.getMessage());
			return"fail";
		}
		//changes completed
		catch (Exception e)
		{
			e.printStackTrace();
			this.setMasterReqMessage(e.getMessage());
			return"fail";
		}
				
		return "success";
	}
	
	public String showNextRecord()
	{
		this.setMasterReqMessage(null);
		this.pageNumber++;
		int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
		int endRowNumber=(this.pageNumber*this.rowsPerPage);
		if(startRowNumner<masterReqList.size())
		{
			if(endRowNumber>=this.masterReqList.size())
			{
				endRowNumber=this.masterReqList.size();
			}
			
			this.viewMasterReqPerPageList=this.masterReqList.subList(startRowNumner, endRowNumber);
			 
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.masterReqList.size();
			
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
		this.setMasterReqMessage(null);
		if(pageNumber>1)
		{
			this.pageNumber--;
			int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
			int endRowNumber=(this.pageNumber*this.rowsPerPage);
			 
			this.viewMasterReqPerPageList=this.masterReqList.subList(startRowNumner, endRowNumber);
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.masterReqList.size();
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
			this.masterReqMessage=ex.getMessage();
		}

	}

	
	public String downloadMasterReqList()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		
		try
		{
			String fName=wrapper.downloadMasterRequirementsReport(this.masterReqList);
		
			FileInputStream fileInputStream = new FileInputStream(fName);
			String fileName="MasterRequirementsReport.xls";
			
			
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
		catch (NoMasterReqAvailableException e) 
		{
			this.setMasterReqMessage(e.getMessage());
			return"fail";
		} 
		catch (Exception e)
		{
			this.setMasterReqMessage(e.getMessage());
		 
			return"fail";		
		}
	}
		

}
