package com.infy.managedBeans;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.myfaces.custom.datalist.HtmlDataList;
import org.apache.myfaces.custom.tabbedpane.HtmlPanelTabbedPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.infy.TOclasses.MasterRequirementTO;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.exceptions.NoProductReqAvailableException;
import com.infy.exceptions.NoSubModuleAvailableForGivenModuleException;
import com.infy.wrapper.FRMS_Wrapper;

public class ViewAndUpdateProductReqMB {
	private List<SelectItem> versionList=null;
	private List<SelectItem> groupList=null;
	private List<SelectItem> moduleList=null;
	private List<SelectItem> requirementList=null;
	private String productRequirementId;
	private String masterRequirementId;
	private String version;
	private String moduleId;
	private String groupId;
	private String assignedToEmpId;
	private String message;
	
	private List<ProductRequirementTO> productRequirementTOList;
	private HtmlDataTable viewProductReqDataTable;
	private ProductRequirementTO productRequirementTO;
	private ProductRequirementTO updateProductReqTO;
	private List<ProductRequirementTO> productReqList;
	private int productReqListSize;
	private Boolean masterReqFlag;
	private Boolean productReqFlag;
	private Boolean unAssignedFlag;
	private HtmlSelectOneMenu groupSelectMenu;
	private HtmlSelectOneMenu moduleSelectMenu;
	private HtmlSelectOneMenu versionSelectMenu;
	private HtmlInputText masterRequirementInputText;
	private HtmlInputText productRequirementInputText;
	private HtmlInputText assignedToInputText;
	private HtmlSelectBooleanCheckbox productCheckBox;
	private HtmlSelectBooleanCheckbox masterCheckBox;
	private HtmlSelectBooleanCheckbox unAssignedCheckBox;
	private Integer pageNumber;
	private Integer rowsPerPage;
	private List<SelectItem> pageNumberList;
	private List<ProductRequirementTO> viewProductReqPerPageList;
	private Integer displayPageNumber;
	private String pageMessage;
	
	private HtmlDataList splitDataList;	
	
	// Changes made by Sanket
	private List<SelectItem> locationList=null;
	private String locationId;
	private HtmlSelectOneMenu locationSelectMenu;
	private String initiatingGroupId;
	private List<SelectItem> initiatingGroupList = null;
	private HtmlSelectOneMenu initiatingGroupSelectMenu;
	private HtmlSelectOneMenu subModuleSelectMenu;
	private List<SelectItem> subModuleList;
	private String subModuleId;
	private String verticalId;
	private HtmlSelectOneMenu verticalSelectMenu;
	private List<SelectItem> verticalList = null;
	private List<SelectItem> localizationList = null;
	private String localizationId;
	
	
	//changes done by Bhuvana
	private String solutionId;
	private List<SelectItem> solutionList;
	private HtmlSelectOneMenu solutionSelectMenu;
	private HtmlSelectOneMenu localizationSelectMenu;
	
	private List<SelectItem> loginList;
	private HtmlSelectOneMenu loginSelectMenu;
	
