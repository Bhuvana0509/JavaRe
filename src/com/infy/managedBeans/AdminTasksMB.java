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

import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.myfaces.custom.datalist.HtmlDataList;

import com.infy.TOclasses.GroupDetailsAttachmentTO;
import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.LoginTO;
import com.infy.TOclasses.ModuleAnchorTO;
import com.infy.TOclasses.ModuleDropDownTO;
import com.infy.TOclasses.SubModuleTO;
import com.infy.TOclasses.VerticalDropDownTO;
import com.infy.TOclasses.VerticalTO;
import com.infy.exceptions.AlreadyExistException;
import com.infy.exceptions.NoModuleAvailableException;
import com.infy.exceptions.NoModulesAvailableForGivenSolutionException;
import com.infy.exceptions.NoSolutionsAvailableException;
import com.infy.exceptions.NoSourceAvailableException;
import com.infy.exceptions.NoSubModuleAvailableForGivenModuleException;
import com.infy.wrapper.FRMS_Wrapper;

public class AdminTasksMB 
{
	private String locationName;
	private String initiatingGroupName;
	private String sourceName;
	private String solutionName;
	private String moduleName;
	private String moduleAnchorName;
	private List<SelectItem> solutionList;
	private List<SelectItem> modulesList;
	private String moduleId;
	private String solutionId;
	private String message;
	private String productVersion;
	private String localizationName;
	
	public String getLocalizationName() {
		return localizationName;
	}
	public void setLocalizationName(String localizationName) {
		this.localizationName = localizationName;
	}
	public String getProductVersion() {
		return productVersion;
	}
	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	private ModuleAnchorTO moduleAnchorTO;
	private String newModuleAnchor;
	private ModuleAnchorTO updateModuleAnchorTO;
	
	public ModuleAnchorTO getUpdateModuleAnchorTO() {
		return updateModuleAnchorTO;
	}
	public void setUpdateModuleAnchorTO(ModuleAnchorTO updateModuleAnchorTO) {
		this.updateModuleAnchorTO = updateModuleAnchorTO;
	}

	//changes done by sanket mehta
	private HtmlDataList moduleDataList;
	private HtmlSelectOneMenu moduleSelectMenu;
	private List<ModuleAnchorTO> moduleNameList;
	private List<HtmlSelectOneMenu> moduleDropDownList;
	private List<List<SelectItem>> moduleListsForSolutions;
	private List<ModuleDropDownTO> moduleDropDownTOList;
	//changes completed
	
	// changes done by Bhuvana starts
	private String subModuleName;
	private List<SelectItem> subModulesList;
	private String verticalName;
	private String verticalId;
	private VerticalTO verticalTO;
	private List<SelectItem> verticalList;
	private List<HtmlSelectOneMenu> verticalDropDownList;
	private List<VerticalDropDownTO> verticalDropDownTOList;
	private HtmlSelectOneMenu verticalSelectMenu;
	private HtmlDataList verticalDataList;
	
	private String selectFunction;
	private HtmlSelectOneMenu functionSelectMenu;
	
	private List<SelectItem> loginList;
	
	public List<SelectItem> getLoginList() {
		return loginList;
	}
	public void setLoginList(List<SelectItem> loginList) {
		this.loginList = loginList;
	}

	// Added newly
	private String selectedItem; 
	
