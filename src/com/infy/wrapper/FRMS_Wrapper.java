package com.infy.wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.infy.TOclasses.GroupDetailsAttachmentTO;
import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.LoginTO;
import com.infy.TOclasses.MasterRequirementAttachmentTO;
import com.infy.TOclasses.MasterRequirementTO;
import com.infy.TOclasses.ModuleAnchorTO;
import com.infy.TOclasses.ProductRequirementTO;
import com.infy.TOclasses.SubModuleTO;
import com.infy.TOclasses.VerticalTO;
import com.infy.exceptions.AlreadyExistException;
import com.infy.exceptions.EmployeeAlradyRegisteredException;
import com.infy.exceptions.GroupNameNotAvailableException;
import com.infy.exceptions.IncorrectPasswordException;
import com.infy.exceptions.InvalidEmployeeIdException;
import com.infy.exceptions.InvalidProductRequirementIdException;
import com.infy.exceptions.NoAttachmentFoundException;
import com.infy.exceptions.NoGroupsAvailableException;
import com.infy.exceptions.NoInitiatingGroupsAvailableException;
import com.infy.exceptions.NoLocationsAvailableException;
import com.infy.exceptions.NoMasterReqAvailableException;
import com.infy.exceptions.NoModuleAvailableException;
import com.infy.exceptions.NoModuleFoundException;
import com.infy.exceptions.NoModulesAvailableForGivenSolutionException;
import com.infy.exceptions.NoProductReqAvailableException;
import com.infy.exceptions.NoProductRequirementAssignedException;
import com.infy.exceptions.NoProductRequirementFoundException;
import com.infy.exceptions.NoSolutionsAvailableException;
import com.infy.exceptions.NoSourceAvailableException;
import com.infy.exceptions.NoSubModuleAvailableForGivenModuleException;
import com.infy.exceptions.NoVersionFoundException;
import com.infy.exceptions.SameOldAndNewPasswordException;
import com.infy.exceptions.UserDoesNotExistException;
import com.infy.exceptions.masterRequirementNotAddedException;
import com.infy.manager.AdminTasksManager;
import com.infy.manager.GroupInfoManager;
import com.infy.manager.LoginManager;
import com.infy.manager.MasterRequirementManager;
import com.infy.manager.ModuleAnchorManager;
import com.infy.manager.ProductRequirementManager;
import com.infy.manager.ReportManager;
import com.infy.service.AdminTasksService;
import com.infy.service.GroupInfoService;
import com.infy.service.ProductRequirementService;


public class FRMS_Wrapper
{

	public Map<String,String> getAllInitiatingGroups()throws NoInitiatingGroupsAvailableException,Exception
	{
		Map<String, String> initatingGroupsMap = new TreeMap<String, String>();
		try 
		{
			GroupInfoManager manager = new GroupInfoManager();
			initatingGroupsMap=manager.getAllInitiatingGroups();


		}
		catch(NoInitiatingGroupsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}


		return initatingGroupsMap;

	}

	public Map<String,String> getAllSource()throws NoSourceAvailableException,Exception
	{

		Map<String, String> sourceMap = new TreeMap<String, String>();
		try 
		{
			GroupInfoManager manager = new GroupInfoManager();
			sourceMap=manager.getAllSource();
		}
		catch(NoSourceAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}

		return sourceMap;

	}

	public Map<String,String> getAllLocations()throws NoLocationsAvailableException,Exception
	{

		Map<String, String> locationMap = new TreeMap<String, String>();
		try 
		{
			GroupInfoManager manager = new GroupInfoManager();
			locationMap=manager.getAllLocations();

		}
		catch(NoLocationsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}

		return locationMap;

	}
	
	//get all localizations
	public Map<String,String> getAllLocalizations()throws NoLocationsAvailableException,Exception
	{

		Map<String, String> localizationMap = new TreeMap<String, String>();
		try 
		{
			GroupInfoManager manager = new GroupInfoManager();
			localizationMap=manager.getAllLocalizations();

		}
		catch(NoLocationsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}

		return localizationMap;

	}

	public Map<String,String> getAllSubModulesByModule(String moduleId)throws NoSubModuleAvailableForGivenModuleException,Exception
	{
		Map<String, String> subModuleMap = new TreeMap<String, String>();
		try 
		{
			MasterRequirementManager manager = new MasterRequirementManager();
			subModuleMap=manager.getAllSubModulesByModule(moduleId);

		}
		catch(NoSubModuleAvailableForGivenModuleException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}

		return subModuleMap;
		
	}
	
	public GroupInfoTO addGroup(GroupInfoTO groupInfoTo)throws Exception
	{

		GroupInfoTO groupTO;
		try 
		{
			GroupInfoManager manager = new GroupInfoManager();
			groupTO=manager.addGroup(groupInfoTo);
			return groupTO;	
		}

		catch(Exception e)
		{
			throw e;
		}
	}