	public HtmlSelectOneMenu getLoginSelectMenu() {
		return loginSelectMenu;
	}
	public void setLoginSelectMenu(HtmlSelectOneMenu loginSelectMenu) {
		this.loginSelectMenu = loginSelectMenu;
	}
	public List<SelectItem> getLoginList() {
		return loginList;
	}
	public void setLoginList(List<SelectItem> loginList) {
		this.loginList = loginList;
	}
	public List<SelectItem> getLocalizationList() {
		return localizationList;
	}
	public void setLocalizationList(List<SelectItem> localizationList) {
		this.localizationList = localizationList;
	}
	public String getLocalizationId() {
		return localizationId;
	}
	public void setLocalizationId(String localizationId) {
		this.localizationId = localizationId;
	}
	public HtmlSelectOneMenu getLocalizationSelectMenu() {
		return localizationSelectMenu;
	}
	public void setLocalizationSelectMenu(HtmlSelectOneMenu localizationSelectMenu) {
		this.localizationSelectMenu = localizationSelectMenu;
	}
	public String getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	}
	public List<SelectItem> getSolutionList() {
		return solutionList;
	}
	public void setSolutionList(List<SelectItem> solutionList) {
		this.solutionList = solutionList;
	}
	public HtmlSelectOneMenu getSolutionSelectMenu() {
		return solutionSelectMenu;
	}
	public void setSolutionSelectMenu(HtmlSelectOneMenu solutionSelectMenu) {
		this.solutionSelectMenu = solutionSelectMenu;
	}
	public String getVerticalId() {
		return verticalId;
	}
	public void setVerticalId(String verticalId) {
		this.verticalId = verticalId;
	}
	public HtmlSelectOneMenu getVerticalSelectMenu() {
		return verticalSelectMenu;
	}
	public void setVerticalSelectMenu(HtmlSelectOneMenu verticalSelectMenu) {
		this.verticalSelectMenu = verticalSelectMenu;
	}
	public List<SelectItem> getVerticalList() {
		return verticalList;
	}
	public void setVerticalList(List<SelectItem> verticalList) {
		this.verticalList = verticalList;
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
	public String getSubModuleId() {
		return subModuleId;
	}
	public void setSubModuleId(String subModuleId) {
		this.subModuleId = subModuleId;
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
	public HtmlSelectOneMenu getLocationSelectMenu() {
		return locationSelectMenu;
	}
	public void setLocationSelectMenu(HtmlSelectOneMenu locationSelectMenu) {
		this.locationSelectMenu = locationSelectMenu;
	}
	// Changes completed
	public HtmlDataList getSplitDataList() {
		return splitDataList;
	}
	public void setSplitDataList(HtmlDataList splitDataList) {
		this.splitDataList = splitDataList;
	}
	public List<SelectItem> getVersionList() {
		
		return versionList;
	}
	public void setVersionList(List<SelectItem> versionList) {
		this.versionList = versionList;
	}
	public List<SelectItem> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<SelectItem> groupList) {
		this.groupList = groupList;
	}
	public List<SelectItem> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<SelectItem> moduleList) {
		this.moduleList = moduleList;
	}
	public List<SelectItem> getRequirementList() {
		return requirementList;
	}
	public void setRequirementList(List<SelectItem> requirementList) {
		this.requirementList = requirementList;
	}
	public String getProductRequirementId() {
		return productRequirementId;
	}
	public void setProductRequirementId(String productRequirementId) {
		this.productRequirementId = productRequirementId;
	}
	public String getMasterRequirementId() {
		return masterRequirementId;
	}
	public void setMasterRequirementId(String masterRequirementId) {
		this.masterRequirementId = masterRequirementId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getAssignedToEmpId() {
		return assignedToEmpId;
	}
	public void setAssignedToEmpId(String assignedToEmpId) {
		this.assignedToEmpId = assignedToEmpId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	public ProductRequirementTO getUpdateProductReqTO() {
		return updateProductReqTO;
	}
	public void setUpdateProductReqTO(ProductRequirementTO updateProductReqTO) {
		this.updateProductReqTO = updateProductReqTO;
	}
	public ProductRequirementTO getProductRequirementTO() {
		return productRequirementTO;
	}
	public void setProductRequirementTO(ProductRequirementTO productRequirementTO) {
		this.productRequirementTO = productRequirementTO;
	}
	public HtmlDataTable getViewProductReqDataTable() {
		return viewProductReqDataTable;
	}
	public void setViewProductReqDataTable(HtmlDataTable viewProductReqDataTable) {
		this.viewProductReqDataTable = viewProductReqDataTable;
	}
	public List<ProductRequirementTO> getProductRequirementTOList() {
		return productRequirementTOList;
	}
	public void setProductRequirementTOList(
			List<ProductRequirementTO> productRequirementTOList) {
		this.productRequirementTOList = productRequirementTOList;
	}
	
	
	
	public List<ProductRequirementTO> getProductReqList() {
		return productReqList;
	}
	public void setProductReqList(List<ProductRequirementTO> productReqList) {
		this.productReqList = productReqList;
	}
	public int getProductReqListSize() {
		return productReqListSize;
	}
	public void setProductReqListSize(int productReqListSize) {
		this.productReqListSize = productReqListSize;
	}
	
	
	public Boolean getMasterReqFlag() {
		return masterReqFlag;
	}
	public void setMasterReqFlag(Boolean masterReqFlag) {
		this.masterReqFlag = masterReqFlag;
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
	
	public HtmlInputText getMasterRequirementInputText() {
		return masterRequirementInputText;
	}
	public void setMasterRequirementInputText(
			HtmlInputText masterRequirementInputText) {
		this.masterRequirementInputText = masterRequirementInputText;
	}
	
	 
	public Boolean getProductReqFlag() {
		return productReqFlag;
	}
	public void setProductReqFlag(Boolean productReqFlag) {
		this.productReqFlag = productReqFlag;
	}
	
	
	public HtmlInputText getProductRequirementInputText() {
		return productRequirementInputText;
	}
	public void setProductRequirementInputText(
			HtmlInputText productRequirementInputText) {
		this.productRequirementInputText = productRequirementInputText;
	}
	
	
	public HtmlSelectBooleanCheckbox getProductCheckBox() {
		return productCheckBox;
	}
	public void setProductCheckBox(HtmlSelectBooleanCheckbox productCheckBox) {
		this.productCheckBox = productCheckBox;
	}
	public HtmlSelectBooleanCheckbox getMasterCheckBox() {
		return masterCheckBox;
	}
	public void setMasterCheckBox(HtmlSelectBooleanCheckbox masterCheckBox) {
		this.masterCheckBox = masterCheckBox;
	}
	
	
	public HtmlInputText getAssignedToInputText() {
		return assignedToInputText;
	}
	public void setAssignedToInputText(HtmlInputText assignedToInputText) {
		this.assignedToInputText = assignedToInputText;
	}
	 
	
	
	
	public Boolean getUnAssignedFlag() {
		return unAssignedFlag;
	}
	public void setUnAssignedFlag(Boolean unAssignedFlag) {
		this.unAssignedFlag = unAssignedFlag;
	}
	public HtmlSelectBooleanCheckbox getUnAssignedCheckBox() {
		return unAssignedCheckBox;
	}
	public void setUnAssignedCheckBox(HtmlSelectBooleanCheckbox unAssignedCheckBox) {
		this.unAssignedCheckBox = unAssignedCheckBox;
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
	public ViewAndUpdateProductReqMB() {
		//FRMS_Wrapper wrapper=new FRMS_Wrapper();
		this.assignedToInputText=new HtmlInputText();
		this.groupSelectMenu=new HtmlSelectOneMenu();
		this.moduleSelectMenu=new HtmlSelectOneMenu();
		this.versionSelectMenu=new HtmlSelectOneMenu();
		// Changes made by Sanket start
		this.locationSelectMenu = new HtmlSelectOneMenu();
		this.subModuleSelectMenu = new HtmlSelectOneMenu();
		this.initiatingGroupSelectMenu = new HtmlSelectOneMenu();
		this.verticalSelectMenu=new HtmlSelectOneMenu();
		this.verticalList=new ArrayList<SelectItem>();
		// Changes Complete
		this.masterCheckBox=new HtmlSelectBooleanCheckbox();
		this.masterRequirementInputText=new HtmlInputText();
		this.productCheckBox=new HtmlSelectBooleanCheckbox();
		this.productRequirementInputText=new HtmlInputText();
		this.unAssignedCheckBox=new HtmlSelectBooleanCheckbox();
		// Changes done by Sanket start
		this.locationList = new ArrayList<SelectItem>();
		this.subModuleList = new ArrayList<SelectItem>();
		this.initiatingGroupList = new ArrayList<SelectItem>();
		this.versionList = new ArrayList<SelectItem>();		
		this.solutionList = new ArrayList<SelectItem>();
		this.moduleList = new ArrayList<SelectItem>();
		this.groupList=new ArrayList<SelectItem>();
		this.solutionSelectMenu = new HtmlSelectOneMenu();
		//this.groupList = new ArrayList<SelectItem>();
		// Changes Complete
		
		this.localizationList = new ArrayList<SelectItem>();
		this.localizationSelectMenu = new HtmlSelectOneMenu();
		this.loginList = new ArrayList<SelectItem>();
		this.loginSelectMenu = new HtmlSelectOneMenu();
		
		
		//changes done by Bhuvana starts
		//this.version="0";
		//changes completed
		try
		{
			/*this.groupList=new ArrayList<SelectItem>();
			Map<String,String> groupMap=new FRMS_Wrapper().getAllGroupsMap();
			Set<Entry<String,String>> entrySet=groupMap.entrySet();
			for (Entry<String, String> entry : entrySet) 
			{
				groupList.add(new SelectItem(entry.getKey(),entry.getValue()));
			}*/
			
			TreeMap<String,String> groupMap = new TreeMap<String, String>();
			groupMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllGroupsMap();
			HashMap<String,String> groupHashMap = new HashMap<String, String>();
			groupHashMap = sortHashMap(groupMap);	
			for (Map.Entry<String,String> entry: groupHashMap.entrySet())
			{
				groupList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			
		}
		catch(Exception e)
		{
			this.message=e.getMessage();
		}	
		
		
		try
		{
			/*this.solutionList=new ArrayList<SelectItem>();
			Map<String,String> solutionMap=new FRMS_Wrapper().getAllSolutions();
			Set<Entry<String,String>> entrySet=solutionMap.entrySet();
			for (Entry<String, String> entry : entrySet) {
				solutionList.add(new SelectItem(entry.getKey(),entry.getValue()));
			}*/		
			
			TreeMap<String,String> solutionMap = new TreeMap<String, String>();
			solutionMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllSolutions();
			HashMap<String,String> solutionHashMap = new HashMap<String, String>();
			solutionHashMap = sortHashMap(solutionMap);	
			for (Map.Entry<String,String> entry: solutionHashMap.entrySet())
			{
				solutionList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
		}
		catch(Exception e)
		{
			this.message=e.getMessage();
		}
		
		// Changes made by Bhuvana starts
		try
		{
			/*this.locationList=new ArrayList<SelectItem>();			
			Map<String,String> locationNamesMap = new FRMS_Wrapper().getAllLocations();
			Set<Entry<String,String>> entrySet = locationNamesMap.entrySet();
			for (Entry<String, String> entry : entrySet) {				
				locationList.add(new SelectItem(entry.getKey(),entry.getValue()));
			}*/
	
				TreeMap<String,String> locationMap = new TreeMap<String, String>(); 
				locationMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllLocations();
				HashMap<String,String> locationHashMap = new HashMap<String, String>();
				locationHashMap = sortHashMap(locationMap);	
				for (Map.Entry<String,String> entry: locationHashMap.entrySet())
				{
					locationList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
			    }
		}
				
		catch(Exception e)
		{
			this.message=e.getMessage();
		}
		// Changes complete
		
		//get all localizations
		try
		{
				TreeMap<String,String> localizationMap = new TreeMap<String, String>(); 
				localizationMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllLocalizations();
				HashMap<String,String> localizationHashMap = new HashMap<String, String>();
				localizationHashMap = sortHashMap(localizationMap);	
				for (Map.Entry<String,String> entry: localizationHashMap.entrySet())
				{
					localizationList.add(new SelectItem( entry.getValue(),entry.getValue() ) );	
			    }
		}
				
		catch(Exception e)
		{
			e.printStackTrace();
			this.message=e.getMessage();
		}
		
		
		//get the list of all initiating groups
		try
		{
//			this.locationList=new ArrayList<SelectItem>();
			Map<String,String> initiatingGroupMap = new FRMS_Wrapper().getAllInitiatingGroups();
			Set<Entry<String,String>> entrySet = initiatingGroupMap.entrySet();
			for (Entry<String, String> entry : entrySet) {				
				initiatingGroupList.add(new SelectItem(entry.getKey(),entry.getValue()));
			}
		}
		catch(Exception e)
		{
			this.message=e.getMessage();
		}
		
		try{
		TreeMap<String,String> moduleMap = new TreeMap<String, String>(); 
		moduleMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllModules();
		HashMap<String,String> moduleHashMap = new HashMap<String, String>();
		moduleHashMap = sortHashMap(moduleMap);	
		for (Map.Entry<String,String> entry: moduleHashMap.entrySet())
		{
			moduleList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
	    }
		}
		catch(Exception e)
		{
			this.message=e.getMessage();
		}
		
		try{
			TreeMap<String,String> verticalMap = new TreeMap<String, String>(); 
			verticalMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllVerticals();
			HashMap<String,String> verticalHashMap = new HashMap<String, String>();
			verticalHashMap = sortHashMap(verticalMap);	
			for (Map.Entry<String,String> entry: verticalHashMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			}
			catch(Exception e)
			{
				this.message=e.getMessage();
			}
		
		/*//get all localizations
				try
				{
						TreeMap<String,String> localizationMap = new TreeMap<String, String>(); 
						localizationMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllLocalizations();
						HashMap<String,String> localizationHashMap = new HashMap<String, String>();
						localizationHashMap = sortHashMap(localizationMap);	
						for (Map.Entry<String,String> entry: localizationHashMap.entrySet())
						{
							localizationList.add(new SelectItem( entry.getValue(),entry.getValue() ) );	
					    }
				}
						
				catch(Exception e)
				{
					e.printStackTrace();
					this.message=e.getMessage();
				}*/
		
		
		
		
		//changes complete
		// fetch list of all versions
		try
		{
			this.versionList=new ArrayList<SelectItem>();
			List<String> stringVersionList=new FRMS_Wrapper().getAllVersions();
			Iterator<String> it=stringVersionList.iterator();
			while (it.hasNext()) 
			{
				String string = (String) it.next();
				//if(!versionList.contains(string))
				this.versionList.add(new SelectItem(string,string));					
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			this.message=e.getMessage();
		}
		
		
		try{
			
			TreeMap<String,String> loginMap = new TreeMap<String, String>(); 
			loginMap=(TreeMap<String, String>) new FRMS_Wrapper().getAllEmailIds();
			HashMap<String,String> loginHashMap = new HashMap<String, String>();
			loginHashMap = sortHashMap(loginMap);	
			for (Map.Entry<String,String> entry: loginHashMap.entrySet())
			{
				loginList.add(new SelectItem( entry.getKey(),entry.getValue() ) );	
		    }
			}
			catch(Exception e)
			{
				this.message=e.getMessage();
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
	
	
	public void getAllModulesByVertical(ValueChangeEvent e)
	{
		System.out.println("hello");
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		Map<String,String> moduleMap = new TreeMap<String, String>();
		String verticalId = this.verticalSelectMenu.getValue().toString();
		
		try {
			moduleMap = wrapper.getAllModulesByVertical(verticalId);

			for (Map.Entry<String,String> entry: moduleMap.entrySet())
			{
				moduleList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
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
		System.out.println("hello");
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		Map<String,String> verticalMap = new TreeMap<String, String>();
		String solutionId = this.solutionSelectMenu.getValue().toString();
		
		try {
			verticalMap = wrapper.getAllVerticalsBySolution(solutionId);

			for (Map.Entry<String,String> entry: verticalMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
		} catch (NoSubModuleAvailableForGivenModuleException e1) {
 
			//e1.printStackTrace();
			this.setMessage(e1.getMessage());
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
			this.setMessage(e1.getMessage());
		}
	}
	//changes completed
	
	public String getFilteredList()
	{
		this.productRequirementTOList=new ArrayList<ProductRequirementTO>();
		this.productRequirementTO=null;
		this.message=null;
		
		this.masterRequirementId=(String)this.masterRequirementInputText.getValue();
		 
		FRMS_Wrapper wrapper=new FRMS_Wrapper(); 
		int flag=0;
		
		
		try
		{
			if(this.productReqFlag)
			{
				this.productRequirementInputText.setDisabled(false);
				this.productRequirementTOList.add(wrapper.getProductRequirmentById(this.productRequirementId));
			}
			else if(this.masterReqFlag)
			{
				this.masterRequirementInputText.setDisabled(false);
				this.productRequirementTOList=wrapper.getProductRequirementsByMasterId(this.masterRequirementId);
				//this.productRequirementTOList=wrapper.getProductRequirements("masterRequirementId",this.masterRequirementId);
				System.out.println("Master Requirement Id in PR :"+this.masterRequirementId);
			}
			
			else 
			{
				List<String> arguementList=new ArrayList<String>();
				if(!this.groupId.equals("0") )
				{
					arguementList.add("groupId");
					arguementList.add(this.groupId);
				}
				if(!this.verticalId.equals("0"))
				{
					arguementList.add("verticalId");
					arguementList.add(this.verticalId);
				}
				if(!this.moduleId.equals("0"))
				{
					arguementList.add("moduleId");
					arguementList.add(this.moduleId);
				}
				if(!this.version.equals("0"))
				{
					arguementList.add("productVersion");
					arguementList.add(this.version);
				}
				// Chnages done by Sanket
				if(!this.locationId.equals("0"))
				{
					arguementList.add("locationId");
					arguementList.add(this.locationId);
				}
				if(!this.initiatingGroupId.equals("0"))
				{
					arguementList.add("initiatingGroupId");
					arguementList.add(this.initiatingGroupId);
				}
			   if(!this.solutionId.equals("0"))
				{
					arguementList.add("solutionId");
					arguementList.add(this.solutionId);
				}
				// Changes Completed

				if(this.unAssignedFlag==true)
				{
					arguementList.add("assignedTo");
					arguementList.add("");
				}
				if(this.assignedToEmpId!=null && !this.assignedToEmpId.equals(""))
				{
					arguementList.add("assignedTo");
					arguementList.add(this.assignedToEmpId);
				}
				
				if(!arguementList.isEmpty())
				{
					String arguementString=arguementList.toString(); 
					String[] arguementArray=arguementString.substring(1, arguementString.length()-1).split(",");
					 
					for (int i=0;i<arguementArray.length;i++) {
						arguementArray[i]=arguementArray[i].replaceAll(" ", "");

					}
					this.productRequirementTOList=wrapper.getProductRequirements(arguementArray);
				}
				else
				{
					flag=1;
					this.message="Please Select an option";
				}

			}
				
	
			if(flag==0)
			{
				this.pageNumber=1;
				this.rowsPerPage=10;
				int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
				int endRowNumber=this.pageNumber*this.rowsPerPage;
				if(endRowNumber>=this.productRequirementTOList.size())
				{
					endRowNumber=this.productRequirementTOList.size();
				}
				
				this.viewProductReqPerPageList=this.productRequirementTOList.subList(startRowNumner, endRowNumber);
				this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.productRequirementTOList.size();
				this.pageNumberList=new ArrayList<SelectItem>();
				int totalPageNumbers=(this.productRequirementTOList.size()-1)/10;
				totalPageNumbers++;
				for(Integer i=1;i<=totalPageNumbers;i++)
				{
					this.pageNumberList.add(new SelectItem(i.toString(),i.toString()));
				}
			}
			return "view";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			this.message=e.getMessage();
			
			return "fail";
		}
		
	}
	
	public String showNextRecord()
	{
		this.message=null;
		this.pageNumber++;
		int startRowNumner=(this.pageNumber-1)*this.rowsPerPage;
		int endRowNumber=(this.pageNumber*this.rowsPerPage);
		if(startRowNumner<productRequirementTOList.size())
		{
			if(endRowNumber>=this.productRequirementTOList.size())
			{
				endRowNumber=this.productRequirementTOList.size();
			}
			
			this.viewProductReqPerPageList=this.productRequirementTOList.subList(startRowNumner, endRowNumber);
			 
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.productRequirementTOList.size();
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
			 
			this.viewProductReqPerPageList=this.productRequirementTOList.subList(startRowNumner, endRowNumber);
			this.pageMessage="Showing "+(startRowNumner+1)+" to "+(endRowNumber)+" Records of total "+this.productRequirementTOList.size();
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


	public String getProductRequirementDetails()
	{
		this.message=null;
		this.productRequirementTO=(ProductRequirementTO)this.viewProductReqDataTable.getRowData();
		return "viewDetails";
	}
	
	public String redirectUpdate()
	{
		this.message=null;
		this.updateProductReqTO=new ProductRequirementTO(this.productRequirementTO);
		return "update";
	}
	
	public String cancelUpdate()
	{
		this.message=null;
		this.productRequirementTO=new ProductRequirementTO(this.updateProductReqTO);
		 
		return "cancel";
	}
	public String updateProductRequirements()
	{
		try
		{
			this.message=null;
			FRMS_Wrapper wrapper=new FRMS_Wrapper();
			boolean result=wrapper.updateProductRequirement(this.productRequirementTO);
			if(result)
			{
				this.message="Product Requirement Updated Successfully";
				return "success";
				
			}
			return "fail";
			
		}
		catch (Exception e) {
			this.message=e.getMessage();
			return "fail";
		}
	}
	
	public String redirectSplit()
	{
		try
		{
			this.message=null;
			productReqList=new FRMS_Wrapper().getProductRequirementsByMasterId(this.productRequirementTO.getMasterRequirementId());
			productReqListSize=productReqList.size();
			return "split";
		}
		catch (Exception e) {
			this.message=e.getMessage();
			return "fail";
		}
	}
	
	public String addProductRequirement()
	{
		ProductRequirementTO requirementTO=new ProductRequirementTO();
		requirementTO.setMasterRequirementId(this.productRequirementTO.getMasterRequirementId());
		requirementTO.setMasterRequirementTitle(this.productRequirementTO.getMasterRequirementTitle());
		requirementTO.setMasterRequirementDescription(this.productRequirementTO.getMasterRequirementDescription());
		requirementTO.setVerticalName(this.productRequirementTO.getVerticalName());
		requirementTO.setModuleName(this.productRequirementTO.getModuleName());
		requirementTO.setGroupId(this.productRequirementTO.getGroupId());
		requirementTO.setGroupName(this.productRequirementTO.getGroupName());
		requirementTO.setApprovedStatus("Approved");
		this.productReqList.add(requirementTO);
		return "split";
	}
	
	public String saveSplitedRequirements()
	{
		try
		{
			for (ProductRequirementTO prodReqTO : this.productReqList) 
			{
				prodReqTO.setApprovedStatus("Approved");
			}
			new FRMS_Wrapper().saveSplitedRequriements(this.productReqList);
			this.message="Changes saved successfully";
			return "success";
		}
		catch (Exception e) {
			this.message=e.getMessage();
			
			return "fail";
		}
	}
	
	public String removeSplitReqruiement()
	{
		int size=this.productReqList.size();
		this.productReqList.remove(size-1);
		return "split";
	}
	
	
	/*public void getAllSubModulesByModule(ValueChangeEvent e)
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		Map<String,String> subModuleMap = new TreeMap<String, String>();
		String submoduleId = this.moduleSelectMenu.getValue().toString();
		
		try {
			subModuleMap = wrapper.getAllSubModulesByModule(submoduleId);

			for (Map.Entry<String,String> entry: subModuleMap.entrySet())
			{
				subModuleList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
		} catch (NoSubModuleAvailableForGivenModuleException e1) {
 
			//e1.printStackTrace();
			this.setMessage(e1.getMessage());
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
			this.setMessage(e1.getMessage());
		}
	}*/
	public void selectMasterRequirement(ValueChangeEvent e)
	{
		 
		 
		boolean flag=Boolean.parseBoolean(e.getNewValue().toString());
		this.groupId="0";
		this.moduleId="0";
		this.version="0";
		this.groupSelectMenu.setDisabled(flag);
		this.moduleSelectMenu.setDisabled(flag);
		this.versionSelectMenu.setDisabled(flag);
		this.initiatingGroupSelectMenu.setDisabled(flag);
		// Changes made by Bhuvana starts
		this.locationSelectMenu.setDisabled(flag);
		// Changes complete		
		this.unAssignedCheckBox.setDisabled(flag);
		this.assignedToInputText.setValue(null);
		this.assignedToInputText.setDisabled(flag);
		
		this.masterRequirementInputText.setDisabled(!flag);
		this.masterRequirementInputText.setValue(null);
		//changes done by Bhuvana starts   
		this.subModuleSelectMenu.setDisabled(flag);
		this.verticalSelectMenu.setDisabled(flag);
		this.solutionSelectMenu.setDisabled(flag);
		//changes completed		
		 
		if(this.productCheckBox.isSelected())
		{
			this.productRequirementInputText.setValue(null);
			this.productRequirementInputText.setDisabled(flag);
			this.productCheckBox.setSelected(false);
		}
		/*if(this.unAssignedCheckBox.isSelected())
		{
			this.assignedToInputText.setValue(null);
			this.assignedToInputText.setDisabled(flag);
			//this.unAssignedCheckBox.setSelected(false);
			this.unAssignedCheckBox.setDisabled(flag);
		}*/
		this.productRequirementTOList=new ArrayList<ProductRequirementTO>();
		this.message=null;
		 
	}
	
	public void selectProductReqruiement(ValueChangeEvent e)
	{
		 
		boolean flag=Boolean.parseBoolean(e.getNewValue().toString());
		this.groupId="0";
		this.moduleId="0";
		this.version="0";
		// Changes made by Bhuvana starts
		this.locationId = "0";
		// Changes completed
		this.groupSelectMenu.setDisabled(flag);
		this.moduleSelectMenu.setDisabled(flag);
		this.versionSelectMenu.setDisabled(flag);
		// Chnages made by Bhuvana starts
		this.locationSelectMenu.setDisabled(flag);
		this.initiatingGroupSelectMenu.setDisabled(flag);
		this.unAssignedCheckBox.setDisabled(flag);
		this.assignedToInputText.setValue(null);
		this.assignedToInputText.setDisabled(flag);
		//changes done by Bhuvana starts   
		this.subModuleSelectMenu.setDisabled(flag);
		this.verticalSelectMenu.setDisabled(flag);
		this.solutionSelectMenu.setDisabled(flag);
		//changes completed	
		
		this.productRequirementInputText.setDisabled(!flag);
		this.productRequirementInputText.setValue(null);
	
		if(this.masterCheckBox.isSelected())
		{
			this.masterRequirementInputText.setValue(null);
			this.masterRequirementInputText.setDisabled(flag); 
			this.masterCheckBox.setSelected(false);
			
		}
		 
		
		this.productRequirementTOList=new ArrayList<ProductRequirementTO>();
		this.message=null;
	}
	
	public void selectUnAssignedOption(ValueChangeEvent e)
	{
		 
		boolean flag=Boolean.parseBoolean(e.getNewValue().toString());
		
	 
		this.assignedToInputText.setDisabled(flag);
		this.assignedToInputText.setValue(null);
		
	/*	 
		if(this.masterCheckBox.isSelected())
		{
			
			this.masterRequirementInputText.setValue(null);
			this.masterRequirementInputText.setDisabled(flag); 
			this.masterCheckBox.setSelected(false);
			
		}
		if(this.productCheckBox.isSelected())
		{
			this.productRequirementInputText.setValue(null);
			this.productRequirementInputText.setDisabled(flag);
			this.productCheckBox.setSelected(false);
		}*/
		
		this.productRequirementTOList=new ArrayList<ProductRequirementTO>();
		this.message=null;
	}
	
	
	public String downloadProductReqList()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		
		try
		{
			String fName=wrapper.downloadProductRequirementsReport(this.productRequirementTOList);
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
			
			this.setMessage(e.getMessage());
			return"fail";
		} 
		catch (Exception e)
		{
	
			this.setMessage(e.getMessage());
			return"fail";		
		}
   }
	
	//Added for Download as RCD Tracker	
	public String downloadProductReqListAsRCDTracker()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		
		try
		{
			String fName=wrapper.downloadProductReqListAsRCDTracker(this.productRequirementTOList);
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
			
			this.setMessage(e.getMessage());
			return"fail";
		} 
		catch (Exception e)
		{
	
			this.setMessage(e.getMessage());
			return"fail";		
		}
   }
	
	// //Added for Download as RS Tracker	
	public String downloadProductReqListAsRSTracker()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		
		try
		{
			String fName=wrapper.downloadProductReqListAsRSTracker(this.productRequirementTOList);
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
			
			this.setMessage(e.getMessage());
			return"fail";
		} 
		catch (Exception e)
		{
	
			this.setMessage(e.getMessage());
			return"fail";		
		}
   }
	
	public String saveSplitedProductRequirement()
	{
		try
		{
			ProductRequirementTO requirementTO=(ProductRequirementTO)this.splitDataList.getRowData();
			FRMS_Wrapper wrapper=new FRMS_Wrapper();
			if(requirementTO.getProductRequirementId()==null)
			{
				 
				requirementTO=wrapper.saveNewProductRequirement(requirementTO);
			}
			else
			{
				 
				wrapper.updateProductRequirement(requirementTO);
			}
			this.productReqListSize++;
			return "split";
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
			 
			
			for (ProductRequirementTO requirementTO : this.productReqList) {
				
				if(requirementTO.getProductRequirementId()==null)
				{					
					requirementTO=wrapper.saveNewProductRequirement(requirementTO);
				}
				else
				{
					wrapper.updateProductRequirement(requirementTO);
				}
			}
			
			this.message="Product Requriement(s) Created successfully!";
			return "success";
		}
		catch(Exception e)
		{
			
			this.message=e.getMessage();
			for (ProductRequirementTO requirementTO : this.productReqList) {
				if(requirementTO.getProductRequirementId()!=null)
				{
					this.message="Some Product Requirement Details may not have been saved, Please click save again!";
					break;
				}
			}
			return "fail";
		}
	}
	

}
