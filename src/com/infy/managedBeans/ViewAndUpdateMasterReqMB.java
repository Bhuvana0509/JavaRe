 
package com.infy.managedBeans;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;

import org.apache.myfaces.custom.datalist.HtmlDataList;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.infy.TOclasses.MasterRequirementAttachmentTO;
import com.infy.TOclasses.MasterRequirementTO;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.exceptions.InvalidDateException;
import com.infy.exceptions.NoAttachmentFoundException;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoLocationsAvailableException;
import com.infy.exceptions.NoMasterReqAvailableException;
import com.infy.exceptions.NoModulesAvailableForGivenSolutionException;
import com.infy.exceptions.NoSubModuleAvailableForGivenModuleException;
import com.infy.exceptions.NoSolutionsAvailableException;
import com.infy.wrapper.FRMS_Wrapper;


public class ViewAndUpdateMasterReqMB {

	private MasterRequirementTO masterRequirementTO;
	private MasterRequirementTO updateMasterRequirementTO;
	private List<SelectItem> groupNamesList;
	private List<SelectItem> modulesList;
	private List<SelectItem> solutionList;
	private List<MasterRequirementTO> viewMasterRequirementTOList;
	private List<MasterRequirementAttachmentTO> attachmentTOList;
	private List<MasterRequirementTO> viewMasterReqPerPageList;
	private Integer pageNumber;
	private Integer rowsPerPage;
	private List<SelectItem> pageNumberList;

	private String groupId;
	private String moduleId;
	private String masterReqStatus;
	private String masterRequirementId;
	private boolean masterReqIdStatus;
	private UploadedFile uploadFile1;
	private UploadedFile uploadFile2;
	private UploadedFile uploadFile3;
	
	

	private HtmlSelectOneMenu groupSelectMenu;
	private HtmlSelectOneMenu moduleSelectMenu;
	private HtmlSelectOneMenu statusSelectMenu;
	private HtmlSelectBooleanCheckbox masterReqIdCheckBox;
	private HtmlInputText masterReqIdInputText;
	private HtmlDataTable viewMasterReqHtmlDataTable;
	private HtmlDataTable attachmentHtmlDataTable;
	private HtmlDataList splitDataList;
	private HtmlDataTable splitDataTable;
	

	private String acceptanceStatus;
	private List<ProductRequirementTO> productRequirementTOList;
	private Integer displayPageNumber;
	private String message;
	private String pageMessage;
	private int productReqListSize;
	
	// Changes made by sanket
	private String customization;	
	private String locationId;
	private List<SelectItem> locationList;
	
	private HtmlSelectOneMenu locationSelectMenu;
	private HtmlSelectOneMenu customizationSelectMenu;	
	private HtmlSelectOneMenu subModuleSelectMenu;
	private List<SelectItem> subModuleList;
	private String subModuleId;
	private String verticalId;
	private List<SelectItem> verticalList;
	private HtmlSelectOneMenu verticalSelectMenu;
	
	private String searchBy;
	private HtmlInputText searchByInputText;
	private boolean searchMasterReqByTitleAndDesc;
	
	private String masterRequirementTitle;
	private String masterRequirementDesc;
	
    public String getMasterRequirementTitle() {
		return masterRequirementTitle;
	}
	public void setMasterRequirementTitle(String masterRequirementTitle) {
		this.masterRequirementTitle = masterRequirementTitle;
	}
	public String getMasterRequirementDesc() {
		return masterRequirementDesc;
	}
	public void setMasterRequirementDesc(String masterRequirementDesc) {
		this.masterRequirementDesc = masterRequirementDesc;
	}
	public boolean isSearchMasterReqByTitleAndDesc() {
		return searchMasterReqByTitleAndDesc;
	}
	public void setSearchMasterReqByTitleAndDesc(
			boolean searchMasterReqByTitleAndDesc) {
		this.searchMasterReqByTitleAndDesc = searchMasterReqByTitleAndDesc;
	}
	public HtmlInputText getSearchByInputText() {
		return searchByInputText;
	}
	public void setSearchByInputText(HtmlInputText searchByInputText) {
		this.searchByInputText = searchByInputText;
	}
	public String getSearchBy() {
		return searchBy;
	}
	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	// changes done by Bhuvana 
	private String solutionId;
	private HtmlSelectOneMenu solutionSelectMenu;