	public void updateGroup(GroupInfoTO groupInfoTo)throws Exception
	{

		try 
		{
			GroupInfoManager manager = new GroupInfoManager();
			manager.updateGroup(groupInfoTo);
		}

		catch(Exception e)
		{
			throw e;
		}


	}
	public Map<String,String> getGroupNamesByGeography(String locationId)throws NoGroupsAvailableException,Exception
	{

		Map<String,String> groupMap = new TreeMap<String, String>();

		try 
		{
			GroupInfoManager manager = new GroupInfoManager();
			groupMap = manager.getGroupNamesByGeography(locationId);
			return groupMap;

		}

		catch( NoGroupsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public GroupInfoTO getGroupDetailsById(String groupId)throws NoGroupsAvailableException , Exception
	{

		GroupInfoTO toObj = new GroupInfoTO();
		GroupInfoManager manager = new GroupInfoManager();

		try
		{
			toObj=manager.getGroupDetailsById(groupId);
		} 
		catch (NoGroupsAvailableException e)
		{
			throw e;

		} 
		catch (Exception e)
		{
			throw e;
		} 

		return toObj;

	}

	// Call to Login Manger

	public LoginTO  authenticate(LoginTO loginTo) throws InvalidEmployeeIdException,IncorrectPasswordException,Exception
	{
		try
		{
			LoginTO loginto=new LoginManager().authenticate(loginTo);
			return loginto;
		}
		catch (InvalidEmployeeIdException e) {
			// handle exception
			throw e;

		}
		catch(IncorrectPasswordException e) {
			// handle exception
			throw e;
		}
		catch (Exception e) {
			// handle exception
			throw e;
		}


	}


	public boolean changePassword(LoginTO loginTO) throws InvalidEmployeeIdException,SameOldAndNewPasswordException, Exception
	{
		try
		{
			LoginManager loginManager=new LoginManager();
			return loginManager.changePassword(loginTO);


		}
		catch (SameOldAndNewPasswordException e) {
			throw e;
		}
		catch (InvalidEmployeeIdException e)
		{
			// handle exception
			throw e;

		}
		catch (Exception e) {
			// handle exception
			throw e;
		}
	}
	public boolean changeOthersPassword(LoginTO loginTO) throws InvalidEmployeeIdException,Exception
	{

		try
		{
			LoginManager loginManager=new LoginManager();
			return loginManager.changeOthersPassword(loginTO);


		}
		catch (SameOldAndNewPasswordException e) {
			throw e;
		}
		catch (InvalidEmployeeIdException e)
		{
			// handle exception
			throw e;

		}
		catch (Exception e) {
			// handle exception
			throw e;
		}
	}


	public List<String> getAllVersions()throws NoVersionFoundException,Exception
	{
		try
		{
			List<String> verstionList=new ProductRequirementManager().getAllVersions();

			return verstionList;
		}
		catch (NoVersionFoundException e) {

			throw e;
		}
		catch (Exception e) {
			throw e;
		}

	}
	
	/*public Map<String,String> getAllVersions()throws NoVersionFoundException,Exception
	{
		try
		{
			Map<String,String> versionMap=new ProductRequirementManager().getAllVersions();

			return versionMap;
		}
		catch (NoVersionFoundException e) {

			throw e;
		}
		catch (Exception e) {
			throw e;
		}

	}*/
	

	public Map<String,String> getAllGroupsMap() throws NoGroupsAvailableException, Exception
	{
		try
		{
			Map<String,String> groupMap=new GroupInfoManager().getAllGroupsMap();
			return groupMap;
		}
		catch(NoGroupsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public Map<String,String> getAllModules() throws NoModuleFoundException,Exception
	{
		try
		{
			Map<String, String> moduleMap=new TreeMap<String, String>();
			moduleMap=new ModuleAnchorManager().getAllModules();
			return moduleMap;
		}
		catch(NoModuleFoundException e)
		{
			throw e;
		}
		catch (Exception e) {
			throw e;
		}	
	}
			

	public ProductRequirementTO getProductRequirmentById(String requirmentId) throws NoProductRequirementFoundException,Exception
	{

		ProductRequirementTO productRequirementTO=null;
		try 
		{
			ProductRequirementManager productRequirementManager=new ProductRequirementManager();
			productRequirementTO=productRequirementManager.getProductRequirmentById(requirmentId);
			return productRequirementTO;
		}
		catch (NoProductRequirementFoundException e) {
			// TODO: handle exception
			throw e;
		}
		catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public boolean updateProductRequirement(ProductRequirementTO productRequirementTO) throws InvalidProductRequirementIdException,Exception
	{
		try
		{
			boolean result=new ProductRequirementService().updateProductRequirement(productRequirementTO);
			
			return result;
		}
		catch(InvalidProductRequirementIdException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public List<ProductRequirementTO> getProductRequirementsByMasterId(String masterRequirementId) throws NoProductRequirementFoundException, Exception
	{
		try
		{
			List<ProductRequirementTO> productRequirementToList=new ProductRequirementManager().getProductRequirementsByMasterId(masterRequirementId);
			
			return productRequirementToList;
		}
		catch (NoProductRequirementFoundException e) {
			throw e;
		}
		catch (Exception e) {
			throw e;
		}
	}
	public void saveSplitedRequriements(List<ProductRequirementTO> productRequirementTOList) throws Exception
	{
		try
		{
			new ProductRequirementManager().saveSplitedRequriements(productRequirementTOList);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	
	//Master requirement methods
	
	//get All Group names
	public Map<String,String> getAllGroupNames()throws NoGroupsAvailableException,Exception
	{
		
		Map<String, String> groupNamesMap = new TreeMap<String, String>();
		try 
		{
			MasterRequirementManager manager = new MasterRequirementManager();
			groupNamesMap=manager.getAllGroupNames();
			
			
		}
		catch(NoGroupsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return groupNamesMap;
		
	}

	//get Master Req Details By Id
	public MasterRequirementTO getMasterReqDetailsById(String masterReqId)throws NoMasterReqAvailableException,Exception
	{
		
		MasterRequirementTO masterReqTo = new MasterRequirementTO();
		try 
		{
			MasterRequirementManager manager = new MasterRequirementManager();
			masterReqTo=manager.getMasterReqDetailsById(masterReqId);			
		}
		catch(NoMasterReqAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	
		return masterReqTo;
	}
	
	//get All Master Requirements By Group
	public List<MasterRequirementTO> getAllMasterReqByGroup (String groupId)throws NoMasterReqAvailableException,Exception
	{
		
		List<MasterRequirementTO> masterReqTOList=null;
		try 
		{
			MasterRequirementManager manager = new MasterRequirementManager();
			masterReqTOList=manager.getAllMasterReqByGroup(groupId);
				
		}
		catch(NoMasterReqAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		
		return masterReqTOList;
		
	}
	
	//get All Master Requirements By Module
	public List<MasterRequirementTO> getAllMasterReqByModule(String moduleId)throws NoMasterReqAvailableException,Exception
	{
		
		List<MasterRequirementTO> masterReqTOList=null;
		try 
		{
			MasterRequirementManager manager = new MasterRequirementManager();
			masterReqTOList=manager.getAllMasterReqByModule(moduleId);
				
		}
		catch(NoMasterReqAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return masterReqTOList;
	}
	
	//get All solutions
	public Map<String,String> getAllSolutions()throws NoSolutionsAvailableException,Exception
	{
		Map<String, String> solutionsMap = new TreeMap<String, String>();
		try 
		{
			MasterRequirementManager manager = new MasterRequirementManager();
			solutionsMap=manager.getAllSolutions();
				
		}
		catch(NoSolutionsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return solutionsMap;
		
	}
	
	//get All emailIds
		public Map<String,String> getAllEmailIds()throws NoSolutionsAvailableException,Exception
		{
			Map<String, String> loginMap = new TreeMap<String, String>();
			try 
			{
				MasterRequirementManager manager = new MasterRequirementManager();
				loginMap=manager.getAllEmailIds();
					
			}
			catch(NoSolutionsAvailableException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
			
			return loginMap;
			
		}
	
	//get All modules of selected solution
	public Map<String,String> getAllModulesBySolution(String solutionId)throws NoModulesAvailableForGivenSolutionException,Exception
	{
		Map<String, String> modulesMap = new TreeMap<String, String>();
		try 
		{
			MasterRequirementManager manager = new MasterRequirementManager();
			modulesMap = manager.getAllModulesBySolution(solutionId);
		}
		catch(NoModulesAvailableForGivenSolutionException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return modulesMap;
		
	}
	
	
	//get All verticals of selected solution
		public Map<String,String> getAllVerticalsBySolution(String solutionId)throws NoModulesAvailableForGivenSolutionException,Exception
		{
			Map<String, String> verticalsMap = new TreeMap<String, String>();
			try 
			{
				MasterRequirementManager manager = new MasterRequirementManager();
				verticalsMap = manager.getAllVerticalsBySolution(solutionId);
			}
			catch(NoModulesAvailableForGivenSolutionException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
			
			return verticalsMap;
			
		}
	
	//get All verticals
		public Map<String,String> getAllVerticals()throws NoSolutionsAvailableException,Exception
		{
			Map<String, String> verticalsMap = new TreeMap<String, String>();
			try 
			{
				MasterRequirementManager manager = new MasterRequirementManager();
				verticalsMap = manager.getAllVerticals();
					
			}
			catch(NoSolutionsAvailableException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
			
			return verticalsMap;
			
		}
		
		
		//get All verticals
				public Map<String,String> getAllModule()throws NoModuleAvailableException,Exception
				{
					Map<String, String> moduleMap = new TreeMap<String, String>();
					try 
					{
						MasterRequirementManager manager = new MasterRequirementManager();
						moduleMap = manager.getAllModule();
							
					}
					catch(NoModuleAvailableException e)
					{
						throw e;
					}
					catch(Exception e)
					{
						throw e;
					}
					
					return moduleMap;
					
				}
		
	//add master requirement
	public String addMasterRequirement(MasterRequirementTO masterReqTo, String emailId) throws Exception
	{
		String masterReqId=null;
		try 
		{
			MasterRequirementManager manager = new MasterRequirementManager();
			masterReqId=manager.addMasterRequirement(masterReqTo,emailId);			
			return masterReqId;
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	public void updateMasterRequirement(MasterRequirementTO masterRequirementTO) throws Exception
	{
		try
		{
			MasterRequirementManager masterRequirementManager=new MasterRequirementManager();
			masterRequirementManager.updateMasterRequirement(masterRequirementTO);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	 public List<MasterRequirementTO> getAllMasterRequirements()throws NoMasterReqAvailableException,Exception
	 {
		 try
		 {
			 return new MasterRequirementManager().getAllMasterRequirements();
		 }
		 catch (NoMasterReqAvailableException e) 
		 {
			throw e;
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
		 
	 }
	 public void abandonMasterRequirement(MasterRequirementTO masterRequirementTO) throws Exception
	 {
		 try
		 {
			new MasterRequirementManager().abandonMasterRequirement(masterRequirementTO); 
		 }
		 catch(Exception e)
		 {
			 throw e;
		 }
	 }
	 
	//get all product requirements
		public List<ProductRequirementTO> getAllProductRequirements()throws NoProductReqAvailableException,Exception
		{
			
			List<ProductRequirementTO> toProductReq = new ArrayList<ProductRequirementTO>() ;
			try 
			{
				ProductRequirementManager  manager = new ProductRequirementManager();
				toProductReq=manager.getAllProductRequirements();
					
			}
			catch(NoProductReqAvailableException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
				
			return toProductReq;
		}
	
		//get all groups
		public List<GroupInfoTO> getAllGroups() throws NoGroupsAvailableException, Exception
		{
			List<GroupInfoTO> groupList = new ArrayList<GroupInfoTO>();
			try
			{
				groupList=new GroupInfoManager().getAllGroups();
				
				return groupList;
			}
			catch(NoGroupsAvailableException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
		}

		
	
	
	
	public List<MasterRequirementTO> getMasterRequirementListByOwner(String ownerEmpId) throws NoMasterReqAvailableException, Exception
	 {
		 try
		 {
			 List<MasterRequirementTO> masterRequirementTOList=new MasterRequirementManager().getMasterRequirementListByOwner(ownerEmpId);
			 if(masterRequirementTOList.isEmpty())
			 {
				 throw new masterRequirementNotAddedException(); 
			 }
			 return masterRequirementTOList;
		 }
		 catch (NoMasterReqAvailableException e) 
		 {
			 throw e;

		 }
		 catch (Exception e) 
		 {
			 throw e;
		 }
	 }
	
	
	//get product requirements assigned to me
	public List<ProductRequirementTO> getProductRequirementsAssignedToMe(String ownerEmpId) throws NoProductReqAvailableException, Exception
	 {
		 try
		 {
			 List<ProductRequirementTO> producRequirementTOList =new MasterRequirementManager().getProductRequirementsAssignedToMe(ownerEmpId);
		
			 if(producRequirementTOList.isEmpty())
			 {
	
				 throw new masterRequirementNotAddedException(); 
			 }
			
			 return producRequirementTOList;
		 }
		 catch (NoProductReqAvailableException e) 
		 {
			 throw e;

		 }
		 catch (Exception e) 
		 {
			 
			 throw e;
		 }
	 }
	
	//get product scope items list
		public List<ProductRequirementTO> getProductScopeItemsList(String ownerEmpId) throws NoProductReqAvailableException, Exception
		 {
			 try
			 {  
				 //System.out.println("I wanted to populate the product scope list2 "+ownerEmpId);
				 List<ProductRequirementTO> producRequirementTOList =new MasterRequirementManager().getProductScopeItemsList(ownerEmpId);
				 if(producRequirementTOList.isEmpty())
				 {
					 throw new masterRequirementNotAddedException(); 
				 }
				 return producRequirementTOList;
			 }
			 catch (NoProductReqAvailableException e) 
			 {
				 throw e;

			 }
			 catch (Exception e) 
			 {
				 throw e;
			 }
		 }
	
	
	public LoginTO registerEmployee(LoginTO loginTO) throws EmployeeAlradyRegisteredException,Exception
	{
		LoginTO loginTO2;
		try
		{
			loginTO2=new LoginManager().registerEmployee(loginTO);
			if(loginTO2==null)
			{
				throw new EmployeeAlradyRegisteredException();
			}
			else 
			{
				return loginTO2;
			}
		}
		catch(EmployeeAlradyRegisteredException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	//Product Requirement Assigned to Employee
	public List<ProductRequirementTO> getAllProductRequirementAssignedToEmployee(String employeeId) throws NoProductRequirementAssignedException,Exception
	{
		List<ProductRequirementTO> produtctReqTOList=null;
		try
		{
			ProductRequirementManager manager=new ProductRequirementManager();
			produtctReqTOList=manager.getAllProductRequirementAssignedToEmployee(employeeId);
			return produtctReqTOList;
		}
		catch(NoProductRequirementAssignedException e){
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public GroupInfoTO getGroupByName(String groupName)throws GroupNameNotAvailableException,Exception
	{
		try
		{
			GroupInfoTO groupInfoTO=new GroupInfoManager().getGroupByName(groupName);
			return groupInfoTO;
		}
		catch(GroupNameNotAvailableException e){
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	//upload Master Requirement List
	public void uploadMasterReqList(List<MasterRequirementTO> masterReqListTo) throws Exception
	{	
		MasterRequirementManager manager = new MasterRequirementManager();
		try 
		{
			manager.uploadMasterReqList(masterReqListTo);
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}
	
	//upload Product Requirement List
		public void uploaProductReqList(List<ProductRequirementTO> productReqListTo) throws Exception
		{	
			ProductRequirementManager manager = new ProductRequirementManager();
			try 
			{
				manager.uploaProductReqList(productReqListTo);
			} 
			catch (Exception e) 
			{
				throw e;
			}
		}
	
		
		public int checkMrId(String masterReq) throws Exception
		{	
			ProductRequirementManager manager = new ProductRequirementManager();
			int mrIdStatus =0;
			try 
			{
				mrIdStatus=manager.checkMRid(masterReq);
			} 
			catch (Exception e) 
			{
				throw e;
			}
			return mrIdStatus;
		}
	

	//add Location
	public String addLocation(String locationName)throws Exception,AlreadyExistException
	{
		String locationId=null;
		try 
		{

			AdminTasksManager manager = new AdminTasksManager();
			locationId=	manager.addLocation(locationName);
						
			return locationId;
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	
	//add Initiating Group
	public String addInitiatingGroup(String initiatingGroupName)throws Exception
	{

		String initiatingGroupId=null;
		try 
		{

			AdminTasksManager manager = new AdminTasksManager();
			initiatingGroupId=	manager.addInitiatingGroup(initiatingGroupName);
						
			return initiatingGroupId;
		}
		
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	//add Source
	public String addSource(String sourceName)throws Exception
	{
		String sourceId=null;
		try 
		{

			AdminTasksManager manager = new AdminTasksManager();
			sourceId=	manager.addSource(sourceName);
			return sourceId;
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	//add Localization
		public String addLocalization(String localizationName)throws Exception
		{
			String localizationId=null;
			try 
			{

				AdminTasksManager manager = new AdminTasksManager();
				localizationId=	manager.addLocalization(localizationName);
				return localizationId;
			}
			
			catch(Exception e)
			{
				throw e;
			}
			
		}
	
	
	
	//add Solution
	public String addSolution(String solutionName)throws Exception
	{

		String solutionId=null;
		try 
		{

			AdminTasksManager manager = new AdminTasksManager();
			solutionId=	manager.addSolution(solutionName);	
			return solutionId;
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
	}
	//add Product version
		public String addProductVersion(String productVersion)throws Exception
		{

			String versionId=null;
			try 
			{

				AdminTasksManager manager = new AdminTasksManager();
				versionId=	manager.addProductVersion(productVersion);	
				return versionId;
			}
			
			catch(Exception e)
			{
				throw e;
			}
			
		}
	
	//add Module And Assign Module Anchor
	public String addModuleAndAssignModuleAnchor(ModuleAnchorTO moduleTo)throws Exception
	{

		String moduleId=null;
		try 
		{

			AdminTasksManager manager = new AdminTasksManager();
			moduleId=	manager.addModuleAndAssignModuleAnchor(moduleTo);			
			return moduleId;
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	//add vertical
		public String addVertical(VerticalTO verticalTO)throws Exception
		{

			String verticalId=null;
			try 
			{

				AdminTasksManager manager = new AdminTasksManager();
				verticalId=	manager.addVertical(verticalTO);			
				return verticalId;
			}
			
			catch(Exception e)
			{
				throw e;
			}
			
		}
	
	
	//get All Groups By Location
	public List<GroupInfoTO> getAllGroupsByLocation(String locationId) throws Exception,NoGroupsAvailableException
	{

		
		List<GroupInfoTO> toGroupList = new ArrayList<GroupInfoTO>() ;

		try 
		{
			GroupInfoManager manager = new GroupInfoManager();
			toGroupList=manager.getAllGroupsByLocation(locationId);
		}
		catch(NoGroupsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return toGroupList;
	}
	
	public String downloadGroupDetailsReport(List<GroupInfoTO> groupList) throws NoGroupsAvailableException,Exception
	{
		ReportManager manager = new ReportManager();
		try 
		{
			String fileName=manager.downloadGroupDetailsReport(groupList);
			return fileName;
		} 
		catch (NoGroupsAvailableException e) 
		{
			throw e;
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}
	
	//Master Requirements REPORT
	public String downloadMasterRequirementsReport(List<MasterRequirementTO> masterReqList)throws NoMasterReqAvailableException,Exception
	{
		ReportManager manager = new ReportManager();
		try 
		{
			String fileName=manager.downloadMasterRequirementsReport(masterReqList);
			return fileName;
		} 
		catch (NoMasterReqAvailableException e) 
		{
			throw e;
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}

	//Product Requirements REPORT
	public String downloadProductRequirementsReport(List<ProductRequirementTO> productReqList)throws NoProductReqAvailableException,Exception
	{
		ReportManager manager = new ReportManager();
		try 
		{
			String fileName=manager.downloadProductRequirementsReport(productReqList);
			return fileName;
		} 
		catch (NoProductReqAvailableException e) 
		{
			throw e;
		} 
		catch (Exception e) 
		{
			throw e;
		}
	}
	
	// Download product requirement report as RCD Tracker
		public String downloadProductReqListAsRCDTracker(List<ProductRequirementTO> productReqList)throws NoProductReqAvailableException,Exception
		{
			ReportManager manager = new ReportManager();
			try 
			{
				String fileName=manager.downloadProductReqListAsRCDTracker(productReqList);
				return fileName;
			} 
			catch (NoProductReqAvailableException e) 
			{
				throw e;
			} 
			catch (Exception e) 
			{
				throw e;
			}
		}
		
		// Download product requirement report as RS Tracker
				public String downloadProductReqListAsRSTracker(List<ProductRequirementTO> productReqList)throws NoProductReqAvailableException,Exception
				{
					ReportManager manager = new ReportManager();
					try 
					{
						String fileName=manager.downloadProductReqListAsRSTracker(productReqList);
						return fileName;
					} 
					catch (NoProductReqAvailableException e) 
					{
						throw e;
					} 
					catch (Exception e) 
					{
						throw e;
					}
				}
	
	// download master requirement template
	public String downloadMRTemplate()throws Exception,NoGroupsAvailableException
	{
		ReportManager manager = new ReportManager();
		try
		{
			
			String fileName=manager.downloadMRTemplate();
			 
			return fileName;
		}
		catch(NoGroupsAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	// download product requirement template
		public String downloadPRTemplate()throws Exception,NoGroupsAvailableException
		{
			ReportManager manager = new ReportManager();
			try
			{
				
				String fileName=manager.downloadPRTemplate();
				 
				return fileName;
			}
			catch(NoGroupsAvailableException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}
			
		}
	

	//get All Master Requirements By status
	public List<MasterRequirementTO> getAllMasterReqByStatus (String status)throws NoMasterReqAvailableException,Exception
	{
		
		List<MasterRequirementTO> masterReqTOList=null;
		try 
		{
			MasterRequirementManager  manager = new MasterRequirementManager();
			masterReqTOList=manager.getAllMasterReqByStatus(status);
				
		}
		catch(NoMasterReqAvailableException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	return masterReqTOList;
  }

	
	

	// View product requirement method
	      public List<ProductRequirementTO> getProductRequirements(String... searchObjects)throws Exception
	      {
	            try 
	            {

	                  List<ProductRequirementTO> productReqTOList=new ProductRequirementManager().getProductRequirements(searchObjects);
	                  
	                  return productReqTOList;
	            }
	            catch (NoProductRequirementFoundException e) {

	                  throw e;
	            }
	            catch(Exception e)
	            {
	                  throw e;
	            }

	      }
	      
	      public List<MasterRequirementTO> getMasterRequirements(String... searchObjects)throws NoMasterReqAvailableException,Exception
	 	 {
	 		 try
	 		 {
	 			 List<MasterRequirementTO> masterRequirementTOList=new MasterRequirementManager().getMasterRequirements(searchObjects);
	 			 
	 			System.out.println("getMasterRequirements: "+masterRequirementTOList.size());
	 			 return masterRequirementTOList;
	 		 }
	 		 catch (NoMasterReqAvailableException e) 
	 		 {
	 			 throw e;

	 		 }
	 		 catch (Exception e) 
	 		 {
	 			 throw e;
	 		 }
	 	 }

	      public MasterRequirementAttachmentTO uploadMasterRequirementAttachment(MasterRequirementAttachmentTO attachmentTO) throws Exception
		  {
			 try
			 {
				 MasterRequirementAttachmentTO masterRequirementAttachmentTO=new MasterRequirementManager().uploadMasterRequirementAttachment(attachmentTO);
				 return masterRequirementAttachmentTO;
				 
			 }
			 catch(Exception e)
			 {
				 throw e;
			 }
		  }
	      
	      public List<MasterRequirementAttachmentTO> getAttachmentsByMasterReqId(String masterRequirementId)throws Exception,NoAttachmentFoundException
	 	 {
	    	  try
	    	  {
	    		  List<MasterRequirementAttachmentTO> attachmentTOList=new MasterRequirementManager().getAttachmentsByMasterReqId(masterRequirementId);

	    		  return attachmentTOList;
	    	  }
	    	  catch(Exception e)
	    	  {
	    		  throw e;
	    	  }
	 	 }
	      
	     
	      
	      public ProductRequirementTO saveNewProductRequirement(ProductRequirementTO productRequirementTO)throws Exception
	  	{
	  		try
	  		{
	  			ProductRequirementTO requirementTO=new ProductRequirementManager().saveNewProductRequirement(productRequirementTO);
	  			return requirementTO;
	  		}
	  		catch(Exception e)
	  		{
	  			throw e;
	  		}

	  	}
	      public GroupDetailsAttachmentTO uploadGroupAttachment(GroupDetailsAttachmentTO attachmentTO) throws Exception
	 	 {
	 		 try
	 		 {
	 			 GroupDetailsAttachmentTO detailsAttachmentTO=new GroupInfoManager().uploadGroupAttachment(attachmentTO);
	 			 return detailsAttachmentTO;
	 		 }
	 		 catch(Exception e)
	 		 {
	 			 throw e;
	 		 }
	 	 }
		      
	      //get employee by id
	      public LoginTO getEmployeeById(String empId) throws Exception, UserDoesNotExistException
	  	{
	  		
	  		LoginTO loginTO=null;
	  		try
	  		{
	  			LoginManager manager  = new LoginManager();
	  			loginTO=manager.getEmployeeById(empId);
	  			return loginTO;
	  		}
	  		catch (UserDoesNotExistException e) {
	  			throw e;
	  		}
	  		catch (Exception e) {
	  			throw e;
	  		}
	  		
	  	}
	      //edit Employee Details
	    public LoginTO editEmployeeDetails(LoginTO loginTO) throws Exception
	  	{
	  		LoginTO loginTo = new LoginTO();
	  		try
	  		{
	  			LoginManager manager = new LoginManager();
	  			loginTo=manager.editEmployeeDetails(loginTO);
	  			   
	  			return loginTo;
	  		}
	  		catch (Exception e) {
	  		
	  			throw e;
	  		}
	  		
	  	}
	      
	    //get Module By moduleId
	    public ModuleAnchorTO getModuleById(String moduleId) throws Exception
	  	{
	  		
	  	
	  		ModuleAnchorTO moduleAnchorTO= new ModuleAnchorTO();
	  		try
	  		{
	  			
	  			ModuleAnchorManager manager = new ModuleAnchorManager();
	  			moduleAnchorTO=manager.getModuleById(moduleId);
	  			return moduleAnchorTO;
	  			
	  			
	  		}
	  		catch (Exception e) 
	  		{
	  			// TODO: handle exception
	  			throw e;
	  		}
     	}
	    
	  //get vertical By moduleId
	    public VerticalTO getVerticalById(String verticalId) throws Exception
	  	{
	  		
	  	
	    	VerticalTO verticalTO= new VerticalTO();
	  		try
	  		{
	  			
	  			ModuleAnchorManager manager = new ModuleAnchorManager();
	  			verticalTO=manager.getVerticalById(verticalId);
	  			return verticalTO;
	  			
	  			
	  		}
	  		catch (Exception e) 
	  		{
	  			// TODO: handle exception
	  			throw e;
	  		}
     	}
	    
	  //save Edited Vertical
	    public VerticalTO saveEditedVertical(VerticalTO verticalTO) throws Exception
	  	{
	  		
	  		try
	  		{
	  			ModuleAnchorManager manager = new ModuleAnchorManager();
	  			verticalTO=manager.saveEditedVertical(verticalTO);
	  			return verticalTO;
	  				
	  		}
	  		catch (Exception e) {
	  			// TODO: handle exception
	  			throw e;
	  		}
	  		
	  	}
	    
	    public Map<String,String> getAllModulesByVertical(String verticalId)throws NoSubModuleAvailableForGivenModuleException,Exception
		{
			Map<String, String> moduleMap = new TreeMap<String, String>();
			try 
			{
				MasterRequirementManager manager = new MasterRequirementManager();
				moduleMap=manager.getAllModulesByVertical(verticalId);

			}
			catch(NoSubModuleAvailableForGivenModuleException e)
			{
				throw e;
			}
			catch(Exception e)
			{
				throw e;
			}

			return moduleMap;
			
		} 
	    
	    //get all modules by id
	    public ModuleAnchorTO getModulesById(String moduleId)throws NoGroupsAvailableException , Exception
		{

	    	ModuleAnchorTO toObj = new ModuleAnchorTO();
			AdminTasksManager manager = new AdminTasksManager();

			try
			{
				toObj=manager.getModuleDetailsById(moduleId);
			} 
			catch (NoGroupsAvailableException e)
			{
				throw e;

			} 
			catch (Exception e)
			{
				throw e;
			} 

			return toObj;

		}
	    
	        
	   //save Edited ModuleAnchor
	    public ModuleAnchorTO saveEditedModuleAnchor(ModuleAnchorTO moduleAnchorTO) throws Exception
	  	{
	  		
	  		try
	  		{
	  			ModuleAnchorManager manager = new ModuleAnchorManager();
	  			moduleAnchorTO=manager.saveEditedModuleAnchor(moduleAnchorTO);
	  			return moduleAnchorTO;
	  				
	  		}
	  		catch (Exception e) {
	  			// TODO: handle exception
	  			throw e;
	  		}
	  		
	  	}
	    
	      
	    public List<GroupDetailsAttachmentTO> getAttachmentsByGroupId(String groupId)throws NoAttachmentFoundException,Exception
		 {
			 try
			 {
				 List<GroupDetailsAttachmentTO> attachmentTOList=new GroupInfoManager().getAttachmentsByGroupId(groupId);
				 return attachmentTOList;
			 }
			 catch(NoAttachmentFoundException e)
			 {
				 throw e;
			 }
			 catch(Exception e)
			 {
				 throw e;
			 }
		 }
	    public int removeGroupAttachmentById(String attachmentId)throws Exception
		 {
			 try
			 {
			  int count=new GroupInfoManager().removeGroupAttachmentById(attachmentId);
			  return count;
			 }
			 catch(Exception e)
			 {
				 throw e;
			 }
		 }
	    
		   
	 //changes made by sanket mehta

	   public void addModuleSubModuleMapping(String subModuleId, String moduleId) throws Exception

	   {

	   try

	   {

	   AdminTasksManager manager = new AdminTasksManager();

	   manager.addModuleSubModuleMapping(subModuleId, moduleId);

	   }

	   catch(Exception e)

	   {

	   throw e;

	   }

	   }

	   //changes completed

	   public String addSubModule(SubModuleTO subModuleTo)throws Exception

	   {

	   String submoduleId = null;

	   try

	   {

	   AdminTasksManager manager = new AdminTasksManager();

	   submoduleId = manager.addSubModule(subModuleTo);

	   return submoduleId;

	   }

	   catch(Exception e)

	   {

	   throw e;

	   }

	   }
	   
	   //Add module
	   public String addModule(ModuleAnchorTO moduleAnchorTO)throws Exception

	   {

	   String moduleId = null;

	   try

	   {

	   AdminTasksManager manager = new AdminTasksManager();

	   moduleId = manager.addModule(moduleAnchorTO);

	   return moduleId;

	   }

	   catch(Exception e)

	   {

	   throw e;

	   }

	   }
	   
	 //vertical module mapping

	   public void addVerticalModuleMapping(String moduleId, String verticalId) throws Exception

	   {

	   try

	   {

	   AdminTasksManager manager = new AdminTasksManager();

	   manager.addVerticalModuleMapping(moduleId, verticalId);

	   }

	   catch(Exception e)

	   {

	   throw e;

	   }

	   }

	   //changes completed
	   
	  public boolean updateModule(ModuleAnchorTO moduleAnchorTO)throws Exception
		{

			try 
			{
				boolean result=new AdminTasksService().updateModule(moduleAnchorTO);
				
				return result;
			}

			catch(Exception e)
			{
				throw e;
			}


		}
	  
	  public boolean updateVerticalModuleMapping(String moduleId, String verticalId)throws Exception
		{

			try 
			{
				boolean result=new AdminTasksService().updateVerticalModuleMapping(moduleId, verticalId);
				
				return result;
			}

			catch(Exception e)
			{
				throw e;
			}


		}
	  
	   
	   
	   
}
 