	public String getSelectedItem() {
		return selectedItem;
	}
	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}
	public HtmlSelectOneMenu getFunctionSelectMenu() {
		return functionSelectMenu;
	}
	public void setFunctionSelectMenu(HtmlSelectOneMenu functionSelectMenu) {
		this.functionSelectMenu = functionSelectMenu;
	}
	public String getSelectFunction() {
		return selectFunction;
	}
	public void setSelectFunction(String selectFunction) {
		this.selectFunction = selectFunction;
	}
	public HtmlDataList getVerticalDataList() {
		return verticalDataList;
	}
	public void setVerticalDataList(HtmlDataList verticalDataList) {
		this.verticalDataList = verticalDataList;
	}
	public HtmlSelectOneMenu getVerticalSelectMenu() {
		return verticalSelectMenu;
	}
	public void setVerticalSelectMenu(HtmlSelectOneMenu verticalSelectMenu) {
		this.verticalSelectMenu = verticalSelectMenu;
	}
	public List<VerticalDropDownTO> getVerticalDropDownTOList() {
		return verticalDropDownTOList;
	}
	public void setVerticalDropDownTOList(
			List<VerticalDropDownTO> verticalDropDownTOList) {
		this.verticalDropDownTOList = verticalDropDownTOList;
	}
	public List<HtmlSelectOneMenu> getVerticalDropDownList() {
		return verticalDropDownList;
	}
	public void setVerticalDropDownList(List<HtmlSelectOneMenu> verticalDropDownList) {
		this.verticalDropDownList = verticalDropDownList;
	}
	public List<SelectItem> getVerticalList() {
		return verticalList;
	}
	public void setVerticalList(List<SelectItem> verticalList) {
		this.verticalList = verticalList;
	}
	public VerticalTO getVerticalTO() {
		return verticalTO;
	}
	public void setVerticalTO(VerticalTO verticalTO) {
		this.verticalTO = verticalTO;
	}
	public String getVerticalId() {
		return verticalId;
	}
	public void setVerticalId(String verticalId) {
		this.verticalId = verticalId;
	}
	public String getVerticalName() {
		return verticalName;
	}
	public void setVerticalName(String verticalName) {
		this.verticalName = verticalName;
	}
	public String getSubModuleName() {
		return subModuleName;
	}
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}
	public List<SelectItem> getSubModulesList() {
		return subModulesList;
	}
	public void setSubModulesList(List<SelectItem> subModulesList) {
		this.subModulesList = subModulesList;
	}
	public HtmlSelectOneMenu getModuleSelectMenu() {
		
		return moduleSelectMenu;
	}
	public void setModuleSelectMenu(HtmlSelectOneMenu moduleSelectMenu) {
		this.moduleSelectMenu = moduleSelectMenu;
	}
	public String getNewModuleAnchor() {
		return newModuleAnchor;
	}
	public void setNewModuleAnchor(String newModuleAnchor) {
		this.newModuleAnchor = newModuleAnchor;
	}
	public ModuleAnchorTO getModuleAnchorTO() {
		return moduleAnchorTO;
	}
	public void setModuleAnchorTO(ModuleAnchorTO moduleAnchorTO) {
		this.moduleAnchorTO = moduleAnchorTO;
	}
	public List<SelectItem> getModulesList() {
		return modulesList;
	}
	public void setModulesList(List<SelectItem> modulesList) {
		this.modulesList = modulesList;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
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
	public String getSolutionName() {
		return solutionName;
	}
	public void setSolutionName(String solutionName) {
		this.solutionName = solutionName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleAnchorName() {
		return moduleAnchorName;
	}
	public void setModuleAnchorName(String moduleAnchorName) {
		this.moduleAnchorName = moduleAnchorName;
	}
	public List<SelectItem> getSolutionList() {
		return solutionList;
	}
	public void setSolutionList(List<SelectItem> solutionList) {
		this.solutionList = solutionList;
	}
	public String getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//changes done by sanket mehta
	public HtmlDataList getModuleDataList() {
		return moduleDataList;
	}
	public void setModuleDataList(HtmlDataList moduleDataList) {
		this.moduleDataList = moduleDataList;
	}
	public List<ModuleAnchorTO> getModuleNameList() {
		return moduleNameList;
	}
	public void setModuleNameList(List<ModuleAnchorTO> moduleNameList) {
		this.moduleNameList = moduleNameList;
	}
	public List<List<SelectItem>> getModuleListsForSolutions() {
		return moduleListsForSolutions;
	}
	public void setModuleListsForSolutions(
			List<List<SelectItem>> moduleListsForSolutions) {
		this.moduleListsForSolutions = moduleListsForSolutions;
	}
	public List<ModuleDropDownTO> getModuleDropDownTOList() {
		return moduleDropDownTOList;
	}
	public void setModuleDropDownTOList(List<ModuleDropDownTO> moduleDropDownTOList) {
		this.moduleDropDownTOList = moduleDropDownTOList;
	}
	public List<HtmlSelectOneMenu> getModuleDropDownList() {
		return moduleDropDownList;
	}
	public void setModuleDropDownList(List<HtmlSelectOneMenu> moduleDropDownList) {
		this.moduleDropDownList = moduleDropDownList;
	}
	//changes completed
	//constructor
	public AdminTasksMB() 
	{
		this.message = null;
		moduleNameList = new ArrayList<ModuleAnchorTO>();
		moduleSelectMenu = new HtmlSelectOneMenu();
		this.moduleAnchorTO=new ModuleAnchorTO();
		modulesList = new ArrayList<SelectItem>();
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		solutionList= new ArrayList<SelectItem>();
		verticalList = new ArrayList<SelectItem>();
		moduleListsForSolutions=new ArrayList<List<SelectItem>>();
		moduleDropDownTOList = new ArrayList<ModuleDropDownTO>();
		moduleDropDownList = new ArrayList<HtmlSelectOneMenu>();
		
		loginList = new ArrayList<SelectItem>();
		
		//added for module addition
		verticalDropDownTOList = new ArrayList<VerticalDropDownTO>();
		verticalDropDownList = new ArrayList<HtmlSelectOneMenu>();
		verticalSelectMenu = new HtmlSelectOneMenu();
		VerticalDropDownTO verticalDropDownTO=new VerticalDropDownTO();
		this.verticalDropDownTOList.add(verticalDropDownTO);
		
		ModuleDropDownTO moduleDropDownTO=new ModuleDropDownTO();
		this.moduleDropDownTOList.add(moduleDropDownTO);
		TreeMap<String,String> solutionMap = new TreeMap<String, String>();
		TreeMap<String,String> verticalMap = new TreeMap<String, String>();
		
		try 
		{
			/*solutionMap=wrapper.getAllSolutions();
			for (Map.Entry<String,String> entry: solutionMap.entrySet())
			{
				solutionList.add(new SelectItem( entry.getKey(),entry.getValue() ) ); 
			}*/
			
			solutionMap= (TreeMap<String, String>) wrapper.getAllSolutions();
			HashMap<String,String> solutionHashMap = new HashMap<String, String>();
			solutionHashMap = sortHashMap(solutionMap);
			
			for (Map.Entry<String,String> entry: solutionHashMap.entrySet())
			{
				//System.out.println("solution entry.getKey()@@@"+entry.getKey()+"*solution entry.getValue()@@@"+entry.getValue());
				solutionList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
			
			/*Map<String,String> vericalNamesMap = new TreeMap<String, String>();
			vericalNamesMap= wrapper.getAllVerticals();
			for (Map.Entry<String,String> entry: vericalNamesMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
				 
			}*/
			
			verticalMap= (TreeMap<String, String>) wrapper.getAllVerticals();
			HashMap<String,String> verticalHashMap = new HashMap<String, String>();
			verticalHashMap = sortHashMap(verticalMap);
			
			for (Map.Entry<String,String> entry: verticalHashMap.entrySet())
			{
				//System.out.println("solution entry.getKey()@@@"+entry.getKey()+"*solution entry.getValue()@@@"+entry.getValue());
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
			
			//added for emailId list
			TreeMap<String,String> loginMap = new TreeMap<String, String>();			
			loginMap= (TreeMap<String, String>) wrapper.getAllEmailIds();
			HashMap<String,String> loginNamesHashMap = new HashMap<String, String>();
			loginNamesHashMap = sortHashMap(loginMap);
			
			for (Map.Entry<String,String> entry: loginNamesHashMap.entrySet())
			{
				//System.out.println("solution entry.getKey()@@@"+entry.getKey()+"*solution entry.getValue()@@@"+entry.getValue());
				loginList.add(new SelectItem( entry.getKey(),entry.getValue() ) );
			}
			
			
		} 
		catch (NoSolutionsAvailableException e) 
		{
			this.message=e.getMessage();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
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
	
	/*//change done by sanket mehta
	public String addMoreModules()
	{
		modulesList=new ArrayList<SelectItem>();
		FRMS_Wrapper wrapper = new FRMS_Wrapper();	
		Map<String,String> modulesMap = new TreeMap<String, String>();
		try 
		{
			modulesMap= wrapper.getAllModulesBySolution(this.solutionId);
			System.out.println("module list size : "+modulesMap.size());
			
			modulesList.clear();
			
			for (Map.Entry<String,String> entry: modulesMap.entrySet())
			{
				modulesList.add(new SelectItem(entry.getKey(),entry.getValue() ) ); 
			}
			
//			this.moduleListsForSolutions.add(modulesList);
			ModuleDropDownTO moduleDropDownTO = new ModuleDropDownTO();
			moduleDropDownTO.setModuleList(modulesList);
//			moduleDropDownTO.setModuleId();
			moduleDropDownTOList.add(moduleDropDownTO);
			
//			this.moduleDropDownList.add(this.moduleSelectMenu);
			System.out.println("no of module menus are: " + moduleDropDownTOList.size());
			for (ModuleDropDownTO dropDownTo : moduleDropDownTOList) 
			{
				System.out.println("selected value for each moduleList: " + dropDownTo.getModuleId());
			}
		} 
		catch (NoModulesAvailableForGivenSolutionException e) 
		{
			e.printStackTrace();
			this.setMessage(e.getMessage());
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			this.setMessage(e.getMessage());
		}
		return "AddNewModule";
	}*/
	
	
	//changes completed
	
	//get Module List Of Selected Solution 
	public void getModuleListOfSelectedSolution(ValueChangeEvent event)
	{
		String obj=(String)event.getNewValue();
//		modulesList.clear();
		modulesList=new ArrayList<SelectItem>();
		this.message=null;
		if(obj!=null && !(obj.equals("0")))
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();	
			Map<String,String> modulesMap = new TreeMap<String, String>();
			try 
			{
				modulesMap= wrapper.getAllModulesBySolution(obj);
				this.solutionId=obj;
				
				for (Map.Entry<String,String> entry: modulesMap.entrySet())
				{
					modulesList.add(new SelectItem(entry.getKey(),entry.getValue() ) ); 
				}
//				this.moduleListsForSolutions.clear();
//				this.moduleDropDownList.clear();
				this.moduleDropDownTOList.clear();
				
//				this.moduleListsForSolutions.add(modulesList);
				ModuleDropDownTO moduleDropDownTO = new ModuleDropDownTO();
				moduleDropDownTO.setModuleList(modulesList);
				moduleDropDownTOList.add(moduleDropDownTO);
			} 
			catch (NoModulesAvailableForGivenSolutionException e) 
			{
				this.setMessage(e.getMessage());
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				this.setMessage(e.getMessage());
				
			}
		}
	}
	
	//add more verticals
	
	public String addMoreVerticals()
	{
		verticalList=new ArrayList<SelectItem>();
		FRMS_Wrapper wrapper = new FRMS_Wrapper();	
		Map<String,String> verticalMap = new TreeMap<String, String>();
		try 
		{
			verticalMap= wrapper.getAllVerticalsBySolution(this.solutionId);
			System.out.println("vertical list size : "+verticalMap.size());
			
			modulesList.clear();
			
			for (Map.Entry<String,String> entry: verticalMap.entrySet())
			{
				verticalList.add(new SelectItem(entry.getKey(),entry.getValue() ) ); 
			}
			
//			this.moduleListsForSolutions.add(modulesList);
			VerticalDropDownTO verticalDropDownTO = new VerticalDropDownTO();
			verticalDropDownTO.setVerticalList(verticalList);
//			moduleDropDownTO.setModuleId();
			verticalDropDownTOList.add(verticalDropDownTO);
			
//			this.moduleDropDownList.add(this.moduleSelectMenu);
			System.out.println("no of vertical menus are: " + verticalDropDownTOList.size());
			for (VerticalDropDownTO dropDownTo : verticalDropDownTOList) 
			{
				System.out.println("selected value for each verticalList: " + dropDownTo.getVerticalId());
			}
		} 
		catch (NoModulesAvailableForGivenSolutionException e) 
		{
			e.printStackTrace();
			this.setMessage(e.getMessage());
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			this.setMessage(e.getMessage());
		}
		return "AddNewModule";
	}
	
	// get verticals list of selected solution
	public void getVerticalListOfSelectedSolution(ValueChangeEvent event)
	{
		//System.out.println("hello");
		String obj=(String)event.getNewValue();
		verticalList = new ArrayList<SelectItem>();
		//this.message=null;
		if(obj!=null && !(obj.equals("0")))
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();	
			Map<String,String> verticalsMap = new TreeMap<String, String>();
			try 
			{
				verticalsMap= wrapper.getAllVerticalsBySolution(obj);
				this.solutionId=obj;
				 
				for (Map.Entry<String,String> entry: verticalsMap.entrySet())
				{
					verticalList.add(new SelectItem(entry.getKey(),entry.getValue() ) ); 
				}
				
                this.verticalDropDownTOList.clear();
				
//				this.moduleListsForSolutions.add(modulesList);
				VerticalDropDownTO verticalDropDownTO = new VerticalDropDownTO();
				verticalDropDownTO.setVerticalList(verticalList);
				verticalDropDownTOList.add(verticalDropDownTO);
			} 
			catch (NoModulesAvailableForGivenSolutionException e) 
			{
				this.setMessage(e.getMessage());
				 
			}
			catch (Exception e) 
			{
				this.setMessage(e.getMessage());
				 
			}
		}
	}
	
	
	public void assignSelectedModule(ValueChangeEvent event)
	{
		ModuleDropDownTO dropDownTO=(ModuleDropDownTO)this.moduleDataList.getRowData();
		dropDownTO.setModuleId((String)event.getNewValue());
	
	}
	
	public void assignSelectedVertical(ValueChangeEvent event)
	{
		VerticalDropDownTO dropDownTO=(VerticalDropDownTO)this.verticalDataList.getRowData();
		dropDownTO.setVerticalId((String)event.getNewValue());
	
	}
	
	//view Module Anchor Details
		public String viewModuleAnchorDetails()
		{
			FRMS_Wrapper wrapper = new FRMS_Wrapper();	
			this.moduleAnchorTO = null;
			this.newModuleAnchor= null;
			try 
			{
				if(!this.moduleId.equalsIgnoreCase("0"))
						{
							moduleAnchorTO=wrapper.getModuleById(this.moduleId);
							this.setModuleId(moduleAnchorTO.getModuleId());
							this.setModuleName(moduleAnchorTO.getModuleName());
							this.setModuleAnchorName(moduleAnchorTO.getAnchorName());
							
						}
				return "view";
			} 
			catch (Exception e) 
			{
				this.setMessage(e.getMessage());
				return "failure";
			}
		}
		//save Edited Vertical Details
				public String saveEditedVerticalDetails()
				{
					this.verticalTO = new VerticalTO();
					this.verticalTO.setVerticalId(this.getVerticalId());
					this.verticalTO.setVerticalName(this.getVerticalName());
					this.verticalTO.setSolutionId(this.getSolutionId());
									
					FRMS_Wrapper wrapper = new FRMS_Wrapper();	
					
					try
					{
						this.verticalTO=wrapper.saveEditedVertical(this.verticalTO);
						this.setVerticalId(this.verticalTO.getVerticalId());
						this.setVerticalName(this.verticalTO.getVerticalName());
						this.setSolutionId(this.verticalTO.getSolutionId());
						this.setMessage("Vertical Details Updated Successfully ");
						return"success";
						
					}
					catch (Exception e) 
					{
						this.setMessage(e.getMessage());
						
						return"failure";
					}
					
					
				}
	
	
	//save Edited ModuleAnchor Details
	public String saveEditedModuleAnchorDetails()
	{
		this.moduleAnchorTO = new ModuleAnchorTO();
		this.moduleAnchorTO.setSolutionId(this.getSolutionId());
		this.moduleAnchorTO.setVerticalId(this.getVerticalId());
		this.moduleAnchorTO.setModuleId(this.getModuleId());
		this.moduleAnchorTO.setModuleName(this.getModuleName());
		System.out.println("module name: "+this.getModuleName());
		this.moduleAnchorTO.setAnchorName(this.getModuleAnchorName());
		
		this.moduleAnchorTO.setVerticalName(this.getVerticalName());
		System.out.println("vertical name: "+this.getVerticalName());
		
		FRMS_Wrapper wrapper = new FRMS_Wrapper();	
	
		try
		{
			
			this.verticalList = new ArrayList<SelectItem>();
			Map<String,String> verticalMap = new TreeMap<String, String>();
			verticalMap=new FRMS_Wrapper().getAllVerticals();
			for (Map.Entry<String,String> entry: verticalMap.entrySet())
			{
				verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );

			}
			this.moduleAnchorTO=wrapper.saveEditedModuleAnchor(this.moduleAnchorTO);
			this.setSolutionId(this.moduleAnchorTO.getSolutionId());
			this.setVerticalId(this.moduleAnchorTO.getVerticalId());
			System.out.println("vertical id in bean: "+this.moduleAnchorTO.getVerticalId());
			this.setModuleId(this.moduleAnchorTO.getModuleId());
			this.setModuleName(this.moduleAnchorTO.getModuleName());
			System.out.println("module name inside try: "+this.moduleAnchorTO.getModuleName());
			
			this.moduleAnchorTO.setVerticalId(moduleAnchorTO.getVerticalId());
			System.out.println("vertical id in managed bean: "+this.moduleAnchorTO.getVerticalId());
			this.setVerticalName(this.moduleAnchorTO.getVerticalName());
			System.out.println("vertical name inside try: "+this.moduleAnchorTO.getVerticalName());
			
			this.setModuleAnchorName(this.moduleAnchorTO.getAnchorName());			
			this.setMessage("Module Details Updated Successfully ");
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			this.setMessage(e.getMessage());
			
			return"failure";
		}
		
		return "moduleSuccess";
	}
	
	public String cancelModuleAnchorChanges()
	{
		this.moduleAnchorTO = null;
		this.newModuleAnchor= null;
		return "cancelModuleAnchor";
	}
	
	//add Location
	public String addLocation()
	{
		this.message = null;
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		try 
		{
			String locationId= wrapper.addLocation(this.getLocationName());
			this.setMessage("Location Added successfully with Location Id "+ locationId);
			return"success";
		} 
		catch (AlreadyExistException e) 
		{
			this.setMessage("Location "+ e.getMessage());
			return"failure";
		}
		catch (Exception e) 
		{
			this.setMessage(e.getMessage());
			return"failure";
		}
	}
	
	//add Initiating Group
	public String addInitiatingGroup()
	{
		this.message = null;
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		try 
		{
			String initiatingGroupId= wrapper.addInitiatingGroup(this.getInitiatingGroupName());
			this.setMessage("initiating Group Added successfully with initiating Group Id "+ initiatingGroupId);
			return"success";
		} 
		catch (AlreadyExistException e) 
		{
			this.setMessage("Initiating Group "+e.getMessage());
			return"failure";
		}
		catch (Exception e) 
		{
			this.setMessage(e.getMessage());
			return"failure";
		}
	}
	
	//add Source
	public String addSource()
	{
		this.message = null;
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		try 
		{
			String sourceId= wrapper.addSource(this.getSourceName());
			this.setMessage("Source Added successfully with source Id "+ sourceId);
			return"success";
		} 
		catch (AlreadyExistException e) 
		{
			this.setMessage("Source "+e.getMessage());
			return"failure";
		}
		catch (Exception e) 
		{
			this.setMessage(e.getMessage());
			return"failure";
		}
	}
	
	//add localization
		public String addLocalization()
		{
			this.message = null;
			FRMS_Wrapper wrapper = new FRMS_Wrapper();
			try 
			{
				
				System.out.println("getLocalizationName() "+getLocalizationName()+"localizationName "+localizationName);
				String localizationId= wrapper.addLocalization(getLocalizationName());
				this.setMessage("Localization Added successfully with Id "+ localizationId);
				return"success";
			} 
			catch (AlreadyExistException e) 
			{
				this.setMessage("Localization "+e.getMessage());
				return"failure";
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				this.setMessage(e.getMessage());
				return"failure";
			}
		}
	
	//add Solution
	public String addSolution()
	{
		this.message = null;
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		try 
		{
			String solutionId= wrapper.addSolution(this.getSolutionName());
			this.setMessage("Solution Added successfully with Solution Id "+ solutionId);
			return"success";
		} 
		catch (AlreadyExistException e) 
		{
			this.setMessage("Solution "+e.getMessage());
			return"failure";
		}
		catch (Exception e) 
		{
			this.setMessage(e.getMessage());
			return"failure";
		}
	}
	
	//add product version
		public String addProductVersion()
		{
			this.message = null;
			FRMS_Wrapper wrapper = new FRMS_Wrapper();
			try 
			{
				String versionId= wrapper.addProductVersion(getProductVersion());
				this.setMessage("Product Version Added successfully");
				return"success";
			} 
			catch (AlreadyExistException e) 
			{
				this.setMessage("Product Version "+e.getMessage());
				return"failure";
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				this.setMessage(e.getMessage());
				return"failure";
			}
		}
	
	//add Solution
	public String addModuleAndAssignModuleAnchor()
	{
		this.message = null;
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		ModuleAnchorTO moduleTo = new ModuleAnchorTO();
		try 
		{	
			moduleTo.setModuleId(this.getModuleId());
			moduleTo.setModuleName(this.getModuleName());
			moduleTo.setSolutionId(this.getSolutionId());
			moduleTo.setAnchorName(this.getModuleAnchorName());
			
			String moduleId= wrapper.addModuleAndAssignModuleAnchor(moduleTo);
			this.setMessage("Module Added successfully with Module Id "+ moduleId +" and "+ this.getModuleAnchorName()+
					" is assigned as the respective Module Anchor");
			return"success";
		} 
		catch (AlreadyExistException e) 
		{
			this.setMessage("Module For the selected Solution "+e.getMessage());
			return"failure";
		}
		catch (Exception e) 
		{
			this.setMessage(e.getMessage());
			return"failure";
		}
	}

	
	//changes done by Bhuvana starts
	//add sub modules
	public String addSubModule()
	{	
		if(this.subModuleName.isEmpty())
		{
			this.setMessage("Please enter sub module name");
			return "failure";
		}
		this.message = null;
		List<String> moduleIdList = new ArrayList<String>();
		
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		SubModuleTO subModuleTo = new SubModuleTO();
		try 
		{
			subModuleTo.setSubModuleName(this.subModuleName);
			String subModuleId= wrapper.addSubModule(subModuleTo);
			
			System.out.println("submodule id: "+subModuleId);
			for(ModuleDropDownTO moduleDropDownTO: this.moduleDropDownTOList)
			{
				
				String moduleId = moduleDropDownTO.getModuleId();
				if(!moduleIdList.contains(moduleId) && moduleId != "0")
				{
					moduleIdList.add(moduleId);
				}	
			}
			
			for(String moduleId : moduleIdList)
			{
				System.out.println("final module id: "+moduleId);
				wrapper.addModuleSubModuleMapping(subModuleId, moduleId);
			}
			this.setMessage("Sub Module Added successfully with Sub Module Id "+ subModuleId);
			return"success";
		} 
		catch (AlreadyExistException e) 
		{
			e.printStackTrace();
			this.setMessage("Sub Module For the selected Module "+e.getMessage());
			return"failure";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			this.setMessage(e.getMessage());
			return"failure";
		}
//		return "success";
	}
	// changes completed
	
	
	//add vertical
	public String addVertical()
	{
		this.message = null;
		FRMS_Wrapper wrapper = new FRMS_Wrapper();
		VerticalTO verticalTo = new VerticalTO();
		try 
		{	
			verticalTo.setVerticalName(this.getVerticalName());
			verticalTo.setSolutionId(this.getSolutionId());
						
			String verticalId= wrapper.addVertical(verticalTo);
			this.setMessage("Vertical Added successfully with Vertical Id "+ verticalId); 
			return"success";
		} 
		catch (AlreadyExistException e) 
		{
			this.setMessage("Vertical For the selected Solution "+e.getMessage());
			return"failure";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			this.setMessage(e.getMessage());
			return"failure";
		}
	}
	
	//view Vertical Details
	public String viewVerticalDetails()
	{
		FRMS_Wrapper wrapper = new FRMS_Wrapper();	
		this.verticalTO = null;
		try 
	    {
			if(!this.verticalId.equalsIgnoreCase("0"))
			{
				verticalTO=wrapper.getVerticalById(this.verticalId);
				this.setVerticalId(verticalTO.getVerticalId());
				this.setVerticalName(verticalTO.getVerticalName());
														
			}
			return "view";
		} 
		catch (Exception e) 
		{
			this.setMessage(e.getMessage());
			return "failure";
		}
	}
	
	public String viewFunction()
    {
		System.out.println("hello");
		if(getSelectFunction().equals("AddVertical")){
			
			System.out.println("inside if of Add Vertical");
			           
			return "addVertical";
		}
		if(getSelectFunction().equals("AddNewModule")){
			
			return "addModule";
		}
		if(getSelectFunction().equals("ChangeVertical")){
	           
			return "changeVertical";
		}
		if(getSelectFunction().equals("ChangeModule")){
	           
			return "changeModule";
		}
		
		return "view";
        
    }

	
	//view module Details
	public String viewModuleDetails()
	{
		System.out.println("hello");
		FRMS_Wrapper wrapper = new FRMS_Wrapper();	
		this.moduleAnchorTO = null;
		try 
	    {
			if(!this.moduleId.equalsIgnoreCase("0"))
			{
				moduleAnchorTO=wrapper.getModuleById(this.moduleId);
				this.setSolutionId(moduleAnchorTO.getSolutionId());
				this.setVerticalId(moduleAnchorTO.getVerticalId());
				this.setModuleId(moduleAnchorTO.getModuleId());
				this.setModuleName(moduleAnchorTO.getModuleName());
				this.setModuleAnchorName(moduleAnchorTO.getAnchorName());
				//this.setSolutionName(moduleAnchorTO.getSolutionId());
														
			}
			return "view";
		} 
		catch (Exception e) 
		{
			this.setMessage(e.getMessage());
			return "failure";
		}
	}
	
	
	
		//add sub modules
		public String addModule()
		{	
			if(this.moduleName.isEmpty())
			{
				this.setMessage("Please enter module name");
				return "failure";
			}
			this.message = null;
			List<String> verticalIdList = new ArrayList<String>();
			
			FRMS_Wrapper wrapper = new FRMS_Wrapper();
			this.moduleAnchorTO = new ModuleAnchorTO();
			try 
			{
				moduleAnchorTO.setModuleId(this.moduleId);
				//System.out.println("module id: "+this.moduleId);
				moduleAnchorTO.setModuleName(this.moduleName);
				//System.out.println("module name: "+this.getModuleName());
				moduleAnchorTO.setSolutionId(this.getSolutionId());
				moduleAnchorTO.setVerticalId(this.verticalId);
				System.out.println("vertical id: "+this.verticalId);
				//moduleAnchorTO.setVerticalName(this.getVerticalName());
				moduleAnchorTO.setAnchorName(this.getModuleAnchorName());
				
				String moduleId= wrapper.addModule(moduleAnchorTO);		
				System.out.println("module id: "+moduleId);
				for(VerticalDropDownTO verticalDropDownTO: this.verticalDropDownTOList)
				{
					
					String verticalId = verticalDropDownTO.getVerticalId();
					if(!verticalIdList.contains(verticalId) && verticalId != "0")
					{
						verticalIdList.add(verticalId);
						//moduleAnchorTO.setVerticalId(verticalId);
					}	
				}
				
				for(String verticalId : verticalIdList)
				{
					System.out.println("final vertical id: "+verticalId);
					wrapper.addVerticalModuleMapping(moduleId, verticalId);
				}
				this.setMessage("Module Added successfully with Module Id "+ moduleId);
				return"moduleSuccess";	
			} 
			
			catch (AlreadyExistException e) 
			{
				e.printStackTrace();
				this.setMessage("Module For the selected Vertical "+e.getMessage());
				return"failure";
			}
			catch (Exception e) 
			{
				//e.printStackTrace();
				this.setMessage(e.getMessage());
				return"failure";
			}
		
		}
		
		
		//get all modules by vertical
		
		public void getAllModulesByVertical(ValueChangeEvent e)
		{
			//System.out.println("hi");
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
				//this.setMessage(e1.getMessage());
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
				this.setMessage(e1.getMessage());
			}
		}
		
		
		public void viewModuleDetails(ValueChangeEvent event)
		{
			
			this.setModuleId((String) event.getNewValue());
			this.moduleAnchorTO=null;
			if(!this.moduleId.equals("0"))
			{
				FRMS_Wrapper wrapper = new FRMS_Wrapper();

				try
				{
					this.moduleAnchorTO=wrapper.getModulesById(this.moduleId);
					this.setSolutionId(moduleAnchorTO.getSolutionId());
					this.setVerticalId(moduleAnchorTO.getVerticalId());
					this.setModuleName(moduleAnchorTO.getModuleName());
					this.setModuleAnchorName(moduleAnchorTO.getAnchorName());
					
				} 
				catch (NoModuleAvailableException e) 
				{
					this.setMessage(e.getMessage());
					
				} 
				catch (Exception e) 
				{
					this.setMessage(e.getMessage());
					
				}
			}
			
		}
		
		// call to edit module
		
		public String editModuleDetails()
		{
			this.message=null;
			
			FRMS_Wrapper wrapper = new FRMS_Wrapper();
			verticalList = new ArrayList<SelectItem>();
			
			Map<String,String> verticalMap = new TreeMap<String, String>();
			try 
			{
				verticalMap= wrapper.getAllVerticals();
				for (Map.Entry<String,String> entry: verticalMap.entrySet())
				{
					verticalList.add(new SelectItem( entry.getKey(),entry.getValue() ) );				
					 
				}
				
				this.updateModuleAnchorTO=new ModuleAnchorTO();
				updateModuleAnchorTO.setSolutionId(moduleAnchorTO.getSolutionId());
				updateModuleAnchorTO.setVerticalId(moduleAnchorTO.getVerticalId());
				updateModuleAnchorTO.setModuleId(moduleAnchorTO.getModuleId());
				updateModuleAnchorTO.setModuleName(moduleAnchorTO.getModuleName());
				updateModuleAnchorTO.setAnchorName(moduleAnchorTO.getAnchorName());
						
				return "edit";
			
			} 
			catch (NoModuleAvailableException e) 
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
		
		// update Module
		public String updateModule()
		{
						
			System.out.println("inside update module function"+this.updateModuleAnchorTO.getModuleName());
			FRMS_Wrapper wrapper = new FRMS_Wrapper();	
			updateModuleAnchorTO.setModuleId(this.updateModuleAnchorTO.getModuleId());			
			updateModuleAnchorTO.setVerticalId(this.updateModuleAnchorTO.getVerticalId());
			System.out.println("vertical ID: "+this.updateModuleAnchorTO.getVerticalId());
			updateModuleAnchorTO.setModuleName(this.updateModuleAnchorTO.getModuleName());
			updateModuleAnchorTO.setAnchorName(this.updateModuleAnchorTO.getAnchorName());
			updateModuleAnchorTO.setAnchorEmployeeId(this.updateModuleAnchorTO.getAnchorEmployeeId());
			System.out.println("Anchor Employee Id: "+this.updateModuleAnchorTO.getAnchorEmployeeId());
			
			/*try 
			{
				wrapper.updateModule(this.updateModuleAnchorTO);
							
				moduleAnchorTO.setSolutionId(updateModuleAnchorTO.getSolutionId());
				moduleAnchorTO.setVerticalId(updateModuleAnchorTO.getVerticalId());
				moduleAnchorTO.setModuleId(updateModuleAnchorTO.getModuleId());
				moduleAnchorTO.setModuleName(updateModuleAnchorTO.getModuleName());
				moduleAnchorTO.setAnchorName(updateModuleAnchorTO.getAnchorName());
				this.setMessage(" Module Updated Successfully ");
								
				return "success";
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				this.setMessage(e.getMessage());
				return "failure";
			}*/
			
			try
			{
				this.message=null;
				//FRMS_Wrapper wrapper=new FRMS_Wrapper();
				boolean result=wrapper.updateModule(this.updateModuleAnchorTO);
				System.out.println("result "+result);
				if(result)
				{
					this.message="Module Updated Successfully";
					return "success";
					
				}
				return "failure";
				
			}
			catch (Exception e) {
				this.message=e.getMessage();
				return "failure";
			}
		}
		
	 
}