    public String getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	}
	public HtmlSelectOneMenu getSolutionSelectMenu() {
		return solutionSelectMenu;
	}
	public void setSolutionSelectMenu(HtmlSelectOneMenu solutionSelectMenu) {
		this.solutionSelectMenu = solutionSelectMenu;
	}
	//changes completed
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
	//	private HtmlSelectOneRadio customizationRadio;
	public List<SelectItem> getSubModuleList() {
		return subModuleList;
	}
	public void setSubModuleList(List<SelectItem> subModuleList) {
		this.subModuleList = subModuleList;
	}
	public HtmlSelectOneMenu getSubModuleSelectMenu() {
		return subModuleSelectMenu;
	}
	public void setSubModuleSelectMenu(HtmlSelectOneMenu subModuleSelectMenu) {
		this.subModuleSelectMenu = subModuleSelectMenu;
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
	//changes done by Bhuvana
	private boolean disable1;
	private String initiatingGroupId;
	private List<SelectItem> initiatingGroupList;
	private HtmlSelectOneMenu initiatingGroupSelectMenu;	
	private Date fromDate;
	private Date toDate;
	private boolean dateStatus;
	private Date mrDate;
	
	public Date getMrDate() {
		return mrDate;
	}
	public void setMrDate(Date mrDate) {
		this.mrDate = mrDate;
	}
	private HtmlInputText fromDateInputText;
	private HtmlInputText toDateInputText;
	
	private HtmlSelectBooleanCheckbox fromDateCheckBox;
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
	public void enableAcceptRejectButtonByCustomization(String customization)
	{
		setDisable1(customization.equalsIgnoreCase("Yes"));
	}
	public boolean isDisable1() {
		return disable1;
	}
	public void setDisable1(boolean disable1) {
		this.disable1 = disable1;
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
	public boolean isDateStatus() {
		return dateStatus;
	}
	public void setDateStatus(boolean dateStatus) {
		this.dateStatus = dateStatus;
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
	//changes done
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
	public String getCustomization() {
		return customization;
	}
	public void setCustomization(String customization) {
		this.customization = customization;
	}
	// Changes completed
	
	public HtmlDataTable getSplitDataTable() {
		return splitDataTable;
	}
	public void setSplitDataTable(HtmlDataTable splitDataTable) {
		this.splitDataTable = splitDataTable;
	}
	public int getProductReqListSize() {
		return productReqListSize;
	}
	public void setProductReqListSize(int productReqListSize) {
		this.productReqListSize = productReqListSize;
	}
	public HtmlDataList getSplitDataList() {
		return splitDataList;
	}
	public void setSplitDataList(HtmlDataList splitDataList) {
		this.splitDataList = splitDataList;
	}
	public MasterRequirementTO getMasterRequirementTO() {
		return masterRequirementTO;
	}
	public void setMasterRequirementTO(MasterRequirementTO masterRequirementTO) {
		this.masterRequirementTO = masterRequirementTO;
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
	public List<MasterRequirementTO> getViewMasterRequirementTOList() {
		return viewMasterRequirementTOList;
	}
	public void setViewMasterRequirementTOList(
			List<MasterRequirementTO> viewMasterRequirementTOList) {
		this.viewMasterRequirementTOList = viewMasterRequirementTOList;
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
	public String getMasterReqStatus() {
		return masterReqStatus;
	}
	public void setMasterReqStatus(String masterReqStatus) {
		this.masterReqStatus = masterReqStatus;
	}
	public String getMasterRequirementId() {
		return masterRequirementId;
	}
	public void setMasterRequirementId(String masterRequirementId) {
		this.masterRequirementId = masterRequirementId;
	}
	public boolean isMasterReqIdStatus() {
		return masterReqIdStatus;
	}
	public void setMasterReqIdStatus(boolean masterReqIdStatus) {
		this.masterReqIdStatus = masterReqIdStatus;
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
	public HtmlSelectBooleanCheckbox getMasterReqIdCheckBox() {
		return masterReqIdCheckBox;
	}
	public void setMasterReqIdCheckBox(HtmlSelectBooleanCheckbox masterReqIdCheckBox) {
		this.masterReqIdCheckBox = masterReqIdCheckBox;
	}
	public HtmlInputText getMasterReqIdInputText() {
		return masterReqIdInputText;
	}
	public void setMasterReqIdInputText(HtmlInputText masterReqIdInputText) {
		this.masterReqIdInputText = masterReqIdInputText;
	}
		
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public HtmlDataTable getViewMasterReqHtmlDataTable() {
		return viewMasterReqHtmlDataTable;
	}
	public void setViewMasterReqHtmlDataTable(
			HtmlDataTable viewMasterReqHtmlDataTable) {
		this.viewMasterReqHtmlDataTable = viewMasterReqHtmlDataTable;
	}
		
	public MasterRequirementTO getUpdateMasterRequirementTO() {
		return updateMasterRequirementTO;
	}
	public void setUpdateMasterRequirementTO(
			MasterRequirementTO updateMasterRequirementTO) {
		this.updateMasterRequirementTO = updateMasterRequirementTO;
	}
	public List<SelectItem> getSolutionList() {
		return solutionList;
	}
	public void setSolutionList(List<SelectItem> solutionList) {
		this.solutionList = solutionList;
	}
	
	
	public String getAcceptanceStatus() {
		return acceptanceStatus;
	}
	public void setAcceptanceStatus(String acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}
	
	public List<ProductRequirementTO> getProductRequirementTOList() {
		return productRequirementTOList;
	}
	public void setProductRequirementTOList(
			List<ProductRequirementTO> productRequirementTOList) {
		this.productRequirementTOList = productRequirementTOList;
	}
	
	
	public List<MasterRequirementAttachmentTO> getAttachmentTOList() {
		return attachmentTOList;
	}
	public void setAttachmentTOList(
			List<MasterRequirementAttachmentTO> attachmentTOList) {
		this.attachmentTOList = attachmentTOList;
	}
	
	
	public HtmlDataTable getAttachmentHtmlDataTable() {
		return attachmentHtmlDataTable;
	}
	public void setAttachmentHtmlDataTable(HtmlDataTable attachmentHtmlDataTable) {
		this.attachmentHtmlDataTable = attachmentHtmlDataTable;
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
	
	public Integer getDisplayPageNumber() {
		return displayPageNumber;
	}
	public void setDisplayPageNumber(Integer displayPageNumber) {
		this.displayPageNumber = displayPageNumber;
	}
	public ViewAndUpdateMasterReqMB() {
		//default constructor stub
		this.masterRequirementTO=null;
		//view and update ---
		this.groupNamesList=new ArrayList<SelectItem>();
		this.modulesList=new ArrayList<SelectItem>();
		this.initiatingGroupList = new ArrayList<SelectItem>();
		//this.masterReqStatus= "0";
		//changes made by sanket mehta
		this.locationList = new ArrayList<SelectItem>();
		this.subModuleList = new ArrayList<SelectItem>();
		this.groupSelectMenu=new HtmlSelectOneMenu();
		this.moduleSelectMenu=new HtmlSelectOneMenu();
		this.statusSelectMenu=new HtmlSelectOneMenu();
		this.customizationSelectMenu= new HtmlSelectOneMenu();
		this.subModuleSelectMenu = new HtmlSelectOneMenu();
		this.verticalSelectMenu=new HtmlSelectOneMenu();
		this.verticalList=new ArrayList<SelectItem>();
		
		this.solutionSelectMenu=new HtmlSelectOneMenu();
		this.solutionList=new ArrayList<SelectItem>();
		
		//changes complete
		// Changes made by Bhuvana 
		this.locationSelectMenu=new HtmlSelectOneMenu();
		this.initiatingGroupSelectMenu=new HtmlSelectOneMenu();
		this.fromDateInputText=new HtmlInputText();
		this.fromDateInputText.setDisabled(true);
		
		this.toDateInputText = new HtmlInputText();
		this.toDateInputText.setDisabled(true);
		
		this.searchByInputText=new HtmlInputText();
		
		// changes complete
		this.masterReqIdInputText=new HtmlInputText();
		this.masterReqIdInputText.setDisabled(true);
		//this.masterRequirementTO.setMrDate(mrDate);
		
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		 
		this.message=null;
		
		// Changes made by Bhuvana
		//this.customization = "No";
		//set default fromDate
		if(getFromDate()== null)
		{
			this.fromDate = new Date(); 
			//this.masterRequirementTO.setMrDate(fromDate);
			
		}
		
		//set default toDate
		if(getToDate()== null)
		{
			this.toDate = new Date();
			//this.masterRequirementTO.setMrDate(fromDate);
		}
				
		//this.masterRequirementTO.setMrDate(fromDate);
		
		this.disable1 = true;
		// Changes completed
	 	
		try
		{
			
			TreeMap<String,String> groupNamesMap = new TreeMap<String, String>();
			groupNamesMap=(TreeMap<String, String>) wrapper.getAllGroupNames();
			HashMap<String,String> groupNamesHashMap = new HashMap<String, String>();
			groupNamesHashMap = sortHashMap(groupNamesMap);	
			for (Map.Entry<String,String> entry: groupNamesHashMap.entrySet())
			{
				groupNamesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			 
			/*Map<String,String> groupNamesMap = new TreeMap<String, String>();
			groupNamesMap= wrapper.getAllGroupNames();
			for (Map.Entry<String,String> entry: groupNamesMap.entrySet())
			{
				groupNamesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );				 
			}*/
			
			TreeMap<String,String> locationMap = new TreeMap<String, String>();
			locationMap=(TreeMap<String, String>) wrapper.getAllLocations();
			HashMap<String,String> locationNamesHashMap = new HashMap<String, String>();
			locationNamesHashMap = sortHashMap(locationMap);	
			for (Map.Entry<String,String> entry: locationNamesHashMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }			
					
			/*Map<String,String> locationMap = new TreeMap<String, String>();
			locationMap = wrapper.getAllLocations();
			for (Map.Entry<String,String> entry: locationMap.entrySet())
			{
				locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}*/
			
			TreeMap<String,String> intiatingGroupMap = new TreeMap<String, String>();
			intiatingGroupMap=(TreeMap<String, String>) wrapper.getAllInitiatingGroups();
			HashMap<String,String> initiatingGroupHashMap = new HashMap<String, String>();
			initiatingGroupHashMap = sortHashMap(intiatingGroupMap);	
			for (Map.Entry<String,String> entry: initiatingGroupHashMap.entrySet())
			{
				initiatingGroupList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }	
				
						
			/*Map<String,String> intiatingGroupMap = new TreeMap<String, String>();
			intiatingGroupMap = wrapper.getAllInitiatingGroups();
			for (Map.Entry<String,String> entry: intiatingGroupMap.entrySet())
			{
				initiatingGroupList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			} */
			
		
			TreeMap<String,String> solutionMap = new TreeMap<String, String>();
			solutionMap=(TreeMap<String, String>) wrapper.getAllSolutions();
			HashMap<String,String> solutionHashMap = new HashMap<String, String>();
			solutionHashMap = sortHashMap(solutionMap);	
			for (Map.Entry<String,String> entry: solutionHashMap.entrySet())
			{
				solutionList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			TreeMap<String,String> verticalMap = new TreeMap<String, String>(); 
			verticalMap=(TreeMap<String, String>) wrapper.getAllVerticals();
			HashMap<String,String> verticalHashMap = new HashMap<String, String>();
			verticalHashMap = sortHashMap(verticalMap);	
			for (Map.Entry<String,String> entry: verticalHashMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
			/*TreeMap<String,String> moduleMap = new TreeMap<String, String>(); 
			moduleMap=(TreeMap<String, String>) wrapper.getAllModules();
			HashMap<String,String> moduleHashMap = new HashMap<String, String>();
			moduleHashMap = sortHashMap(moduleMap);	
			for (Map.Entry<String,String> entry: moduleHashMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }*/
			
			
			/*Map<String,String> moduleMap = new TreeMap<String, String>();
			moduleMap= wrapper.getAllModules();
			for (Map.Entry<String,String> entry: moduleMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				 
			}*/
			
						
		} 
		catch (NoGroupsAvailableException e)
		{
			this.setMessage(e.getMessage());
		} 
		catch (NoSolutionsAvailableException e) 
		{
			this.setMessage(e.getMessage());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
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
	
	//changes done by sanket mehta
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
		public void getAllModulesByVertical(ValueChangeEvent e)
		{
			System.out.println("hello");
			FRMS_Wrapper wrapper = new FRMS_Wrapper();
			TreeMap<String,String> moduleMap = new TreeMap<String, String>();
			String verticalId = this.verticalSelectMenu.getValue().toString();
			
			try {
				/*moduleMap = wrapper.getAllModulesByVertical(verticalId);

				for (Map.Entry<String,String> entry: moduleMap.entrySet())
				{
					modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				}*/
				
				moduleMap=(TreeMap<String, String>) wrapper.getAllModulesByVertical(verticalId);
				HashMap<String,String> moduleHashMap = new HashMap<String, String>();
				moduleHashMap = sortHashMap(moduleMap);	
				for (Map.Entry<String,String> entry: moduleHashMap.entrySet())
				{
					modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
			    }
				
				
				
			} catch (NoSubModuleAvailableForGivenModuleException e1) {
	 
				//e1.printStackTrace();
				this.setMessage(e1.getMessage());
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
				this.setMessage(e1.getMessage());
			}
		}
		
		// get all verticals by solution starts
		public void getAllVerticalsBySolution(ValueChangeEvent e)
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();
			TreeMap<String,String> verticalMap = new TreeMap<String, String>();
			String solutionId = this.solutionSelectMenu.getValue().toString();
			
			try {
				verticalMap=(TreeMap<String, String>) wrapper.getAllVerticalsBySolution(solutionId);
				HashMap<String,String> verticalHashMap = new HashMap<String, String>();
				verticalHashMap = sortHashMap(verticalMap);	
				for (Map.Entry<String,String> entry: verticalHashMap.entrySet())
				{
					verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
			    }
				
				
				/*verticalMap = wrapper.getAllVerticalsBySolution(solutionId);

				for (Map.Entry<String,String> entry: verticalMap.entrySet())
				{
					verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				}*/
			} catch (NoSubModuleAvailableForGivenModuleException e1) {
	 
				//e1.printStackTrace();
				this.setMessage(e1.getMessage());
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
				this.setMessage(e1.getMessage());
			}
		}
		//changes completed
		
		
	public void enableDateFields(ValueChangeEvent e)
	{
		boolean flag=Boolean.parseBoolean(e.getNewValue().toString());
		if(!masterReqIdStatus)
		{
			this.fromDateInputText.setDisabled(!flag);
			this.toDateInputText.setDisabled(!flag);
		}
	}
	//changes completed
	
	public void selectMasterRequirementId(ValueChangeEvent e)
	{
		this.masterRequirementTO=null;
		this.message=null;
		this.viewMasterRequirementTOList=new ArrayList<MasterRequirementTO>();
		boolean flag=Boolean.parseBoolean(e.getNewValue().toString());
		this.groupSelectMenu.setDisabled(flag);
		this.moduleSelectMenu.setDisabled(flag); 
		//changes done by Bhuvana starts
		this.subModuleSelectMenu.setDisabled(flag);
		//changes completed
		this.statusSelectMenu.setDisabled(flag);
		// Changes made by Bhuvana start
		this.locationSelectMenu.setDisabled(flag);
		this.initiatingGroupSelectMenu.setDisabled(flag);
		this.customizationSelectMenu.setDisabled(flag);
		this.solutionSelectMenu.setDisabled(flag);
		this.verticalSelectMenu.setDisabled(flag);
		
		this.groupId="0";
		this.moduleId="0";
		this.locationId="0";
		
	    this.masterReqStatus="0";
		this.masterReqIdInputText.setValue(null);
		this.masterReqIdInputText.setDisabled(!flag);
		
		//changes done by sanket mehta
		this.fromDateCheckBox.setDisabled(flag);
		if(dateStatus)
		{
			//		this.fromDateInputText.setValue(null);
			this.fromDateInputText.setDisabled(flag);
			//		this.toDateInputText.setValue(null);
			this.toDateInputText.setDisabled(flag);
		}
		// Changes completed
	}
	
	
	public void searchMasterReqByTitleAndDesc(ValueChangeEvent e)
	{
		this.masterRequirementTO=null;
		this.message=null;
		this.viewMasterRequirementTOList=new ArrayList<MasterRequirementTO>();
		boolean flag=Boolean.parseBoolean(e.getNewValue().toString());
		this.groupSelectMenu.setDisabled(flag);
		this.moduleSelectMenu.setDisabled(flag); 
		//changes done by Bhuvana starts
		this.subModuleSelectMenu.setDisabled(flag);
		//changes completed
		this.statusSelectMenu.setDisabled(flag);
		// Changes made by Bhuvana start
		this.locationSelectMenu.setDisabled(flag);
		this.initiatingGroupSelectMenu.setDisabled(flag);
		this.customizationSelectMenu.setDisabled(flag);
		
		this.groupId="0";
		this.moduleId="0";
		this.locationId="0";
		
	    this.masterReqStatus="0";
		this.masterReqIdInputText.setValue(null);
		this.masterReqIdInputText.setDisabled(!flag);
		
		//changes done by sanket mehta
		this.fromDateCheckBox.setDisabled(flag);
		if(dateStatus)
		{
			//		this.fromDateInputText.setValue(null);
			this.fromDateInputText.setDisabled(flag);
			//		this.toDateInputText.setValue(null);
			this.toDateInputText.setDisabled(flag);
		}
		// Changes completed
	}

	public String viewMasterRequirementsDetails()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		this.viewMasterRequirementTOList= new ArrayList<MasterRequirementTO>();
 
		this.masterRequirementTO=null;
		this.message=null;
		int flag=0;
		this.pageMessage=null;
 
		try
		{
			/*if(this.allMasterReqStatus == true)
			{
				this.viewMasterRequirementTOList=wrapper.getAllMasterRequirements();
			}
			else*/
			if(this.masterReqIdStatus){
				MasterRequirementTO masterTO=wrapper.getMasterReqDetailsById(this.masterRequirementId);
				this.viewMasterRequirementTOList.add(masterTO);
			}
			/*if(this.searchMasterReqByTitleAndDesc){
				MasterRequirementTO masterTO=wrapper.getMasterReqDetailsById(this.searchBy);
				this.viewMasterRequirementTOList.add(masterTO);
			}*/
			
			/*else if(!groupId.equalsIgnoreCase("0") && !moduleId.equalsIgnoreCase("0") && !masterReqStatus.equalsIgnoreCase("0"))
			{

				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("groupId",this.groupId,"moduleId", this.moduleId,"status", this.masterReqStatus) ;
			}
			else if(!groupId.equalsIgnoreCase("0") && !moduleId.equalsIgnoreCase("0"))
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("groupId",this.groupId,"moduleId", this.moduleId) ;
			}
			else if (!moduleId.equalsIgnoreCase("0") && !masterReqStatus.equalsIgnoreCase("0")) 
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("moduleId", this.moduleId,"status", this.masterReqStatus) ;
			}
			else if (!groupId.equalsIgnoreCase("0") && !masterReqStatus.equalsIgnoreCase("0")) 
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("groupId",this.groupId,"status", this.masterReqStatus) ;
			}*//*
			else if(!groupId.equalsIgnoreCase("0") && !solutionId.equalsIgnoreCase("0"))
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("groupId",this.groupId,"solutionId",this.solutionId) ;
			}
			else if(!groupId.equalsIgnoreCase("0") && !solutionId.equalsIgnoreCase("0") && !verticalId.equalsIgnoreCase("0"))
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("groupId",this.groupId,"solutionId",this.solutionId,"verticalId",this.verticalId);
			}
			else if(!groupId.equalsIgnoreCase("0") && !solutionId.equalsIgnoreCase("0") && !verticalId.equalsIgnoreCase("0") && !moduleId.equalsIgnoreCase("0"))
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("groupId",this.groupId,"solutionId",this.solutionId,"verticalId",this.verticalId,"moduleId",this.moduleId);
			}
			else if(!groupId.equalsIgnoreCase("0") && !verticalId.equalsIgnoreCase("0"))
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("groupId",this.groupId,"verticalId",this.verticalId);
			}
			else if(!solutionId.equalsIgnoreCase("0") && !verticalId.equalsIgnoreCase("0"))
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("solutionId",this.solutionId,"verticalId",this.verticalId);
			}
			else if(!groupId.equalsIgnoreCase("0") && !moduleId.equalsIgnoreCase("0"))
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("groupId",this.groupId,"moduleId",this.moduleId);
			}
			else if(!verticalId.equalsIgnoreCase("0") && !moduleId.equalsIgnoreCase("0"))
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("verticalId",this.verticalId,"moduleId",this.moduleId);
			}
			else if(!masterReqStatus.equalsIgnoreCase("0") && !solutionId.equalsIgnoreCase("0"))
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("status",this.masterReqStatus,"solutionId",this.solutionId);
			}
			else if(!groupId.equalsIgnoreCase("0"))
			{
				System.out.println("groupid: "+groupId);
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("groupId",this.groupId) ;
			}
			else if(!groupId.equalsIgnoreCase("0") && !masterReqStatus.equalsIgnoreCase("0"))
			{
				System.out.println("group id: "+groupId+" and requriement status: "+masterReqStatus);
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("groupId",this.groupId, "status",this.masterReqStatus) ;
			}
			else if(!solutionId.equalsIgnoreCase("0"))
			{
				System.out.println("viewMasterRequirementTOList: "+viewMasterRequirementTOList.size());
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("solutionId",this.solutionId) ;
			}
			else if(!verticalId.equalsIgnoreCase("0"))
			{
				System.out.println("vertical id: "+verticalId);
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("verticalId",this.verticalId) ;
			}
			else if(!moduleId.equalsIgnoreCase("0"))
			{
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("moduleId",this.moduleId) ;
			}
			else if(!masterReqStatus.equalsIgnoreCase("0"))
			{ 
				System.out.println("viewMasterRequirementTOList: "+viewMasterRequirementTOList.size());
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements("status",this.masterReqStatus) ;
				System.out.println("viewMasterRequirementTOList: "+viewMasterRequirementTOList.size());
			}
			List<String> arguementList=new ArrayList<String>();
			if(dateStatus)
			{
				Date frmDate = this.fromDate;
				Date tDate = this.toDate;
//				if(this.fromDate != null && this.toDate != null)
				if(frmDate != null && tDate != null)
				{
					//check for the validity of dates
					if(this.fromDate.after(this.toDate))
					{
//						throw new InvalidDateException();
//						System.out.println("date is not proper");
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
//					System.out.println("date is not proper");
					throw new InvalidDateException();
//					return "fail";
				}
				
			}
			if(!arguementList.isEmpty())
			{
				String arguementString=arguementList.toString(); 
				String[] arguementArray=arguementString.substring(1, arguementString.length()-1).split(",");
				 
				for (int i=0;i<arguementArray.length;i++) {
					arguementArray[i]=arguementArray[i].replaceAll(" ", "");

				}
				this.viewMasterRequirementTOList=wrapper.getMasterRequirements(arguementArray);
			}
			
			else
			{
				flag=1;
				this.setMessage("Please Select an Option !");
			}*/
			else 
			{
				List<String> arguementList=new ArrayList<String>();
				if(!this.groupId.equals("0") )
				{
					arguementList.add("groupId");
					arguementList.add(this.groupId);
				}
				
				//changes done by sanket mehta
				if(!this.verticalId.equals("0"))
				{
					arguementList.add("verticalId");
					arguementList.add(this.verticalId);
				}
				//changes completed
				if(!this.masterReqStatus.equals("0"))
				{
					arguementList.add("status");
					arguementList.add(this.masterReqStatus);
				}
				if(!this.customization.equals("0") && (this.masterReqStatus.equals("0") || this.masterReqStatus.equals("Entered")))
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
				if(!this.moduleId.equals("0"))
				{
					arguementList.add("moduleId");
					arguementList.add(this.moduleId);
				}
				if(!this.solutionId.equals("0"))
				{
					arguementList.add("solutionId");
					arguementList.add(this.solutionId);
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
					Date frmDate = this.fromDate;
					Date tDate = this.toDate;
//					if(this.fromDate != null && this.toDate != null)
					if(frmDate != null && tDate != null)
					{
						//check for the validity of dates
						if(this.fromDate.after(this.toDate))
						{
//							throw new InvalidDateException();
//							System.out.println("date is not proper");
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
//						System.out.println("date is not proper");
						throw new InvalidDateException();
//						return "fail";
					}
					
				}
				//changes complete
				if(!arguementList.isEmpty())
				{
					String arguementString=arguementList.toString(); 
					//String[] arguementArray = arguementList.toArray(new String[arguementList.size()]); 
					String[] arguementArray=arguementString.substring(1, arguementString.length()-1).split(",");
					 
					for (int i=0;i<arguementArray.length;i++) {
						arguementArray[i]=arguementArray[i].trim();//replaceAll(" ", "");

					}
					this.viewMasterRequirementTOList=wrapper.getMasterRequirements(arguementArray);
				}
				//	Changes made by Sanket ends
			
			    else
				{
					flag=1;
					this.setMessage("Please Select an Option !");
				}
				
			}
			
			if(flag==0)
			{
				this.pageNumber=1;
				this.rowsPerPage=10;
				int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
				int endRowNumber=this.pageNumber*this.rowsPerPage;
				if(endRowNumber>=this.viewMasterRequirementTOList.size())
				{
					endRowNumber=this.viewMasterRequirementTOList.size();
				}
			
				this.viewMasterReqPerPageList=this.viewMasterRequirementTOList.subList(startRowNumner, endRowNumber);
				this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.viewMasterRequirementTOList.size();
				this.pageNumberList=new ArrayList<SelectItem>();
				int totalPageNumbers=(this.viewMasterRequirementTOList.size()-1)/10;
				totalPageNumbers++;
				for(Integer i=1;i<=totalPageNumbers;i++)
				{
					this.pageNumberList.add(new SelectItem(i.toString(),i.toString()));
				}
			}

			return "view";
		}
		catch (NoMasterReqAvailableException e)
		{	
			e.printStackTrace();
			this.setMessage(e.getMessage());
			return"fail";
		}
		//changes added by sanket mehta
		catch(InvalidDateException e)
		{	
			this.setMessage(e.getMessage());
			return"fail";
		}
		//changes completed
		catch (Exception e)
		{
			e.printStackTrace();
			this.setMessage(e.getMessage());
			
			return"fail";
		} 
	}
	public String showNextRecord()
	{
		this.message=null;
		this.pageNumber++;
		int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
		int endRowNumber=(this.pageNumber*this.rowsPerPage);
		if(startRowNumner<viewMasterRequirementTOList.size())
		{
			if(endRowNumber>=this.viewMasterRequirementTOList.size())
			{
				endRowNumber=this.viewMasterRequirementTOList.size();
			}
			
			this.viewMasterReqPerPageList=this.viewMasterRequirementTOList.subList(startRowNumner, endRowNumber);
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.viewMasterRequirementTOList.size();
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
		this.message=null;
		if(pageNumber>1)
		{
			this.pageNumber--;
			int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
			int endRowNumber=(this.pageNumber*this.rowsPerPage);
			
			
			this.viewMasterReqPerPageList=this.viewMasterRequirementTOList.subList(startRowNumner, endRowNumber);
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.viewMasterRequirementTOList.size();
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
			this.message=ex.getMessage();
		}

	}

	public String getMasterReqDetails( )
	{
		this.attachmentTOList=new ArrayList<MasterRequirementAttachmentTO>();
		try
		{
			this.message=null;
			this.masterRequirementTO=(MasterRequirementTO)this.viewMasterReqHtmlDataTable.getRowData();
//			System.out.println("customization before loading the page " +  masterRequirementTO.getCustomization());
//			System.out.println("mrdate: " +  masterRequirementTO.getMrDate().toString());
			this.enableAcceptRejectButtonByCustomization(masterRequirementTO.getCustomization());
			this.attachmentTOList=new FRMS_Wrapper().getAttachmentsByMasterReqId(this.masterRequirementTO.getMasterRequirementId());
			return "viewInDetails";
		}
		catch(NoAttachmentFoundException e)
		{
			
			return "viewInDetails";
			
		}
		catch(Exception e)
		{
			return "fail";
		}
		

	}
	
	public String prepareUpdate()
	{
		try
		{
			this.message=null;
			updateMasterRequirementTO=new MasterRequirementTO();
			updateMasterRequirementTO.setContactPerson(masterRequirementTO.getContactPerson());
			updateMasterRequirementTO.setDescription(masterRequirementTO.getDescription());
			updateMasterRequirementTO.setExternalReferenceNumber(masterRequirementTO.getExternalReferenceNumber());
			updateMasterRequirementTO.setGroupId(masterRequirementTO.getGroupId());
			updateMasterRequirementTO.setGroupName(masterRequirementTO.getGroupName());
			updateMasterRequirementTO.setMasterRequirementId(masterRequirementTO.getMasterRequirementId());
			updateMasterRequirementTO.setMasterRequirementTitle(masterRequirementTO.getMasterRequirementTitle());
			//updateMasterRequirementTO.setModuleId(masterRequirementTO.getModuleId());
			//updateMasterRequirementTO.setModuleName(masterRequirementTO.getModuleName());
			updateMasterRequirementTO.setVerticalId(masterRequirementTO.getVerticalId());
			updateMasterRequirementTO.setVerticalName(masterRequirementTO.getVerticalName());
			updateMasterRequirementTO.setOwnerEmployeeId(masterRequirementTO.getOwnerEmployeeId());
			updateMasterRequirementTO.setSolutionId(masterRequirementTO.getSolutionId());
			updateMasterRequirementTO.setSolutionName(masterRequirementTO.getSolutionName());
			System.out.println("solution Name: "+masterRequirementTO.getSolutionName());
			updateMasterRequirementTO.setStatus(masterRequirementTO.getStatus());
			updateMasterRequirementTO.setCustomization(masterRequirementTO.getCustomization());
			
			//changes made by sanket mehta
			updateMasterRequirementTO.setMrDate(masterRequirementTO.getMrDate());
			//changes completed
			
			//changes done by Bhuvana starts
			updateMasterRequirementTO.setModuleId(masterRequirementTO.getModuleId());
			System.out.println("module id in View/Update MR MB: "+masterRequirementTO.getModuleId());
			updateMasterRequirementTO.setModuleName(masterRequirementTO.getModuleName());
			System.out.println("module name: "+masterRequirementTO.getModuleName());
			//changes completed
			
					
			solutionList = new ArrayList<SelectItem>();			
			TreeMap<String,String> solutionMap = new TreeMap<String, String>();			
			solutionMap= (TreeMap<String, String>) new FRMS_Wrapper().getAllSolutions();
			HashMap<String,String> solutionNamesHashMap = new HashMap<String, String>();
			solutionNamesHashMap = sortHashMap(solutionMap);
			
			for (Map.Entry<String,String> entry: solutionNamesHashMap.entrySet())
			{
				solutionList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}			
			/*Map<String,String> solutionMap = new TreeMap<String, String>();
			solutionMap=new FRMS_Wrapper().getAllSolutions();
			for (Map.Entry<String,String> entry: solutionMap.entrySet())
			{
				solutionList.add(new SelectItem( entry.getKey(),entry.getValue() ) );

			}*/
			
			verticalList = new ArrayList<SelectItem>();
			TreeMap<String,String> verticalMap = new TreeMap<String, String>();			
			verticalMap= (TreeMap<String, String>) new FRMS_Wrapper().getAllVerticals();
			HashMap<String,String> verticalHashMap = new HashMap<String, String>();
			verticalHashMap = sortHashMap(verticalMap);
			
			for (Map.Entry<String,String> entry: verticalHashMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
			/*Map<String,String> verticalMap = new TreeMap<String, String>();
			verticalMap=new FRMS_Wrapper().getAllVerticals();
			for (Map.Entry<String,String> entry: verticalMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );

			}*/
			
			this.modulesList=new ArrayList<SelectItem>();
			TreeMap<String,String> moduleNamesMap = new TreeMap<String, String>();			
			moduleNamesMap= (TreeMap<String, String>) new FRMS_Wrapper().getAllModulesByVertical(this.updateMasterRequirementTO.getVerticalId());
			HashMap<String,String> moduleHashMap = new HashMap<String, String>();
			moduleHashMap = sortHashMap(moduleNamesMap);
			
			for (Map.Entry<String,String> entry: moduleHashMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
			
			/*Map<String,String> moduleNamesMap = new TreeMap<String, String>();
			moduleNamesMap= new FRMS_Wrapper().getAllModulesByVertical(this.updateMasterRequirementTO.getVerticalId());
			System.out.println("Solution Id: "+this.updateMasterRequirementTO.getSolutionId());
			for (Map.Entry<String,String> entry: moduleNamesMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) );				 
			}*/
			
			return "update";
		}
		catch (Exception e) {
			e.printStackTrace();
			this.message=e.getMessage();
			return "fail";
		}
	}
	 
	//update master requirement
	public String updateMasterRequirement()
	{
		try
		{
			FRMS_Wrapper wrapper=new FRMS_Wrapper();
			wrapper.updateMasterRequirement(this.updateMasterRequirementTO);
			this.masterRequirementTO=this.updateMasterRequirementTO;
			MasterRequirementAttachmentTO newAttachmentTO=new MasterRequirementAttachmentTO();
			String masterReqId=masterRequirementTO.getMasterRequirementId();
			newAttachmentTO.setMasterRequirementId(masterReqId);
			String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("MR-Attachment");
			if(uploadFile1!=null)
			{
			
				newAttachmentTO.setFileName(uploadFile1.getName());
				newAttachmentTO=wrapper.uploadMasterRequirementAttachment(newAttachmentTO);
				
				String fileName= filePath+newAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(uploadFile1.getBytes());
				outStream.close();
				 
			}
			if(uploadFile2!=null)
			{
				
				newAttachmentTO.setFileName(uploadFile2.getName());
				newAttachmentTO.setMasterRequirementId(masterReqId);
				newAttachmentTO=wrapper.uploadMasterRequirementAttachment(newAttachmentTO);
				String fileName= filePath+newAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(uploadFile2.getBytes());
				outStream.close();
				 
			}
			if(uploadFile3!=null)
			{
				
				newAttachmentTO.setFileName(uploadFile3.getName());
				newAttachmentTO.setMasterRequirementId(masterReqId);
				newAttachmentTO=wrapper.uploadMasterRequirementAttachment(newAttachmentTO);
				String fileName= filePath+newAttachmentTO.getFileName();
				FileOutputStream outStream=new FileOutputStream(fileName);
				outStream.write(uploadFile3.getBytes());
				outStream.close();
				 
			}
			//changes
			this.enableAcceptRejectButtonByCustomization(masterRequirementTO.getCustomization());
			//changes complete
			this.message="Master Requirement Updated Successfully";
			this.attachmentTOList=new FRMS_Wrapper().getAttachmentsByMasterReqId(this.masterRequirementTO.getMasterRequirementId());
			return "success";
		}
		catch(NoAttachmentFoundException e)
		{
			
			return "success";
			
		}
		catch(Exception e)
		{
			this.message=e.getMessage();
			return "fail";
		}

	}
	
	

	/*public void getModuleListOfSelectedSolution(ValueChangeEvent event)
	{
		String obj=(String)event.getNewValue();
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		this.message=null;
		modulesList = new ArrayList<SelectItem>();
		Map<String,String> modulesMap = new TreeMap<String, String>();

		try 
		{
			modulesMap= wrapper.getAllModulesBySolution(obj);
			for (Map.Entry<String,String> entry: modulesMap.entrySet())
			{
				modulesList.add(new SelectItem( entry.getKey(),entry.getValue() ) ); 
				}
		} 
		catch (NoModulesAvailableForGivenSolutionException e) 
		{
			this.setMessage(e.getMessage());
		}
		catch (Exception e) 
		{
			this.setMessage(e.getMessage());
		}
	}*/

	//Accept/reject
	public String acceptRejectMasterRequirement()
	{
		this.acceptanceStatus=null;
		this.productRequirementTOList=new ArrayList<ProductRequirementTO>();
		return "acceptMR";
	}
	
	public void statusChange(ValueChangeEvent event)
	{
		this.productRequirementTOList=new ArrayList<ProductRequirementTO>();
		ProductRequirementTO productRequirementTO=new ProductRequirementTO();
		if(event.getNewValue()!=null)
		{

			if(event.getNewValue().toString().equalsIgnoreCase("Accepted"))
			{
				productRequirementTO.setMasterRequirementId(this.masterRequirementTO.getMasterRequirementId());
				productRequirementTO.setMasterRequirementTitle(this.masterRequirementTO.getMasterRequirementTitle());
				productRequirementTO.setMasterRequirementDescription(this.masterRequirementTO.getDescription());
				productRequirementTO.setGroupId(this.masterRequirementTO.getGroupId());
				productRequirementTO.setGroupName(this.masterRequirementTO.getGroupName());
				productRequirementTO.setModuleName(this.masterRequirementTO.getModuleName());				
				productRequirementTO.setProductRequirementDescription(this.masterRequirementTO.getDescription());
				productRequirementTO.setProductRequirementTitle(this.masterRequirementTO.getMasterRequirementTitle());
				productRequirementTO.setApprovedStatus("Approved");
				this.productReqListSize=1;
			}
		}
		this.productRequirementTOList.add(productRequirementTO);
	}
	
	public String splitRequirement()
	{
		ProductRequirementTO productRequirementTO=new ProductRequirementTO();
		productRequirementTO.setMasterRequirementId(this.masterRequirementTO.getMasterRequirementId());
		productRequirementTO.setMasterRequirementTitle(this.masterRequirementTO.getMasterRequirementTitle());
		productRequirementTO.setMasterRequirementDescription(this.masterRequirementTO.getDescription());
		productRequirementTO.setGroupId(this.masterRequirementTO.getGroupId());
		productRequirementTO.setGroupName(this.masterRequirementTO.getGroupName());
		productRequirementTO.setModuleName(this.masterRequirementTO.getModuleName());
		productRequirementTO.setProductRequirementDescription(this.masterRequirementTO.getDescription());
		productRequirementTO.setProductRequirementTitle(this.masterRequirementTO.getMasterRequirementTitle());
		productRequirementTO.setApprovedStatus("Approved");

		this.productRequirementTOList.add(productRequirementTO);
		return "split";
	}
	
	public String removeSplitReqruiement()
	{
		int size=this.productRequirementTOList.size();
		this.productRequirementTOList.remove(size-1);
		
		return "split";
	}
	
	
	public String addToProductRequirement()
	{
		this.message=null;
		this.message=null;
		if(!this.acceptanceStatus.equals("Accepted"))
		{
			if(this.masterRequirementTO.getComments()==null || this.masterRequirementTO.getComments().equals(""))
			{
				 
				FacesMessage message=new FacesMessage("Please Enter Comments","Please Enter Comments");
				FacesContext.getCurrentInstance().addMessage("Comment Field is empty", message);
				return "fail";  

			}
			
		}
		try
		{
			if(this.acceptanceStatus.equals("Accepted"))
			{
				this.masterRequirementTO.setComments("Accepted in product scope");
			}
			this.masterRequirementTO.setStatus(this.acceptanceStatus);
			
			// Changes made by sanket
//			this.masterRequirementTO.setCustomization(this.masterRequirementTO.getCustomization());
			System.out.println(" ********customizationMB********  "+this.masterRequirementTO.getCustomization());
			// changes completed
					
			FRMS_Wrapper wrapper=new FRMS_Wrapper();
			wrapper.updateMasterRequirement(this.masterRequirementTO);
			this.message="Master Requirement Updated successfully with status 'Rejected'";
			 
			if(this.acceptanceStatus.equals("Abandoned"))
			{
				wrapper.abandonMasterRequirement(masterRequirementTO);
				this.message="Master Requirement Updated successfully with status 'Abandoned'";
			}

			return "added";
		}
		catch(Exception e)
		{
			
			this.message=e.getMessage();
			return "fail";
		}
	}
	
	
	 
	public String saveAllSplitedProductRequirement()
	{
		try
		{
			FRMS_Wrapper wrapper=new FRMS_Wrapper();
			this.masterRequirementTO.setStatus(this.acceptanceStatus);
			wrapper.updateMasterRequirement(this.masterRequirementTO);
			
			
			for (ProductRequirementTO requirementTO : this.productRequirementTOList) {
				requirementTO=wrapper.saveNewProductRequirement(requirementTO);
			}
			
			this.message="Product Requriement(s) Created successfully!";
			return "added";
		}
		catch(Exception e)
		{
			
			this.message=e.getMessage();
			return "fail";
		}
	}
	
	public String completeSaveRequirement()
	{
		for (ProductRequirementTO requirementTO : this.productRequirementTOList) 
		{
			if(requirementTO.getProductRequirementId()==null)
			{
				this.message="Please save all the product Requirements and then click 'ok'";
				return "fail";
			}
			
		}
		return "added";
	}
	
	public String cancelAddToProductRequirement()
	{
		try
		{
			//this.masterRequirementTOList=new FRMS_Wrapper().getAllMasterRequirements();
			//this.acceptanceStatus=null;
			return "cancel";
		}
		catch(Exception e)
		{
			this.message=e.getMessage();
			return "fail";
		}
	}
	public String downloadMasterReqList()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		
		try
		{
			String fName=wrapper.downloadMasterRequirementsReport(this.viewMasterRequirementTOList);
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
			this.setMessage(e.getMessage());
			return"fail";
		} 
		catch (Exception e)
		{
			this.setMessage(e.getMessage());
			//
			return"fail";		
		}
	}
	
	public String downloadAttachment()
	{
		try
		{
			MasterRequirementAttachmentTO attachmentTO=(MasterRequirementAttachmentTO)attachmentHtmlDataTable.getRowData();
			String filePath= FacesContext.getCurrentInstance().getExternalContext().getInitParameter("MR-Attachment");
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



}
