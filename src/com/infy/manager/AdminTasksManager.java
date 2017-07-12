package com.infy.manager;

import com.infy.TOclasses.GroupInfoTO;
import com.infy.TOclasses.ModuleAnchorTO;
import com.infy.TOclasses.SubModuleTO;
import com.infy.TOclasses.VerticalTO;
import com.infy.exceptions.AlreadyExistException;
import com.infy.exceptions.NoModuleAvailableException;
import com.infy.service.AdminTasksService;
import com.infy.service.GroupInfoService;

public class AdminTasksManager 
{
	//add Location
	public String addLocation(String locationName)throws Exception,AlreadyExistException
	{
		String locationId=null;
		try 
		{

			AdminTasksService service = new AdminTasksService();
			locationId=	service.addLocation(locationName);
						
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

			AdminTasksService service = new AdminTasksService();
			initiatingGroupId=	service.addInitiatingGroup(initiatingGroupName);
						
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

			AdminTasksService service = new AdminTasksService();
			sourceId=	service.addSource(sourceName);
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

				AdminTasksService service = new AdminTasksService();
				localizationId=	service.addLocalization(localizationName);
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

			AdminTasksService service = new AdminTasksService();
			solutionId=	service.addSolution(solutionName);	
			return solutionId;
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
	}

	// add product version
	public String addProductVersion(String productVersion)throws Exception
	{

		String versionId=null;
		try 
		{

			AdminTasksService service = new AdminTasksService();
			versionId=	service.addProductVersion(productVersion);	
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

			AdminTasksService service = new AdminTasksService();
			moduleId=	service.addModuleAndAssignModuleAnchor(moduleTo);			
			return moduleId;
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	//add vertical
		public String addVertical(VerticalTO verticalTo)throws Exception
		{

			String verticalId=null;
			try 
			{

				AdminTasksService service = new AdminTasksService();
				
				verticalId=	service.addVertical(verticalTo);			
				return verticalId;
			}
			
			catch(Exception e)
			{
				throw e;
			}
			
		}
	
	//changes made by sanket mehta

	public String addSubModule(SubModuleTO subModuleTo)throws Exception

	{

	String submoduleId = null;

	try

	{ 

	AdminTasksService service = new AdminTasksService();

	submoduleId = service.addSubModule(subModuleTo);

	return submoduleId;

	}

	catch(Exception e)

	{

	throw e;

	}

	}


	public void addModuleSubModuleMapping(String subModuleId, String moduleId) throws Exception

	{

	try

	{

	AdminTasksService service= new AdminTasksService();

	service.addModuleSubModuleMapping(subModuleId, moduleId);

	}

	catch(Exception e)

	{

	throw e;

	}

	}

	//changes completed
	
	//changes done by Bhuvana starts
	//add module
	public String addModule(ModuleAnchorTO moduleAnchorTO)throws Exception

	{

	String moduleId = null;

	try

	{ 

	AdminTasksService service = new AdminTasksService();

	moduleId = service.addModule(moduleAnchorTO);

	return moduleId;

	}

	catch(Exception e)

	{

	throw e;

	}

	}
	//changes completed
	
	public void addVerticalModuleMapping(String moduleId, String verticalId) throws Exception

	{

	try

	{

	AdminTasksService service= new AdminTasksService();

	service.addVerticalModuleMapping(moduleId, verticalId);

	}

	catch(Exception e)

	{

	throw e;

	}

	}
	
	public ModuleAnchorTO getModuleDetailsById(String moduleId)throws NoModuleAvailableException , Exception
	{

		ModuleAnchorTO toObj = new ModuleAnchorTO();
		AdminTasksService service = new AdminTasksService();

		try
		{
			toObj=service.getModuleDetailsById(moduleId);
		} 
		catch (NoModuleAvailableException e)
		{
			throw e;

		} 
		catch (Exception e)
		{
			throw e;

		} 

		return toObj;

	}
	public void updateModule(ModuleAnchorTO moduleAnchorTO)throws Exception
	{

		try 
		{
			AdminTasksService service = new AdminTasksService();
			service.updateModule(moduleAnchorTO);

		}

		catch(Exception e)
		{
			throw e;
		}


	}


}
